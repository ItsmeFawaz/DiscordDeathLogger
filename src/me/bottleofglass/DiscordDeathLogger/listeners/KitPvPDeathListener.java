package me.bottleofglass.DiscordDeathLogger.listeners;

import me.bottleofglass.DiscordDeathLogger.BotManager;
import me.bottleofglass.DiscordDeathLogger.DiscordBotPlugin;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.guildcraft.kitpvp.events.PlayerKilledByPlayerEvent;

public class KitPvPDeathListener implements Listener {
    @EventHandler
    public void onKitPvPDeath(PlayerKilledByPlayerEvent evt) {
        TextChannel channel = BotManager.getJda().getTextChannelById(DiscordBotPlugin.getInstance().getConfig().getLong("channelID"));
        channel.sendMessage(evt.getKilled().getName() + " has been brutally murdered by " + evt.getKiller().getName()).queue();
    }
}
