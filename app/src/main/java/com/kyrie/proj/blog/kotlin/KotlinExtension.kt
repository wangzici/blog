package com.kyrie.proj.blog.kotlin

import android.app.Activity
import android.view.View
import androidx.annotation.IdRes

/**
 * Created by Kyrie
 * Date: 2020/9/6
 * kotlin扩展学习
 */

fun main() {
    val list = mutableListOf(1, 2, 3)
    list.swap(0, 2)
    println("list after swap is $list")//输出[3, 2, 1]
    println("\"A,B,C,D,E\".lastChar is ${"A,B,C,D,E".lastChar}")
}

/**
 * 为MutableList新增扩展方法，用于两个index的互换
 * 原理：反编译后其实是生成static void swap(@NotNull List $this$swap, int index1, int index2)函数
 */
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

/**
 * 泛型扩展
 */
fun <T> MutableList<T>.swap2(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

/**
 * 扩展属性
 */
val String.lastChar : Char
    get() {
        return this[this.length - 1]
    }

/**
 * let扩展
 */
fun testLet(str: String?) {
    //1.减少判空的次数
    str?.let {
        //2.限制作用域
        val str2 = "ABC"
        println(it + str2)
    }
}

data class Room(val address: String)

/**
 * run扩展
 * 可以有指定的返回值
 */
fun testRun(room: Room) {
    room.run {
        //1.可以直接访问address，简化调用
        //2.直接返回最后一行或者是自己return的值
        address
    }
}

/**
 * apply扩展
 * 可以直接访问其中的方法，并返回对象本身
 */
fun testApply() {
    ArrayList<String>().apply {
        add("1")
        add("2")
        add("3")
        add("4")
    }.let { println(it) }
}

/**
 * 案例1：减少find的模板代码
 */
fun <T : View> Activity.find(@IdRes id: Int): T {
    return this.findViewById(id)
}

/**
 * 案例2：减少为控件设置监听的模板代码
 * 使用方法：R.id.text.onClick(activity){ ... }
 */
fun Int.onClick(activity: Activity, click: () -> Unit) {
    activity.find<View>(this).apply {
        setOnClickListener { click() }
    }
}