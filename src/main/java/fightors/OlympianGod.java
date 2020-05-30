package fightors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class OlympianGod extends Observer {

    private boolean mortality;
    private String name;
    private String alias;
    private Human human;
    private List<String> logs;

    /**
     * Constructor 1
     * @param name : the god's name
     * @param alias : the god's alias in the mythology
     */
    public OlympianGod(String name,String alias){
        this.name = name;
        this.mortality = false;
        this.alias = alias;
        this.human = null;
        this.setKnights( new HashSet<Knight>() );
        this.logs = new ArrayList<String>();
    }
    /**
     * Constructor 2
     * @param name : the god's name
     * @param mortality : boolean that represents if a god is mortal or not
     * @param alias : the god's alias in the mythology
     */
    public OlympianGod(String name, boolean mortality, String alias) {
        this.name = name;
        this.mortality = mortality;
        this.alias = alias;
        this.human = null;
    }
    /**
     * Constructor 3
     * @param name : the god's name
     * @param mortality : boolean that represents if a god is mortal or not
     * @param alias : the god's alias in the mythology
     * @param human : the human that this god become after his defeat
     */
    public OlympianGod(String name, boolean mortality, String alias, Human human) {
        this.name = name;
        this.mortality = mortality;
        this.alias = alias;
        this.human = human;
    }

    public boolean isHuman() {
        return (this.human == null)? false: true;
    }

    /**
     * Some description
     * @param human
     * @param monster
     * @return
     */
    public String order(Human human, Monster monster){
        human.setOrdered(true);
        return "God " + this.getName() + "has ordered human" + human.getName() + "to attack the monster" + monster.getName();
    }

    @Override
    public void update(Knight attackerKnight, Monster attackedMonster) {
        this.logs.add("Le chevalier "+attackerKnight.getName()+" a occis le monstre"+attackedMonster.getName());
    }

    // getters and setters

    /**
     * mortality getter
     * @return mortality of the god
     */
    public boolean getMortality(){
        return this.mortality;
    }
    /**
     * god's name getter
     * @return god's name
     */
    public String getName(){
        return this.name;
    }
    /**
     * mortality setter
     * @param mortality
     */
    public void setMortality(boolean mortality) {
        this.mortality = mortality;
    }
    /**
     * god's name setter
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * god's alias getter
     * @return god's alias
     */
    public String getAlias() {
        return alias;
    }
    /**
     * god's alias setter
     * @param alias
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }
    /**
     * @return the human that the god become
     */
    public Human getHuman() {
        return human;
    }
    /**
     * @param human :the human to set after god's defeat
     */
    public void setHuman(Human human) {
        this.human = human;
    }
    public List<String> getLogs() {
        return logs;
    }
    public void setLogs(List<String> logs) {
        this.logs = logs;
    }




}


