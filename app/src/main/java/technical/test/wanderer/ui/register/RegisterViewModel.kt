package technical.test.wanderer.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import technical.test.wanderer.base.BaseViewModel
import technical.test.wanderer.model.LoginRegisterRequestBody
import technical.test.wanderer.model.LoginRegisterResult
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerInteractor: RegisterInteractorContract
) : BaseViewModel(), RegisterViewModelContract {

    private val registerLiveData = MutableLiveData<LoginRegisterResult>()

    override fun register(loginReqBody: LoginRegisterRequestBody) {
        viewModelScope.launch {
            setIsLoading(true)
            try {
                val result = registerInteractor.register(loginReqBody)
                registerLiveData.value = result
            } catch (e: Exception) {
                val error = (e as? HttpException)?.response()?.errorBody()?.string()
                errorLiveData.value = error
            }
            setIsLoading(false)
        }
    }

    override fun registerLiveData(): LiveData<LoginRegisterResult> = registerLiveData

    override fun saveToken(token: String) {
        registerInteractor.saveToken(token)
    }

}