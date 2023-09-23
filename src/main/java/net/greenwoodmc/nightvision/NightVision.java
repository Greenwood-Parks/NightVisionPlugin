package net.greenwoodmc.nightvision;

import org.bukkit.plugin.java.JavaPlugin;

public final class NightVision extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Night Vision Enabled");
        getLogger().info("Author: VoidemLIVE");
        getLogger().info("Property of Greenwood Parks & VoidemLIVE");
        getLogger().info("https://greenwoodmc.net");
        getLogger().info("Version: " + getDescription().getVersion());
        this.getCommand("nightvision").setExecutor(new nightVisionCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
