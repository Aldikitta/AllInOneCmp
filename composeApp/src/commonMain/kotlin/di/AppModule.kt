package di

import MainViewModel
import StringRepository
import StringRepositoryImpl
import StringUseCaseImpl
import org.koin.dsl.module

val appModule = module {
    factory<StringRepository> { StringRepositoryImpl() }
    factory { StringUseCaseImpl(get()) }
    single { MainViewModel(get()) }
}