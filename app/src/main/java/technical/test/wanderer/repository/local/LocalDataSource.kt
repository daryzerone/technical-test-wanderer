package technical.test.wanderer.repository.local

interface LocalDataSource {

    fun getAppToken(): String

    fun saveAppToken(appToken: String)
    fun clearSessionData()
}