package Monsters;

public class Obstacle {
    private String name;
    private int id;
    private int health;
    private int originalHealth;
    private int damage;
    private int award;

    public Obstacle(String name, int id, int health, int damage, int award) {
        this.name = name;
        this.id = id;
        this.health = health;
        this.damage = damage;
        this.award = award;
        this.originalHealth = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
