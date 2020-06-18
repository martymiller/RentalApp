buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Libs.gradle)
        classpath(Libs.kotlinGradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
