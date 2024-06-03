package university;

public class Staff {

  private int skill, yearsOfTeaching = 0, stamina = 100;
  private String name;

  public Staff(String name, int skill) {
    this.name = name;
    this.skill = skill;

  }

  public String getName(){
    return name;
  } // Returns name
  public int instruct(int numberOfStudents) { // Instructs student (to study). Returns a reputation value which must be added to University reputation.
    int reputation = (100 * skill) / (100 + numberOfStudents); // Calculation for reputation
    if (skill < 100) { // if statement increments staff's skill by 1 for each instruct.
      skill += 1;
    }

    stamina -= (int) (Math.ceil((double) numberOfStudents / (20 + skill)) * 20); // Decrease in stamina calculation

    return reputation;
  }

  public void replenishStamina() { // Increases stamina by 20 whilst less than or equal to 80. Replenishes stamina to max (100) when stamina greater than 80
    if (stamina < 81) {
      stamina += 20;
    } else {
      stamina = 100;
    }
  }

  public void increaseYearsOfTeaching() {
    yearsOfTeaching += 1;
  } // Increases staff's years of teaching by 1

  public int getSkill() {
    return skill;
  } // Returns skill of staff
  public int getYearsOfTeaching(){
    return yearsOfTeaching;
  } // Returns number of years staff has been teaching

  public int getStamina() {
    return stamina;
  } // Returns stamin of staff
}
