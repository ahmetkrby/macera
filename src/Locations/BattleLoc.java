package Locations;

import Game.Player;
import Monsters.Obstacle;

import java.util.Random;

public abstract class BattleLoc extends Location {

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }
    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("Şuan buradasınız!" + this.getName());
        System.out.println("Dikkatli ol burada" + this.getObstacle().getName() + " yaşıyor!");
        System.out.println("Dikkatli ol burada " + obsNumber +" tane " + this.getObstacle().getName() +" yaşıyor");
        System.out.println("<S>avaş veya <K>aç");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("S")) {
            if (combat(obsNumber)) {
                System.out.println(this.getName() + " tüm düşmanları yendiniz!");
                return true;

            }
        }
        if (this.getPlayer().getHealthy() <= 0) {
            return false;
        }

        return true;
    }

    public boolean combat(int obstNumber) {
        if (this.getObstacle().getName().equals("Snake")) {
            this.getObstacle().setDamage(snakeDamage());
        }
        for (int i = 1; i <= obstNumber; i++) {
            this.obstacle.setHealth(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);
            int combatChance = chance();
            while (this.getPlayer().getHealthy() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println("<V>ur veya <K>aç");
                String selectCombat = input.nextLine().toUpperCase();
                System.out.println("Siz vurdunuz!");
                if (selectCombat.equals("V")) {
                    if (combatChance < 50) {
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotatlDamage());
                        afterHit();
                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println();
                            System.out.println("Canavar Size Vurdu!");
                            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealthy(this.getPlayer().getHealthy() - obstacleDamage);
                            afterHit();
                        }
                    }
                } else {
                    if (this.getObstacle().getHealth() > 0) {
                        System.out.println();
                        System.out.println(this.getObstacle().getName() + "Hasar : !");
                        int enemyDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (enemyDamage < 0) {
                            enemyDamage = 0;
                        }
                        this.getPlayer().setHealthy(this.getPlayer().getHealthy() - enemyDamage);
                        afterHit();
                    }
                    System.out.println("Your Hit!");
                    this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotatlDamage());
                    afterHit();
                }
            }
            if (this.getObstacle().getHealth() < this.getPlayer().getHealthy()) {
                System.out.println("Düşmanı yendiniz!");
                System.out.println(this.getObstacle().getAward() +"Para Kazandınız!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Güncel Paranız: "+ this.getPlayer().getMoney());
            } else {
                return false;
            }
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Canınız:" +this.getPlayer().getHealthy());
        System.out.println(this.getObstacle().getName() + " Canı " + this.getObstacle().getHealth());
        System.out.println();
    }

    public void playerStats() {
        System.out.println("Oyuncu Değerleri");
        System.out.println("Sağlık:" + this.getPlayer().getHealthy() +
                " Silah:" + this.getPlayer().getInventory().getWeapon().getName()+
                " Zırh:" + this.getPlayer().getInventory().getArmor().getName()+
                " Bloklama:" + this.getPlayer().getInventory().getArmor().getBlock()+
                " Hasar:" + this.getPlayer().getTotatlDamage()+
                " Para:" + this.getPlayer().getMoney());
    }

    public void obstacleStats(int i) {
        System.out.println(i +"." +this.getObstacle().getName() + " Değerleri");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Sağlık:" + this.getObstacle().getHealth());
        System.out.println("Hasar:" + this.getObstacle().getDamage());
        System.out.println("Ödül:" + this.getObstacle().getAward());

    }

    public int snakeDamage() {
        Random r =new Random();
        return r.nextInt(3) + 3;
    }
    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public int chance() {
        Random r = new Random();
        return r.nextInt(100);
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public void combat(){

    }
}
