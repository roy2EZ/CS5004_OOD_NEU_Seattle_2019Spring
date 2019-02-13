package edu.neu.ccs.cs5004.problem1;

/**
 * Represents the parking spot
 * @author Roy Chen
 * @version 1.0
 */
public class ParkingSpot implements IParkingSpot {
  private Size spotSize;
  private Disabilities spotDisType;
  private Availability spotAvailability;
  private Vehicle vehicle;
  private ParkingSpot parkingSpot;

  public ParkingSpot(Size spotSize, Disabilities spotDisType,
      Availability spotAvailability) {
    this.spotSize = spotSize;
    this.spotDisType = spotDisType;
    this.spotAvailability = spotAvailability;
  }

  public Size getSpotSize() {
    return spotSize;
  }

  public Disabilities getSpotDisType() {
    return spotDisType;
  }

  public Availability getSpotAvailability() {
    return spotAvailability;
  }

  /**
   * @param vehicle the vehicle which is looking for parking spot
   * @param parkingSpot the parking spot
   * @return returns true if a vehicle was successfully parked, and false otherwise
   */
  @Override
  public Boolean parkVehicle(Vehicle vehicle, ParkingSpot parkingSpot) {
    this.parkingSpot = parkingSpot;
    try {
      if (parkingSpot.isParkingValid(vehicle)) {
        return true;
      }
    } catch (InvalidSpotSizeException | InvalidSpotTypeException | UnavailableSpotException e) {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * @param vehicle the vehicle which is looking for parking spot
   * @return true if a vehicle was successfully parked
   * @throws UnavailableSpotException if vehicle can't park for spot is taken
   * @throws InvalidSpotTypeException if vehicle can't park for disability type not matching spot
   * @throws InvalidSpotSizeException if vehicle can't park for size not matching spot
   */
  @Override
  public Boolean isParkingValid(Vehicle vehicle)
      throws InvalidSpotSizeException, InvalidSpotTypeException, UnavailableSpotException {
    if (vehicle.getVehicleSize().ordinal() > this.spotSize.ordinal()) {
      throw new InvalidSpotSizeException(String.format("%s vehicle can't park in %s spot.",
          vehicle.getVehicleSize().toString(), this.spotSize.toString()));
    } else if (vehicle.getVehicleDisType().ordinal() > this.spotDisType.ordinal()) {
      throw new InvalidSpotTypeException(String.format("%s vehicle can't park in %s spot.",
          vehicle.getVehicleDisType().toString(), this.spotDisType.toString()));
    } else if (this.spotAvailability.equals(Availability.TAKEN)) {
      throw new UnavailableSpotException(String.format("This spot is %s.",
          this.spotAvailability.toString()));
    }
    return true;
  }
}
