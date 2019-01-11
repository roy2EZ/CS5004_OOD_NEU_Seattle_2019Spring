public class Person {
    private String firstname;
    private String lastname;
    private String fullname;

    public Person(String firstname, String lastname, String fullname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.fullname = firstname + lastname;
    }

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFullname() {
        return fullname;
    }
}
