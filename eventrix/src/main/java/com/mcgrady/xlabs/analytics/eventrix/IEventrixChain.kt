package com.mcgrady.xlabs.analytics.eventrix

interface IEventrixHandler {
    fun proceed(eventName: String, params: Map<String, Any>?): Boolean
}
