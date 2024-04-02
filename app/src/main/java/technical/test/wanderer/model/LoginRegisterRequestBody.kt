package technical.test.wanderer.model

import com.google.gson.annotations.SerializedName

data class LoginRegisterRequestBody(
    @SerializedName("email") val email:String,
    @SerializedName("password") val password:String
)