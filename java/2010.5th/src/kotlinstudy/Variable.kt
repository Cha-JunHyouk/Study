package kotlinstudy

fun main() {
    val a: Int = 1     //immediate assignment 즉각적으로 할당됨
    val b = 2         //'Int' type is inffered 'Int' 타입으로 추론됨
    val c: Int           //Type required when no initializer is provided
    c=3
    println("a=$a. b=$b. c=$c")

    var x=5         //"int" type is inferred 'Int' 타입으로 추론됨
    x+=1
    println("x=$x")

    println("x1=$x1; PI=$PI")
    incrementX()
    println("incrementX()")
    println("x1=$x1; PI=$PI")
}

val PI=3.14
var x1=0

fun incrementX() {
    x1 += 1
}