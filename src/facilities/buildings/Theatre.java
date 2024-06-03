package facilities.buildings;

import facilities.Facility;

public class Theatre extends Facility implements Building {

  private int level = 1, upgrade_cost, capacity, max_level, base_capacity, base_building_cost; // Initialising relevant variables

  public Theatre(String name) {
    super(name);
    setMaxLevel(6);
    setBaseCapacity(10);
    setBaseBuildingCost(200);
    setUpgradeCost();
    setCapacity();
    // Setting variables to relevant values upon instantiation
  }

  public int getLevel() {
    return level;
  }

  public void increaseLevel() {
    level++;
    setUpgradeCost();
    setCapacity();
  }
  public void setUpgradeCost() {
    upgrade_cost = base_building_cost * (level + 1);
  }

  public int getUpgradeCost() {
    if (level == max_level){ // Returns -1 when level has reached max level
      return -1;
    }
    setUpgradeCost();
    return upgrade_cost;
  }
  public void setCapacity() {
    this.capacity = (int) (base_capacity * Math.pow(2, level - 1));
  }

  public int getCapacity() {
    return capacity;
  }
  public int getMaxLevel() {
    return max_level;
  }
  public void setMaxLevel(int max_level) {
    this.max_level = max_level;
  }
  public void setBaseCapacity(int base_capacity) {
    this.base_capacity = base_capacity;
  }
  public void setBaseBuildingCost(int cost) {
    this.base_building_cost = cost;
  }
  /* Methods with no comment/description are detailed in the Building implementation */
}
