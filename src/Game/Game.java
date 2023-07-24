package Game;

import Locations.*;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Game {
    private Player player;
    private Location location;


    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Macera Oyununa Hoşgeldiniz");
        System.out.println("Lütfen isim giriniz:"  );
       // String playerName = input.nextLine();
        Player player = new Player("Mustafa");
        System.out.println("Sayın "+ player.getName() + " Bu karanlık ve sisli adaya hoşgeldiniz!!");
        System.out.println("Burada yaşanılanların hepsi gerçek");
         player.selectChar();
        Location location = null;
         while (true) {
             player.printInfo();
             System.out.println();
             System.out.println("#########################Bölgeler:###########################3");
             System.out.println();
             System.out.println("1-Güvenli Bölge");
             System.out.println("2-Eşya Dükkanı");
             System.out.println("3-Mağara-- Ödül:Yemek--Dikkatli ol zombi çıkabilir");
             System.out.println("4-Orman-- Ödül:Odun--Dikkatli ol vampir çıkabilir");
             System.out.println("5-Nehir-- Ödül:Su--Dikkatli ol ayı çıkabilir");

             System.out.println("0-Çıkış Yap");
             System.out.println("Lütfen Gitmek istediğiniz bölgeyi seçiniz!");
             int selecetLocation = input.nextInt();
             switch (selecetLocation) {
                 case 0:
                     location = null;
                     break;
                 case 1:
                     location = new SafeHouse(player);
                     break;
                 case 2:
                     location = new ToolStore(player);
                     break;
                 case 3:
                     location = new Cave(player);
                     break;
                 case 4:
                     location = new Forest(player);
                     break;
                 case 5:
                     location = new River(player);
                     break;
                 default:
                     System.out.println("Hatalı seçim yaptınız!");
             }
             if (location == null) {
                 System.out.println("Oyun bitti tekrar bekleriz!");
                 break;
             }
             if(!location.onLocation()) {
                 System.out.println("GAME OVER ÖLDÜNÜZ!");
                 break;
             }
         }
    }

    public Player getPlayer() {
        return player;
    }

    public Location getLocation() {
        return location;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
