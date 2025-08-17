package screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CmpIsFunScreenViewModel(): ViewModel() {
    private val _state = MutableStateFlow(CmpIsFunScreenState())
    val state = _state.asStateFlow()
}

data class CmpIsFunScreenState(
    val titleTopBar: String? = "",
    val content: @Composable ((PaddingValues) -> Unit) = {}
)