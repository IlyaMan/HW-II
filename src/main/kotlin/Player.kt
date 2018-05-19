class Player(override var money: Int = 1, override var alive: Boolean = true, val ii_: Strategy) : Bot {
    override val ii = ii_.myII
    val name = arrayListOf("John", "Jack", "Stack", "Crack", "Pack", "Check", "RedNeck")[(Math.random() * 100 % 6).toInt()]
    override fun shoot(g: Shootable, observer: WatchOut) {
        if (alive && money < WINCONST) {
            println("${name}: My turn...")
            var t = g.gun
            if (t) {
                println("BANG!")
                if (money > 0) {
                    observer.shot = true
                    money = 0
                } else {
                    alive = false
                    println("${name}: ${Yuppi().getDeadPhrase()}")
                    observer.shot = true
                }
            } else {
                money += 1
                if (money >= WINCONST) {
                    println("${name}: ${Yuppi().getWinningPhrase()}")
                    observer.winner = true
                }
            }

        }
    }

    override fun go(g: Shootable, observer: WatchOut) {
        ii(this, g, observer)
    }
}

interface Bot {
    var money: Int
    var alive: Boolean
    val ii: (Bot, Shootable, WatchOut) -> Unit
    fun shoot(g: Shootable, observer: WatchOut)
    fun go(g: Shootable, observer: WatchOut)
}