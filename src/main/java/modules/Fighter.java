package modules;

public class Fighter {
    String name;
    float hp;
    float attackSkill;
    float defenceSkill;

    /**
     * Конструктор бойцов
     * */
    public Fighter(String name, float hp, float attackSkill, float defenceSkill) {
        this.name = name;
        this.hp = hp;
        this.attackSkill = attackSkill;
        this.defenceSkill = defenceSkill;
    }

    public Fighter(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public float getAttackSkill() {
        return attackSkill;
    }

    public void setAttackSkill(float attackSkill) {
        this.attackSkill = attackSkill;
    }

    public float getDefenceSkill() {
        return defenceSkill;
    }

    public void setDefenceSkill(float defenceSkill) {
        this.defenceSkill = defenceSkill;
    }
}
