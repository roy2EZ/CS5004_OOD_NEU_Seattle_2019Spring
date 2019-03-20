package java.edu.neu.ccs.cs5004.prob1;

public abstract class Vehicle implements IVehicle {
  protected String ID;
  protected Float aveSpeed;
  protected Float maxSpeed;

  public String getID() {
    return ID;
  }

  public Float getAveSpeed() {
    return aveSpeed;
  }

  public Float getMaxSpeed() {
    return maxSpeed;
  }
}
