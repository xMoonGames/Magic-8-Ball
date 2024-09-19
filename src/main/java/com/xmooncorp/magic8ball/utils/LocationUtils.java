package com.xmooncorp.magic8ball.utils;

import org.bukkit.Location;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;

// from https://www.spigotmc.org/threads/player-right-hand-location.168219/
public class LocationUtils {

    /**
     * Returns a location with a specified distance in front of a location.
     *
     * @param location The origin location
     * @param distance The distance in front
     * @return the location in front of the given location
     */
    public static Location getFrontSide(@Nonnull Location location, double distance) {
        return location.clone().add(new Vector(-Math.sin(Math.toRadians(location.getYaw())), 0, Math.cos(Math.toRadians(location.getYaw()))).normalize().multiply(distance));
    }

    /**
     * Returns a location with a specified distance behind a location.
     *
     * @param location The origin location
     * @param distance The distance behind
     * @return the location behind the given location
     */
    public static Location getBackSide(@Nonnull Location location, double distance) {
        return location.clone().subtract(new Vector(-Math.sin(Math.toRadians(location.getYaw())), 0, Math.cos(Math.toRadians(location.getYaw()))).normalize().multiply(distance));
    }

    /**
     * Returns a location with a specified distance away from the right side of
     * a location.
     *
     * @param location The origin location
     * @param distance The distance to the right
     * @return the location of the distance to the right
     */

    public static Location getRightSide(@Nonnull Location location, double distance) {
        float angle = location.getYaw() / 60;
        return location.clone().subtract(new Vector(Math.cos(angle), 0, Math.sin(angle)).normalize().multiply(distance));
    }

    /**
     * Gets a location with a specified distance away from the left side of a
     * location.
     *
     * @param location The origin location
     * @param distance The distance to the left
     * @return the location of the distance to the left
     */

    public static Location getLeftSide(@Nonnull Location location, double distance) {
        float angle = location.getYaw() / 60;
        return location.clone().add(new Vector(Math.cos(angle), 0, Math.sin(angle)).normalize().multiply(distance));
    }
}
