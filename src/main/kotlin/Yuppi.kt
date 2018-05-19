class Yuppi() : Huray {
    override val winPhrase = mutableListOf("I Won it!", "Cooooooool!!!!!!", "It feels... good to be alive")
    override val deadPhrase = mutableListOf("I am so young:(", "I'm already dead", "Omae wa mou shindeiru")

    override fun getWinningPhrase(): String {
        return (winPhrase[(Math.random() * 100 % winPhrase.size).toInt()])
    }

    override fun getDeadPhrase(): String {
        return (deadPhrase[(Math.random() * 100 % deadPhrase.size).toInt()])
    }

}

interface Huray {
    val winPhrase: MutableList<String>
    val deadPhrase: MutableList<String>
    fun getWinningPhrase(): String
    fun getDeadPhrase(): String
}