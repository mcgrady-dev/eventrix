package com.mcgrady.analytics.sensors

import android.content.Context
import com.mcgrady.analytics.core.EventTrackAttrs
import com.mcgrady.analytics.core.EventTrackClient
import org.json.JSONObject

/**
 * Created by mcgrady on 2021/10/15.
 */
class SensorsEventTrackClient : EventTrackClient {

    companion object {
        @JvmStatic
        val instance: SensorsEventTrackClient by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { SensorsEventTrackClient() }
    }

    override fun track(context: Context?, eventName: String, attrKey: String, attrValue: Any?) {
        TODO("Not yet implemented")
    }

    override fun track(context: Context?, eventName: String, attrs: Map<String, Any>) {
        TODO("Not yet implemented")
    }

    override fun track(context: Context?, eventName: String, attrs: JSONObject) {
        TODO("Not yet implemented")
    }

    override fun track(context: Context?, eventName: String, attrs: EventTrackAttrs) {
        TODO("Not yet implemented")
    }
}