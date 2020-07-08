class Observer : WatchOut {
    override var shot: Boolean = false

    override var winner = false

    override fun nextRound() {
        shot = false
    }

}

interface WatchOut {
    var shot: Boolean
    var winner: Boolean
    fun nextRound()
}