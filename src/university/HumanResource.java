package university;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class HumanResource {

  private ConcurrentHashMap<Staff, Float> staffSalary;

  public HumanResource() {
    staffSalary = new ConcurrentHashMap<Staff, Float>();
  } // ConcurrentHashMap used over HashMap. Though HashMaps performance is higher as threads can perform simultaneously, ConcurrentHashMap was chosen due to its greater thread-safety

  public void addStaff(Staff staff) { // Adds staff to StaffSalary HashMap
    staffSalary.put(staff, (float) (staff.getSkill() * (Math.random() * 0.01 + 0.095)));
  }

  public Iterator<Staff> getStaff() {
    return staffSalary.keySet().iterator();
  } // Returns iterator over the staff in staffSalary

  public float getTotalSalary() { // Returns total salary paid to all staff
    int total_salary = 0;

    Iterator<Staff> it = getStaff();

    while (it.hasNext()) { // while loop increments local variable by individual staff salaries
      Staff s = it.next();
      total_salary += staffSalary.get(s);
    }

    return total_salary;
  }

  public void leaveUniversity() { // Conditions under which a staff leaves the university

    Iterator<Staff> it = getStaff();

    while (it.hasNext()) {
      Staff s = it.next();
      if (s.getYearsOfTeaching() > 30) { // Staff leaves after 30 years of teaching
        staffSalary.remove(s);
      } else if (s.getStamina() < (Math.random() * 100)) { // Random chance of staff leaving before 30 years. Simulated by a random integer between 0 and 100 being greater than the staff's stamina
        staffSalary.remove(s);
      }
    }
  }
}
