package org.aj3douglas.ajanimals.test

import me.mattstudios.mf.base.CommandManager
import org.bukkit.plugin.java.JavaPlugin

class Test:JavaPlugin() {
    override fun onEnable() {
        val cmdManager = CommandManager(this)
        cmdManager.register(TestCommand())
    }
}