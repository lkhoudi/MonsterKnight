#Author: your.email@your.domain.com
@tag
Feature: US_002 update monster list attacked
  As a Player
  I want my monsters list to be updated
  So that I can see attacked monsters list

  Scenario Outline: List of monsters attacked
    Given the damage <damage> caused to the monster and a monster including a name <name> and health <initialHealth>
    And another damage <damage2> and another monster including a name <name2> and health <initialHealth2>
    When  the knight attacks the monster
    And the knight attacks the another monster
    Then  the list <list> is updated
    Examples:
      | name      | initialHealth  | damage  | name2         | initialHealth2    | damage2 |   list                 |
      | "dragon"  | 8              | 3       | "gobelin"     |     6             |  1      |   "dragon,gobelin"     |
