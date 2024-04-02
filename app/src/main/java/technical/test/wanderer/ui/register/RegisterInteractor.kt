package technical.test.wanderer.ui.register

import technical.test.wanderer.model.LoginRegisterRequestBody
import technical.test.wanderer.model.LoginRegisterResult
import technical.test.wanderer.repository.local.LocalDataSource
import technical.test.wanderer.repository.remote.RemoteDataSource
import javax.inject.Inject

class RegisterInteractor @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) : RegisterInteractorContract {

    override suspend fun register(loginRegisterRequestBody: LoginRegisterRequestBody): LoginRegisterResult =
        remoteDataSource.register(loginRegisterRequestBody)

    override fun saveToken(token: String) {
        localDataSource.saveAppToken(token)
    }


}