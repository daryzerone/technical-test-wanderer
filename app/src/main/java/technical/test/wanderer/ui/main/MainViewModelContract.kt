package technical.test.wanderer.ui.main

import androidx.lifecycle.LiveData
import technical.test.wanderer.base.BaseViewModelContract
import technical.test.wanderer.model.UserResult

interface MainViewModelContract : BaseViewModelContract {

    fun getUserList(page: Int)

    fun userListLiveData(): LiveData<UserResult>

    fun clearSessionData()

}