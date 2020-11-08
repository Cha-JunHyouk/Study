package kotlinstudy

fun main() {
    val items=setOf("apple", "banana", "kiwifruit")
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }
}

//in 연산자로 좌항이 우항 안에 포함되어 있는가 체크