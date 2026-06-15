import com.vanniktech.maven.publish.AndroidSingleVariantLibrary
import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.SourcesJar

plugins {
    id("com.android.library")
    id("com.vanniktech.maven.publish")
    id("signing")
}

android {
    namespace = "com.forkingcode.androidjunitparams"
    compileSdk = 37

    defaultConfig {
        minSdk = 21
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
}

dependencies {
    //implementation(fileTree(dir: "libs", include: ["*.jar"]))
    api("androidx.test:runner:1.7.0")
    api("pl.pragmatists:JUnitParams:1.1.1")
}

// Publishing info

val libraryGroupId = "com.forkingcode.androidjunitparams"
val libraryName = "androidjunitparams"
val libraryDescription = "Android extensions to the JUnitParams library"
val libraryVersion = "1.4.0"

mavenPublishing {
    publishToMavenCentral()
    signAllPublications()

    configure(
        AndroidSingleVariantLibrary(
            javadocJar = JavadocJar.Javadoc(),
            sourcesJar = SourcesJar.Sources(),
            variant = "release"
        )
    )

    coordinates(groupId = libraryGroupId, artifactId = libraryName, version = libraryVersion)

    pom {
        packaging = "aar"

        // Add your description here
        name.set(libraryName)
        description.set(libraryDescription)
        url.set("https://github.com/joerogers/AndroidJUnitParams")

        // Set your license
        licenses {
            license {
                name.set("The Apache Software License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }

        developers {
            developer {
                id.set("joerogers")
                name.set("Joe Rogers")
                url.set("https://github.com/joerogers")
            }
        }
        scm {
            connection.set("scm:git:git://github.com/joerogers/AndroidJUnitParams.git")
            developerConnection.set("scm:git:git://github.com/joerogers/AndroidJUnitParams.git")
            url.set("https://github.com/joerogers/AndroidJUnitParams")
        }
    }
}

