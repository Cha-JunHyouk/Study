package kotlinstudy

fun main() {
    val items=listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
    }
}
/*
fun main() {
    val items=listOf("apple", "banana", "kiwifruit")
    for(index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}
 */

//item을 배열 내의 인자를 뜻하는 변수로 설정하고, in을 이용하여 전부 꺼낸다.