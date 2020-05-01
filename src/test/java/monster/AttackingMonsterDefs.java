package monster;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fightors.Knight;
import fightors.Monster;
import org.junit.Assert;

public class AttackingMonsterDefs {

    private Knight knight = new Knight("Zam");
    private Monster monster = new Monster(knight);
    private Monster anotherMonster = new Monster(knight);
    private String messageError;
    private int damage;
    private int anotherDamage;

    @Given("^the damage (\\d+) caused to the monster and a monster including a name \"([^\"]*)\" and health (\\d+)$")
    public void the_damage_caused_to_the_monster_and_a_monster_including_a_name_and_health(int arg1, String arg2, int arg3) throws Throwable {
        this.monster.setName(arg2);
        this.monster.setHealth(arg3);
        this.damage = arg1;
        Assert.assertNotNull(this.monster);
    }

    @When("^the knight attacks the monster$")
    public void the_knight_attacks_the_monster(){
        try {
            this.knight.attackMonster(this.damage, this.monster);
            Assert.assertNotNull(this.monster);
        } catch (IllegalArgumentException e) {
            this.messageError = e.getMessage();
        }
    }

    @Then("^the number of the monster's health points (\\d+) will be calculated automatically$")
    public void the_number_of_the_monster_s_health_points_will_be_calculated_automatically(int arg1) throws Throwable {
        Assert.assertEquals(this.monster.getHealth(), arg1);
    }

    @Then("^the system refuses with \"([^\"]*)\"$")
    public void the_system_refuses_with(String arg1) throws Throwable {
    	Assert.assertEquals(arg1, this.messageError);
    }


    @Given("^another damage (\\d+) and another monster including a name \"([^\"]*)\" and health (\\d+)$")
    public void another_damage_and_another_monster_including_a_name_and_health(int arg1, String arg2, int arg3) throws Throwable {
        this.anotherMonster.setName(arg2);
        this.anotherMonster.setHealth(arg3);
        this.anotherDamage = arg1;
        Assert.assertNotNull(this.anotherMonster);
    }

    @When("^the knight attacks the another monster$")
    public void the_knight_attacks_the_another_monster() throws Throwable {
        try {
            this.knight.attackMonster(this.anotherDamage, this.anotherMonster);
            Assert.assertNotNull(this.monster);
        } catch (IllegalArgumentException e) {
            this.messageError = e.getMessage();
        }
    }

    @Then("^the list \"([^\"]*)\" is updated$")
    public void the_list_is_updated(String arg1) throws Throwable {
        String[] arrOfStr =  arg1.split(",");
        Assert.assertEquals(arrOfStr.length, this.knight.getMonsters().size());
    }

}
