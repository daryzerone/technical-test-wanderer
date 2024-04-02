package technical.test.wanderer.preference

interface AppPreferences {

    fun getAppToken(): String

    fun saveAppToken(appToken: String)

    fun clearSessionData()

}