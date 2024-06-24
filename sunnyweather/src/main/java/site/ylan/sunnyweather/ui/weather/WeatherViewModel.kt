package site.ylan.sunnyweather.ui.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import site.ylan.sunnyweather.date.Repository
import site.ylan.sunnyweather.date.model.PlaceResponse.Place.Location
import site.ylan.sunnyweather.date.model.Weather

/**
 * WeatherViewModel
 * @author: ylan
 */
class WeatherViewModel : ViewModel() {

    // 地理信息
    var locationLng = ""
    var locationLat = ""
    var placeName = ""

    // locationLiveData
    private val locationLiveData = MutableLiveData<Location>()

    // weatherLiveData
    val weatherLiveData: LiveData<Result<Weather>> =
        locationLiveData.switchMap { location ->
            Repository.refreshWeather(location.lng, location.lat)
        }

    // refreshWeather
    fun refreshWeather(lng: String, lat: String) {
        locationLiveData.value = Location(lng, lat)
    }
}