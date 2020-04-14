package me.bottleofglass.DiscordDeathLogger;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
import java.util.Arrays;
import java.util.EnumSet;

public class BotManager {
    private static JDA jda;
    public BotManager(String token) throws LoginException {
        jda = JDABuilder.create(token,EnumSet.noneOf(GatewayIntent.class)).disableCache(Arrays.asList(CacheFlag.values())).setMemberCachePolicy(MemberCachePolicy.NONE).build();
    }
    public static JDA getJda() {return jda;}
}
