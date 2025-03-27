package com.mcgrady.xlabs.analytics.eventrix

class EventrixSample {

    fun main() {
        // Create Eventrix instance
        val eventrix = Eventrix()

        // Register interceptors and event handler chains
        eventrix.registerInterceptor(LoggingEventrixInterceptor())
        eventrix.registerChain(FirebaseEventrixChain())

        // Emit an event
        eventrix.emit("purchase", mapOf("item" to "Laptop", "price" to 999))
    }
}