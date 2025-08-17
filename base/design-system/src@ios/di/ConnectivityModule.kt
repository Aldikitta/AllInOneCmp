package di

import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import screen.connectivity.ConnectivityObserver

@Module
actual class ConnectivityModule {
    @Single
    actual fun provideConnectivityObserver(): ConnectivityObserver {
        return ConnectivityObserver()
    }
}

