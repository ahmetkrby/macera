package Locations;

import Game.Player;

public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }
    public boolean onLocation(){
        System.out.println("Güvenli evdesiniz!");
        System.out.println("Canınız yenilendi!");
        this.getPlayer().setHealthy(this.getPlayer().getOriginalHealth());
        this.getPlayer().printInventory();
        return true;
    }
}
