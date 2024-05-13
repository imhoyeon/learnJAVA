package me.shy.test;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Test extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().warning("플러그인 활성화");
        Bukkit.getCommandMap().register("test", new command("test"));
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().warning("플러그인 비활성화");
    }
}
