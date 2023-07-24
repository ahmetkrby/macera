package Locations;

import Game.Player;
import Locations.BattleLoc;
import Monsters.Vampire;

public class Forest extends BattleLoc {
    public Forest(Player player) {
        super(player, "Orman", new Vampire(), "water",1);
    }
}
