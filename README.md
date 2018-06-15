# Demo project for the new Kotlin/Native Gradle plugin

#### To set up the project:

1. Clone Kotlin/Native repository: https://github.com/JetBrains/kotlin-native.
2. Checkout the `rework-gradle-plugin` branch in the Kotlin/Native repository.
3. Build the Kotin/Native compiler: run `./gradlew cross_dist` in the Kotlin/Native repository.
4. Specify path to Kotlin/Native in [settings.gradle](settings.gradle) and [gradle.properties](gradle.properties).

Now you can build the project:

```
./gradlew build
```

#### Supported:

1. Building for different targets, binary types (klib and executable) and build types (debug and release).
2. Publishing.
3. Dependencies on projects and published artifacts.
4. Testing.

#### Not supported:

1. Building and publishing interop libraries.
2. Declaring dependencies between source sets.
3. Convenient way to create a custom source set.
