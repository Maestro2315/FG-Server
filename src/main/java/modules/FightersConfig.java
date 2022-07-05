package modules;

import java.util.ArrayList;
import java.util.List;

public class FightersConfig implements FightersConfigOption {

    private String name;
    private List<Fighter> fighters;

    /**
     * Конструктор
     */
    public FightersConfig(String name) {
        this.name = name;
        this.fighters = new ArrayList<>();
    }

    public FightersConfig() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Fighter> getFighters() {
        return fighters;
    }

    public void setFighters(List<Fighter> fighters) {
        this.fighters = fighters;
    }

    /**
     * Метод для добавления бойцов в лист
     */
    @Override
    public void addFighter(Fighter fighter) {
        fighters.add(fighter);
    }

}
