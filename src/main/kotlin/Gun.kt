class Gun(var observer: WatchOut) : Shootable {
    override val revolversSize = 6
    override fun loadTheGun(): MutableList<Boolean> {
        var b: MutableList<Boolean> = mutableListOf()
        for (i in 1..revolversSize) { //revolvers size is constant
            b.add(false)
        }
        b[(Math.random() * 100).toInt() % revolversSize] = true
        return b
    }

    override var revolver = loadTheGun()
    override var index: Int = 0
    override var gun: Boolean = false
        get() {
            if (index < revolversSize - 1) {
                index += 1
                return revolver[index]
            } else {
                revolver = loadTheGun()
                observer.nextRound()
                index = 0
                return false

            }
        }

}

interface Shootable {
    val revolversSize: Int
    fun loadTheGun(): MutableList<Boolean>
    var revolver: MutableList<Boolean>
    var index: Int
    var gun: Boolean
}