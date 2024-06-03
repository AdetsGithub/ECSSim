import facilities.Facility;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import university.Staff;
import university.University;

public class EcsSim {

  private static PrintStream print_stream;
  private static ArrayList<Staff> staffMarket;
  private static University uni;

  public static void main(String[] args) throws Exception {

    FileReader fr = new FileReader(args[0]);
    staffMarket = fr.getStaff();

    uni = new University(Integer.parseInt(args[1]));

    simulate(Integer.parseInt(args[2]));
  }

  public static void simulate() throws Exception { // Simulates one year

    uni = new University(2000);
    staffMarket = new ArrayList<Staff>();
    // Initialises University and staffMarket for simulation.

    Staff brad = new Staff("a", 20);
    staffMarket.add(brad);

    Staff ryan = new Staff("b", 50);
    staffMarket.add(ryan);

    Staff dave = new Staff("c", 20);
    staffMarket.add(dave);

    Staff daniel = new Staff("d", 50);
    staffMarket.add(daniel);

    Staff elija = new Staff("e", 20);
    staffMarket.add(elija);

    Staff frank = new Staff("f", 50);
    staffMarket.add(frank);

    Staff grace = new Staff("a", 20);
    staffMarket.add(grace);

    Staff hannah = new Staff("b", 50);
    staffMarket.add(hannah);

    Staff india = new Staff("c", 20);
    staffMarket.add(india);

    Staff janice = new Staff("d", 50);
    staffMarket.add(janice);

    Staff kevin = new Staff("e", 20);
    staffMarket.add(kevin);

    Staff lottie = new Staff("f", 50);
    staffMarket.add(lottie);

    Staff marvin = new Staff("a", 20);
    staffMarket.add(marvin);

    Staff nick = new Staff("b", 50);
    staffMarket.add(nick);

    Staff olivia = new Staff("c", 20);
    staffMarket.add(olivia);

    Staff peach = new Staff("d", 50);
    staffMarket.add(peach);

    Staff quan = new Staff("e", 20);
    staffMarket.add(quan);

    Staff ray = new Staff("f", 50);
    staffMarket.add(ray);

    Staff sophie = new Staff("a", 20);
    staffMarket.add(sophie);

    Staff tyrell = new Staff("b", 50);
    staffMarket.add(tyrell);

    Staff uraraka = new Staff("c", 20);
    staffMarket.add(uraraka);

    Staff vega = new Staff("d", 50);
    staffMarket.add(vega);

    Staff winston = new Staff("e", 20);
    staffMarket.add(winston);

    Staff xavier = new Staff("f", 50);
    staffMarket.add(xavier);

    // Adding staff to staffMarket to be hired for simulation

    int check = 0;

    while (uni.getBudget()
        > 600) { // while loop builds hall, lab and theatre whilst budget is greater than 600
      uni.build("Hall", "hallbuild");
      uni.build("Lab", "labbuild");
      uni.build("Theatre", "theatrebuild");
      check++;
    }

    uni.increaseBudget(
        uni.getNumberOfStudents() * 10); // Increases budget for number of students in university

    for (int k = 0; k < check / 2;
        k++) { // Adds staff from staffMarket and removes them  from staffMarket afterward
      uni.addStaff(staffMarket.get(0));
      staffMarket.remove(staffMarket.get(0));
    }

    int students_taught = 0;

    Iterator<Staff> it = uni.getStaff();

    while (it.hasNext()) { // while loop checks how many students each staff can teach and assigns them either all the students or there maximum number
      Staff s = it.next();
      if (80 + 4 * s.getSkill() < uni.getNumberOfStudents()) {
        uni.increaseReputation(s.instruct(80 + 4 * s.getSkill()));
        students_taught += 80 + 4
            * s.getSkill(); // This number is chosen as it uses 20 stamina which can be replenished completely at the end of the year. This decreases chance of losing staff by chance
      } else {
        s.instruct(uni.getNumberOfStudents());
        uni.increaseReputation(
            students_taught += uni.getNumberOfStudents()); // Maximum number of students that can be taught is the total students
      }
    }

    uni.decreaseBudget(uni.getMaintenanceCost()); // Deduct cost of maintenance from budget

    uni.decreaseBudget(uni.getTotalSalary()); // Deduct staff pay from budget

    while (it.hasNext()) { // Increases years of teaching by 1
      Staff s = it.next();
      s.increaseYearsOfTeaching();
    }

    if (students_taught
        < uni.getNumberOfStudents()) { // Checks if any students were not taught and decreases reputation accordingly
      uni.decreaseReputation(uni.getNumberOfStudents() - students_taught);
    }

    uni.leaveUniversity(); // Checks to see if any staff will leave the university

    while (it.hasNext()) { // Replenishes all staff stamina
      Staff s = it.next();
      s.replenishStamina();

    }

    uni.limit(); // Ensures budget is not negative
  }

  public static void simulate(int years) throws Exception {

    int count = 0;

    while (count < years) { // while loop runs until desired simulation time

      int j = 0;

      if (uni.getFacilities().length == 0){
        uni.build("Hall", "Wessex");
      }

      while (uni.getBudget() > 1000) { // Builds hall, lab, theatre, shop and gym whilst budget greater than 1000. 1000 chosen through experimentation
        uni.build("Hall", "Wessex");
        uni.build("Lab", "Zepler");
        uni.build("Theatre", "Mayflower");
        uni.build("Gym", "Jubilee");
        uni.build("Shop", "Nisa Local");
        j++;
      }

      uni.increaseBudget(uni.getNumberOfStudents() * 10); // Increase budget for number of students
      try { // try-catch  statement adds staff to staffMarket and removes the staff
        for (int k = 0; k < j; k++) {
          uni.addStaff(staffMarket.get(0));
          staffMarket.remove(staffMarket.get(0));
        }
      } catch (
          IndexOutOfBoundsException e) { //If no staff remaining in staffMarket, exception thrown
        throw new Exception("No more staff remaining");
      }

      int students_taught = 0;

      Iterator<Staff> it = uni.getStaff();

      while (it.hasNext()) { // while loop calculates number of students taught per year
        Staff s = it.next();
        if (80 + 4 * s.getSkill() < uni.getNumberOfStudents()) {
          uni.increaseReputation(s.instruct(80 + 4
              * s.getSkill())); // This number is chosen as it uses 20 stamina which can be replenished completely at the end of the year. This decreases chance of losing staff by chance
          students_taught += 80 + 4 * s.getSkill();
        } else {
          s.instruct(
              uni.getNumberOfStudents()); // Maximum number of students that can be taught is the total students
          uni.increaseReputation(students_taught += uni.getNumberOfStudents());
        }
      }

      uni.decreaseBudget(uni.getMaintenanceCost()); // Deducts maintenance cost from budget

      uni.decreaseBudget(uni.getTotalSalary()); //Deducts staff pay from budget

      if (uni.getBudget() > 300) { // Renovates facility if budget greater than 300 and age of facility great than 13
        for (Facility f : uni.getFacilities()) {
          if (f.getAge() > 13) {
            int[] res = f.renovate();
            uni.decreaseBudget(res[0]);
            uni.increaseReputation(res[1]);
          }
        }
      }

      uni.limit(); // Tests to see whether budget is negative

      while (it.hasNext()) { // Increases years of teaching for all staff
        Staff s = it.next();
        s.increaseYearsOfTeaching();
      }

      if (students_taught < uni.getNumberOfStudents()) { // Decreases reputation for untaught students
        uni.decreaseReputation(uni.getNumberOfStudents() - students_taught);
      }

      for (Facility f : uni.getFacilities()) { // Increases age of all buildings
        f.increaseAge();
      }

      uni.leaveUniversity(); // Method dictates whether each staff will leave the university
      uni.decreaseReputation(uni.demolishFacilities()); // Method dictates whether facility will be demolished

      while (it.hasNext()) { // Replenishes staff stamina for all staff
        Staff s = it.next();
        s.replenishStamina();
      }

      count++; // Increments count for the number of years
    }
  }
}
