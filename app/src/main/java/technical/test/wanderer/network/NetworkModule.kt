package technical.test.wanderer.network

import android.content.Context
import androidx.viewbinding.BuildConfig
import com.google.gson.Gson
import technical.test.wanderer.preference.AppPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    companion object {
        private const val CONNECT_TIMEOUT_IN_SECOND: Long = 100
        private const val HEADER_CONTENT_TYPE = "Content-Type"
        private const val HEADER_CONTENT_TYPE_VALUE = "application/json"
        private const val HEADER_AUTHORIZATION = "Authorization"
        private const val HEADER_ACCEPT = "Accept"
    }

    @Provides
    fun provideApiService(
        @ApplicationContext context: Context,
        appPreferences: AppPreferences
    ): ApiService {
        return RetrofitProvider(getOkHttpClient(context, appPreferences)).getApiService()
    }

    @Provides
    fun provideGson(): Gson = Gson()

    private fun getOkHttpClient(context: Context, appPreferences: AppPreferences): OkHttpClient {
        return OkHttpClient.Builder().apply {
            connectTimeout(CONNECT_TIMEOUT_IN_SECOND, TimeUnit.SECONDS)
            readTimeout(CONNECT_TIMEOUT_IN_SECOND, TimeUnit.SECONDS)
            writeTimeout(CONNECT_TIMEOUT_IN_SECOND, TimeUnit.SECONDS)
            if (BuildConfig.DEBUG) {
                addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            }
            addInterceptor(createRequestInterceptor(context, appPreferences))
            readTimeout(30, TimeUnit.SECONDS)
        }.build()
    }

    private fun createRequestInterceptor(
        context: Context,
        appPreferences: AppPreferences
    ): Interceptor {
        return Interceptor { chain ->
            val original = chain.request()

            val requestBuilder = original.newBuilder()
                .header(HEADER_CONTENT_TYPE, HEADER_CONTENT_TYPE_VALUE)
                .header(HEADER_ACCEPT, HEADER_CONTENT_TYPE_VALUE)

            val appToken = appPreferences.getAppToken()
            if (appToken.isNotBlank()) {
                requestBuilder.header(HEADER_AUTHORIZATION, appToken)
            }

            val modifiedUrl = original.url.newBuilder()
                .build()

            val request = requestBuilder.url(modifiedUrl)
                .build()

            return@Interceptor chain.proceed(request)
        }
    }

}