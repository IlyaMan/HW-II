import com.beust.klaxon.Klaxon
import java.io.File

val base64Const = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"

class Mapper(var version: Int,
             var sources: Array<String>,
             var names: Array<String>,
             var mappings: String)

fun main(arg: Array<String>) {
    var fname : String = "src/main/resources/o.js.map"
    var jsMap: String = File(fname).readText()
    val result = Klaxon().parse<Mapper>(jsMap)

    with(result!!) {
        var maps = mappings.split(",")
        var list = mutableListOf(0, 0, 0, 0, 0)
        for (m in maps) {
            var sign: Int = 0
            var value: Int = 0
            var cont: Boolean = false
            var t: Int = 0
            var i: Int = 0
            for (c in m) {
                t = base64Const.indexOf(c)
                sign = if ((t and 1) == 0) 1 else -1
                cont = (t and 32 == 32)
                value = ((t shr 1) and 0b1111) * sign
                if ((i == 2) && (value != 0)){
                    list[3] = 0
                }
                if (cont) {
                    list[i] =  (list[i] + value) * 16
                } else {
                    list[i] = (list[i] + value)
                    i++
                }

            }
            i = 0
//            println("${m} stands for ${list}")
            println("Symbol ${list[0]} links to line ${list[2]} column ${if (list[3] > 0) list[3] else File("src/main/resources/input.js").readLines()[list[2]].length
            - list[3]} of file ${sources[list[1]]} and belongs to ${names[list[4]]}")

        }
    }


}


