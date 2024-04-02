package technical.test.wanderer.ui.login

import technical.test.wanderer.model.LoginRegisterRequestBody
import technical.test.wanderer.model.LoginRegisterResult
import technical.test.wanderer.repository.local.LocalDataSource
import technical.test.wanderer.repository.remote.RemoteDataSource
import javax.inject.Inject

class LoginInteractor @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) : LoginInteractorContract {

    override suspend fun login(loginRegisterRequestBody: LoginRegisterRequestBody): LoginRegisterResult =
        remoteDataSource.login(loginRegisterRequestBody)

    override fun saveToken(token: String) {
        localDataSource.saveAppToken(token)
    }


}