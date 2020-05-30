package fightors;

import org.junit.Test;

import static org.junit.Assert.*;

public class KnightTest {

    @Test
    public void notifyAllObservers() {
        Knight knight = new Knight("Zam");
        Monster monster = new Monster(knight);
        knight.attackMonster(10, monster);
        assertEquals(0, monster.getHealth());

        OlympianGod godObserver = new OlympianGod("Hades", "Dieu des enfers");
        godObserver.addKnight(knight);
        knight.notifyAllObservers(monster);

        assertEquals(godObserver.getLogs().get(godObserver.getLogs().size() - 1), "Le chevalier "+knight.getName()+" a occis le monstre"+monster.getName());
    }
}