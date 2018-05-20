//class Yuppi() : Huray {
//    override val winPhrase = mutableListOf("A", "B", "C")
//    override val deadPhrase = mutableListOf("D", "E", "F")
//
//    override fun getWinningPhrase(): String {
//        return (winPhrase[(Math.random() * 100 % winPhrase.size).toInt()])
//    }
//
//    override fun getDeadPhrase(): String {
//        return (deadPhrase[(Math.random() * 100 % deadPhrase.size).toInt()])
//    }
//
//}

interface Huray {
    val winPhrase: MutableList<String>
    val deadPhrase: MutableList<String>
    fun getWinningPhrase(): String
    fun getDeadPhrase(): String
}