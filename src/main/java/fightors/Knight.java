package fightors;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Knight
{

    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private Set<Monster> monsters;
    private String name;

    /**
     * Constructeur d'objets de classe Knight
     * @param name
     */
    public Knight(String name)
    {
        this.name = name;
        // initialisation des variables d'instance
        this.monsters = new HashSet<Monster>();

    }

    public Set<Monster> getMonsters(){
        return this.monsters;
    }

    public void setMonsters(Set<Monster> monsters){
        this.monsters = monsters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Met à jour le nouveau set de monstres que le chevalier a attaqué
     *
     * @param  damage le nombre vie que le monstre va perdre
     * @return  nombre de vie restantes
     */
    public Set<Monster> attackMonster(int damage, Monster monster)
    {
        if(!monster.getKnight().equals(this)){
            throw new IllegalStateException("The monster cannot be attacked by this knight " + this );
        }
        else{
            monster.attacked(damage);
            fillMonsterSet(monster);
            return this.monsters;
        }
    }

    private void fillMonsterSet(Monster monster) {
        this.monsters.add(monster);
    }

    @Override
    public String toString() {
        return "Knight{" +
                "monsters=" + monsters +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Knight knight = (Knight) o;
        return Objects.equals(monsters, knight.monsters) &&
                Objects.equals(name, knight.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monsters, name);
    }
}
