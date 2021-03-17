package de.polo.coins;

import com.google.common.collect.Lists;
import de.polo.coins.database.CoinsDatabaseAdapter;
import de.polo.coins.database.DatabaseConnection;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class CoinsAPI {

    private static CoinsAPI instance;
    private DatabaseConnection databaseConnection;
    private CoinsDatabaseAdapter coinsDatabaseAdapter;

    private final List<CoinsPlayer> coinsPlayers = Lists.newArrayList();

    public CoinsAPI() throws SQLException {
        instance = this;

        this.databaseConnection = new DatabaseConnection();
        this.databaseConnection.connect();
        this.coinsDatabaseAdapter = new CoinsDatabaseAdapter(this.databaseConnection.getExecutor());
    }

    public static CoinsAPI getInstance() {
        return instance;
    }

    public CoinsPlayer getCoinsPlayer(UUID uuid){
        return this.coinsPlayers.stream().filter(coinsPlayer -> coinsPlayer.getUuid().equals(uuid)).findFirst().orElse(null);
    }

    public List<CoinsPlayer> getAllCachedCoinPlayers() {
        return coinsPlayers;
    }

    public DatabaseConnection getDatabaseConnection() {
        return databaseConnection;
    }


    public CoinsDatabaseAdapter getCoinsDatabaseAdapter() {
        return coinsDatabaseAdapter;
    }
}
