package technical.test.wanderer.ui.register

import technical.test.wanderer.model.LoginRegisterRequestBody
import technical.test.wanderer.model.LoginRegisterResult

interface RegisterInteractorContract {

    suspend fun register(loginRegisterRequestBody: LoginRegisterRequestBody): LoginRegisterResult

    fun saveToken(token: String)

}