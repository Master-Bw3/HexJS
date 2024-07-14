package hexjs.utils


/**
 * Precompiled [json5.gradle.kts][hexjs.utils.Json5_gradle] script plugin.
 *
 * @see hexjs.utils.Json5_gradle
 */
public
class Json5Plugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("hexjs.utils.Json5_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
