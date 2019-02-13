package edu.neu.ccs.cs5004.problem1;
/**
 * Represents the abstract vehicle
 *
 * @author Roy Chen
 * @version 1.0
 */
public abstract class AbstractVehicle {
  protected Size vehicleSize;
  protected Disabilities vehicleDisType;

  public AbstractVehicle(Size vehicleSize, Disabilities vehicleDisType) {
    this.vehicleSize = vehicleSize;
    this.vehicleDisType = vehicleDisType;
  }

  public Size getVehicleSize() {
    return vehicleSize;
  }

  public Disabilities getVehicleDisType() {
    return vehicleDisType;
  }
}
