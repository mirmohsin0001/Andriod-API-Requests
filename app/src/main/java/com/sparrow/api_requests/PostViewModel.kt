import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    private val _posts = mutableStateOf<List<Post>>(emptyList())
    val posts: State<List<Post>> = _posts

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getPosts()
                if (response.isSuccessful) {
                    _posts.value = response.body() ?: emptyList()
                }
            } catch (e: Exception) {
                // Handle network errors
            }
        }
    }
}