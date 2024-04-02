package technical.test.wanderer.ui.register

import androidx.lifecycle.LiveData
import technical.test.wanderer.base.BaseViewModelContract
import technical.test.wanderer.model.LoginRegisterRequestBody
import technical.test.wanderer.model.LoginRegisterResult

interface RegisterViewModelContract : BaseViewModelContract {

    fun register(loginReqBody: LoginRegisterRequestBody)

    fun registerLiveData(): LiveData<LoginRegisterResult>

    fun saveToken(token: String)

}