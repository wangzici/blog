package com.kyrie.proj.blog.track

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kyrie.proj.blog.R
import com.kyrie.proj.blog.track.ui.tracklist.TrackListFragment

class TrackStudyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.track_study_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TrackListFragment.newInstance())
                .commitNow()
        }
    }
}