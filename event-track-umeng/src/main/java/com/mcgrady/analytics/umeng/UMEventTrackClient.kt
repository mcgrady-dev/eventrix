package com.mcgrady.analytics.umeng

import android.content.Context
import com.mcgrady.analytics.core.EventTrackAttrs
import com.mcgrady.analytics.core.EventTrackClient
import com.umeng.analytics.MobclickAgent
import org.json.JSONObject

/**
 * Created by mcgrady on 2021/10/14.
 */
object UMEventTrackClient : EventTrackClient {

//    companion object {
//        @JvmStatic
//        val instance: UMEventTrackClient by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { UMEventTrackClient() }
//    }

    override fun init(context: Context) {
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO)
    }

    override fun track(context: Context?, eventName: String, attrKey: String, attrValue: Any?) {
        context?.let {
            MobclickAgent.onEvent(it, eventName, if (attrValue != null) attrValue as String else "")
        }
    }

    override fun track(context: Context?, eventName: String, attrs: Map<String, Any>) {
        context?.let {
            MobclickAgent.onEventObject(it, eventName, attrs)
        }
    }

    override fun track(context: Context?, eventName: String, attrs: EventTrackAttrs) {
        context?.let {
            MobclickAgent.onEventObject(it, eventName, attrs.toMap())
        }
    }

    override fun track(context: Context?, eventName: String, attrs: JSONObject) {

    }
}