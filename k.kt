open class Auto(
        open var name: String? = null,
        var maxSpeed: Int = 300, var capacity: Int = 4,
        open var country: String? = null) {

    open var info: String? = null
        get() {
            return ("Name: $name\nCountry: $country\nCapacity: $capacity\nMaxSpeed: $maxSpeed")
        }

}

class D(
        override var name: String?,
        var someStuff: String?,
        override var country: String? = "LAND") : Auto() {
    override var info: String? = null
        get() {
            return ("Name: $name\nCountry: $country\nCapacity: $capacity\nMaxSpeed: $maxSpeed\nSomeStuff: $someStuff")
        }
}

fun main(args: Array<String>) {
    var a = Auto("M", 311, 4, "S")
    println(a.info)
    var b = D(name = "GARBAGE CAR", someStuff = "Stuffy")
    println(b.info)


}
