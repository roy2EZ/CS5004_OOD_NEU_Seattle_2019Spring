package edu.neu.ccs.cs5004.problem1;

public abstract class AbstractVehicle {
  protected Size vehicleSize;
  protected Disabilities vehicleDisType;

  public Size getVehicleSize() {
    return vehicleSize;
  }

  public Disabilities getVehicleDisType() {
    return vehicleDisType;
  }
}
