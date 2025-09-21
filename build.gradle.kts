plugins {
    id("java")
    id("org.jetbrains.intellij.platform") version "2.9.0"
}

group = "com.tihonovcore"
version = "0.1-SNAPSHOT"

sourceSets {
    main {
        java {
            srcDirs("src/main/gen")
        }
    }
}

repositories {
    mavenCentral()
    mavenLocal()

    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        intellijIdeaCommunity(version = "2024.3.6")
        bundledPlugin(id = "com.intellij.java")
    }

    implementation("com.tihonovcore:iceberg:0.1")
}

intellijPlatform {
    buildSearchableOptions = false

    pluginConfiguration {
        ideaVersion {
            sinceBuild = "243"
            untilBuild = "252.*"
        }
    }
    pluginVerification  {
        ides {
            recommended()
        }
    }
}
