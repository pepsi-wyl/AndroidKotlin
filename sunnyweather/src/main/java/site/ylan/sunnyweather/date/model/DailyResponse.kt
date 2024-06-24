package site.ylan.sunnyweather.date.model

import com.google.gson.annotations.SerializedName

/**
 * DailyResponse
 * @author: ylan
 */
data class DailyResponse(
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
        @SerializedName("daily") val daily: Daily
    ) {
        data class Daily(
            @SerializedName("status") val status: String,
            @SerializedName("astro") val astro: List<Astro>,
            @SerializedName("precipitation") val precipitation: List<Precipitation>,
            @SerializedName("temperature") val temperature: List<Temperature>,
            @SerializedName("wind") val wind: List<Wind>,
            @SerializedName("humidity") val humidity: List<Humidity>,
            @SerializedName("cloudrate") val cloudrate: List<Cloudrate>,
            @SerializedName("pressure") val pressure: List<Pressure>,
            @SerializedName("visibility") val visibility: List<Visibility>,
            @SerializedName("dswrf") val dswrf: List<Dswrf>,
            @SerializedName("air_quality") val airQuality: AirQuality,
            @SerializedName("skycon") val skycon: List<Skycon>,
            @SerializedName("skycon_08h_20h") val skycon08h20h: List<Skycon08h20h>,
            @SerializedName("skycon_20h_32h") val skycon20h32h: List<Skycon20h32h>,
            @SerializedName("life_index") val lifeIndex: LifeIndex,
        ) {
            data class Astro(
                @SerializedName("date") val date: String,
                @SerializedName("sunrise") val sunrise: Sunrise,
                @SerializedName("sunset") val sunset: Sunset
            ) {
                data class Sunrise(
                    @SerializedName("time") val time: String
                )

                data class Sunset(
                    @SerializedName("time") val time: String
                )
            }

            data class Precipitation(
                @SerializedName("date") val date: String,
                @SerializedName("max") val max: Float,
                @SerializedName("min") val min: Float,
                @SerializedName("avg") val avg: Float
            )

            data class Temperature(
                @SerializedName("date") val date: String,
                @SerializedName("max") val max: Float,
                @SerializedName("min") val min: Float,
                @SerializedName("avg") val avg: Float
            )

            data class Wind(
                @SerializedName("date") val date: String,
                @SerializedName("max") val max: Max,
                @SerializedName("min") val min: Min,
                @SerializedName("avg") val avg: Avg
            ) {
                data class Max(
                    @SerializedName("speed") val speed: Float,
                    @SerializedName("direction") val direction: Float
                )

                data class Min(
                    @SerializedName("speed") val speed: Float,
                    @SerializedName("direction") val direction: Float
                )

                data class Avg(
                    @SerializedName("speed") val speed: Float,
                    @SerializedName("direction") val direction: Float
                )
            }

            data class Humidity(
                @SerializedName("date") val date: String,
                @SerializedName("max") val max: Float,
                @SerializedName("min") val min: Float,
                @SerializedName("avg") val avg: Float
            )

            data class Cloudrate(
                @SerializedName("date") val date: String,
                @SerializedName("max") val max: Float,
                @SerializedName("min") val min: Float,
                @SerializedName("avg") val avg: Float
            )

            data class Pressure(
                @SerializedName("date") val date: String,
                @SerializedName("max") val max: Float,
                @SerializedName("min") val min: Float,
                @SerializedName("avg") val avg: Float
            )

            data class Visibility(
                @SerializedName("date") val date: String,
                @SerializedName("max") val max: Float,
                @SerializedName("min") val min: Float,
                @SerializedName("avg") val avg: Float
            )

            data class Dswrf(
                @SerializedName("date") val date: String,
                @SerializedName("max") val max: Float,
                @SerializedName("min") val min: Float,
                @SerializedName("avg") val avg: Float
            )

            data class AirQuality(
                @SerializedName("aqi") val date: List<Aqi>,
                @SerializedName("pm25") val pm25: List<Pm25>,
            ) {
                data class Aqi(
                    @SerializedName("date") val date: String,
                    @SerializedName("max") val max: Max,
                    @SerializedName("min") val min: Min,
                    @SerializedName("avg") val avg: Avg
                ) {
                    data class Max(
                        @SerializedName("chn") val chn: Float,
                        @SerializedName("usa") val usa: Float
                    )

                    data class Min(
                        @SerializedName("chn") val chn: Float,
                        @SerializedName("usa") val usa: Float
                    )

                    data class Avg(
                        @SerializedName("chn") val chn: Float,
                        @SerializedName("usa") val usa: Float
                    )
                }

                data class Pm25(
                    @SerializedName("date") val date: String,
                    @SerializedName("max") val max: Float,
                    @SerializedName("min") val min: Float,
                    @SerializedName("avg") val avg: Float
                )
            }

            data class Skycon(
                @SerializedName("date") val date: String,
                @SerializedName("value") val value: String,
            )

            data class Skycon08h20h(
                @SerializedName("date") val date: String,
                @SerializedName("value") val value: String,
            )

            data class Skycon20h32h(
                @SerializedName("date") val date: String,
                @SerializedName("value") val value: String,
            )

            data class LifeIndex(
                @SerializedName("ultraviolet") val ultraviolet: List<Ultraviolet>,
                @SerializedName("carWashing") val carWashing: List<CarWashing>,
                @SerializedName("dressing") val dressing: List<Dressing>,
                @SerializedName("comfort") val comfort: List<Comfort>,
                @SerializedName("coldRisk") val coldRisk: List<ColdRisk>,
            ) {
                data class Ultraviolet(
                    @SerializedName("date") val date: String,
                    @SerializedName("index") val index: String,
                    @SerializedName("desc") val desc: String,
                )

                data class CarWashing(
                    @SerializedName("date") val date: String,
                    @SerializedName("index") val index: String,
                    @SerializedName("desc") val desc: String,
                )

                data class Dressing(
                    @SerializedName("date") val date: String,
                    @SerializedName("index") val index: String,
                    @SerializedName("desc") val desc: String,
                )

                data class Comfort(
                    @SerializedName("date") val date: String,
                    @SerializedName("index") val index: String,
                    @SerializedName("desc") val desc: String,
                )

                data class ColdRisk(
                    @SerializedName("date") val date: String,
                    @SerializedName("index") val index: String,
                    @SerializedName("desc") val desc: String,
                )
            }
        }
    }
}