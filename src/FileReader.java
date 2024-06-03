import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import university.Staff;

public class FileReader {
  BufferedReader myReader;
  ArrayList<Staff> staffMarket;
  public FileReader(String filename) throws Exception { // If file is not found in directory, exception is thrown
    try {
      myReader = new BufferedReader(new java.io.FileReader(filename));
    } catch (FileNotFoundException e) {
      throw new Exception("File not found in directory");
    }
  }

  public Boolean fileIsReady() throws Exception { // Returns whether the file is ready to be read as a Bool
    try {
      if (myReader != null) {
        return myReader.ready();
      }
    }
    catch (IOException e) {
      throw new Exception("File is not ready");
    }
    return false;
  }
  public String getLine() throws Exception{ // Returns a line of a .txt file
    try{
      return myReader.readLine();
    }
    catch (IOException e){
      throw new Exception("Could not read line");
    }
  }
  public ArrayList<Staff> getStaff() throws Exception { // Returns an ArrayList containing staff from a .txt file

    staffMarket = new ArrayList<Staff>();

    while (true){
      String line = this.getLine();

      if (line == null){
        break;
      }
      String name = line.substring(0, line.indexOf("(") - 1);
      String skill_string = line.substring(line.indexOf("(") + 1, line.indexOf(")"));
      int skill = Integer.parseInt(skill_string);

      Staff newStaff = new Staff(name, skill);

      staffMarket.add(newStaff);
    }
    return staffMarket;
  }
}
