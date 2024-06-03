package university;

import facilities.Facility;
import facilities.buildings.Building;
import java.util.Iterator;

public class University {

  private float budget;
  private final Estate estate;
  private int reputation;
  private final HumanResource humanResource;

  public University(int funding) {
    estate = new Estate();
    humanResource = new HumanResource();
    budget = funding;
  }

  public Facility build(String type,
      String name) { // Builds a facility and returns the facility. Deducts relevant amount from budget and increments reputation by 100.
    switch (type) {
      case "Hall": {
        budget -= 100;
        reputation += 100;
        return estate.addFacility("Hall", name);
      }
      case "Lab": {
        budget -= 300;
        reputation += 100;
        return estate.addFacility("Lab", name);
      }
      case "Theatre": {
        budget -= 200;
        reputation += 100;
        return estate.addFacility("Theatre", name);
      }
      case "Shop": {
        budget -= 80;
        reputation += 100;
        return estate.addFacility("Shop", name);
      }
      case "Gym": {
        budget -= 100;
        reputation += 100;
        return estate.addFacility("Gym", name);
      }
      default: {
        return null;
      }
    }
  }

  public void upgrade(Building building) throws Exception { // Upgrades building level

    if (building.getMaxLevel()
        == building.getLevel()) { // Throws exception when attempting to upgrade a building which is already at maximum level
      throw new Exception("Building is already at max level");
    }
    int i = 0;

    for (Facility f : estate.getFacilities()) { // Throws exception if building not found in facilities in estate.
      if (!(estate.getFacilities()[i] == building)) {
        throw new Exception("Building does not exist");
      }
      i++;

    }

    budget -= building.getUpgradeCost(); // Decreases budget by amount required to upgrade building
    building.increaseLevel(); // If no exceptions are thrown building is upgraded
    reputation += 50; // Reputation incremented by 50
  }

  public float getBudget() {
    return budget;
  } // Returns budget

  public void decreaseBudget(float expense) {
    budget -= expense;
  } // Decreases budget

  public void increaseBudget(float gain) {
    budget += gain;
  } // Increases budget

  public void decreaseReputation(int rep) {
    reputation -= rep;
  } // Decreases reputation

  public void increaseReputation(int rep) {
    reputation += rep;
  } // Increases reputation

  public int getReputation() {
    return reputation;
  } // Returns reputation

  public int getNumberOfStudents() {
    return estate.getNumberOfStudents();
  } // Returns number of students

  public float getMaintenanceCost() {
    return estate.getMaintenanceCost();
  } // Returns maintenance cost

  public float getTotalSalary() {
    return humanResource.getTotalSalary();
  } // Returns total salary for staff

  public void addStaff(Staff staff) {
    humanResource.addStaff(staff);
  } // Adds staff to staffSalary

  public Iterator<Staff> getStaff() {
    return humanResource.getStaff();
  } // Returns an iterator for the keyset of staffSalary

  public void leaveUniversity() {
    humanResource.leaveUniversity();
  } // Runs whether staff members will leave the university

  public Facility[] getFacilities() {
    return estate.getFacilities();
    // Returns array of facilities
  }

  public void limit() throws Exception { // Throws exception when budget is negative
    if (getBudget() < 0) {
      throw new Exception("Budget cannot be negative");
    }
  }
  public int demolishFacilities(){ //Deducts 50 from reputation ande demolishes facility
    return estate.demolishFacilities();
  }
  public int[] renovate(Facility facility){ // Decreases facility age by 6
    return facility.renovate();
  }
}
