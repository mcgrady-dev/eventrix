package com.mcgrady.analytics.event_track

import android.app.Application
import com.mcgrady.analytics.umeng.UMEventTrackClient

/**
 * Created by mcgrady on 2021/10/15.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        UMEventTrackClient.init(this)
    }
}