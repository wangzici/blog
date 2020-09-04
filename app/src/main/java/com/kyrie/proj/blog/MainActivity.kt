package com.kyrie.proj.blog

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kyrie.proj.blog.fragment.FragmentTestActivity
import com.kyrie.proj.blog.nestedscroll.NestedScrollActivity
import com.kyrie.proj.blog.textview.TextActivity
import com.kyrie.proj.blog.track.TrackStudyActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_fragment -> startActivity(Intent(this, FragmentTestActivity::class.java))
            R.id.button_nested -> startActivity(Intent(this, NestedScrollActivity::class.java))
            R.id.button_text -> startActivity(Intent(this, TextActivity::class.java))
            R.id.button_track -> startActivity(Intent(this, TrackStudyActivity::class.java))
        }
    }

}
