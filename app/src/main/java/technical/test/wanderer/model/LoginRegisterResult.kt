package technical.test.wanderer.model

import com.google.gson.annotations.SerializedName
import technical.test.wanderer.base.BaseResult

data class LoginRegisterResult(
    @SerializedName("token") val token: String
): BaseResult()