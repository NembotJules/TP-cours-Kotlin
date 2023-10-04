// TP SUR LES CLASSES ET LES OBJETS/


import example.myapp.Aquarium

fun buildAquarium() {
    val myAquarium = Aquarium()
    myAquarium.printSize()
    //Let set the height to 60 and print the changed dimension properties
    myAquarium.height = 60
    myAquarium.printSize()
}

fun main() {
    buildAquarium()
}