package hexjs.utils


/**
 * Precompiled [mod-dependencies.gradle.kts][hexjs.utils.Mod_dependencies_gradle] script plugin.
 *
 * @see hexjs.utils.Mod_dependencies_gradle
 */
public
class ModDependenciesPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("hexjs.utils.Mod_dependencies_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
