package technical.test.wanderer.ui.login

import android.util.Log
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
class LoginViewModel @Inject constructor(
    private val loginInteractor: LoginInteractorContract
) : BaseViewModel(), LoginViewModelContract {

    private val loginLiveData = MutableLiveData<LoginRegisterResult>()

    override fun login(loginReqBody: LoginRegisterRequestBody) {
        viewModelScope.launch {
            setIsLoading(true)
            try {
                val result = loginInteractor.login(loginReqBody)
                Log.d("test", "login: $result")
                loginLiveData.value = result
            } catch (e: Exception) {
                val error = (e as? HttpException)?.response()?.errorBody()?.string() ?: "Error"
                errorLiveData.value = error
            }
            setIsLoading(false)
        }
    }

    override fun loginLiveData(): LiveData<LoginRegisterResult> = loginLiveData

    override fun saveToken(token: String) {
        loginInteractor.saveToken(token)
    }

}