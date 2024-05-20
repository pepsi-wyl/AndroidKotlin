package site.ylan.k24_score

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

const val VALUES = "TEAM_SCORE"
const val SCORE_A = "SCORE_A"
const val SCORE_B = "SCORE_B"

class MyViewModel(application: Application) : AndroidViewModel(application) {

    private val sharedPreferences = application.getSharedPreferences(VALUES, Context.MODE_PRIVATE)

    private var aTeamScore: MutableLiveData<Int> = MutableLiveData<Int>(sharedPreferences.getInt(SCORE_A, 0))
    private var bTeamScore: MutableLiveData<Int> = MutableLiveData<Int>(sharedPreferences.getInt(SCORE_B, 0))

    fun getATeamScore(): MutableLiveData<Int> {
        return aTeamScore
    }

    fun getBTeamScore(): MutableLiveData<Int> {
        return bTeamScore
    }


}