package fightors;

public class Adapter extends Human {

    private Knight knight;

    public Adapter(String name, Knight knight) {
        super(name);
        this.knight = knight;
    }

    public Knight getKnight() {
        return knight;
    }

    public void setKnight(Knight knight) {
        this.knight = knight;
    }

    public void doOrder(Monster monster){
        if(this.isOrdered()){
            this.knight.attackMonster(10, monster);
            this.knight.notifyAllObservers(monster);
        }
    }
}
