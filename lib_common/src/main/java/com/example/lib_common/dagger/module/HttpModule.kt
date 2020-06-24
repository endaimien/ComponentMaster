package com.example.lib_common.dagger.module

import com.example.test2.intercept.CacheIntercepter
import com.franmontiel.persistentcookiejar.ClearableCookieJar
import dagger.Module
import dagger.Provides
import okhttp3.Authenticator
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Url
import java.net.URL
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

@Module
class HttpModule{
    private val HTTP_RESPONSE_DISK_CACHE_MAX_SIZE = 10 * 1024 * 1024 // 缓存文件最大值为 10Mb

    private val DEFAULT_BASEURL = "https://api.github.com/"
    private val CONNECTED_TOME_OUT = 15
    private val WRITE_TOME_OUT = 15
    private val READE_TOME_OUT = 15

    /**OkHttp配置*/
    var sslSocketFactory: SSLSocketFactory?=null
    lateinit var trustManager: X509TrustManager
    lateinit var cacheIntercepter: CacheIntercepter
    lateinit var verifier: HostnameVerifier
    lateinit var authenticator: Authenticator
    lateinit var cookieJar: ClearableCookieJar
    lateinit var intercepterset: Set<Interceptor>
    lateinit var interNetcepterset: Set<Interceptor>
    lateinit var cache: Cache

    /**
     * Retrofit配置*/

    lateinit var baseUrl: URL


    @Singleton
    @Provides
    fun okHttpProvider(builder: OkHttpClient.Builder): OkHttpClient {
        return builder.build()
    }

    @Singleton
    @Provides
    fun okHttpBuilderProvider(): OkHttpClient.Builder {
        var okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
            .readTimeout(READE_TOME_OUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(WRITE_TOME_OUT.toLong(), TimeUnit.SECONDS)
            .cookieJar(cookieJar)
            .cache(cache)
            .sslSocketFactory(sslSocketFactory)
            .hostnameVerifier(verifier)
        for (a in intercepterset) {
            okHttpClientBuilder.addInterceptor(a)
        }
        for (b in interNetcepterset) {
            okHttpClientBuilder.addNetworkInterceptor(b)
        }
        return okHttpClientBuilder.authenticator(authenticator)
    }

    @Singleton
    @Provides
    fun retrofitProvider(retrofitBuilder: Retrofit.Builder): Retrofit {
            return retrofitBuilder.build()
    }

    @Singleton
    @Provides
    fun retrofitBuilderProvider(okHttpClient: OkHttpClient): Retrofit.Builder {
        var retrofitBuild = Retrofit.Builder()
        retrofitBuild.baseUrl(baseUrl)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
        return retrofitBuild
    }

}