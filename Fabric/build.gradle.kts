plugins {
    id("hexjs.platform")
}

architectury {
    fabric()
}

hexjsModDependencies {
    // expand versions in fabric.mod.json
    filesMatching.add("fabric.mod.json")

    // transform Gradle version ranges into a Fabric-compatible format
    anyVersion = "*"
    mapVersions {
        replace(",", " ")
        replace(Regex("""\s+"""), " ")
        replace(Regex("""\[(\S+)"""), ">=$1")
        replace(Regex("""(\S+)\]"""), "<=$1")
        replace(Regex("""\](\S+)"""), ">$1")
        replace(Regex("""(\S+)\["""), "<$1")
    }

    // CurseForge/Modrinth mod dependency metadata
    requires("architectury-api")
    requires("cloth-config")
    requires(curseforge = "hexcasting", modrinth = "hex-casting")
    requires("fabric-api")
    requires("fabric-language-kotlin")
    optional("modmenu")
}

dependencies {
    modApi(libs.fabric.api)
    modImplementation(libs.fabric.loader)

    modImplementation(libs.kotlin.fabric)

    modApi(libs.architectury.fabric) {
        // Fix for the "two fabric loaders" loading crash
        exclude(group = "net.fabricmc", module = "fabric-loader")
    }

    modApi(libs.hexcasting.fabric) {
        // If not excluded here, calls a nonexistent method and crashes the dev client
        exclude(module = "phosphor")
    }
    // Hex Casting dependencies
    // we use modLocalRuntime to add these to the development runtime, but not at compile time or for consumers of this project
    modLocalRuntime(libs.paucal.fabric)
    modLocalRuntime(libs.patchouli.fabric)
    modLocalRuntime(libs.cardinalComponents)
    modLocalRuntime(libs.serializationHooks)
    modLocalRuntime(libs.trinkets)

    // this is also a Hex dependency, but it's included in case you want to use it for stuff
    libs.mixinExtras.also {
        implementation(it)
        include(it)
    }

    modApi(libs.clothConfig.fabric) {
        exclude(group = "net.fabricmc.fabric-api")
    }
    modImplementation(libs.modMenu)
}

publishMods {
    modLoaders.add("quilt")

    // this fails if we do it for all projects, since the tag already exists :/
    // see https://github.com/modmuss50/mod-publish-plugin/issues/3
    github {
        accessToken = System.getenv("GITHUB_TOKEN") ?: ""
        repository = System.getenv("GITHUB_REPOSITORY") ?: ""
        commitish = System.getenv("GITHUB_SHA") ?: ""

        type = STABLE
        displayName = "v${project.version}"
        tagName = "v${project.version}"
    }
}

tasks {
    named("publishGithub") {
        dependsOn(project(":Common").tasks.remapJar)
        dependsOn(project(":Forge").tasks.remapJar)

        // we need to do this here so that it waits until Forge is already configured
        // otherwise tasks.remapJar doesn't exist yet
        publishMods {
            github {
                additionalFiles.from(
                    project(":Common").tasks.remapJar.get().archiveFile,
                    project(":Forge").tasks.remapJar.get().archiveFile,
                )
            }
        }
    }
}
