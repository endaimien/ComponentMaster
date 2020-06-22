package com.example.test2.intercept

import android.content.Context
import android.net.ConnectivityManager
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class CacheIntercepter : Interceptor {
    lateinit var  mContext:Context
     var cacheControlValue_Offline: String = ""+60*60*24
    var cacheControlValue_Online: String = ""+60
    fun CacheIntercepter(context: Context){
        mContext =context
    }
    override fun intercept(chain: Interceptor.Chain?): Response {
        var request:Request? = chain?.request()
        if(!isNetworkAvailable(mContext)){
            request = request?.newBuilder()?.cacheControl(CacheControl.FORCE_CACHE)?.build()
            val response:Response? = chain?.proceed(request)
            return response!!.newBuilder().removeHeader("Pragma")
                .removeHeader("Cache-Control")
                .header("Cache-Control", "public, only-if-cached, max-stale=" +cacheControlValue_Offline ).build()
        }else{
            val response:Response? = chain?.proceed(request)
            return response!!.newBuilder().removeHeader("Pragma")
                .removeHeader("Cache-Control")
                .header("Cache-Control", "public, max-age=" +cacheControlValue_Online ).build()
    }

    }
    fun isNetworkAvailable(context: Context): Boolean {
        val manager = context.applicationContext.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager ?: return false
        val info = manager.activeNetworkInfo
        return if (null == info || !info.isAvailable) false else true
    }
}