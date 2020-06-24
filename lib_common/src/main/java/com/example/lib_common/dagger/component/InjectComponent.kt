package com.example.lib_common.dagger.component

/**
 * des:inject 接口
 *
 * @author wy
 */
interface InjectComponent<T> {
    fun inject(injectData: T)
}