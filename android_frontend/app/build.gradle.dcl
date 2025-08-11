androidApplication {
    namespace = "org.example.app"

    dependencies {
        implementation("org.apache.commons:commons-text:1.11.0")
        implementation(project(":utilities"))

        // Jetpack Compose
        implementation("androidx.compose.ui:ui:1.6.1")
        implementation("androidx.compose.material3:material3:1.2.1")
        implementation("androidx.activity:activity-compose:1.8.2")
        implementation("androidx.compose.foundation:foundation:1.6.1")
        implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")
        // Coil for image loading
        implementation("io.coil-kt:coil-compose:2.5.0")
    }
}
