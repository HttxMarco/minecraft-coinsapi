package de.polo.coins.database;

import java.sql.ResultSet;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class CoinsDatabaseAdapter {

    private final Executor executor;

    public CoinsDatabaseAdapter(Executor executor) {
        this.executor = executor;
    }

    public void createTable(){
        CompletableFuture.supplyAsync(() -> executor.executeUpdate("CREATE TABLE IF NOT EXISTS coinsapi (uuid varchar(64), coins int)"));
    }

    public void createProfile(UUID uuid, int coins){
        CompletableFuture.supplyAsync(() -> executor.executeUpdate("INSERT INTO coinsapi (uuid, coins) VALUES (" + uuid.toString() + ", " + coins + ")"));
    }

    public boolean isProfileExists(UUID uuid){
        return executor.executeQuery("SELECT * FROM coinsapi WHERE uuid=" + uuid.toString(), ResultSet::next, false);
    }

    public int getCoinsFromData(UUID uuid){
        return this.executor.executeQuery("SELECT coins FROM coinsapi WHERE uuid=" + uuid.toString(), resultSet -> {
            if(resultSet.next()){
                return resultSet.getInt("coins");
            }
            return -1;
        }, -1);
    }

}
