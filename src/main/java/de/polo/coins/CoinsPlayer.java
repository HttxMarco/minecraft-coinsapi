package de.polo.coins;

import de.polo.coins.database.CoinsDatabaseAdapter;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class CoinsPlayer {

    private final UUID uuid;
    private int coins;

    public CoinsPlayer(UUID uuid) {
        this.uuid = uuid;

        CoinsDatabaseAdapter coinsDatabaseAdapter = CoinsAPI.getInstance().getCoinsDatabaseAdapter();
        if(!coinsDatabaseAdapter.isProfileExists(uuid)){
            coinsDatabaseAdapter.createProfile(uuid, 0);
        }
        this.coins = coinsDatabaseAdapter.getCoinsFromData(uuid);

    }

    public UUID getUuid() {
        return uuid;
    }

    public int getCoins() {
        return coins;
    }

    public void updateAsync(){
        CompletableFuture.supplyAsync(this::update);
    }

    public int update(){
        return CoinsAPI.getInstance().getDatabaseConnection().getExecutor().executeUpdate("UPDATE coinsapi SET coins= " + this.coins + " WHERE uuid=" + uuid.toString() + ";");
    }

    public void addCoins(int coins){
        setCoins(getCoins()+coins);
    }

    public void setCoins(int coins){
        this.coins = coins;
    }
}
