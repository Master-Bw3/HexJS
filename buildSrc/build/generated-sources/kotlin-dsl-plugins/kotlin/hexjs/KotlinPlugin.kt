package hexjs


/**
 * Precompiled [kotlin.gradle.kts][hexjs.Kotlin_gradle] script plugin.
 *
 * @see hexjs.Kotlin_gradle
 */
public
class KotlinPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("hexjs.Kotlin_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
