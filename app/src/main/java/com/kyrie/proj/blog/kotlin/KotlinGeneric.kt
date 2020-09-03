package com.kyrie.proj.blog.kotlin

/**
 * Created by Kyrie
 * Date: 2020/8/27
 *
 */
fun main() {
    val listString = listOf("A", "B", "C")
    val list = test(listString, "B")
    println(list)
}

//多个上界的泛型
fun <T> test(list: List<T>, t: T) : List<T>
        where T : Comparable<T>,
              T : CharSequence {
    return list.filter { it > t }.map { it }
}

//kotlin的协变,可看成上界通配符extends
fun sunOfList(list: List<out Number>) {

}

//kotlin的逆变，可看成下界通配符super
/*
fun  addNumbers(list: List<in Int>) {

}

internal fun addNumber(list: List<in Int>) {

}*/
