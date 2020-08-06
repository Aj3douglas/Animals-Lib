package org.aj3douglas.ajanimals.util

import com.cryptomorin.xseries.XMaterial
import com.mojang.authlib.GameProfile
import com.mojang.authlib.properties.Property
import org.aj3douglas.ajanimals.errors.AJException
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.inventory.meta.SkullMeta
import java.lang.reflect.Field
import java.util.*
fun from(itemStack: ItemStack):ItemBuilder{
    return ItemBuilder(itemStack)
}

fun from(material:Material):ItemBuilder{
    return ItemBuilder(material)
}

class ItemBuilder(private var itemStack: ItemStack) {
    private var meta: ItemMeta = itemStack.itemMeta ?: throw AJException("Item meta is null!")

    constructor(material:Material) : this(ItemStack(material))


    fun build():ItemStack{
        itemStack.itemMeta = meta
        return itemStack
    }


    fun setSkullTexture(texture:String):ItemBuilder{
        if(itemStack.type != XMaterial.PLAYER_HEAD.parseMaterial()) return this
        val skullMeta = meta as SkullMeta
        val profile = GameProfile(UUID.randomUUID(),null)
        profile.properties.put("textures", Property("textures", texture))
        val profileField = skullMeta::class.java.getDeclaredField("profile")
        profileField.isAccessible = true
        profileField.set(skullMeta, profile)
        meta = skullMeta
        return this
    }

}