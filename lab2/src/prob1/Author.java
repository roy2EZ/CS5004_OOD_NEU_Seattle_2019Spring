package prob1;

public class Author extends Person{

  private String email;
  private String address;

  public Author(String firstname, String lastname, String email, String address) {
    super(firstname, lastname);
    this.email = email;
    this.address = address;
  }

  public String getEmail() {
    return this.email;
  }

  public String getAddress() {
    return this.address;
  }
}
