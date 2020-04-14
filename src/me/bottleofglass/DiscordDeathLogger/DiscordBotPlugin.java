package me.bottleofglass.DiscordDeathLogger;

import me.bottleofglass.DiscordDeathLogger.listeners.KitPvPDeathListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;

public class DiscordBotPlugin extends JavaPlugin {
    private static DiscordBotPlugin instance;
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        initializeBot();
        Bukkit.getPluginManager().registerEvents(new KitPvPDeathListener(), this);
    }

    @Override
    public void onDisable() {
        BotManager.getJda().shutdown();
    }

    private void initializeBot() {
        try {
            new BotManager(getConfig().getString("token"));
        } catch (LoginException e) {
            e.printStackTrace();
            getLogger().severe("Failed to initialize bot. Disabling plugin.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }
    public static DiscordBotPlugin getInstance() {return instance;}
}
