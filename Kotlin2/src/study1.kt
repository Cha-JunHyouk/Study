class study

fun main(args:Array<String>) {
    println("Hello world")
}
//함수를 선언할 때 fun 키워드를 사용한다. 실제로도 코틀린 프로그래밍은 수많은 fun을 만드는 재미있는 fun 일이다＇.
//파라미터 이름 뒤에 그 파라미터의 타입을 쓴다. 나중에 보겠지만 변수를 선언할 때도 마찬가지 방식으로 타입을 지정한다．
//함수를 최상위 수준에 정의할 수 있다. （자바와 달리）꼭 클래스 안에 함수를 넣어 야 할 필요가 없다．
//배열도 일반적인 클래스와 마찬가지다. 코틀린에는 자바와 달리 배열 처리를 위한 문법이 따로 존재하지 않는다．
//System,out,println 대신에 println이라고 쓴다 . 코틀린 표준 라이브러리
//는 여러 가지 표준 자바 라이브러리 함수를 간결하게 사용할 수 있게 감싼 래퍼
//wrappe「를 제공한다. println도 그런 함수 중 하나다．
//최신 프로그래밍 언어 경향과 마찬가지로 줄 끝에 세미콜론쟈）을 붙이지 않아도 좋다．

fun max(a:Int,b:Int):Int=if(a>b) a else b
//if문이 아니라 if식
fun max(a:Int,b:Int)=if(a>b) a else b

//코틀린에서는 키워드로 변수 선언을 시작하는 대신 변수 이름 뒤에 타입을 명시하거나 생략하게 허용한다
val question ="삶, 우추, 그리고 모든 것에 대한 궁극적인 질문"
val answer = 42
//val:변경 불가능환 변수
//var:변경 가능한 변수
//변경 불가능한 변수를 권장->함수형 코드에 가까워짐
//val 참조 자체는 불변일지라도 그 참조가 가리키는 객쳬의 내부 값은 변경될 수 있다.
//var는 변수의 값을 변경할 수 있지만 변수의 타입은 고정돼 바뀌지 않는다


fun main(args:Array<String>) {
    val name=if(args.size>0) args[0] else"Kotlin"
    println("Hello, $name!")
}
//문자열 리터럴의 필요한 곳에 변수를 넣되 변수 앞에 ＄를 추가해야 한다．

class Person (val name: String)
//이런 유형의 클래스（코드가 없이 데이터만 저장하는 클래스）를 값 객체(value object)라 부르며，
//다양한 언어가 값 객쳬를 간결하게 기술할 수 있는 구문을 제공한다．

//java 프로그래밍 구조와 도일하게 짜는 것을 추천함
//java와 Kotlin을 함께 사용하는 프로젝트에서는 java의 방식을 따르는 것이 중요하다.

enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}
//enum은 자바 선언보다 코틀린 선언에 더 많은 키워드를 써야 하는 흔치 않은 예
//enum은 class 앞에 있을 때는 특별한 의미를 지니지만 다른 곳에서는 이름에 사용할 수 있다
//enum 클래스 안에도 프로퍼티나 메소드를 정의할 수 있다

fun getMnemonic (color: Color) =
    when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color. YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }
println(getMnemonic (Color.BLUE) )

