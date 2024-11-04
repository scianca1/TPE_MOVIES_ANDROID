plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kapt)
    alias(libs.plugins.hilt)
    alias(libs.plugins.parcelizekotlinAndroid)
}

android {
    namespace = "edu.ar.unicen.tpe"
    compileSdk = 34

    defaultConfig {
        applicationId = "edu.ar.unicen.tpe"
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

    flavorDimensions+= listOf("evironment")

    productFlavors{
        create("develop"){
            applicationIdSuffix= ".develop"
            versionNameSuffix="-develop"
            dimension= "evironment"
            buildConfigField("String","BASE_URL", "\"https://api.themoviedb.org/3/\"")
            buildConfigField("String","BASE_URL_IMAGES","\"https://image.tmdb.org/t/p/w500/\"")
            //con esto nosotros podemos especificar la base url de hambiente de desarrollo
            //y la de produccion, sin tener que andas cambiandola cada vez que tenemos que hacer pruebas
        }
        create("produccion"){
            versionNameSuffix="-produccion"
            dimension= "evironment"
            buildConfigField("String","BASE_URL", "\"https://api.themoviedb.org/3/movie/produccion\"")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding=true
        buildConfig=true
//        compose=true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.activityKtx)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.glide)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}