package di

import android.content.Context
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import org.koin.core.context.GlobalContext
import screen.connectivity.ConnectivityObserver

@Module
actual class ConnectivityModule {
    @Single
    actual fun provideConnectivityObserver(): ConnectivityObserver {
        val context: Context = GlobalContext.get().get()
        return ConnectivityObserver(context)
    }
}

