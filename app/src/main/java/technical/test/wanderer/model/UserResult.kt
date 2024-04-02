package technical.test.wanderer.model

import com.google.gson.annotations.SerializedName
import technical.test.wanderer.base.BaseResult

data class UserResult(
    @SerializedName("page") val page: Int,
    @SerializedName("total_pages") val totalPage: Int,
    @SerializedName("data") val data: List<Users>
): BaseResult()