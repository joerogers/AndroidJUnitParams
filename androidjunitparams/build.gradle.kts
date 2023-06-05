import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("com.android.library")
    id("com.vanniktech.maven.publish")
}

android {
    namespace = "com.forkingcode.androidjunitparams"
    compileSdk = 30

    defaultConfig {
        minSdk = 16
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

val groupId = "com.forkingcode.androidjunitparams"
val libraryName = "androidjunitparams"
val libraryDescription = "Android extentions to the JUnitParams library"
val libraryVersion = "1.2.0"

dependencies {
    //implementation(fileTree(dir: "libs", include: ["*.jar"]))
    api("androidx.test:runner:1.5.0")
    api("pl.pragmatists:JUnitParams:1.1.1")
}

mavenPublishing {
    // publishing to https://s01.oss.sonatype.org
    publishToMavenCentral(SonatypeHost.S01)

    signAllPublications()
    coordinates(groupId, libraryName, libraryVersion)

    // This generates POM.xml with proper parameters
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
