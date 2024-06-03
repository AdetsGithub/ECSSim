package facilities;

public class Facility {

  private String name;
  private int age = 0;

  public Facility(String name) {
    setName(name);
  }

  public String getName() {
    return name;
  } // returns name of facility

  public void setName(String name) {
    this.name = name;
  } // sets name of facility
  public int getAge(){ // Returns age
    return age;
  }
  public void increaseAge(){ // Increases age
    age++;
  }
  public int[] renovate(){ // Decreases facility age by 6
    if (age < 5){
      age = 0;
    }
    else{
      age -= 6;
    }
    return new int[] {10, 50};
  }
}
