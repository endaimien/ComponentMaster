package com.example.lib_common.common

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.lib_base.base.BaseApplication
import com.example.lib_common.R
import com.example.lib_common.dagger.component.DaggerMainComponent
import com.example.lib_common.dagger.component.MainComponent
import com.example.lib_common.dagger.module.HttpModule
import com.example.lib_common.utils.FileUtils
import com.example.lib_common.utils.HTTPS_CER_ONEWAY
import com.example.lib_common.utils.HTTPS_OPEN
import com.example.lib_common.utils.HTTP_RESPONSE_DISK_CACHE_MAX_SIZE
import com.example.lib_network.https.HttpsUtils
import com.example.test2.intercept.CacheIntercepter
import com.franmontiel.persistentcookiejar.ClearableCookieJar
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import okhttp3.Authenticator
import okhttp3.Cache
import okhttp3.CookieJar
import okhttp3.Interceptor
import javax.net.ssl.SSLSocketFactory


class CommonApplication : BaseApplication() {
    /**dagger全局变量*/
    companion object {
        lateinit var mainComponent: MainComponent
        fun getDaggerAppComponent(): MainComponent {
            return mainComponent
        }
        /** dagger全局变量获取和设置*/
        private fun setDaggerComponent(mainComponentin: MainComponent) {
            mainComponent = mainComponentin
        }

    }
    override fun onCreate() {
        super.onCreate()
    }

    fun initComponent(){
        mainComponent = DaggerMainComponent.builder().httpModule(HttpModule()).build()
    }

    @RequiresApi(Build.VERSION_CODES.FROYO)
    fun getHttpModule() : HttpModule {
        return HttpModule().apply {
            authenticator = getAuthenticator()
            sslSocketFactory = geSslSocketFactory()
            intercepterset = getIntercepter()
            verifier = HttpsUtils.hostNameVerifier()
            cookieJar = getCookieJar()
            cache = getCache()
        }

    }
    private fun getAuthenticator():Authenticator {
        return Authenticator { route, response ->
            response.request().newBuilder().header("Authorization", "").build()
        }
    }

    private fun getIntercepter():Set<Interceptor>{
        var interceptor = HashSet<Interceptor>()
           interceptor.add(CacheIntercepter())
        return interceptor
    }
    private fun geSslSocketFactory(): SSLSocketFactory?{
        val a = intArrayOf(R.raw.plus)
        when{
            HTTPS_OPEN&& HTTPS_CER_ONEWAY-> return HttpsUtils.getOneWaySSLFactory()
            HTTPS_OPEN&& !HTTPS_CER_ONEWAY-> return HttpsUtils.getSaveSSLFactory(this,a)
            !HTTPS_OPEN->return null
        }
        return null
    }

    private fun getCookieJar():ClearableCookieJar{
        val cookieJar: ClearableCookieJar =
            PersistentCookieJar(SetCookieCache(), SharedPrefsCookiePersistor(this))
        return cookieJar
    }
    @RequiresApi(Build.VERSION_CODES.FROYO)
    private fun getCache():Cache{
        return Cache(FileUtils.getCacheFile(this,false),HTTP_RESPONSE_DISK_CACHE_MAX_SIZE.toLong())
    }
}