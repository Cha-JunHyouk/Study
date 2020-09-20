package kotlin_study

fun main() {
    println("sum of 3 and 5 is ${sum(3, 5)}")
}

fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")               //$는 해당 String의 위치에 값이 들어가는 것
    fun main() {
        printSum(-1, 8)
    }                                                     //return type을 Kotlin에서는 알아서 지정해준다
}