package example.myapp
//step1 et step2

//Creer un singleton
object GoldColor : FishColor {
    override val color = "gold"
}


//CREER UNE NOUVELLE INTERFACE
interface FishColor {
    val color: String
}
//Changement de la classe Shark pour implementer une interface FishColor
//
class Shark:FishAction, FishColor {
    override val color = "grey"
    override fun eat() {
        println("hunt and eat fish")
    }
}
//Changement de la classe plecostomus pour implementer une interface FishColor
class Plecostomus: FishAction, FishColor {
    override val color = "gold"
    override fun eat() {
        println("eat algae")
    }
}

//creer une interface FishAction
interface FishAction  {
    fun eat()
}