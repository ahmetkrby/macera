package Item;

public class Weapon {
    String name;
    int id;
    int damage;
    int price;

    public Weapon(String name, int id, int damage, int price) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    public static Weapon[] weapons() {
        Weapon[] weapons = new Weapon[3];
        weapons[0] = new Weapon("Tabanca", 1, 2,5);
        weapons[1] = new Weapon("Kılıç", 2, 3,6);
        weapons[2] = new Weapon("Tüfek", 3, 4,7);

        return weapons;
    }

    public static Weapon getWeaponById(int id) {
        for (Weapon w : Weapon.weapons()) {
            if (w.getId() == id) {
                return w;
            }
        }
        return null;
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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
