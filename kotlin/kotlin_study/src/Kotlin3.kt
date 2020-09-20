package kotlin_study

fun main() {
    val PI=3.14                 //val=value, 고정값. 불변
    var x=0                     //var=variation, 변수. 가변

    fun incrementX(){           //단순 함수명
        x+=1                    //함수의 내용(x 가산 연산)
    }
    println("x=$x; PI=$PI")
    incrementX()
    println("incrementX()")
    println("x=$x, PI=$PI")

    var a=1
    val s1="a is $a"

    a=2
    val s2="${s1.replace("is","was")}"
    println(s2)
//조건식
    fun maxOf(a:Int,b:Int): Int {
        if (a>b) {
            return a
        } else {
            return b
        }
    }
    println("max of 0 and 42 is ${maxOf(0,42)}")

    fun maxof(c:Int,d:Int)=if(c>d)c else d
    println("max of 0 and 42 is ${maxof(0,42)}")

//nullable 값 및 null 검사

}