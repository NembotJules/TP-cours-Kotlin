package example.myapp
//step3(fin)

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
//Ajouter une delegation interface pour FishColor (la modification a ete effectuee a ce niveau)
class Plecostomus(fishColor: FishColor = GoldColor):  FishAction,
    FishColor by fishColor {
    override fun eat() {
        println("eat algae")
    }
}

//creer une interface FishAction
interface FishAction  {
    fun eat()
}