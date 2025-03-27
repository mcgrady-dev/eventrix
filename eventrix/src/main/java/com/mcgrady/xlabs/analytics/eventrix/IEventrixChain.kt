package com.mcgrady.xlabs.analytics.eventrix


/**
 * IEventrixChain defines the interface for event handler chains.
 * Event handler chains are responsible for processing the event after all interceptors have been executed.
 */
interface IEventrixChain {
    /**
     * Proceeds to the next handler in the chain, or finishes processing.
     *
     * @param eventName the name of the event
     * @param params the parameters associated with the event
     */
    fun proceed(eventName: String, params: Map<String, Any>?)
}
