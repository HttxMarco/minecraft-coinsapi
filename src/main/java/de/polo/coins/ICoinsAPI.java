package de.polo.coins;

import java.util.UUID;

public interface ICoinsAPI {

    boolean isProfileExists(UUID uuid);

    void createProfile(UUID uuid, int defaultValue);

    boolean removeProfile(UUID uuid);



}
