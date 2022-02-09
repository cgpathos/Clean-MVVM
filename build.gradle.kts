plugins {
    id("com.android.application") version "7.1.1" apply false
    id("com.android.library") version "7.1.1" apply false
    id("org.jetbrains.kotlin.android") version Version.KOTLIN_VERSION apply false
    id("dagger.hilt.android.plugin") version Version.HILT_VERSION apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}