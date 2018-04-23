

val WINCONST = 12

class Observer(shot: Boolean = false) {
    var shot: Boolean = shot

    var winner = false

    fun nextRound() {
        shot = false
    }

}

class Yuppi() {
    val winPhrase = mutableListOf("I Won it!", "Cooooooool!!!!!!", "It feels... good to be alive")
    val deadPhrase = mutableListOf("I am so young:(", "I'm already dead", "Oh me shunderu")

    fun getWinningPhrase(): String {
        return (winPhrase[(Math.random() * 100 % 3).toInt()])
    }

    fun getDeadPhrase(): String {
        return (deadPhrase[(Math.random() * 100 % 3).toInt()])
    }

}


class Player(val name: String? = null, var money: Int = 1, var alive: Boolean = true, val ii: II) {
    fun shoot(g: Gun, observer: Observer) {
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

    fun go(g: Gun, observer: Observer) {
        when (ii.name) {
            "Clever" -> ii.cleverGui(this, g, observer)
            "AllIn" -> ii.allIn(this, g, observer)
        }
    }
}


class II(var name: String = "AllIn") {
    fun allIn(p: Player, g: Gun, observer: Observer) {
        p.shoot(g, observer)
    }

    fun cleverGui(p: Player, g: Gun, observer: Observer) {
        if (p.money > 0 || observer.shot) {
            p.shoot(g, observer)
        }
    }
}


class Gun(var observer: Observer) {
    fun loadTheGun(): MutableList<Boolean> {
        var b: MutableList<Boolean> = mutableListOf()
        for (i in 1..6) {
            b.add(false)
        }
        b[(Math.random() * 100).toInt() % 6] = true
        return b
    }

    var revolver = loadTheGun()
    var index: Int = 0
    var gun: Boolean = false
        get() {
            if (index < 5) {
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

fun gameLoop(players: ArrayList<Player>, observer: Observer, g: Gun) : Boolean {
    var U = Player("U", 1, true, II("AllIn"))
    while (observer.winner != true) {
        val t = readLine()!!.toString()
        when (t) {
            "1" -> {
                println("Lets try!")
                U.shoot(g, observer)
            }
            "0" -> println("Pass? Ok")
            else -> println("Oh, man, you are nervous, try it next round")

        }
        for (i in players) {
            if (observer.winner != true) {
                i.go(g, observer)
            }
            else{
                return true
                println("We have a winner. See you next time. May bee... BANG!")
            }
        }
    }
    return true
    println("We have a winner. See you next time. May bee... BANG!")

}

fun main(args: Array<String>) {
    var observer = Observer()
    val gun = Gun(observer)
    var players = arrayListOf(
            Player("Bobby", 1, true, II("AllIn")),
            Player("Robby", 1, true, II("Clever")),
            Player("Tobby", 1, true, II("AllIn")),
            Player("SLobby", 1, true, II("Clever")),
            Player("Pobby", 1, true, II("AllIn"))
    )
    gameLoop(players, observer, gun)

}
