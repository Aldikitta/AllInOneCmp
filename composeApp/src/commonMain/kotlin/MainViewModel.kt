import androidx.lifecycle.ViewModel

class MainViewModel(
    private val stringUseCaseImpl: StringUseCaseImpl
) : ViewModel() {
    fun getDummyText(): String {
        return stringUseCaseImpl.invoke()
    }
}