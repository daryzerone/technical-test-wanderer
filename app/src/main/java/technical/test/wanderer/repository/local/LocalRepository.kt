package technical.test.wanderer.repository.local

import technical.test.wanderer.preference.AppPreferences
import javax.inject.Inject

class LocalRepository @Inject constructor(private val appPreferences: AppPreferences) :
    LocalDataSource {

    override fun getAppToken(): String = appPreferences.getAppToken()

    override fun saveAppToken(appToken: String) {
        appPreferences.saveAppToken(appToken)
    }

    override fun clearSessionData() {
        appPreferences.clearSessionData()
    }

}