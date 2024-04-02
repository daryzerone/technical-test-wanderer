package technical.test.wanderer.base

import androidx.lifecycle.LiveData

interface BaseViewModelContract {

    fun getIsLoading(): LiveData<Boolean>

    fun setIsLoading(isLoading: Boolean)

    fun errorLiveData(): LiveData<String?>

}