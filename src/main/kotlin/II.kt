class II() : Strategy {
    val allIn = fun(p: Bot, g: Shootable, observer: WatchOut) {
        p.shoot(g, observer)
    }

    val cleverGui = fun(p: Bot, g: Shootable, observer: WatchOut) {
        if (p.money > 0 || observer.shot) {
            p.shoot(g, observer)
        }
    }
    override var myII = allIn
        get() {
            if (Math.random() <= 0.5) {
                return allIn
            } else {
                return cleverGui
            }
        }
}

interface Strategy {
    var myII: (Bot, Shootable, WatchOut) -> Unit
}
