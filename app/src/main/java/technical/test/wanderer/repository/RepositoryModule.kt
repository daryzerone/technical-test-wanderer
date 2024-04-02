package technical.test.wanderer.repository

import technical.test.wanderer.repository.local.LocalDataSource
import technical.test.wanderer.repository.local.LocalRepository
import technical.test.wanderer.repository.remote.RemoteDataSource
import technical.test.wanderer.repository.remote.RemoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRemoteDataSource(remoteRepository: RemoteRepository): RemoteDataSource

    @Binds
    abstract fun bindLocalDataSource(localRepository: LocalRepository): LocalDataSource
}