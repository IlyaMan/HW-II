import org.koin.standalone.StandAloneContext


fun main(args: Array<String>) {
//    val classLoaderUrls = arrayOf(URL("file:///Users/Elijah/IdeaProjects/R/src/main/resources/Y.jar"))
//    val urlClassLoader = URLClassLoader(classLoaderUrls)
//    val beanClass = urlClassLoader.loadClass("Y")
//    var a = beanClass.getConstructor().newInstance()
//    beanClass.getMethod("Method").invoke(a)
    StandAloneContext.startKoin(listOf(myModule))
    GameLoop().gameLoop()

}