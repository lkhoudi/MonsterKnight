package monster;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fightors.*;
import org.junit.Assert;

public class US_DP_Mythology_01 {

    private OlympianGod god;
    private Adapter adapter;
    private Monster monster;

    @Given("^a god \"([^\"]*)\" \"([^\"]*)\"$")
    public void aGod(String godName, String godAlias) {
        this.god = new OlympianGod(godName, godAlias);
    }

    @And("^a legendary human \"([^\"]*)\"$")
    public void aLegendaryHuman(String humanName) {
        Knight knight = new Knight(humanName);
        this.adapter = new Adapter(humanName, knight);
    }

    @And("^a monster \"([^\"]*)\"$")
    public void aMonster(String monsterName) {
        this.monster = new Monster(monsterName, this.adapter.getKnight());
    }

    @And("^Hades starts observing Zam the legendary$")
    public void hadesStartsObservingZamTheLegendary() {
        this.god.addKnight(this.adapter.getKnight());
    }

    @When("^Hades orders Zam the legendary to attack Tebonus$")
    public void hadesOrdersZamTheLegendaryToAttackTebonus() {
        god.order(this.adapter, this.monster);
        Assert.assertTrue(this.adapter.isOrdered());
    }

    @Then("^Zam the legendary attacks Tebonus$")
    public void zamTheLegendaryAttacksTebonus() {
        this.adapter.doOrder(this.monster);
        Assert.assertEquals(0, this.monster.getHealth());
    }

    @And("^Hades observers the attack of Zam the legendary$")
    public void hadesObserversTheAttackOfZamTheLegendary() {
        Assert.assertEquals(this.god.getLogs().get(0),
                "Le chevalier "+this.adapter.getKnight().getName()+" a occis le monstre"+this.monster.getName());
    }
}
