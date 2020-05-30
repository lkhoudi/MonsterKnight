package fightors;

import java.util.HashSet;
import java.util.Set;

public abstract class Observer {
    private Set<Knight> knights;

    public Set<Knight> getKnights() {
        return knights;
    }

    public void setKnights(Set<Knight> knights) {
        this.knights = knights;
    }

    public void addKnight(Knight knight) {
        this.knights.add(knight);
        knight.getObservers().add(this);
    }

    /**
     * This function adds in log of the observer god a new event
     * @param attackerKnight
     * @param attackedMonster
     */
    abstract public void update(Knight attackerKnight, Monster attackedMonster);
}
