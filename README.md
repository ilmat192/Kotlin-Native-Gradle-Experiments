# Demo project for the new Kotlin/Native Gradle plugin

To set up the project:

1. Clone Kotlin/Native repository: https://github.com/JetBrains/kotlin-native.
2. Build the Kotin/Native compiler. Open the directory with Kotlin/Native sources and run `./gradlew cross_dist`.
3. Specify path to Kotlin/Native in [settings.gradle](settings.gradle) and [gradle.properties](gradle.properties).

Now you can build the project:

```
./gradlew build
```
