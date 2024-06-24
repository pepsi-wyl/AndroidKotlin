package site.ylan.sunnyweather.ui.place

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import site.ylan.sunnyweather.date.model.PlaceResponse.Place
import site.ylan.sunnyweather.date.Repository

/**
 * PlaceViewModel
 * @author: ylan
 */
class PlaceViewModel : ViewModel() {

    // searchLiveData
    private val searchLiveData: MutableLiveData<String> = MutableLiveData<String>()

    // placeList
    val placeList: ArrayList<Place> = ArrayList<Place>()

    // placeLiveData
    val placeLiveData: LiveData<Result<List<Place>>> =
        searchLiveData.switchMap { query ->
            Repository.searchPlaces(query)
        }

    // searchPlaces
    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }

    // savePlace
    fun savePlace(place: Place) = Repository.savePlace(place)

    // getSavedPlace
    fun getSavedPlace() = Repository.getSavedPlace()

    // isPlaceSaved
    fun isPlaceSaved() = Repository.isPlaceSaved()
}