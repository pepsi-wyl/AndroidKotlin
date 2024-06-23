package site.ylan.sunnyweather.date.model

import site.ylan.sunnyweather.date.model.RealtimeResponse.Result.Realtime
import site.ylan.sunnyweather.date.model.DailyResponse.Result.Daily

/**
 * Weather
 * @author: ylan
 */
data class Weather(
    val realtime: Realtime,
    val daily: Daily
)