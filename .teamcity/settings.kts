import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.placeholder
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.script

version = "2019.1"

project {
    buildType(Build)
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        script {
            scriptContent = """echo "running the Build...""""
        }
    }
})
