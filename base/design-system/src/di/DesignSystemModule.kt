package di

import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import screen.CmpIsFunScreenViewModel
import screen.connectivity.ConnectivityObserver

@Module
class DesignSystemModule {
    @KoinViewModel
    fun cmpIsFunScreenViewModel() = CmpIsFunScreenViewModel()
}