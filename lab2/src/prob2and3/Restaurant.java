package prob2and3;

/**
 *
 * Represents a Restaurant with their details--name, address,
 * is the restaurant open or not and menu.
 *
 * @author roych
 * @version 1.0
 */
public class Restaurant {
  private String name;
  private String address;
  private Boolean isOpen;
  private Menu menu;

  /**
   *
   * Creates a new Restaurant given the name, address as strings,
   * isOpen as boolean and menu as a Menu class.
   *
   * @param name the restaurant's name
   * @param address the restaurant's address
   * @param isOpen if the restaurant is open or closed, true for open, false for closed
   * @param menu the menu
   */

  public Restaurant(String name, String address, Boolean isOpen, Menu menu) {
    this.name = name;
    this.address = address;
    this.isOpen = isOpen;
    this.menu = menu;
  }

  /**
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   *
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   *
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   *
   * @param address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   *
   * @return the isOpen, true for open, false for closed
   */
  public Boolean getOpen() {
    return isOpen;
  }

  /**
   *
   * @param open
   */
  public void setOpen(Boolean open) {
    isOpen = open;
  }

  /**
   *
   * @return the menu
   */
  public Menu getMenu() {
    return this.menu;
  }
}
