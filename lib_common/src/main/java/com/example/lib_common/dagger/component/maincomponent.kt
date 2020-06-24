package com.example.lib_common.dagger.component

import com.example.lib_base.base.BaseApplication
import com.example.lib_common.dagger.module.HttpModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [HttpModule::class])
interface MainComponent : InjectComponent<BaseApplication> {
}