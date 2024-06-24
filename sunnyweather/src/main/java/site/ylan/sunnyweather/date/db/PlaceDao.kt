package site.ylan.sunnyweather.date.db

import android.content.Context
import android.provider.Settings.Global.putString
import android.provider.Settings.System.putString
import androidx.core.content.edit
import com.google.gson.Gson
import site.ylan.sunnyweather.MainApplication
import site.ylan.sunnyweather.date.model.PlaceResponse.Place


/**
 * PlaceDao
 * @author: ylan
 */
object PlaceDao {

    private fun sharedPreferences() = MainApplication.globeContext.getSharedPreferences("sunny_weather", Context.MODE_PRIVATE)

    fun savePlace(place: Place) {
        sharedPreferences().edit { putString("place", Gson().toJson(place)) }
    }

    fun getSavedPlace(): Place {
        return Gson().fromJson(sharedPreferences().getString("place", ""), Place::class.java)
    }

    fun isPlaceSaved() = sharedPreferences().contains("place")
}