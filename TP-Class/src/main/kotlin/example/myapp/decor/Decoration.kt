package example.myapp.decor

//step2
// data class avec 3 proprietes
data class Decoration2(val rocks: String, val wood: String, val diver: String){
}

fun makeDecorations() {
    val d5 = Decoration2("crystal", "wood", "diver")
    println(d5)

// Assigner toutes les proprietes aux variables
    val (rock, wood, diver) = d5
    println(rock)
    println(wood)
    println(diver)
}
