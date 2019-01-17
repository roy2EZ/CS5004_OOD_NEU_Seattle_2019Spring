package prob1;

import org.junit.Assert;

public class PersonTest {

  private Person roy;

  @org.junit.Before
  public void setUp() throws Exception {
    this.roy = new Person("Roy","Chen");
  }

  @org.junit.Test
  public void getFirstname() {
    Assert.assertEquals("Roy",this.roy.getFirstname());
  }

  @org.junit.Test
  public void getLastname() {
    Assert.assertEquals("Chen",this.roy.getLastname());
  }

  @org.junit.Test
  public void getFullname() {
    Assert.assertEquals("Roy Chen",this.roy.getFullname());
  }
}