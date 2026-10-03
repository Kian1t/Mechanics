package com.kianit.firstKotlinPlugin

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Mechanics : JavaPlugin() {

    override fun onEnable() {

        instance = this
        logger.info("Mechanics enabled!")
        Bukkit.getPluginManager().registerEvents(EventListener(), this)
    }

    override fun onDisable() {
        logger.info("Mechanics disabled!")
    }

    companion object {
        lateinit var instance: Mechanics
            private set
    }

}
