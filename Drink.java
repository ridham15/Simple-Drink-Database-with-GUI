
//////////////////////////////////////////////////////////////////////////////
//Title:            Drink
//Files:            Main.java, Drink.java, Cart.java
//Author:           Ridham Gabani
//////////////////////////////////////////////////////////////////////////////

public class Drink {
  // INSTANCE FIELDS
  private String company;
  private String name;
  private int quantity;
  private double price;

  // CONSTRUCTORS
  /**
   * Constructs a Drink object with specified name, company, quantity and price
   * 
   * @param c the company of the drink
   * @param n the name of the drink
   * @param q the quantity of the drinks
   * @param p the price of a single drink
   */
  public Drink(String c, String n, int q, double p) {
    company = c;
    name = n;
    quantity = q;
    price = p;
  }

  // ACCESSORS (including equals, compareTo and toString)
  /**
   * Returns the name of the company
   * 
   * @return company the name of the comapny
   */
  public String getCompany() {
    return company;
  }

  /**
   * Returns the name of the drink
   * 
   * @return name the name of the drink
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the quantity of the drink
   * 
   * @return quantity the quantity of the drinks
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * Returns the price of a single drink
   * 
   * @return price returns price of a single drink
   */
  public double getPrice() {
    return price;
  }

  /**
   * Tests whether two drinks are equal or not
   * 
   * @param o the object being tested
   * @return whether or not the two drinks are equal
   */
  public boolean equals(Object o) {
    Drink other = (Drink) o;
    return (this.company).equals(other.company) && (this.name).equals(other.name) && (this.quantity == other.quantity)
        && (this.price == other.price);
  }

  /**
   * Compares the two Drink objects
   * 
   * @param o the object being tested
   * @return the value of compareTo between the two company names
   */
  public int compareTo(Object o) {
    Drink other = (Drink) o;
    return (this.company).compareTo(other.company);
  }

  /**
   * Converts Drink object information to string
   * 
   * @return information of Drink in string format
   */
  public String toString() {
    return company + "\n\t Name of Drink: " + name + "\n\t Quantity of " + name + ": " + quantity + "\n\t Price of "
        + name + ": $" + price;
  }

  // MUTATORS for each instance field even if not using
  /**
   * Changes the company of the drink object
   */
  public void changeCompany(String cc) {
    company = cc;
  }

  /**
   * Changes the name of the drink object
   */
  public void changeName(String cn) {
    name = cn;
  }

  /**
   * Change the quantity of the drink object
   */
  public void changeQuantity(int cq) {
    quantity = cq;
  }

  /**
   * Change the price of the drink object
   */
  public void changePrice(double cp) {
    price = cp;
  }

  /**
   * Saves file for drink object
   */
  public String saveToFile() {
    return company + "\n" + name + "\n" + quantity + "\n" + price;
  }

}