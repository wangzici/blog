package com.kyrie.proj.blog.kotlin

/**
 * Created by Kyrie
 * Date: 2020/9/3
 *
 */
//只需要在class前加上annotation修饰符
@Target(AnnotationTarget.FIELD,AnnotationTarget.FUNCTION,AnnotationTarget.CLASS)
annotation class ApiDoc(val value: String)

@ApiDoc("修饰类")
class Box{
    @ApiDoc("修饰字段")
    val size = 6

    @ApiDoc("修饰方法")
    fun test() {

    }
}

enum class Method{
    GET,
    POST
}

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class HttpMethod(val method: Method)

interface Api{
    val name: String
    val version: String
        get() = "1.0"
}

@HttpMethod(Method.GET)
class ApiGetArticles : Api {
    override val name: String
        get() = "/api.articles"
}

fun getClassAnnotation(api: Api) {
    val annotations = api.javaClass.annotations
    val method = annotations.find { it is HttpMethod } as? HttpMethod
    println("通过注解得知该接口需要通过：${method?.method} 方式请求")
}

fun getVariableAnnotation(box: Box) {
    val annotations = box::class.java.getDeclaredField("size").annotations
    val apiDoc = annotations.find { it is ApiDoc } as? ApiDoc
    println("通过注解得知该属性的ApiDoc为：${apiDoc?.value}")
}

fun getMethodAnnotation(box: Box) {
    val annotations = box.javaClass.getDeclaredMethod("test").annotations
    val apiDoc = annotations.find { it is ApiDoc } as? ApiDoc
    println("通过注解得知该方法的ApiDoc为：${apiDoc?.value}")
}

fun main() {
    //在运行时通过反射获取注解信息
    getClassAnnotation(ApiGetArticles())
    getVariableAnnotation(Box())
    getMethodAnnotation(Box())
}