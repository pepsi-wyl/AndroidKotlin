package site.ylan.sunnyweather.date.model

import com.google.gson.annotations.SerializedName

/**
 * RealtimeResponse
 * @author: ylan
 */
data class RealtimeResponse(
    @SerializedName("status") val status: String,
    @SerializedName("api_version") val apiVersion: String,
    @SerializedName("api_status") val apiStatus: String,
    @SerializedName("lang") val lang: String,
    @SerializedName("unit") val unit: String,
    @SerializedName("tzshift") val tzshift: Int,
    @SerializedName("timezone") val timezone: String,
    @SerializedName("server_time") val serverTime: Int,
    @SerializedName("location") val location: List<Double>,
    @SerializedName("result") val result: Result
) {
    data class Result(
        @SerializedName("primary") val primary: Float,
        @SerializedName("realtime") val realtime: Realtime
    ) {
        data class Realtime(
            @SerializedName("status") val status: String,
            @SerializedName("temperature") val temperature: Float,
            @SerializedName("humidity") val humidity: Float,
            @SerializedName("cloudrate") val cloudrate: Float,
            @SerializedName("skycon") val skycon: String,
            @SerializedName("visibility") val visibility: Float,
            @SerializedName("dswrf") val dswrf: Float,
            @SerializedName("wind") val wind: Wind,
            @SerializedName("pressure") val pressure: Float,
            @SerializedName("apparent_temperature") val apparentTemperature: Float,
            @SerializedName("precipitation") val precipitation: Precipitation,
            @SerializedName("air_quality") val airQuality: AirQuality,
            @SerializedName("life_index") val lifeIndex: LifeIndex
        ) {
            data class Wind(
                @SerializedName("speed") val speed: Float,
                @SerializedName("direction") val direction: Float
            )

            data class Precipitation(
                @SerializedName("status") val status: String,
                @SerializedName("local") val local: Local,
                @SerializedName("nearest") val nearest: Nearest
            ) {
                data class Local(
                    @SerializedName("status") val status: String,
                    @SerializedName("datasource") val datasource: String,
                    @SerializedName("intensity") val intensity: Float
                )

                data class Nearest(
                    @SerializedName("distance") val distance: Float,
                    @SerializedName("intensity") val intensity: Float
                )

            }

            data class AirQuality(
                @SerializedName("pm25") val pm25: Float,
                @SerializedName("pm10") val pm10: Float,
                @SerializedName("o3") val o3: Float,
                @SerializedName("so2") val so2: Float,
                @SerializedName("no2") val no2: Float,
                @SerializedName("co") val co: Float,
                @SerializedName("aqi") val aqi: AQI,
                @SerializedName("description") val description: Description
            ) {
                data class AQI(
                    @SerializedName("chn") val chn: Float,
                    @SerializedName("usa") val usa: Float
                )

                data class Description(
                    @SerializedName("chn") val chn: String,
                    @SerializedName("usa") val usa: String
                )
            }

            data class LifeIndex(
                @SerializedName("ultraviolet") val ultraviolet: Ultraviolet,
                @SerializedName("comfort") val comfort: Comfort
            ) {
                data class Ultraviolet(
                    @SerializedName("index") val index: Float,
                    @SerializedName("desc") val desc: String
                )

                data class Comfort(
                    @SerializedName("index") val index: Float,
                    @SerializedName("desc") val desc: String
                )
            }
        }
    }
}

