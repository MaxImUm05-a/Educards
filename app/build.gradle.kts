plugins {
    id("com.android.application")
    id("kotlin-android")
//    id("kotlin-kapt") // підтримка KAPT
    id("io.freefair.lombok") version "8.0.1"
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.educards"
    compileSdk = 34
    buildToolsVersion = "34.0.0"


    defaultConfig {
        applicationId = "com.example.educards"
        minSdk = 26
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    packaging {
        resources {
            excludes += "META-INF/LICENSE.md"
            excludes += "META-INF/NOTICE.md"
        }
    }
}

dependencies {
//    implementation("com.google.devtools.ksp:symbol-processing-api:1.9.24-1.0.17")
//    ksp("com.google.devtools.ksp:symbol-processing:1.9.24-1.0.17")

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.activity:activity:1.8.0")
    implementation("androidx.drawerlayout:drawerlayout:1.1.1")
    //implementation("com.google.android.material:material:1.9.0")

    implementation("redis.clients:jedis:5.2.0")
    implementation("androidx.mediarouter:mediarouter:1.7.0")

    // Room
    val roomVersion = "2.6.1"

    implementation("androidx.room:room-runtime:$roomVersion")
//    annotationProcessor("androidx.room:room-compiler:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")
//    implementation("androidx.room:room-ktx:$roomVersion") // Для інтеграції з Coroutines

    implementation("com.google.dagger:hilt-android:2.50")
    ksp("com.google.dagger:hilt-compiler:2.50")

    // Lombok
    compileOnly("org.projectlombok:lombok:1.18.34")
    ksp("org.projectlombok:lombok:1.18.34")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

kotlin {
    jvmToolchain(21)
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "21"
    }
}
