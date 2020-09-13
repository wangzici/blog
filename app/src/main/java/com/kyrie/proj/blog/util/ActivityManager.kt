package com.kyrie.proj.blog.util

import android.app.Activity
import android.app.Application
import android.os.Bundle
import java.lang.ref.WeakReference

/**
 * Created by Kyrie
 * Date: 2020/9/13
 * Activity的管理类，用于判断activity是否处于前台
 */
class ActivityManager private constructor() {
    private val activityRefs = arrayListOf<WeakReference<Activity>>()
    private val frontCallbacks = arrayListOf<FrontCallback>()
    var front = true
    private var activityStartCount = 0
    companion object {
        val instance: ActivityManager by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            ActivityManager()
        }
    }

    fun getTopActivity(): Activity? {
        return if (activityRefs.size > 0) activityRefs.last().get() else null
    }
    //不推荐通过实现topActivity属性的get方法来实现函数的功能
/*    val topActivity: Activity?
        get() {
            return if (activityRefs.size > 0) activityRefs.last().get() else null
        }*/

    fun addCallback(callback: FrontCallback) {
        if (!frontCallbacks.contains(callback)) {
            frontCallbacks.add(callback)
        }
    }

    fun removeCallback(callback: FrontCallback) {
        frontCallbacks.remove(callback)
    }

    fun init(application: Application) {
        application.registerActivityLifecycleCallbacks(InnerActivityLifecycleCallbacks())
    }

    private fun onFrontChange(state: Boolean) {
        for (callback in frontCallbacks) {
            callback.onChanged(state)
        }
    }

    inner class InnerActivityLifecycleCallbacks : Application.ActivityLifecycleCallbacks {
        override fun onActivityPaused(activity: Activity) {
        }

        override fun onActivityStarted(activity: Activity) {
            activityStartCount++
            if (!front && activityStartCount > 0) {
                front = true
                onFrontChange(front)
            }
        }

        override fun onActivityDestroyed(activity: Activity) {
            for (activityRef in activityRefs) {
                if (activityRef.get() == activity) {
                    activityRefs.remove(activityRef)
                    break
                }
            }
        }

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        }

        override fun onActivityStopped(activity: Activity) {
            activityStartCount--
            if (front && activityStartCount <= 0) {
                front = false
                onFrontChange(front)
            }
        }

        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            activityRefs.add(WeakReference(activity))
        }

        override fun onActivityResumed(activity: Activity) {
        }

    }

    interface FrontCallback {
        fun onChanged(state: Boolean)
    }
}