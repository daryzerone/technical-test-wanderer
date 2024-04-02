package com.zerone.siphpkbuilding.preference

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import technical.test.wanderer.preference.AppPreferences
import technical.test.wanderer.preference.AppRepository

@Module
@InstallIn(SingletonComponent::class)
class PreferenceModule {

    companion object {
        private const val PREF_NAME = "sip-hpk-building-preferences"
    }

    private var appPreferences: AppPreferences? = null

    @Provides
    fun provideAppPreferences(@ApplicationContext context: Context): AppPreferences {
        val preferences = appPreferences ?: buildPreference(context)
        if (appPreferences == null) {
            appPreferences = buildPreference(context)
        }
        return preferences
    }

    private fun buildPreference(context: Context): AppPreferences {
        return AppRepository(
            context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        )
    }

}