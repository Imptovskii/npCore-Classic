package dev.newplaces.npcore;

import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;
import dev.newplaces.npcore.events.BlockPlace;
import dev.newplaces.npcore.events.PlayerJoin;
import dev.newplaces.npcore.events.PlayerQuit;
import dev.newplaces.npcore.events.GreenChat;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        PlayerJoin playerJoin = new PlayerJoin();
        PlayerQuit playerQuit = new PlayerQuit();
       getServer().getPluginManager().registerEvent(Event.Type.PLAYER_JOIN, playerJoin, Event.Priority.Normal, this);
       getServer().getPluginManager().registerEvent(Event.Type.PLAYER_QUIT, playerQuit, Event.Priority.Normal, this);
       getServer().getPluginManager().registerEvent(Event.Type.BLOCK_PLACE, new BlockPlace(), Event.Priority.Normal, this);
       getServer().getPluginManager().registerEvent(Event.Type.PLAYER_CHAT, (Listener)new GreenChat(), Event.Priority.Normal, (Plugin)this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
