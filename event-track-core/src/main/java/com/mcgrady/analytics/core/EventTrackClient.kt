package com.mcgrady.analytics.core

import android.content.Context
import org.json.JSONObject


/**
 * 埋点客户端统一接口
 * Created by mcgrady on 2021/10/14.
 */
interface EventTrackClient {

    fun init(context: Context) { }

    fun track(context: Context? = null, eventName: String, attrKey: String, attrValue: Any? = "")

    fun track(context: Context? = null, eventName: String, attrs: Map<String, Any>)

    fun track(context: Context? = null, eventName: String, attrs: JSONObject)

    fun track(context: Context? = null, eventName: String, attrs: EventTrackAttrs)
}