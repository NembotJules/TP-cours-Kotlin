// TP CLASSES ET OBJETS...
// SAAH NEMBOT JULES CLINTON --->  19GOO503

package example.myapp

class Aquarium (var length: Int = 100, var width: Int = 20, var height: Int = 40){

    constructor(numberOfFish: Int) : this() {
        // 2000 cm^3 per fish + extra room so water doesn't spill
        val tank = numberOfFish * 2000 * 1.1
        height = (tank / (length * width)).toInt()
    }

        // Adding getters and setters...

    var volume: Int
        get() = width * height * length / 1000 // 1000 cm^3 = 1 liter
        set(value) {
            height = (value * 1000) / (width * length)
        }

    init {
        println("Aquarium initialization")
    }


    fun printSize() {
        println("Width: $width cm " +
                "Length: $length cm  "   +
                "height:  $height cm")
        println("Volume:  $volume liters")
    }
}
//You can access properties directly, for example, myAquarium.length