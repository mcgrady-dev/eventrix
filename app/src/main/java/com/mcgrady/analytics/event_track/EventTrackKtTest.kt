package com.mcgrady.analytics.event_track

import android.content.Context
import com.mcgrady.analytics.core.EventTrack
import com.mcgrady.analytics.core.EventTrackAttrs
import com.mcgrady.analytics.sensors.SensorsEventTrackClient
import com.mcgrady.analytics.umeng.UMEventTrackClient

/**
 * Created by mcgrady on 2021/10/14.
 */
class EventTrackKtTest {

    fun main(context: Context) {

        //代理类使用方式
        EventTrack.with(UMEventTrackClient)
            .eventName("eventName")
            .add("key1", "value1")
            .add(mapOf("key2" to "value2","key3" to "value3","key4" to "value4"))
            .asJsonObject()
            .track()

        //自定义代理类使用方式
        MyEventTrack.with(UMEventTrackClient)
            .button("button")
            .title("title")
            .eventName("eventName")
            .add("key1", "value1")
            .add(mapOf("key2" to "value2","key3" to "value3","key4" to "value4"))
            .asMap()
            .track(context)

        //客户端使用方式
        SensorsEventTrackClient.instance
            .track(eventName = "eventName", attrKey = "key1", attrValue = "value1")

        val attrs = EventTrackAttrs.create()
            .add("key1", "value1")
            .add(mapOf("key2" to "value2", "key3" to "value3", "key4" to "value4"))
            .build()
        UMEventTrackClient
            .track(context, "eventName", attrs)
    }
}