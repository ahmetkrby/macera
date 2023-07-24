package Game;

import Game.Inventory;
import Character.GameCharacter;
import Character.Samurai;
import Character.Knight;
import Character.Archer;
import Item.Weapon;

import java.util.Scanner;

public class Player {

    private Inventory inventory;
    private int damage;
    private int healthy;
    private int originalHealth;
    private int money;
    private String name;
    private String charName;

    Scanner input = new Scanner(System.in);

    public  Player(String name){
        this.inventory = new Inventory();
        this.name = name;
    }
    public void selectChar(){
     GameCharacter[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("-------------------------------------------------------------------------------------");
     for(GameCharacter gameCharacter : charList) {
         System.out.println( "ID: "+ gameCharacter.getId() +
                 "\t Karakter:" + gameCharacter.getName() +
                 "\t Hasar:" + gameCharacter.getDamage() +
                 "\t Sağlık:" + gameCharacter.getHealth() +
                 "\t Para:" + gameCharacter.getMoney());
     }

        System.out.println("-------------------------------------------------------------------------------------");

        System.out.println("Lütfen bir karakter seçiniz");
        int selectChar = input.nextInt();

       switch (selectChar) {
           case 1:initPlayer(new Samurai());
           break;
           case 2:initPlayer(new Archer());
           break;
           case 3:initPlayer(new Knight());
           break;
       }

      /*   System.out.println("Karakter:" + this.getName() +
                ", Hasar:" + this.getDamage() +
                ", Sağlık:" + this.getHealthy() +
                ", Para:" + this.getMoney());
*/
    }

    public void initPlayer(GameCharacter gameCharacter) {
        this.setHealthy(gameCharacter.getHealth());
        this.setOriginalHealth(gameCharacter.getHealth());
        this.setDamage(gameCharacter.getDamage());
        this.setName(gameCharacter.getName());
        this.setMoney(gameCharacter.getMoney());

    }

    public void printInfo() {
        System.out.println("Silahınız:" + this.getInventory().getWeapon().getName() +
                ", Zırhınız:" + this.getInventory().getArmor().getName() +
                ", Bloklama:" + this.getInventory().getArmor().getBlock() +
                ", Hasar:" + this.getTotatlDamage() +
                ", Sağlık:" + this.getHealthy() +
                ", Para:" + this.getMoney());
    }

    public void printInventory() {
        System.out.println();
        System.out.println("Food:" + this.getInventory().getFood());
        System.out.println("Water:" + this.getInventory().getWater());
        System.out.println("Wood:" + this.getInventory().getWood());
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getTotatlDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }
    public int getDamage() {
        return damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public int getMoney() {
        return money;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public String getName() {
        return name;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHealthy(int healthy) {
        if (healthy < 0) {
            healthy = 0;
        }

        this.healthy = healthy;
    }
    public Weapon getWeapon() {
        return getInventory().getWeapon();
    }
}
