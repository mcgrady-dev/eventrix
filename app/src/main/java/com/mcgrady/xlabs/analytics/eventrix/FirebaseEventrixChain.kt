package com.mcgrady.xlabs.analytics.eventrix

/**
 * FirebaseEventrixChain is an implementation of IEventrixChain.
 * It processes events and sends them to Firebase for tracking or other processing.
 */
class FirebaseEventrixChain : IEventrixChain {
    /**
     * Processes the event and sends it to Firebase.
     *
     * @param eventName the name of the event
     * @param params the parameters associated with the event
     * @return true if the event is processed successfully, false otherwise
     */
    override fun proceed(eventName: String, params: Map<String, Any>?) {
        println("Sending event $eventName to Firebase with params: $params")
    }
}
