package technical.test.wanderer.ui.login.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import technical.test.wanderer.ui.login.LoginInteractor
import technical.test.wanderer.ui.login.LoginInteractorContract
import technical.test.wanderer.ui.login.LoginViewModel
import technical.test.wanderer.ui.login.LoginViewModelContract

@Module
@InstallIn(ViewModelComponent::class)
interface LoginModule {

    @Binds
    fun bindLoginViewModel(loginViewModel: LoginViewModel): LoginViewModelContract

    @Binds
    fun bindLoginInteractor(loginInteractor: LoginInteractor): LoginInteractorContract

}