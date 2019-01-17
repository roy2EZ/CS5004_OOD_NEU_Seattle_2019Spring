package prob2and3;

public class Restaurant {
  private String name;
  private String address;
  private Boolean isOpen;
  private Menu menu;

  public Restaurant(String name, String address, Boolean isOpen, Menu menu) {
    this.name = name;
    this.address = address;
    this.isOpen = isOpen;
    this.menu = menu;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Boolean getOpen() {
    return isOpen;
  }

  public void setOpen(Boolean open) {
    isOpen = open;
  }

  public Menu getMenu() {
    return this.menu;
  }
}
