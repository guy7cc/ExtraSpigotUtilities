package io.github.guy7cc.extraspigotutilities;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Entity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoveSeatsScheduler extends BukkitRunnable{
    public static final List<Chicken> seats = new ArrayList<>();
    public RemoveSeatsScheduler(){
        for(World w : ExtraSpigotUtilities.getPlugin().getServer().getWorlds()){
            for(Entity e : w.getEntities()){
                if(e instanceof Chicken){
                    Chicken c = (Chicken) e;
                    if(c.getCustomName() != null && c.getCustomName().equals(ChatColor.GREEN + "seat")){
                        seats.add(c);
                    }
                }
            }
        }
    }
    @Override
    public void run(){
        Iterator<Chicken> it = seats.iterator();
        while(it.hasNext()){
            Chicken c = it.next();
            if(c.getPassengers().size() == 0){
                it.remove();
                c.remove();
            }
            else{
                c.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 216000, 1, false, false));
            }
        }
    }
}
