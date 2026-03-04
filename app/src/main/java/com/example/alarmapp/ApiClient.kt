package com.example.alarmapp

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    // 에뮬레이터에서 내 컴퓨터(localhost)로 접속하는 특수 주소
    private const val BASE_URL = "http://10.0.2.2:8080/"

    // 로그를 찍기 위한 설정 (서버랑 대화하는 걸 Logcat에서 볼 수 있음)
    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()) // JSON -> 객체 변환
        .client(client)
        .build()

    val alarmApiService: AlarmApiService = retrofit.create(AlarmApiService::class.java)
}