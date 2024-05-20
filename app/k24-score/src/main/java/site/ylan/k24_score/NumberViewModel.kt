package site.ylan.k24_score

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NumberViewModel : ViewModel() {

    private val _number: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>().also {
            it.value = 0
        }
    }
    //    val _number: MutableLiveData<Int> = MutableLiveData(0)

    val number: LiveData<Int>
        get() = _number

    fun modifyNumber(number: Int) {
        this._number.value = this._number.value?.plus(number)
    }
}