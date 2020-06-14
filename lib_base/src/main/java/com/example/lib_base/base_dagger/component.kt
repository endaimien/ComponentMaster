package com.example.lib_base.base_dagger

import com.example.lib_base.base.BaseActivity
import com.example.lib_base.base.BaseApplication
import dagger.Component
import dagger.Subcomponent
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [AndroidInjectionModule::class, AndroidSupportInjectionModule::class]
)
interface AppComponent {
    fun inject(baseApplication: BaseApplication)
}

@Subcomponent(modules = [AndroidInjectionModule::class])
interface ActivityComponent : AndroidInjector<BaseActivity> {
    @Subcomponent.Factory
    abstract class Factory : AndroidInjector.Factory<BaseActivity> {}
}

