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
// val isUnit = println("This is an expression")
// println(isUnit)
//=> This is an expression
//Kotlin.Unit est la valeur par défaut retourner par kotlin, si une fonction ne retourne pas une valeur.

// fun main() {
//     val temperature = 10
//     val isHot = if (temperature > 50) true else false
//     println(isHot)
//     val message = "The water temperature is ${ if (temperature > 50) "too warm" else "OK" }."
//     println(message)
//     //=>The water temperature is OK.
// }
import java.util.*

// Creating some functions...
fun randomDay() : String {
    val week = arrayOf ("Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

// fun feedTheFish() {
//     val day = randomDay()
//     val food = "pellets"
//     println ("Today is $day and the fish eat $food")
// }



// Use a when expression
// fun fishFood (day : String) : String {
//     var food = ""
//     when (day) {
//         "Monday" ->  "flakes"
//         "Tuesday" -> "pellets"
//         "Wednesday" -> "redworms"
//         "Thursday" -> "granules"
//         "Friday" -> "mosquitoes"
//         "Saturday" -> "lettuce"
//         "Sunday" -> "plankton"
//         else -> "nothing"
//     }
//     return food
// }

// fun feedTheFish() {
//     val day = randomDay()
//     val food = fishFood(day)

//     println ("Today is $day and the fish eat $food")
//     //=>Today is Thursday and the fish eat granules
// }

// fun main(args: Array<String>) {
//     feedTheFish()
// }

fun swim(speed: String = "fast") {
   println("swimming $speed")
}

fun main() {
    swim()
    swim("slow")   // positional argument
    swim(speed="turtle-like")   // named parameter

    // swimming fast
    // swimming slow
    // swimming turtle-like
}

//If no default is specified for a parameter, the corresponding argument must always be passed.

// fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
//     return when {
//         temperature > 30 -> true
//         dirty > 30 -> true
//         day == "Sunday" ->  true
//         else -> false
//     }
// }

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println ("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}
//Today is Thursday and the fish eat granules
//Change water: false

//-----Compact functions--------//
fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

//updating shouldChangeWater()
fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else  -> false
    }
}

//les valeurs par défaut peuvent aussi etre des fonctions
//exemple
fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = getDirtySensorReading()): Boolean {}

//Get started with filters...
val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

fun main() {
    println( decorations.filter {it[0] == 'p'})
    // eager, creates a new list
    val eager = decorations.filter { it [0] == 'p' }
    println("eager: $eager")
     // lazy, will wait until asked to evaluate
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")
     // force evaluation of the lazy list
    val newList = filtered.toList()
    println("new list: $newList")
     val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }
    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")


    //  lazy: kotlin.sequences.TransformingSequence@5ba23b66
    //     -----
    //     access: rock
    //     first: rock
    //     -----
    //     access: rock
    //     access: pagoda
    //     access: plastic plant
    //     access: alligator
    //     access: flowerpot
    //     all: [rock, pagoda, plastic plant, alligator, flowerpot]
    val lazyMap2 = decorations.asSequence().filter {it[0] == 'p'}.map {
        println("access: $it")
        it
    }
    println("-----")
    println("filtered: ${lazyMap2.toList()}")

//     ⇒
// -----
// access: pagoda
// access: plastic plant
// filtered: [pagoda, plastic plant]

val mysports = listOf("basketball", "fishing", "running")
val myplayers = listOf("LeBron James", "Ernest Hemingway", "Usain Bolt")
val mycities = listOf("Los Angeles", "Chicago", "Jamaica")
val mylist = listOf(mysports, myplayers, mycities)     // list of lists
println("-----")
println("Flat: ${mylist.flatten()}")

// ⇒
// -----
// Flat: [basketball, fishing, running, LeBron James, Ernest Hemingway, Usain Bolt, Los Angeles, Chicago, Jamaica]

}
//⇒ [pagoda, plastic plant]
//=> filtered: kotlin.sequences.FilteringSequence@386cc1c4
//=> new list: [pagoda, plastic plant]

//6. Get started with lambdas and higher-order functions

var dirtyLevel = 20
val waterFilter = { dirty : Int -> dirty / 2}
println(waterFilter(dirtyLevel))
val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
//⇒ 10
fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
   return operation(dirty)
}
val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
println(updateDirty(30, waterFilter))
//⇒ 15
fun increaseDirty( start: Int ) = start + 1

println(updateDirty(15, ::increaseDirty))
//⇒ 16
var dirtyLevel = 19
dirtyLevel = updateDirty(dirtyLevel) { dirtyLevel -> dirtyLevel + 23}
println(dirtyLevel)
//⇒ 42