package technical.test.wanderer.base

import com.google.gson.annotations.SerializedName

open class BaseResult(
    @SerializedName("error") val error: String? = null
)