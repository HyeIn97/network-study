import com.google.protobuf.gradle.proto

plugins {
    id("com.android.library")
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.protobuf") version "0.9.3"
}

android {
    namespace = "com.example.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    sourceSets {
        getByName("main") {
            proto {
                srcDirs("src/main/proto")
            }
            java {
                srcDir("build/generated/source/proto/main/java")
            }
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(project(":domain"))

    // Hilt
    implementation(Dependency.Libraries.HILT)
    kapt(Dependency.Libraries.HILT_COMPILER)

    // Retrofit
    implementation(Dependency.Libraries.GSON)
    implementation(Dependency.Libraries.RETROFIT)
    implementation(Dependency.Libraries.GSON_CONVERTER)

    // DataStore
    implementation(Dependency.AndroidX.DATASTORE)
    implementation(Dependency.Libraries.PROTOBUF_JAVA_LITE)
    implementation(Dependency.Libraries.PROTOBUF_KOTLIN_LITE)
}

kapt {
    correctErrorTypes = true
    generateStubs = true
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.24.1"
    }
    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                create("java") {
                    option("lite")
                }
            }
        }
    }
}