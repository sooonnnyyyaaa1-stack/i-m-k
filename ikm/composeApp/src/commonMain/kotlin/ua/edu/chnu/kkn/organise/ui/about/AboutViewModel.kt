package ua.edu.chnu.kkn.organise.ui.about

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ua.edu.chnu.kkn.organise.data.about.AboutRepository

@Stable
internal class AboutViewModel(
    private val aboutRepository: AboutRepository,
) : ViewModel() {

    private val _state = MutableStateFlow<List<Pair<String, String>>>(emptyList())
    val state = _state.asStateFlow()

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            _state.value = aboutRepository.getAbout()
        }
    }
}

