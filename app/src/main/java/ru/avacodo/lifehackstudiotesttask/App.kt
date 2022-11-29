package ru.avacodo.lifehackstudiotesttask

import android.app.Application
import org.koin.core.context.startKoin
import ru.avacodo.lifehackstudiotesttask.di.repositoryModule
import ru.avacodo.lifehackstudiotesttask.di.retrofitModule
import ru.avacodo.lifehackstudiotesttask.di.usecaseModule
import ru.avacodo.lifehackstudiotesttask.di.viewModelModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                viewModelModule,
                usecaseModule,
                repositoryModule,
                retrofitModule)
        }
    }
}