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

    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        intellijIdeaCommunity(version = "2024.3.6")
        bundledPlugin(id = "com.intellij.java")
    }
}

intellijPlatform {
    buildSearchableOptions = false

    pluginConfiguration {
        ideaVersion {
            sinceBuild = "243"
        }
    }
    pluginVerification  {
        ides {
            recommended()
        }
    }
}
