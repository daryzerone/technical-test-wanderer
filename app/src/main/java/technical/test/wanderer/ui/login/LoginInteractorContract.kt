package technical.test.wanderer.ui.login

import technical.test.wanderer.model.LoginRegisterRequestBody
import technical.test.wanderer.model.LoginRegisterResult

interface LoginInteractorContract {

    suspend fun login(loginRegisterRequestBody: LoginRegisterRequestBody): LoginRegisterResult

    fun saveToken(token: String)

}