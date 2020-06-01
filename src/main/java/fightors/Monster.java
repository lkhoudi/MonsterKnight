package fightors;

public class Monster
{
    // variables d'instance
    private int health;
    private String name;
    private Knight knight;

    /**
     * Constructeur d'objets de classe Monster
     * @param
     * @param knight
     */
    public Monster(Knight knight)
    {
        this.knight = knight;
        // initialisation des variables d'instance
        this.health = 10;
        this.name = "monster";
    }

    public Monster(String name, Knight knight){
        this.name = name;
        this.knight = knight;
        // initialisation des variables d'instance
        this.health = 10;
    }

    public int getHealth(){
        return this.health;
    }

    public String getName(){
        return this.name;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public void setName(String name){
        this.name = name;
    }

    public Knight getKnight() {
        return knight;
    }

    public void setKnight(Knight knight) {
        this.knight = knight;
    }

    /***
     *
     * @param damage Le nombre de vie du monstre après avoir attaqué
     * @return le nombre de vie restant
     */
    public int attacked(int damage) throws IllegalArgumentException {
        // Insérez votre code ici
        if(this.health == 0){
            throw new IllegalStateException("It's forbidden to hit a dead monster !");
        }
        else if(damage > this.health){
            throw new IllegalArgumentException("Damage must be less then " + this.health);
        }
        else if (damage <= 0) {
            throw new IllegalArgumentException("Damage must be positive");
        }
        return this.health -= damage;
    }
}
