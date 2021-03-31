package de.polo.coins.listener;

import de.polo.coins.CoinsAPI;
import de.polo.coins.database.CoinsDatabaseAdapter;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener{

    public PlayerJoinListener() {
        Bukkit.getPluginManager().registerEvents(this, CoinsAPI.getInstance());
    }

    @EventHandler
    public void handle(PlayerJoinEvent event){
        CoinsDatabaseAdapter coinsDatabaseAdapter = CoinsAPI.getInstance().getCoinsDatabaseAdapter();
        if(!coinsDatabaseAdapter.isProfileExists(event.getPlayer().getUniqueId()))
        coinsDatabaseAdapter.createProfile(event.getPlayer().getUniqueId(), 150);
    }
}
