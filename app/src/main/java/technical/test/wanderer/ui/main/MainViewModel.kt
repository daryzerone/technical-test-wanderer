package technical.test.wanderer.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import technical.test.wanderer.base.BaseViewModel
import technical.test.wanderer.model.UserResult
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainInteractor: MainInteractorContract
) : BaseViewModel(), MainViewModelContract {

    private val userListLiveData = MutableLiveData<UserResult>()

    override fun getUserList(page: Int) {
        viewModelScope.launch {
            setIsLoading(true)
            try {
                val result = mainInteractor.getUserList(page)
                userListLiveData.value = result
            } catch (e: Exception) {
                val error = (e as? HttpException)?.response()?.errorBody()?.string() ?: "Error"
                errorLiveData.value = error
            }
            setIsLoading(false)
        }
    }

    override fun userListLiveData(): LiveData<UserResult> = userListLiveData

    override fun clearSessionData() {
        mainInteractor.clearSessionData()
    }
}