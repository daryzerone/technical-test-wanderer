package technical.test.wanderer.repository.remote

import technical.test.wanderer.model.LoginRegisterRequestBody
import technical.test.wanderer.model.LoginRegisterResult
import technical.test.wanderer.model.UserResult
import technical.test.wanderer.network.ApiService
import javax.inject.Inject

class RemoteRepository @Inject constructor(private val apiService: ApiService) : RemoteDataSource {

    override suspend fun login(loginReqBody: LoginRegisterRequestBody): LoginRegisterResult {
        return apiService.login(loginReqBody)
    }

    override suspend fun register(registerReqBody: LoginRegisterRequestBody): LoginRegisterResult {
        return apiService.register(registerReqBody)
    }

    override suspend fun getUserList(page: Int): UserResult {
        return apiService.getUserList(page)
    }

}