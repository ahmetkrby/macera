package Locations;

import Game.Player;
import Locations.BattleLoc;
import Monsters.Zombie;

public class Cave extends BattleLoc {
    public Cave(Player player) {
        super(player, "Mağara", new Zombie(), "food", 3);
    }
}
