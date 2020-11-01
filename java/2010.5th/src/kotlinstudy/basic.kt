package kotlinstudy

fun main() {        //An entry point of a Kotlin application is the main function.
    println("Hello world!")
}

fun sum (a: Int, b: Int): Int {    //Fuction having two Int parameters with Int return type
    return a+b
}

fun sum1 (a: Int, b: Int)=a+b      //Fuction with an expression body and inferred return type

fun printSum (a: Int, b: Int): Unit {  //Fuction returning no meaningful value
    println("sum of $a and $b is ${a+b}")
}

fun printSum1 (a: Int, b: Int) {      //Unit return type can be omitted
    println("sum of $a and $b is ${a+b}")
}