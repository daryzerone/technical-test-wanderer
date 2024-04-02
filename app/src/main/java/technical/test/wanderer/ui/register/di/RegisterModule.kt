package technical.test.wanderer.ui.register.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import technical.test.wanderer.ui.register.RegisterInteractor
import technical.test.wanderer.ui.register.RegisterInteractorContract
import technical.test.wanderer.ui.register.RegisterViewModel
import technical.test.wanderer.ui.register.RegisterViewModelContract

@Module
@InstallIn(ViewModelComponent::class)
interface RegisterModule {

    @Binds
    fun bindRegisterViewModel(registerViewModel: RegisterViewModel): RegisterViewModelContract

    @Binds
    fun bindLoginInteractor(registerInteractor: RegisterInteractor): RegisterInteractorContract

}