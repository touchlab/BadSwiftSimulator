import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction
import org.gradle.process.ExecOperations
import javax.inject.Inject

abstract class LinkSdkSourcesTask @Inject constructor(
    private val execOperations: ExecOperations,
    project: Project,
): DefaultTask() {

    private val rootDir = project.rootDir
    private val projectDir = project.projectDir

    @TaskAction
    fun linkKmpSources() {
        val files = mapOf(
            "DefaultArgs.kt" to "defaultArgs",
            "Enums.kt" to "enums",
            "Flows.kt" to "flows",
            "Generics.kt" to "generics",
            "Sealed.kt" to "sealed",
            "Suspends.kt" to "suspends",
        )

        execOperations.exec {
            commandLine("mkdir", "-p", "$projectDir/src/commonMain/kotlin/co/touchlab/sdk")
        }

        files.forEach { (file, module) ->
            val sourceFile = rootDir.resolve("sdk/good/$module/src/main/kotlin/co/touchlab/sdk").resolve(file)
            val targetParentDir = projectDir.resolve("src/commonMain/kotlin/co/touchlab/sdk")
            // Don't try to overwrite anything
            if (!targetParentDir.resolve(file).exists()) {
                execOperations.exec {
                    rootDir.relativeTo(projectDir)
                    commandLine("ln", "-s", sourceFile.relativeTo(targetParentDir), file)
                    workingDir = targetParentDir
                }
            }
        }
    }
}
