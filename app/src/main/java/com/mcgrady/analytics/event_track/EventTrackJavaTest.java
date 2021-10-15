package com.mcgrady.analytics.event_track;

import android.content.Context;

import com.mcgrady.analytics.core.EventTrack;
import com.mcgrady.analytics.core.EventTrackAttrs;
import com.mcgrady.analytics.sensors.SensorsEventTrackClient;
import com.mcgrady.analytics.umeng.UMEventTrackClient;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mcgrady on 2021/10/14.
 */
public class EventTrackJavaTest {

    void main(Context context) {

        Map<String, Object> attrsMap = new HashMap<>();
        attrsMap.put("name", "test");
        attrsMap.put("age", "20");

        //代理类使用方式
        EventTrack.with(UMEventTrackClient.INSTANCE)
                .eventName("eventName")
                .add("key1", "value1")
                .add(attrsMap)
                .asJsonObject()
                .track();

        //自定义代理类使用方式
        MyEventTrack.with(UMEventTrackClient.INSTANCE)
                .button("button")
                .title("title")
                .eventName("eventName")
                .add("key1", "value1")
                .add(attrsMap)
                .asMap()
                .track(context);

        //客户端使用方式
        SensorsEventTrackClient.getInstance()
                .track(null, "eventName", "key1", "value1");

        EventTrackAttrs attrs = EventTrackAttrs.create()
                .add("key1", "value1")
                .add(attrsMap)
                .build();
        UMEventTrackClient.INSTANCE
                .track(context, "eventName", attrs);

    }
}
