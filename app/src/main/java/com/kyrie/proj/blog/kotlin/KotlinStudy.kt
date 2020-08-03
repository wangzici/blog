package com.kyrie.proj.blog.kotlin

/**
 * Created by Kyrie
 * Date: 2020/8/3
 *
 */
fun main() {
    testClosure(1)(2) {
        println(it)
    }
    add(2, 3)
}

/**
 * 实现一个testClosure方法，该方法接受一个Int类型的v1参数
 * 同时能够返回一个声明为(v2 : Int,(Int) -> Unit)的函数，并且此函数可计算v1和v2的和
 * (v2: Int, (Int) -> Unit) -> Unit表示testClosure返回一个无返回值的方法，此方法首个参数为int，第二个参数为另一个方法，此方法参数为Int，无返回值
 */
//若方法为返回值，则只写参数名可省略
//fun testClosure(v1: Int): (v2: Int, printer: (Int) -> Unit) -> Unit {
//若方法为返回值，此处可以省略类型
//    return fun(v2: Int, printer: (Int) -> Unit) {
fun testClosure(v1: Int): (Int, (Int) -> Unit) -> Unit {
    return fun(v2, printer) {
        printer(v1 + v2)
    }
}

/**
 * 匿名函数
 */
val add = fun(x: Int, y: Int): Int = x + y
//相当于
val add1 = fun(x:Int,y:Int):Int{
    return x + y
}

/**
 * 方法字面值，其实就是方法类型的变量
 */
var double : ((Int) -> Int)? = null
var double1 = {v1 : Int -> v1 * 2}
fun helper() {
    double = { num -> num * 2}
    double1 = { it * 3}
}