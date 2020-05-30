package fightors;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class AdapterTest {

    @Test
    public void testAdapter(){
        OlympianGod zeus = new OlympianGod("Zeus", "Dieu des dieux");
        Knight knight = new Knight("Zam");
        Monster monster = new Monster(knight);
        Adapter adapter = new Adapter(knight.getName(), knight);
        zeus.order(adapter, monster);
        adapter.doOrder(monster);
        assertEquals(0, monster.getHealth());
        Set<Monster> expectedMonsters = new HashSet<Monster>();
        expectedMonsters.add(monster);
        assertEquals(knight.getMonsters(), expectedMonsters);
    }

}
