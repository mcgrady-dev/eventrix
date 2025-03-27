package com.mcgrady.xlabs.analytics.eventrix

/**
 * Eventrix manages the chain of interceptors and event handlers.
 * It is responsible for emitting events, processing interceptors, and eventually handling events.
 */
class Eventrix {
    private val interceptors = mutableListOf<IEventrixInterceptor>()
    private val chains = mutableListOf<IEventrixChain>()

    /**
     * Registers an interceptor in the Eventrix system.
     * The interceptors will be executed in the order they are registered.
     *
     * @param interceptor the interceptor to be registered
     */
    fun registerInterceptor(interceptor: IEventrixInterceptor) {
        interceptors.add(interceptor)
    }

    /**
     * Registers an event chain handler in the Eventrix system.
     * Event handlers are responsible for processing events after all interceptors have completed.
     *
     * @param chain the event handler chain to be registered
     */
    fun registerChain(chain: IEventrixChain) {
        chains.add(chain)
    }

    /**
     * Emits an event and processes it through the interceptor chain and event handlers.
     *
     * @param eventName the name of the event
     * @param params the parameters associated with the event
     */
    fun emit(eventName: String, params: Map<String, Any>?) {
        val iterator = interceptors.iterator()

        // Create the interceptor chain
        val chain = object : IEventrixChain {
            override fun proceed(eventName: String, params: Map<String, Any>?) {
                if (iterator.hasNext()) {
                    val interceptor = iterator.next()
                    // Execute the current interceptor's intercept method
                    interceptor.intercept(this, eventName, params)
                } else {
                    // Once all interceptors have been executed, process the event
                    processEvent(eventName, params)
                }
            }
        }

        // Start the interceptor chain
        chain.proceed(eventName, params)
    }

    /**
     * Processes the event using all registered event handler chains.
     *
     * @param eventName the name of the event
     * @param params the parameters associated with the event
     * @return true if the event was successfully processed by all handlers, false otherwise
     */
    private fun processEvent(eventName: String, params: Map<String, Any>?) {
        for (chain in chains) {
            chain.proceed(eventName, params)
        }
    }
}


