package facilities.buildings;

public interface Building {

  int getLevel(); //Method to return the level of building

  void increaseLevel(); //Method to increase the level of building

  void setUpgradeCost(); //Method which sets the current upgrade cost using the given formula

  int getUpgradeCost(); // Method to return upgrade cost

  void setCapacity(); // Method to set the capacity of building

  int getMaxLevel(); //Returns maximum level of building

  void setMaxLevel(int max_level); // Sets maximum level

  void setBaseCapacity(int base_capacity); // Sets base capacity of building

  void setBaseBuildingCost(int cost); // Sets cost to build building

  int getCapacity(); // Returns building capacity
}

