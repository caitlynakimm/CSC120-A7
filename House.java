/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building {
  
  private ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;
  
  public House(boolean hasDiningRoom) {
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    System.out.println("You have built a house: 🏠");
  }

  public boolean hasDiningRoom(){

  }
  
  public int nResidents(){

  }

  public static void main(String[] args) {
    new House();
  }

}