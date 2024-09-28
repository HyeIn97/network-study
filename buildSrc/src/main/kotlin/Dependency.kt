object Dependency {
    object Versions {
        // AndroidX
        const val COROUTINES_VERSION = "1.3.9"
        const val LIFECYCLE_VERSION = "2.8.5"

        // Library
        const val HILT_VERSION = "2.44"
        const val HILT_COMPILER_VERSION = "2.44"
        const val NETWORK_VERSION = "2.11.0"
    }

    object Lifecycle {
        const val LIFECYCLE = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_VERSION}"
        const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_VERSION}"
    }

    object AndroidX {
        const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES_VERSION}"
    }

    object Libraries {
        const val HILT = "com.google.dagger:hilt-android:${Versions.HILT_VERSION}"
        const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT_COMPILER_VERSION}"
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.NETWORK_VERSION}"
        const val GSON = "com.google.code.gson:gson:${Versions.NETWORK_VERSION}"
        const val GSON_CONVERTER = "com.squareup.retrofit2:converter-gson:${Versions.NETWORK_VERSION}"
    }
}