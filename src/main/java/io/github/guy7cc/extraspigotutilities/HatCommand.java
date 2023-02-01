package io.github.guy7cc.extraspigotutilities;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class HatCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("hat")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                ItemStack helmet = player.getInventory().getHelmet();
                ItemStack mainHand = player.getInventory().getItemInHand();
                player.getInventory().setHelmet(mainHand);
                player.getInventory().setItemInHand(helmet);
                return true;
            }
        }
        return false;
    }
}
