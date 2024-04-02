package technical.test.wanderer.ui.login

import androidx.lifecycle.LiveData
import technical.test.wanderer.base.BaseViewModelContract
import technical.test.wanderer.model.LoginRegisterRequestBody
import technical.test.wanderer.model.LoginRegisterResult

interface LoginViewModelContract : BaseViewModelContract {

    fun login(loginReqBody: LoginRegisterRequestBody)

    fun loginLiveData(): LiveData<LoginRegisterResult>

    fun saveToken(token: String)

}