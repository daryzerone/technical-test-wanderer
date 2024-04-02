package technical.test.wanderer.ui.main

import technical.test.wanderer.model.UserResult

interface MainInteractorContract {

    suspend fun getUserList(page: Int): UserResult

    fun clearSessionData()

}