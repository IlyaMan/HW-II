import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext


val myModule: Module = applicationContext {
    factory { Gun(get()) as Shootable }
    factory { II() as Strategy }
    factory { Yuppi() as Huray }
    factory { Player(ii_ = get()) as Bot }
    bean { Observer() as WatchOut }
}
