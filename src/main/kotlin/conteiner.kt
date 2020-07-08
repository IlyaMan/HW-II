import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext
import java.net.URL;
import java.net.URLClassLoader;
val classLoaderUrls = arrayOf(URL("file:///Users/Elijah/Code/HW-II/src/main/resources/H.jar"))
val urlClassLoader = URLClassLoader(classLoaderUrls)
val beanClass = urlClassLoader.loadClass("Yuppi")

val myModule: Module = applicationContext {
    factory { Gun(get()) as Shootable }
    factory { II() as Strategy }
    factory { Player(ii_ = get(), yuppi = get()) as Bot }
    bean { Observer() as WatchOut }
    bean {beanClass.getConstructor().newInstance() as Huray}
}
