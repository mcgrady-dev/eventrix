package com.mcgrady.xlabs.analytics.eventrix

/**
 * LoggingEventrixInterceptor is an implementation of IEventrixInterceptor.
 * It intercepts events and logs them before passing them to the next interceptor in the chain.
 */
class LoggingEventrixInterceptor : IEventrixInterceptor {
    /**
     * Intercepts the event, logs it, and passes it to the next interceptor.
     *
     * @param chain the chain of interceptors
     * @param eventName the name of the event
     * @param params the parameters associated with the event
     * @return true if the event is passed to the next interceptor
     */
    override fun intercept(chain: IEventrixChain, eventName: String, params: Map<String, Any>?): Boolean {
        println("Logging event: $eventName with params: $params")
//        return chain.proceed(eventName, params) // Continue passing the event to the next interceptor
        return false
    }
}
