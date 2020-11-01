package kotlinstudy

fun getStringLength(obj:Any):Int? {
    if(obj is String) {
        //'obj'is automatically cast to 'String' in this branch
        return obj.length
    }

    //'obj' is still of type 'Any' outside of the type-checked branch
    return null
}
/*
fun getStringLength(obj:Any):Int? {
   if(obj !is String) return null
        return obj.length
    }
 */
/*
fun getStringLength(obj:Any):Int? {
   if(obj is String && obj.length>0) {
        return obj.length
    }
 */

fun main() {
    fun printLength(obj:Any) {
        println("'$obj' string length is ${getStringLength(obj)?:"... err, not a string"}")
    }
    printLength("Incomprehensibilities")
    printLength(1888)
    printLength(listOf(Any()))
}