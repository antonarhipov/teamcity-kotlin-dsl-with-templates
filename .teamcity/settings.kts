import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.placeholder
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.script

version = "2019.1"

project {
    buildType(Build)
    template(MyTemplate)
}

object Build : BuildType({
    templates(MyTemplate)
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

object MyTemplate : Template({
    name = "MyTemplate"

    steps {
        script {
            scriptContent = """echo "Hello from MyTemplate""""
        }
        placeholder {
        }
        script {
            scriptContent = """echo "Final step from MyTemplate""""
        }
    }
})
