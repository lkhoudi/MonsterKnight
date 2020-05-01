package fightors;

import junit.extensions.ActiveTestSuite;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MonsterTest extends TestCase {
    private Knight francois;
    private Knight zamzam;
    private Monster dragon;
    private Monster goblin;
    private Monster manticore;

    /**
     * Met en place les engagements.
     *
     * Méthode appelée avant chaque appel de méthode de test.
     */
    @Before
    public void setUp() // throws java.lang.Exception
    {
        this.francois = new Knight("François");
        this.zamzam = new Knight("Zamzam");
        this.dragon =  new Monster(this.francois);
        this.goblin =  new Monster(this.francois);
        this.manticore =  new Monster(this.zamzam);
    }

    /**
     * Supprime les engagements
     *
     * Méthode appelée après chaque appel de méthode de test.
     */
    @After
    public void tearDown() // throws java.lang.Exception
    {
        //Libérez ici les ressources engagées par setUp()
    }

    @Test
    public void testAttacked(){
        int nbVie = dragon.attacked(2);
        assertEquals(8, nbVie);
    }

    @Test
    public void testAttackingDeadMonster(){
        Monster deadMonster = new Monster(this.francois);
        deadMonster.setHealth(0);
        try {
            this.francois.attackMonster(5, deadMonster);
        }catch(Exception exp){
            assert(exp.getMessage().contains("It's forbidden to hit a dead monster !"));
            assert(exp.getClass().equals(IllegalStateException.class));
        }
    }

    @Test
    public void testAttackedWithTooHighDamage(){
        try {
            this.francois.attackMonster(this.dragon.getHealth() + 3, this.dragon);
        }catch(Exception exp){
            assert(exp.getMessage().contains("Damage must be less then " + this.dragon.getHealth()));
            assert(exp.getClass().equals(IllegalArgumentException.class));
        }
    }

    @Test
    public void testAttackedWithNegativeHighDamage(){
        try {
            this.francois.attackMonster(-2, this.dragon);
        }catch(Exception exp){
            assert(exp.getMessage().contains("Damage must be positive"));
            assert(exp.getClass().equals(IllegalArgumentException.class));
        }
    }

    @Test
    public void testAttackMonster()
    {
        this.francois.attackMonster(2, dragon);
        this.francois.attackMonster(5, goblin);
        assertEquals(8, this.dragon.getHealth());
        assertEquals(5, this.goblin.getHealth());
        Set<Monster> expectedMonsters = new HashSet<Monster>();
        expectedMonsters.add(this.dragon);
        expectedMonsters.add(this.goblin);
        assertEquals(this.francois.getMonsters(), expectedMonsters);
    }

    @Test
    public void testAttackWrongMonster()
    {
        try {
            this.francois.attackMonster(2, manticore);
        }catch(Exception exp){
            assert(exp.getMessage().contains("The monster cannot be attacked by this knight " + francois));
            assert(exp.getClass().equals(IllegalStateException.class));
        }
    }



    public static junit.framework.Test suite() {
        TestSuite suite = new ActiveTestSuite();
        suite.addTest(new TestSuite(MonsterTest.class));
        return suite;
}

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }
}
