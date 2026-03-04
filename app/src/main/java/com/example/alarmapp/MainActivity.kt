package com.example.alarmapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. 토큰 준비 (Bearer와 문자열 사이에 공백 하나만 정확히 확인)
        val rawToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ5b25naW4xMjEyIiwidHlwZSI6ImFjY2VzcyIsImlhdCI6MTc3MjYxNDg3MCwiZXhwIjoxNzcyNjE4NDcwfQ.uOI-5cFvz4yLkNUwBIIqCFrJzIsgRTYVLC4D83531ME"
        val authToken = "Bearer $rawToken"

        // 2. API 호출 (1L은 테스트용 ID)
        val call = ApiClient.alarmApiService.getAlarm(authToken, 1L)

        call.enqueue(object : Callback<AlarmGetResDto> {
            override fun onResponse(call: Call<AlarmGetResDto>, response: Response<AlarmGetResDto>) {
                if (response.isSuccessful) {
                    val alarm = response.body()
                    Log.d("ALARM_APP", "✅ 성공: ${alarm?.alarmName}")
                    println("알람 가져오기 성공: ${alarm?.alarmName}")
                } else {
                    Log.e("ALARM_APP", "❌ 실패 코드: ${response.code()}")
                    println("서버 응답 에러: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<AlarmGetResDto>, t: Throwable) {
                Log.e("ALARM_APP", "⚠️ 통신 장애: ${t.message}")
                println("통신 실패 원인: ${t.message}")
            }
        })
    }
}