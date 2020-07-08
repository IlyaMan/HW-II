import org.koin.standalone.StandAloneContext
import java.net.URL;
import java.net.URLClassLoader;
fun main(args: Array<String>) {

    val classLoaderUrls = arrayOf(URL("file:///Users/Elijah/Code/HW-II/src/main/resources/H.jar"))
    val urlClassLoader = URLClassLoader(classLoaderUrls)
    val beanClass = urlClassLoader.loadClass("Yuppi")
    var a = beanClass.getConstructor().newInstance()
    beanClass.getMethod("getWinningPhrase").invoke(a)
    StandAloneContext.startKoin(listOf(myModule))
    GameLoop().gameLoop()

}