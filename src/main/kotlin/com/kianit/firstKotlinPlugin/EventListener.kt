package com.kianit.firstKotlinPlugin

import org.bukkit.Material
import org.bukkit.Particle
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

class EventListener : Listener {
    @EventHandler
    fun PlayerInteractEvent(event: PlayerInteractEvent) {
        val player = event.player
        val act = event.action

        if (act == Action.RIGHT_CLICK_BLOCK) {
            var block = event.clickedBlock
            if (player.inventory.itemInMainHand.type == Material.BONE_MEAL && block?.type == Material.DIRT) {
                block?.type = Material.GRASS_BLOCK
                player.inventory.itemInMainHand.amount -= 1
                event.isCancelled = true

                var loc = block.location
                loc.add(0.5,0.5,0.5)
                val world = player.world
                world.spawnParticle(Particle.HAPPY_VILLAGER, loc, 30, 0.53, 0.53, 0.53)

            }
        }
    }
}