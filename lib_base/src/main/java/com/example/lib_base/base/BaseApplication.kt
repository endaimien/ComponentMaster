package com.example.lib_base.base

import android.app.Application
import com.example.lib_base.base_dagger.AppComponent
import com.example.lib_base.base_dagger.DaggerAppComponent

/**
 * des:BaseApplication
 * author:wy
 * date:2020/6/14*/
class BaseApplication: Application() {
    /**dagger全局变量*/
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
    }

    /** dagger全局变量获取和设置*/
    fun setDaggerComponent(){
        appComponent = DaggerAppComponent.builder().build();
    }
    fun getDaggerAppComponent(): AppComponent{
        if(appComponent==null){
            setDaggerComponent()
        }
        return appComponent
    }
}