package Locations;

import Game.Player;
import Item.Armor;
import Item.Weapon;

public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya Hoşgeldiniz!");
        Boolean showMenu = true;
        while (showMenu) {
            System.out.println("1-Silahlar");
            System.out.println("2-Zırhlar");
            System.out.println("3-Çıkış Yap");
            System.out.println("Lütfen bir seçim yapın:");
            int selectCase = input.nextInt();
            if (selectCase < 1 || selectCase > 3) {
                System.out.println("Hatalı seçim, Lütfen tekrar seçim yapınız!");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Tekrar bekleriz!");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("Silahlar");
        System.out.println();
        for (Weapon w :Weapon.weapons()) {
            System.out.println(w.getId()+ " - " + w.getName() + " Para = " +w.getPrice() + " Hasar = " +w.getDamage());
        }

        System.out.println("0 - Çıkış Yap!");

    }

    public void buyWeapon() {
        System.out.println("Lütfen bir silah seçiniz!");
        int selectWeaponId = input.nextInt();
        if (selectWeaponId < 0 || selectWeaponId > Weapon.weapons().length) {
            System.out.println("Hatalı seçim, Lütfen tekrar seçim yapınız!");
            selectWeaponId = input.nextInt();
        }
        if (selectWeaponId != 0) {
            Weapon selectedWeapon = Weapon.getWeaponById(selectWeaponId);
            if (selectedWeapon != null) {
                if (this.getPlayer().getMoney() > selectedWeapon.getPrice() || this.getPlayer().getMoney() == selectedWeapon.getPrice()) {
                    System.out.println("Seçtiğiniz silah = " + selectedWeapon.getName());
                    int balance = (this.getPlayer().getMoney() - selectedWeapon.getPrice());
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız = " + this.getPlayer().getMoney());
                    System.out.println("Önceki silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Yeni silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                } else {
                    System.out.println("Yeterli paranız bulunmamaktadır!");
                }
            }
        }
    }
    public void printArmor() {
        System.out.println("Zırhlar");
        for (Armor a :Armor.armors()) {
            System.out.println(a.getId()+ " - " + a.getName() + " Para = " +a.getPrice() + " Block = " +a.getBlock());
        }
        System.out.println("0 - Çıkış Yap!");
    }

    public void buyArmor() {
        System.out.println("Lütfen bir zırh seçiniz!");
        int selectArmorId = input.nextInt();
        if (selectArmorId < 0 || selectArmorId > Armor.armors().length) {
            System.out.println("Hatalı seçim, Lütfen tekrar seçim yapınız!");
            selectArmorId = input.nextInt();
        }
        if (selectArmorId != 0) {
            Armor selectedArmor = Armor.getArmorsById(selectArmorId);
            if (selectedArmor != null) {
                if (this.getPlayer().getMoney() > selectedArmor.getPrice() || this.getPlayer().getMoney() == selectedArmor.getPrice()) {
                    System.out.println("Seçtiğiniz zırh = " + selectedArmor.getName());
                    int balance = (this.getPlayer().getMoney() - selectedArmor.getPrice());
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız = " + this.getPlayer().getMoney());
                    System.out.println("Önceki zırhınız: " + this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Yeni zırhınız: " + this.getPlayer().getInventory().getArmor().getName());
                } else {
                    System.out.println("Yeterli paranız bulunmamaktadır!");
                }
            }
        }
    }

    public void menu(){

    }

    public void buy(){

    }

}
