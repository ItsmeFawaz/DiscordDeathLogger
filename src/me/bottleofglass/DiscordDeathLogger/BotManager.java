package me.bottleofglass.DiscordDeathLogger;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.bukkit.Bukkit;

import javax.security.auth.login.LoginException;
import java.util.Arrays;
import java.util.EnumSet;

public class BotManager {
    private static JDA jda;
    private static TextChannel channel;
    public BotManager(String token) throws LoginException {
        DiscordBotPlugin.getInstance().getLogger().info("Intializing Bot");
        jda = JDABuilder.create(token,EnumSet.noneOf(GatewayIntent.class)).disableCache(Arrays.asList(CacheFlag.values())).setMemberCachePolicy(MemberCachePolicy.NONE).build();
        if(channel == null) {
            DiscordBotPlugin.getInstance().getLogger().info("No channel found with the provided channelID, Disabling plugin..");
            Bukkit.getPluginManager().disablePlugin(DiscordBotPlugin.getInstance());
        }
        channel = BotManager.getJda().getTextChannelById(DiscordBotPlugin.getInstance().getConfig().getLong("channelID"));
    }
    public static JDA getJda() {return jda;}
    public static TextChannel getChannel() {return channel;}
}
