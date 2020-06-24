package com.example.lib_base.base

import android.app.Application
import com.example.lib_base.base_dagger.AppComponent
import com.example.lib_base.base_dagger.DaggerAppComponent

/**
 * des:BaseApplication
 * author:wy
 * date:2020/6/14*/
open class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        setBaseApplication(this)
    }

    /**设置当前的Application,方便module直接获取*/
    fun setBaseApplication(application: BaseApplication){
        applicationInstance = application
    }
    companion object{
        lateinit var applicationInstance:BaseApplication
        /**获取当前的Application*/
        fun getApplicationInstance():Application{
            return applicationInstance
        }
    }
}