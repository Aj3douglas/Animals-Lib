package org.aj3douglas.ajanimals.test

import me.mattstudios.mf.annotations.Command
import me.mattstudios.mf.annotations.Default
import me.mattstudios.mf.base.CommandBase
import org.aj3douglas.ajanimals.animals.Turtle
import org.bukkit.entity.Player


@Command("test")
class TestCommand : CommandBase() {
    @Default
    fun defaultTest(player:Player){
        val turtle = Turtle(player.location)
        turtle.spawn()
    }
}