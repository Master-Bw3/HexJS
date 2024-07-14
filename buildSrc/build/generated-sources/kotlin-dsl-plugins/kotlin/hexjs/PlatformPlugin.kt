package hexjs


/**
 * Precompiled [platform.gradle.kts][hexjs.Platform_gradle] script plugin.
 *
 * @see hexjs.Platform_gradle
 */
public
class PlatformPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("hexjs.Platform_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
