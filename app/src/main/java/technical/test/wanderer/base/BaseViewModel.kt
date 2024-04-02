package technical.test.wanderer.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel(), BaseViewModelContract, CoroutineScope {
    private val isLoading = MutableLiveData<Boolean>()
    protected val errorLiveData = MutableLiveData<String?>()

    override val coroutineContext: CoroutineContext
        get() = viewModelScope.coroutineContext

    override fun getIsLoading() = isLoading

    override fun setIsLoading(isLoading: Boolean) {
        this.isLoading.value = isLoading
    }

    override fun errorLiveData(): LiveData<String?> = errorLiveData
}