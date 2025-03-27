package com.mcgrady.xlabs.analytics.eventrix

/**
 * IEventrixInterceptor defines the interface for interceptors.
 * Each interceptor intercepts events and can either pass the event to the next interceptor
 * or process the event itself.
 */
interface IEventrixInterceptor {
    /**
     * Intercepts the event and decides whether to pass it to the next interceptor in the chain.
     *
     * @param chain the chain of interceptors to which the event will be passed
     * @param eventName the name of the event
     * @param params the parameters associated with the event
     * @return true if the event is passed successfully to the next interceptor or handled, false otherwise
     */
    fun intercept(chain: IEventrixChain, eventName: String, params: Map<String, Any>?): Boolean
}
