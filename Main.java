//////////////////////////////////////////////////////////////////////////////
//Title:            Drink
//Files:            Main.java, Drink.java, Cart.
//Author:           Ridham Gabani
//////////////////////////////////////////////////////////////////////////////

import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;

public class Main {
  // Use Shopping Cart lab as a sample
  // Create Static variable of your list class
  /**
   * Constructs the ArrayList object 'Cart'
   */
  public static Cart cart = new Cart();
  /**
   * Conditional variable to exit the program when needed by the user
   */
  public static boolean quit = false;

  public static void main(String[] args) {
    while (!quit) {
      dropDownMenu();
    }
  }

  /**
   * Loads the file selected by the user by reading the file's information and
   * using the information to instantiate the ArrayList 'Cart' with multiple Drink
   * objects
   * Shows a message of whether the load was successful or not
   * 
   */
  public static void loadFile() {
    // Declare your Scanner Object for input data/do not instantiate until inside
    // try block
    Scanner input;
    // Create try catch block to catch error
    try {
      // use JFileChooser to select the filename to read from
      JFileChooser chooser = new JFileChooser();
      chooser.requestFocus();
      File infile = null;
      if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        infile = chooser.getSelectedFile();
      }
      // instantiate the Scanner object
      input = new Scanner(infile);
      // loop until no more data
      if ((infile.getName()).equals("drink.dat")) {
        while (input.hasNext()) {
          // read all data for one record
          String company = input.nextLine();
          String name = input.next();
          input.nextLine();
          int quantity = input.nextInt();
          input.nextLine();
          Double price = input.nextDouble();
          input.nextLine();

          // construct an object and call list class add method
          cart.addDrink(company, name, quantity, price);
        }
      }
      JOptionPane.showMessageDialog(null, "File Loaded");

    } catch (IOException e) {
      // print message and include the variable e to tell what happened
      JOptionPane.showMessageDialog(null, "Error: " + e);
    }
  }

  /**
   * Saves the changes made by the user into a new file, giving the user to choose
   * the name and shows a message of whether the save was successful or not
   */
  public static void saveFile() {
    String filename = JOptionPane.showInputDialog("Enter the file name to save to: ");
    try {
      PrintWriter output = new PrintWriter(filename);
      // output.println(cart.saveToFile());
      output.close();
      JOptionPane.showMessageDialog(null, "File has been successfully saved");
    } catch (IOException exception) {
      JOptionPane.showMessageDialog(null, "Information could not be saved");
    }
  }

  /**
   * Creates a drop down menu which gives the user multiple options and guides the
   * user through the menu
   */
  public static void dropDownMenu() {
    String menu = "Drink Data Base\n1. Display\n2. Files\n3. Quit";
    String menuOption = JOptionPane.showInputDialog(menu);
    int choice = Integer.parseInt(menuOption);

    int typeOptions;
    if (choice == 1) {
      menu = ("0. Display list of all drinks\n1. Display drinks in a price range\n2. List by Alphabetical order\n3. Sort by price\n4. Sort by quantity\n5. Calculate total price of all drinks \n6. Find a drink in cart");
      menuOption = JOptionPane.showInputDialog(menu);
      choice = Integer.parseInt(menuOption);
      switch (choice) {
        case 0:
          JOptionPane.showMessageDialog(null, cart);
          break;
        case 1:
          double min = Double.parseDouble(JOptionPane.showInputDialog(null, "Minimum price: "));
          double max = Double.parseDouble(JOptionPane.showInputDialog(null, "Maximum price: "));
          JOptionPane.showMessageDialog(null, cart.partialSortByPrice(min, max));
          break;
        case 2:
          JOptionPane.showMessageDialog(null, cart.sortAlphabetically());
          break;
        case 3:
          JOptionPane.showMessageDialog(null, cart.sortByPrice());
          break;
        case 4:
          JOptionPane.showMessageDialog(null, cart.sortByQuantity());
        case 5:
          JOptionPane.showMessageDialog(null, cart.totalPrice());
          break;
        case 6:
          String company = JOptionPane.showInputDialog(null, "Company: ");
          JOptionPane.showMessageDialog(null, cart.searchDrink(company));

      }
    } else if (choice == 2) {
      menu = ("0. Load file\n1. Save file\n2. Remove drink\n3. Add drink\n4. Edit drink");
      menuOption = JOptionPane.showInputDialog(menu);
      choice = Integer.parseInt(menuOption);
      switch (choice) {
        case 0:
        	loadFile();
        	break;
        case 1:
        	saveFile();
        	break;
        case 2:
        	String de = JOptionPane.showInputDialog(null, "Company: ");
        	JOptionPane.showMessageDialog(null, cart.delete(de));
        	break;
        case 3:
        	String company = JOptionPane.showInputDialog(null, "What is the name of the company? ");
        	String name = JOptionPane.showInputDialog(null, "What is the name of the drink? ");
        	int quantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantity of the drink?"));
        	double price = Double.parseDouble(JOptionPane.showInputDialog(null, "Price of the drink"));
        	try {
        		cart.addDrink(company, name, quantity, price);
        		JOptionPane.showMessageDialog(null, "Drink successfully added");
        	}
        	catch (IOError e) {
				JOptionPane.showMessageDialog(null, "Error: " + e);
			}
        	break;
        case 4:
        	String c = JOptionPane.showInputDialog(null, "What is the name of the company? ");
        	String n = JOptionPane.showInputDialog(null, "What is the name of the drink? ");
        	int newQuantity = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the new quantity of the drink?"));
        	double newPrice = Double.parseDouble(JOptionPane.showInputDialog(null, "What is the new price of the drink?"));
        	cart.edit(c, n, newQuantity, newPrice);
      }

    } else if (choice == 3) {
      quit = true;
    }
  }

}