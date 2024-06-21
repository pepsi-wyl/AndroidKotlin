package site.ylan.sunnyweather.date.model

import com.google.gson.annotations.SerializedName

/**
 * PlaceResponse
 * @author: ylan
 */
data class PlaceResponse(
    @SerializedName("status")
    val status: String,

    @SerializedName("query")
    val query: String,

    @SerializedName("places")
    val places: List<Place>
)

data class Place(
    @SerializedName("id")
    var id: String,

    @SerializedName("place_id")
    val placeId: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("location")
    val location: Location,

    @SerializedName("formatted_address")
    val address: String
)

data class Location(
    @SerializedName("lng")
    val lng: String,

    @SerializedName("lat")
    val lat: String
)