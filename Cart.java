//////////////////////////////////////////////////////////////////////////////
//Title:            Drink
//Files:            Main.java, Drink.java, Cart.java
//Author:           Ridham Gabani
//////////////////////////////////////////////////////////////////////////////

import java.time.chrono.MinguoChronology;
import java.util.*;

public class Cart {
  // declare an ArrayList
  /**
   * ArrayList of drink objects of drink
   */
  private ArrayList<Drink> cart;

  // constructors to construct/instantiate the ArrayList
  /**
   * Instantiates the ArrayList
   */
  public Cart() {
    cart = new ArrayList<Drink>();
  }

  /**
   * Adds a drink object to the ArrayList
   * 
   * @param company  the name of the company of drink
   * @param name     the name of the drink
   * @param quantity the quantity of drink
   * @param price    the price of drink
   */
  public void addDrink(String company, String name, int quantity, double price) {
    cart.add(new Drink(company, name, quantity, price));
  }

  /**
   * Sorts the ArrayList into alphabetical order
   * 
   * @return returns the ArrayList in alphabetical order in String format
   */
  public String sortAlphabetically() {
    ArrayList<Drink> cartA = new ArrayList<Drink>();
    cartA.addAll(cart);
    Drink temp;
    boolean sorted = false;
    while (!sorted) {
      sorted = true;
      for (int i = 0; i < cartA.size() - 1; i++) {
        if ((cartA.get(i).compareTo(cartA.get(i + 1)) > 0)) {
          temp = cartA.get(i);
          cartA.set(i, cartA.get(i + 1));
          cartA.set(i + 1, temp);
          sorted = false;
        }
      }
    }
    String list = "";
    for (Drink drink : cartA) {
      list += drink + " ";
    }
    return list;
  }

  /**
   * Sorts the ArrayList by descending prices
   * 
   * @return returns string format of descending prices
   */
  public String sortByPrice() {
    ArrayList<Drink> cartB = new ArrayList<Drink>();
    cartB.addAll(cart);
    Drink temp;
    boolean sorted = false;
    while (!sorted) {
      sorted = true;
      for (int i = 0; i < cartB.size() - 1; i++) {
        if (cartB.get(i).getPrice() < cartB.get(i + 1).getPrice()) {
          temp = cartB.get(i);
          cartB.set(i, cartB.get(i + 1));
          cartB.set(i + 1, temp);
          sorted = false;
        }
      }
    }
    String list = "";
    for (Drink drink : cartB) {
      list += drink + " ";
    }
    return list;
  }

  /**
   * Displays all drinks within the given price range
   * 
   * @param min the minimum price
   * @param max the maximum price
   * @return returns all drink names within the given price range
   */
  public String partialSortByPrice(double min, double max) {
    ArrayList<Drink> cartC = new ArrayList<Drink>();
    cartC.addAll(cart);
    String list = "";
    for (Drink drink : cart) {
      if (min <= drink.getPrice() && drink.getPrice() <= max) {
        list += drink + " ";
      }
    }
    return list;
  }
  
  /**
   * Sorts by quantity
   * @return returns ArrayList in descending order of quantity 
   */
  public String sortByQuantity() {
	  ArrayList<Drink> cartD = new ArrayList<Drink>();
	  cartD.addAll(cart);
	  Drink temp;
	  boolean sorted = false;
	  for (int i = 0; i < cartD.size() - 1; i++) {
		  sorted = true;
		  if (cartD.get(i).getQuantity() < cartD.get(i+1).getQuantity()) {
			  temp = cartD.get(i);
			  cartD.set(i, cartD.get(i + 1));
	          cartD.set(i + 1, temp);
	          sorted = false;
		  }
	  }
	  String list = "";
	    for (Drink drink : cartD) {
	      list += drink + " ";
	    }
	    return list;
  }

  /**
   * Displays total price of all drinks
   * 
   * @return returns total price of all drinks
   */
  public String totalPrice() {
    ArrayList<Drink> cartD = new ArrayList<Drink>();
    cartD.addAll(cart);
    double total = 0;
    for (int i = 0; i < cartD.size(); i++) {
      total += cartD.get(i).getPrice();
    }
    return "The total price of all drinks in cart is: $" + total;
  }

  /**
   * Searches for a drink in the ArrayList cart
   * 
   * @param company the company of the drink user is looking for
   * @param name    the name of the drink the user is looking for
   * @return returns the drink object
   *
   */
  public String searchDrink(String company) {
    ArrayList<Drink> cartE = new ArrayList<Drink>();
    String list = "";
    for (int i = 0; i < cartE.size(); i++) {
      if (cartE.get(i).getCompany() == company) {
        list += cartE.get(i);
      }
    }
    return list;
  }

  /**
   * Converts ArrayList into String
   * 
   * @return returns the ArrayList into string format for display purposes
   */
  public String toString() {
	System.out.println();
    String list = "";
    for (Drink drink : cart) {
      list += drink.toString() + " ";
    }
    return list;
  }

  /**
   * Deletes specified drink object
   * 
   * @param company the company the user wants to remove
   * @return returns if the object has been removed 
   */
  public String delete(String company) {
    ArrayList<Drink> delete = new ArrayList<Drink>();
    boolean removed = false;
    for (Drink drink : cart) {
    	if (drink.getCompany().equals(company)) {
    		removed = true;
    		delete.add(drink);
    	}
      }
 
    if (removed == true) {
    	cart.removeAll(delete);
    	return "All drinks with the company name " + company + " have been removed from cart";
    }
    else {
    	return "No drinks with the company name " + company + " have been found in cart";
    }
  }
  
  /**
   * Edits a existing drink object to change its parameters
   * @param company the name of the company
   * @param name the name of the drink
   * @param newQuantity the new quantity of the drink
   * @param newPrice the new price of the drink
   */
  public void edit(String company, String name, int newQuantity, double newPrice) {
	  for (Drink drink : cart) {
		  if(drink.getCompany().equals(company) && drink.getName().equals(name)) {
			  drink.changeQuantity(newQuantity);
			  drink.changePrice(newPrice);
		  }
	  }
  }
  

}
