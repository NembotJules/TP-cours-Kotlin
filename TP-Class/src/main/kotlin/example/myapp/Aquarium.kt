// TP CLASSES ET OBJETS...

package example.myapp

class Aquarium {
    var width: Int = 20
    var height:Int = 40
    var length: Int = 100

    fun printSize() {
        println("Width: $width cm " +
                "Length: $length cm  "   +
                "height:  $height cm")
    }
}
//You can access properties directly, for example, myAquarium.length