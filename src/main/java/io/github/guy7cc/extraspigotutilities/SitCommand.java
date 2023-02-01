package io.github.guy7cc.extraspigotutilities;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class SitCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(command.getName().equalsIgnoreCase("sit")){
            if(sender instanceof Entity){
                Entity e = (Entity)sender;
                World w = e.getWorld();
                Chicken seat = (Chicken)w.spawnEntity(e.getLocation().add(new Vector(0.0, -0.3, 0.0)), EntityType.CHICKEN);

                seat.setBaby();
                seat.setBreed(false);
                seat.setAI(false);
                seat.setGravity(false);
                seat.setSilent(true);
                seat.setInvulnerable(true);
                seat.setHealth(1.0);
                seat.setCollidable(false);
                seat.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 216000, 1, true, false));
                seat.setCustomName(ChatColor.GREEN + "seat");
                seat.setCustomNameVisible(false);
                seat.addPassenger(e);
                RemoveSeatsScheduler.seats.add(seat);

                return true;
            }
        }
        return false;
    }
}
