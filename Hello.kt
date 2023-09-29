//La fonction main avec les arguments...
// fun main(args:Array<String>) {
//     println("Hello, World")
// }
//=> Hello, World

// fun main(args: Array<String>) {
//     println("Hello, ${args[0]}")
// }
//Hello Kotlin

//--------Presque tout retourne une valeur en Kotlin----------------
val isUnit = println("This is an expression")
println(isUnit)
//=> This is an expression
//Kotlin.Unit est la valeur par défaut retourner par kotlin, si une fonction ne retourne pas une valeur.

fun main() {
    val temperature = 10
    val isHot = if (temperature > 50) true else false
    println(isHot)
    val message = "The water temperature is ${ if (temperature > 50) "too warm" else "OK" }."
    println(message)
    //=>The water temperature is OK.
}
