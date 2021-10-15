package com.mcgrady.analytics.core

import org.json.JSONObject

/**
 * 埋点属性类，构建埋点信息
 * Created by mcgrady on 2021/10/14.
 */
class EventTrackAttrs @JvmOverloads constructor(builder: Builder = Builder()) {

    companion object {
        @JvmStatic
        fun create(): Builder = Builder()
    }

    var attrs: Map<String, Any> = builder.attrs

    class Builder {
        val attrs: MutableMap<String, Any> = mutableMapOf()

        fun add(attrKey: String, attrValue: Any?): Builder {
            attrs[attrKey] = attrValue ?: ""
            return this
        }

        fun add(attrsMap: Map<String, Any>): Builder {
            attrs.putAll(attrsMap)
            return this
        }

        fun build(): EventTrackAttrs {
            return EventTrackAttrs(this)
        }
    }

    fun toMap(): Map<String, Any> {
        return attrs
    }

    fun toJsonObject(): JSONObject = try {
        JSONObject(attrs)
    } catch (e: NullPointerException) {
        e.printStackTrace()
        JSONObject()
    }

    override fun toString(): String = toJsonObject().toString()
}