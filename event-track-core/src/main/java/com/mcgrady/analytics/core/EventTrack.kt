package com.mcgrady.analytics.core

import android.content.Context
import org.json.JSONObject


/**
 * 埋点代理类
 * Created by mcgrady on 2021/10/14.
 */
open class EventTrack(private val eventTrackClient: EventTrackClient) {

    companion object {
        @JvmStatic
        fun with(eventTrackClient: EventTrackClient) = EventTrack(eventTrackClient)
    }

    protected var attrs: MutableMap<String, Any> = mutableMapOf()
    private var eventName: String? = ""
    private var attrsType: AttrsType? = AttrsType.MAP

    open fun eventName(eventName: String): EventTrack {
        this.eventName = eventName
        return this
    }

    open fun add(attrKey: String, attrValue: Any?): EventTrack {
        attrs[attrKey] = attrValue ?: ""
        return this
    }

    fun add(attrsMap: Map<String, Any>): EventTrack {
        attrs.putAll(attrsMap)
        return this
    }

    fun asMap(): EventTrack {
        attrsType = AttrsType.MAP
        return this
    }

    fun asJsonObject(): EventTrack {
        attrsType = AttrsType.JSONOBJECT
        return this
    }

    fun asString(): EventTrack {
        attrsType = AttrsType.STRING
        return this
    }

    fun track(context: Context) {
        eventName?.let {
            when (attrsType) {
                AttrsType.MAP -> {
                    eventTrackClient.track(context, it, attrs)
                }
                AttrsType.JSONOBJECT -> {
                    eventTrackClient.track(context, it, toJsonObject())
                }
                AttrsType.STRING -> {
                }
            }
        }
    }

    fun track() {
        eventName?.let {
            when (attrsType) {
                AttrsType.MAP -> {
                    eventTrackClient.track(eventName = it, attrs = toMap())
                }
                AttrsType.JSONOBJECT -> {
                    eventTrackClient.track(eventName = it, attrs = toJsonObject())
                }
                AttrsType.STRING -> {
                }
            }
        }
    }

    private fun toMap(): Map<String, Any> {
        return attrs
    }

    private fun toJsonObject(): JSONObject = try {
        JSONObject(attrs as Map<String, Any>)
    } catch (e: NullPointerException) {
        e.printStackTrace()
        JSONObject()
    }

    override fun toString(): String = toJsonObject().toString()

    private enum class AttrsType {
        MAP,
        JSONOBJECT,
        STRING
    }

}