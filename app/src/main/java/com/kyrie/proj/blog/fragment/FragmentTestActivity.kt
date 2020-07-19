package com.kyrie.proj.blog.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.kyrie.proj.blog.R
import kotlinx.android.synthetic.main.activity_fragment_test.*

class FragmentTestActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG_HOME = "TAG_HOME"
    private val TAG_FAVORITE = "TAG_FAVORITE"
    private val KEY_TAG = "TAG_KEY"
    var currFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("wzt", "onCreate : " + javaClass.simpleName)
        setContentView(R.layout.activity_fragment_test)
        val lastTag = savedInstanceState?.getString(KEY_TAG, TAG_HOME) ?: TAG_HOME
        changeFragment(TAG_HOME)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //记录当前Fragment的tag
        currFragment?.let {
            outState.putString(KEY_TAG, it.tag)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("wzt", "onDestroy : " + javaClass.simpleName)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button1 -> changeFragment(TAG_HOME)
            R.id.button2 -> changeFragment(TAG_FAVORITE)
        }
    }

    private fun changeFragment(tag: String) {
        val fragment = initFragment(tag)
        Log.i("wzt", "changeFragment : $fragment")
        if (currFragment == fragment) {
            return
        }
        val transaction = supportFragmentManager.beginTransaction()
        currFragment?.let { transaction.hide(it) }
        if (!fragment.isAdded) {
            transaction.add(R.id.fl_content, fragment, tag)
        }
        transaction.show(fragment)
        currFragment = fragment
        transaction.commitAllowingStateLoss()
    }

    private fun initFragment(tag: String): Fragment {
        var fragment = supportFragmentManager.findFragmentByTag(tag)
        if (fragment == null) {
            fragment = when (tag) {
                TAG_FAVORITE -> FavoriteFragment()
                TAG_HOME -> HomeFragment()
                else -> HomeFragment()
            }
        }
        return fragment
    }
}
