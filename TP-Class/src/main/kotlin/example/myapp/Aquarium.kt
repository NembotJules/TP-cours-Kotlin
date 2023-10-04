// TP CLASSES ET OBJETS....

// SAAH NEMBOT JULES CLINTON --->  19GOO503

package example.myapp

import kotlin.math.PI

//Make the aquarium subclass open...

open class Aquarium (open var length: Int = 100, open var width: Int = 20, open var height: Int = 40){

    init {
        println("Aquarium initialization")
    }

   open var volume: Int
        get() = (width  * length * height / 1000 ) // 1000 cm^3 = 1 liter
        //Change the visibility of the setter to private
        set(value) {
            height = ((value * 1000) / (width * length))
        }

    open val shape = "rectangle"
    open var water: Double = 0.0
        get() = volume * 0.9


    constructor(numberOfFish: Int) : this() {
        // 2000 cm^3 per fish + extra room so water doesn't spill
       //val tank = numberOfFish * 2000 * 1.1
      //height = (tank / (length * width)).toInt()
    }


        // Adding getters and setters...

    fun printSize() {
        println(shape)
        println("Width: $width cm " +
                "Length: $length cm  "   +
                "height:  $height cm")
        println("Volume:  $volume liters")
    }

    //Create a subclass...

    class TowerTank(override var height: Int, var diameter: Int): Aquarium(height = height, width = diameter, length = diameter){
      override var volume: Int
            get() = (width/2  * length/2 * height / 1000 * PI).toInt() // 1000 cm^3 = 1 liter
            //Change the visibility of the setter to private
            set(value) {
                height = ((value * 1000/PI) / (width/2 * length/2)).toInt()
            }
            override var water = volume * 0.8
            override val shape = "cylinder"

    }
}
//You can access properties directly, for example, myAquarium.length