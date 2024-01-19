/*
 * This file was generated by the Gradle 'init' task.
 *
 * This is a general purpose Gradle build.
 * To learn more about Gradle by exploring our Samples at https://docs.gradle.org/8.5/samples
 */

 plugins {
    java
    checkstyle
  }

 repositories {
    mavenCentral()
  }

 version = "2.3.4"  

 checkstyle {
    val archive = configurations.checkstyle.get().resolve().filter {
        it.name.startsWith("checkstyle")
    }
    config = resources.text.fromArchiveEntry(archive, "google_checks.xml")
}

dependencies {
  testImplementation(platform("org.junit:junit-bom:5.10.1"))
  testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.jar {
  val archiveName by archiveFileName
    eachFile {
      println("Jar file: $sourceName will be included in $archiveName")
    }
}

tasks.named<ProcessResources>("processResources") {
  eachFile {
    println("Copying: $sourceName to $destinationDir")
  }
}

val checkVersion = tasks.register<DefaultTask>("checkVersion") {
  description = "Checks that the project version follows the standard major.minor.patch format"
  group = "Verification"
  doFirst {
    println("Current version: ${project.version}")

    val re = Regex("\\d+\\.\\d+\\.\\d+")

    if (!re.matches(project.version.toString())) {
      throw RuntimeException("Version has invalid format")
    } else {
       println("It's ok!")
      }
  }
}

tasks.named<DefaultTask>("check") {
  dependsOn(checkVersion)
}