package di

import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import screen.connectivity.ConnectivityObserver

@Module
expect class ConnectivityModule {
    @Single
    fun provideConnectivityObserver(): ConnectivityObserver
}
