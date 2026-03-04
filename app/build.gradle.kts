plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.alarmapp"
    compileSdk {
        version = release(36)
    }
    viewBinding {
        enable = true
    }

    defaultConfig {
        applicationId = "com.example.alarmapp"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    // 1. Retrofit: 서버 통신을 담당하는 메인 라이브러리
    implementation("com.squareup.retrofit2:retrofit:2.9.0")

    // 2. Gson Converter: 서버가 준 JSON 데이터를 코틀린 객체로 자동 변환
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // 3. OkHttp Logging: 서버랑 주고받는 실제 내용을 로그(Logcat)로 보여줌 (디버깅 필수!)
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
}