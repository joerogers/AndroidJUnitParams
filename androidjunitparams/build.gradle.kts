plugins {
    id("com.android.library")
    id("maven-publish")
    id("signing")
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
    publishing {
        singleVariant("release") {
            // if you don't want sources/javadoc, remove these lines
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {
    //implementation(fileTree(dir: "libs", include: ["*.jar"]))
    api("androidx.test:runner:1.5.0")
    api("pl.pragmatists:JUnitParams:1.1.1")
}

// Publishing info

val libraryGroupId = "com.forkingcode.androidjunitparams"
val libraryName = "androidjunitparams"
val libraryDescription = "Android extensions to the JUnitParams library"
val libraryVersion = "1.2.0"

val mavenUsername = project.providers.gradleProperty("mavenUsername").getOrElse("")
val mavenPassword =  project.providers.gradleProperty("mavenPassword").getOrElse("")

afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                groupId = libraryGroupId
                artifactId = libraryName
                version = libraryVersion

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

                afterEvaluate {
                    from(components["release"])
                }
            }

            signing {
                sign(publishing.publications)
            }

            repositories {
                maven {
                    val releasesRepoUrl = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
                    val snapshotsRepoUrl = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
                    url = if (libraryVersion.endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
                    credentials {
                        username = mavenUsername
                        password = mavenPassword
                    }
                }
            }
        }
    }
}

