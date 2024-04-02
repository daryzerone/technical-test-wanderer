package technical.test.wanderer.preference

import android.content.SharedPreferences

class AppRepository(
    private val preferences: SharedPreferences
) : AppPreferences {

    companion object {
        private const val KEY_APP_TOKEN = "KEY_APP_TOKEN"
    }

    override fun getAppToken(): String =
        preferences.getString(KEY_APP_TOKEN, "").orEmpty()

    override fun saveAppToken(appToken: String) {
        preferences.edit().putString(KEY_APP_TOKEN, appToken).apply()
    }

    override fun clearSessionData() {
        preferences.edit().apply {
            remove(KEY_APP_TOKEN)
        }.apply()
    }
}