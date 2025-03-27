package com.mcgrady.xlabs.analytics.mylibrary

class Eventrix {
    private val handlers = mutableListOf<EventrixHandler>()
    private val interceptors = mutableListOf<EventrixInterceptor>()

    // 注册事件处理器
    fun registerHandler(handler: EventrixHandler) {
        handlers.add(handler)
    }

    // 注册事件拦截器
    fun registerInterceptor(interceptor: EventrixInterceptor) {
        interceptors.add(interceptor)
    }

    // 触发事件，执行拦截器和处理器
    fun emit(eventName: String, params: Map<String, Any>?) {
        var eventParams = params
        // 通过拦截器链处理事件
        for (interceptor in interceptors) {
            if (!interceptor.intercept(eventName, eventParams)) {
                return
            }
        }
        // 处理事件
        for (handler in handlers) {
            handler.process(eventName, eventParams)
        }
    }
}
