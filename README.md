# Demo project for the new Kotlin/Native Gradle plugin

#### Building

To build the project run:

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

#### DSL Example:

```
sourceSets {
    // By default 2 source sets are created: main and test.
    // Adding custom source sets isn't supported at the moment.
    main {
        // Adding custom sources.
        // 'kotlin' is a SourceDirectorySet so you can use all methods/properties described at
        // https://docs.gradle.org/current/dsl/org.gradle.api.file.SourceDirectorySet.html
        kotlin.srcDir 'custom/path/to/sources'

        // Adding target-specific sources. The object returned is also SourceDirectorySet.
        target('wasm32').srcDir 'custom/path/wasm/sources'

        target('wasm32', 'host') {
            srcDir 'common/for/several/targets/sources'
        }

        // Settings not related to sources.
        component {
            // Binary kinds produced from these sources.
            outputKinds = [ KLIBRARY, EXECUTABLE ]

            // List of targets the binary is compiled for.
            // Calling the 'target' method of a source set for some target (see above)
            // implicitly adds this target to this list.
            target 'host', 'wasm32'
        }
    }
}

dependencies {
    // Project dependency. Only project having output kind 'KLIBRARY' can be a dependency.
    implementation project('library')

    // External dependency.
    implementation 'foo:bar:1.0'

    // Kotlin 'expected by' dependency.
    expectedBy project('common')


    // Test dependencies are stored in the 'testImplementation' configuration:
    testImplementation project('testLibrary')
    testImplementation 'foo:barTest:1.0'
}
```
