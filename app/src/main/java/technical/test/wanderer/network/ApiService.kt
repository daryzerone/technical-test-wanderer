package technical.test.wanderer.network

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import technical.test.wanderer.model.LoginRegisterRequestBody
import technical.test.wanderer.model.LoginRegisterResult
import technical.test.wanderer.model.UserResult

interface ApiService {

    @POST("login")
    suspend fun login(@Body loginReqBody: LoginRegisterRequestBody): LoginRegisterResult

    @POST("register")
    suspend fun register(@Body loginReqBody: LoginRegisterRequestBody): LoginRegisterResult

    @GET("users")
    suspend fun getUserList(@Query("page") page: Int): UserResult

}