package de.polo.coins;

import java.util.UUID;

public interface ICoinsAPI {

    boolean isProfileExists(UUID uuid);

    void createProfile(UUID uuid, int defaultValue);

    boolean removeProfile(UUID uuid);

    void addProfileAtCache(UUID uuid, int coins);

    void removeProfileAtCache(UUID uuid);

    void updateProfile(UUID uuid, int coins);

    int getCoins();

    int getCoinsFromDatabase();


}
