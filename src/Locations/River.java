package Locations;

import Game.Player;
import Locations.BattleLoc;
import Monsters.Bear;

public class River extends BattleLoc {
    public River(Player player) {
        super(player, "Nehir",new Bear(), "water",2);
    }
}
