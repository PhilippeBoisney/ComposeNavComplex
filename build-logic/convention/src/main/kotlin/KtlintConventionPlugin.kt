/*
 * Copyright 2023 The Android Open Source Project
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

import com.complexnav.libs
import java.io.File
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.attributes.Bundling
import org.gradle.api.file.ConfigurableFileTree
import org.gradle.api.file.Directory
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.JavaExec
import org.gradle.kotlin.dsl.creating
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.named
import org.gradle.kotlin.dsl.register
import org.gradle.language.base.plugins.LifecycleBasePlugin

class KtlintConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            val ktlint by configurations.creating
            dependencies {
                ktlint(libs.findLibrary("ktlint").get()) {
                    attributes {
                        attribute(Bundling.BUNDLING_ATTRIBUTE, objects.named(Bundling.EXTERNAL))
                    }
                }
            }
            val inputFiles: ConfigurableFileTree =
                project.fileTree(".") {
                    include("**/*.kt", "**/*.kts")
                    exclude("**/build/**", "**/generated/**")
                }
            val argsFiles = inputFiles.includes + inputFiles.excludes.map { "!$it" }
            val outputDir: Provider<Directory> = project.layout.buildDirectory.dir("reports/ktlint")
            val outputFile = File(outputDir.get().asFile, "checkstyle-report.xml")

            tasks.register("ktlintCheck", JavaExec::class) {
                group = LifecycleBasePlugin.VERIFICATION_GROUP
                description = "Check Kotlin code style."

                inputs.files(inputFiles)
                outputs.dir(outputDir)

                classpath = ktlint
                mainClass.set("com.pinterest.ktlint.Main")

                args = listOf("--reporter=checkstyle,output=$outputFile") + argsFiles
            }

            tasks.register("ktlintFormat", JavaExec::class) {
                group = LifecycleBasePlugin.VERIFICATION_GROUP
                description = "Fix Kotlin code style deviations."

                inputs.files(inputFiles)
                outputs.dir(outputDir)

                classpath = ktlint
                mainClass.set("com.pinterest.ktlint.Main")
                jvmArgs = listOf("--add-opens=java.base/java.lang=ALL-UNNAMED")

                args = listOf("-F") + argsFiles
            }
        }
    }
}
