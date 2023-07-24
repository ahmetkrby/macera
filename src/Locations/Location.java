package Locations;

import Game.Player;

import java.util.Scanner;

public abstract class Location {

    private Player player;
    private String name;
    protected Scanner input = new Scanner(System.in);

    public Location(Player player, String name) {
        this.player = player;
        this.name = name;
    }

    public void Location() {

    }
    public abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public String getName() {
        return name;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setName(String name) {
        this.name = name;
    }
}
