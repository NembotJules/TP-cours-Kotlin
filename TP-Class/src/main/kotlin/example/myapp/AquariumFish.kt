package example.myapp
//step3 debut

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

//Creation de la classe PrintingFishAction
class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}
//Ajouter une delegation interface pour FishColor
class Plecostomus:  FishAction, FishColor by GoldColor {
    override fun eat() {
        println("eat algae")
    }
}
//creer une interface FishAction
interface FishAction  {
    fun eat()
}