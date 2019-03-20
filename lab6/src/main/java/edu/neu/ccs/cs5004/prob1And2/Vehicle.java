package edu.neu.ccs.cs5004.prob1And2;

public class Vehicle implements IVehicle {
  protected String ID;
  protected Float aveSpeed;
  protected Float maxSpeed;

  public Vehicle(String ID, Float aveSpeed, Float maxSpeed) {
    this.ID = ID;
    this.aveSpeed = aveSpeed;
    this.maxSpeed = maxSpeed;
  }

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
