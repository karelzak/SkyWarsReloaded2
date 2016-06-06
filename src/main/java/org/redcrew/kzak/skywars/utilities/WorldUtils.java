package org.redcrew.kzak.skywars.utilities;

import org.bukkit.World;
import org.bukkit.entity.Player;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;

import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import net.minecraft.server.v1_8_R3.PlayerConnection;

public class WorldUtils {
    public static void sendParticles(World world, String type, float x, float y, float z, float offsetX, float offsetY, float offsetZ, float data, int amount) {
        EnumParticle particle = EnumParticle.valueOf(type);
        PacketPlayOutWorldParticles particles = new PacketPlayOutWorldParticles(particle, false, x, y, z, offsetX, offsetY, offsetZ, data, amount, 1);
        for (Player player : world.getPlayers()) {
            CraftPlayer start = (CraftPlayer) player; //Replace player with your player.
            EntityPlayer target = start.getHandle();
            PlayerConnection connect = target.playerConnection;
            connect.sendPacket(particles);
        }
    }

}
