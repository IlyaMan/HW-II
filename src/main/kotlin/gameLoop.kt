import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

val WINCONST = 12
val PLAYERS_SIZE = 6

class GameLoop() : KoinComponent {

    val gun: Shootable by inject()
    val observer: WatchOut by inject()
    val players = mutableListOf<Bot>()

    fun gameLoop(): Boolean {
        for (i: Int in 1..PLAYERS_SIZE) {
            val yuppi : Huray by inject()
            print(yuppi.getDeadPhrase())
            val player: Bot by inject()
            players.add(player)
        }
        val U: Bot by inject()
        while (observer.winner != true) {
            val t = readLine()!!.toString()
            when (t) {
                "1" -> {
                    println("Lets try!")
                    U.shoot(gun, observer)
                }
                "0" -> println("Pass? Ok")
                else -> println("Oh, man, you are nervous, try it next round")

            }
            for (i in players) {
                if (observer.winner != true) {
                    i.go(gun, observer)
                } else {
                    println("We have a winner. See you next time. May bee... BANG!")
                    return true
                }
            }
        }
        println("We have a winner. See you next time. May bee... BANG!")
        return true
    }

}
