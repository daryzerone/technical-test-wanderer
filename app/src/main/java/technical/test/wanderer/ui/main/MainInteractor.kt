package technical.test.wanderer.ui.main

import technical.test.wanderer.model.UserResult
import technical.test.wanderer.repository.local.LocalDataSource
import technical.test.wanderer.repository.remote.RemoteDataSource
import javax.inject.Inject

class MainInteractor @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : MainInteractorContract {
    override suspend fun getUserList(page: Int): UserResult = remoteDataSource.getUserList(page)

    override fun clearSessionData() {
        localDataSource.clearSessionData()
    }


}