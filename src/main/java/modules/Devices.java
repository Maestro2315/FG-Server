package modules;

public class Devices {
    String name;
    int attack;
    int defence;

    /**
     * Конструктор предметов
     */
    public Devices(String name, int attack, int defence) {
        this.name = name;
        this.attack = attack;
        this.defence = defence;
    }

    public Devices() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public float getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }
}