/* This is a stub for the Library class */

import java.util.Hashtable;
import java.util.NoSuchElementException;

public class Library extends Building implements LibraryRequirements{
    private Hashtable<String, Boolean> collection;

    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<>();
      System.out.println("You have built a library: 📖");
    }

    public void addTitle(String title){
      this.collection.put(title, true);
      System.out.println(title + "added.");
    }

    public String removeTitle(String title){
      //return the title that we removed
      if (this.collection.containsKey(title)){
        this.collection.remove(title);
        return title;
      }
      throw new NoSuchElementException(title + "not found.");
    }

    public void checkOut(String title){
      if (!this.collection.containsKey(title)){
        //if book doesn't exist in collection
        throw new NoSuchElementException(title + "doesn't exist in collection.");
      }
      if (!this.collection.get(title)){
        //if book is already checked out
        throw new NoSuchElementException(title + "is already checked out.");
      }
      this.collection.replace(title, false); //updating book's availability to checked out
      System.out.println("Successfully checked out " + title + ".");

      }

    public void returnBook(String title){
      if (!this.collection.containsKey(title)){
        //if book doesn't exist in collection
        throw new NoSuchElementException(title + "doesn't exist in collection.");
      }
      if (this.collection.get(title)){
        //if book is already available
        throw new NoSuchElementException(title + "is already available.");
      }
      this.collection.replace(title, true); //updating book to be available after checking in
      System.out.println("Successfully returned " + title + ".");
    }

    public boolean containsTitle(String title){
      return this.collection.containsKey(title);
    }

    public boolean isAvailable(String title){
      // check if title exists first
      if (this.collection.containsKey(title)) {
        // return title's availability (true/false)
        return this.collection.get(title);
      }
      // if title not found, return false
      return false;
    }

    public void printCollection(){
      System.out.println("\n----Library Collection----");
        for (String title : this.collection.keySet()) {
            String titleStatus = this.collection.get(title) ? "available" : "checked out"; 
            //if title is available (true), "available" assigned to titleStatus, else (false) "checked out" is assigned
            System.out.println("- " + title + " is " + titleStatus);
        }
        System.out.println("---------------------------");
    }
  
    public static void main(String[] args) {
    Library neilson = new Library("Neilson Library", "7 Neilson Drive", 4);
    
    neilson.addTitle("Pachinko");
    neilson.addTitle("The Vegetarian");
    
    neilson.printCollection();
    
    neilson.checkOut("Pachinko");
    neilson.printCollection();
    
    neilson.returnBook("Pachinko");
    neilson.printCollection();
    
    try {
        neilson.checkOut("Sunrise on the Reaping"); // book doesn't exist in collection
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    
    String removedBook = neilson.removeTitle("The Vegetarian");
    System.out.println("\nRemoved book: " + removedBook);
    System.out.println("Final collection:");
    neilson.printCollection();
    }
  
  }