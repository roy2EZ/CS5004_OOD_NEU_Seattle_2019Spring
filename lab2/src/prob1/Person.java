package prob1;

public class Person {
  private final String firstname;
  private final String lastname;


  public Person(String firstname, String lastname) {
    this.firstname = firstname;
    this.lastname = lastname;
  }


  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getFullname() {
    return firstname+" "+lastname;
  }
}
