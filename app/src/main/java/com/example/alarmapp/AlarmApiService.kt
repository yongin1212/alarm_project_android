package com.example.alarmapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface AlarmApiService {
    @GET("alarm/get")
    fun getAlarm(
        @Header("Authorization") token: String, // "Bearer " 포함된 토큰
        @Query("alarmId") alarmId: Long         // ?alarmId=1 부분
    ): Call<AlarmGetResDto>
}