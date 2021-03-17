package de.polo.coins;

import java.util.UUID;

public class CoinsPlayer {

    private UUID uuid;
    private int coins;

    public CoinsPlayer(UUID uuid, int coins) {
        this.uuid = uuid;
        this.coins = coins;
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getCoins() {
        return coins;
    }
}
