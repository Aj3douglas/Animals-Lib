package org.aj3douglas.ajanimals.animals

import com.cryptomorin.xseries.XMaterial
import org.aj3douglas.ajanimals.errors.AJException
import org.aj3douglas.ajanimals.util.ItemBuilder
import org.aj3douglas.ajanimals.util.debug
import org.aj3douglas.ajanimals.util.from
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.entity.ArmorStand
import org.bukkit.inventory.ItemStack

class Turtle(private val location:Location) {

    private val parts = mutableMapOf<String, ArmorStand>()
    fun spawn() {
        val bodyAs = spawnArmourStand(location, true)
        val headAs = spawnArmourStand(location.clone().add(0.2, -0.2, 0.0), true)

        val shellMaterial = from(XMaterial.PLAYER_HEAD.parseMaterial()!!)
        bodyAs.equipment?.helmet = ItemStack(Material.GREEN_CONCRETE)
        headAs.equipment?.helmet = ItemStack(Material.LIME_CONCRETE)

        parts["body"] = bodyAs
        parts["head"] = headAs
        "spawning armour stand".debug()

    }
    private fun spawnArmourStand(location: Location, small:Boolean = false): ArmorStand {
        val stand = location.world?.spawn(location, ArmorStand::class.java) ?: throw AJException("World in location is null!")
        stand.setBasePlate(false)
        stand.setArms(true)
        stand.isVisible = true
        stand.isInvulnerable = true
        stand.canPickupItems = false
        stand.setGravity(true)
        stand.isSmall = small
        return stand
    }
}