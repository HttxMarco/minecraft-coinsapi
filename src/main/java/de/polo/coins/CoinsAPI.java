package de.polo.coins;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CoinsAPI {

    private static CoinsAPI instance;
    private List<CoinsPlayer> coinsPlayers = Lists.newArrayList();

    public static CoinsAPI getInstance() {
        return instance;
    }

    public CoinsPlayer getCoinsPlayer(UUID uuid){
        return this.coinsPlayers.stream().filter(coinsPlayer -> coinsPlayer.getUuid().equals(uuid)).findFirst().orElse(null);
    }




}
