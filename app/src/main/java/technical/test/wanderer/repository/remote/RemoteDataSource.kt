package technical.test.wanderer.repository.remote

import technical.test.wanderer.model.LoginRegisterRequestBody
import technical.test.wanderer.model.LoginRegisterResult
import technical.test.wanderer.model.UserResult


interface RemoteDataSource {

    suspend fun login(loginReqBody: LoginRegisterRequestBody): LoginRegisterResult

    suspend fun register(registerReqBody: LoginRegisterRequestBody): LoginRegisterResult

    suspend fun getUserList(page: Int): UserResult

}