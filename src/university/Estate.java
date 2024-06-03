package university;

import facilities.Facility;
import facilities.buildings.Building;
import facilities.buildings.Gym;
import facilities.buildings.Hall;
import facilities.buildings.Lab;
import facilities.buildings.Shop;
import facilities.buildings.Theatre;
import java.util.ArrayList;

public class Estate {

  private final ArrayList<Facility> facilities;


  public Estate() {
    facilities = new ArrayList<Facility>();
  } // Constructor initialises ArrayList of facilities

  public Facility[] getFacilities() { // Returns array containing facilities built

    Facility[] facility_array = new Facility[facilities.size()]; // Creating local array of facilities with size equivalent to facilities. This is where the Facility objects are stored.

    int i = 0;

    for (Facility f : facilities){ // for loop to add all facilities to facility_array
      facility_array[i] = f;
      i++;
    }
    return facility_array;
  }

  public Facility addFacility(String type, String name) { // Adds facility to ArrayList facilities
    switch (type) { // Switch-case statement dictates which facility is built
      case "Hall": {
        Hall newFacility = new Hall(name);
        facilities.add(newFacility);
        return newFacility;
      }
      case "Lab": {
        Lab newFacility = new Lab(name);
        facilities.add(newFacility);
        return newFacility;
      }
      case "Theatre": {
        Theatre newFacility = new Theatre(name);
        facilities.add(newFacility);
        return newFacility;
      }
      case "Shop": {
        Shop newFacility = new Shop(name);
        facilities.add(newFacility);
        return newFacility;
      }
      case "Gym": {
        Gym newFacility = new Gym(name);
        facilities.add(newFacility);
        return newFacility;
      }
      default: {
        return null;
      }
    }
  }

  public float getMaintenanceCost() { // Returns maintenance cost for all the buildings
    float maintenance_cost = 0; // local variable to keep count of total maintenance cost

    for (Facility f : facilities) { // for loop adds up maintenance cost for each building
      if (f instanceof Hall) {
        maintenance_cost += (float) (0.1 * ((Hall) f).getCapacity());
      } else if (f instanceof Lab) {
        maintenance_cost += (float) (0.1 * ((Lab) f).getCapacity());
      } else if (f instanceof Theatre) {
        maintenance_cost += (float) (0.1 * ((Theatre) f).getCapacity());
      } else if (f instanceof Shop) {
        maintenance_cost += (float) (0.1 * ((Shop) f).getCapacity());
      } else if (f instanceof Gym) {
        maintenance_cost += (float) (0.1 * ((Gym) f).getCapacity());
      }
    }
    return maintenance_cost;
  }

  public int getNumberOfStudents() { // Returns number of students

    int hall_cap = 0, lab_cap = 0, theatre_cap = 0;
    for (Facility f : facilities) { // for loop increases local variables to find the total capacity of each kinf od building
      if (f instanceof Hall) {
        hall_cap += ((Hall) f).getCapacity();
      } else if (f instanceof Lab) {
        lab_cap += ((Lab) f).getCapacity();
      } else if (f instanceof Theatre) {
        theatre_cap += ((Theatre) f).getCapacity();
      }
    }
    return Math.min(theatre_cap, Math.min(hall_cap, lab_cap));
    /* Returns number of students defined as 'the minimal of the total capacity of the halls, the total capacity of the labs, and the total capacity of the theatres' */
  }
  public int demolishFacilities(){ // Demolishes facility if age exceeds 15
    for (Facility f : getFacilities()){
      if (f.getAge() > 15){
        facilities.remove(f);
        return 20;
      }
      else if (f.getAge() > Math.random() * 15 + 14){ // Random chance of facility being damaged and not viable for use
        facilities.remove(f);
        return 20;
      }
    }
    return 0;
  }
}

