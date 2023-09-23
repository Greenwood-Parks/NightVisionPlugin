package net.greenwoodmc.nightvision;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class nightVisionCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command");
            return true;
        } else {
            Player player = (Player) sender;
            JavaPlugin plug = JavaPlugin.getPlugin(NightVision.class);
            if (cmd.getName().equalsIgnoreCase("nightvision") || cmd.getName().equalsIgnoreCase("nv")) {
                if (player.hasPermission("gwnv.use")) {
                    PotionEffect potionEffect = player.getPotionEffect(PotionEffectType.NIGHT_VISION);
                    if (potionEffect != null) {
                        player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                        player.sendMessage(ChatColor.DARK_PURPLE + "Removed Night Vision");
                    } else {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 1, true, false));
                        player.sendMessage(ChatColor.DARK_PURPLE + "Applied Night Vision");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "No Permission");
                }
            }
        }
        return false;
    }
}
