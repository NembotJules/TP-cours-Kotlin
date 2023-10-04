package example.myapp

//creation de classe abstraite
abstract class AquariumFish {
    abstract val color: String

}
//Ajout de FishAction dans chaque subclasse
class Shark: AquariumFish(), FishAction {
    override val color = "grey"
    override fun eat() {
        println("hunt and eat fish")
    }
}

class Plecostomus: AquariumFish(), FishAction{
    override val color = "gold"
    override fun eat() {
        println("eat algae")
    }
}

//creer une interface FishAction
interface FishAction  {
    fun eat()
}