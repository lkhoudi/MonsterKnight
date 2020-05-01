#Author: your.email@your.domain.com
@tag
Feature: US_001

  As a Player
  I want my knight to be able to attack a monster
  So that the monster looses health points

  Scenario Outline: Attacking monster
    Given the damage <damage> caused to the monster and a monster including a name <name> and health <initialHealth>
    When  the knight attacks the monster
    Then  the number of the monster's health points <new_health> will be calculated automatically
    Examples:
    | name     | initialHealth | damage | new_health |
    | "dragon" | 8             | 3      | 5          |
    | "goblin" | 5             | 4      | 1          |

  Scenario Outline: Forbidding attacking dead monsters
    Given the damage <damage> caused to the monster and a monster including a name <name> and health <initialHealth>
    When  the knight attacks the monster
    Then  the system refuses with <messageError>
    Examples:
      | name     | initialHealth  | damage | messageError                            |
      | "dragon" | 0              | 2      | "It's forbidden to hit a dead monster !"|

  Scenario Outline: Forbidding attacking monster with too high damage
    Given the damage <damage> caused to the monster and a monster including a name <name> and health <initialHealth>
    When  the knight attacks the monster
    Then  the system refuses with <messageError>
    Examples:
      | name     | initialHealth  | damage |  messageError                |
      | "dragon" | 5              | 10     | "Damage must be less then 5" |
      | "goblin" | 3              | 4      | "Damage must be less then 3" |

  Scenario Outline: Forbidding attacking dead monsters with negative damage
    Given the damage <damage> caused to the monster and a monster including a name <name> and health <initialHealth>
    When  the knight attacks the monster
    Then  the system refuses with <messageError>
    Examples:
      | name     | initialHealth  | damage | messageError              |
      | "dragon" |      10        |   0    | "Damage must be positive" |
