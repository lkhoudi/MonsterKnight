package fightors;

import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ MonsterTest.class })
public class AllTest {
    public static junit.framework.Test suite() {
        TestSuite suite= new TestSuite();
        suite.addTest(
                new MonsterTest() {
                    protected void runTest() { testAttacked(); }
                }
        );
        suite.addTest(
                new MonsterTest() {
                    protected void runTest() { testAttackMonster(); }
                }
        );
        suite.addTest(
                new MonsterTest() {
                    protected void runTest() { testAttackWrongMonster(); }
                }
        );
        return suite;
    }
}


