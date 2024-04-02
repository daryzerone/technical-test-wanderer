package technical.test.wanderer.ui.main.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import technical.test.wanderer.ui.main.MainInteractor
import technical.test.wanderer.ui.main.MainInteractorContract
import technical.test.wanderer.ui.main.MainViewModel
import technical.test.wanderer.ui.main.MainViewModelContract

@Module
@InstallIn(ViewModelComponent::class)
interface MainModule {

    @Binds
    fun bindMainViewModel(mainViewModel: MainViewModel): MainViewModelContract

    @Binds
    fun bindMainInteractor(mainInteractor: MainInteractor): MainInteractorContract

}