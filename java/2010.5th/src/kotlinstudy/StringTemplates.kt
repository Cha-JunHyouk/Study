package kotlinstudy

fun main() {
    var a=1     //Simple name in template:
    val s1="a is $a"
    println(s1)

    a=2         //arbitrary expression in template: 템플릿의 임의 표현식
    val s2="${s1. replace("is", "was")}, but now is $a"
    println(s2)
}