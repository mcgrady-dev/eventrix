package com.mcgrady.analytics.event_track

import com.mcgrady.analytics.core.EventTrack
import com.mcgrady.analytics.core.EventTrackClient

/**
 * 自定义埋点客户端的代理类案例，也可直接使用客户端处理
 * 注意：自定义埋点属性需写在 EventTrack 内置方法前面
 * Created by mcgrady on 2021/10/14.
 */
class MyEventTrack private constructor(eventTrackClient: EventTrackClient): EventTrack(eventTrackClient) {

    companion object {
        @JvmStatic
        fun with(eventTrackClient: EventTrackClient) = MyEventTrack(eventTrackClient)

        private const val COMMON_TITLE_KEY = "title"
        private const val COMMON_BUTTON_CONTENT_KEY = "button_name"
        private const val COMMON_USER_ID_KEY = "user_id"
    }

    fun title(titleName: String?): MyEventTrack {
        attrs[COMMON_TITLE_KEY] = titleName ?: ""
        return this
    }

    fun button(btnName: String?): MyEventTrack {
        attrs[COMMON_BUTTON_CONTENT_KEY] = btnName ?: ""
        return this
    }

    fun userId(): MyEventTrack {
//        val userId: String = SPUtil.getInstance().getUserId()
        val userId: String = "mcgrady"
        return userId(userId)
    }

    fun userId(userId: String?): MyEventTrack {
        attrs.put(COMMON_USER_ID_KEY, userId ?: "")
        return this
    }

}