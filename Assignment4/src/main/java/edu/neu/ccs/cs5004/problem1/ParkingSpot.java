package edu.neu.ccs.cs5004.problem1;



public class ParkingSpot implements IParkingSpot {
  private Size spotSize;
  private Disabilities spotDisType;
  private Availability spotAvailability;

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
  public Boolean parkVehicle(AbstractVehicle vehicle, IParkingSpot parkingSpot) {
    return null;
  }

  /**
   * @param vehicle the vehicle which is looking for parking spot
   * @param parkingSpot the parking spot
   * @return returns true if a vehicle was successfully parked
   * @throws Exception as following: if vehicle can't park for spot is taken, throws
   * UnavailableSpotException; if vehicle can't park for disability type not matching spot, throws
   * InvalidSpotTypeException; if vehicle can't park for size not matching spot, throws
   * InvalidSpotSizeException;
   */
  @Override
  public Boolean isParkingValid(AbstractVehicle vehicle, ParkingSpot parkingSpot)
      throws InvalidSpotSizeException, InvalidSpotTypeException, UnavailableSpotException {
    if (vehicle.getVehicleSize().ordinal() > parkingSpot.getSpotSize().ordinal()) {
      throw new InvalidSpotSizeException(String.format("%s vehicle can't park in %s spot.",
          vehicle.getVehicleSize().toString(), parkingSpot.getSpotSize().toString()));
    } else if (vehicle.getVehicleDisType().ordinal() > parkingSpot.getSpotDisType().ordinal()) {
      throw new InvalidSpotTypeException(String.format("%s vehicle can't park in %s spot.",
          vehicle.getVehicleDisType().toString(), parkingSpot.getSpotDisType().toString()));
    } else if (parkingSpot.getSpotAvailability().equals(Availability.TAKEN)) {
      throw new UnavailableSpotException(String.format("This spot is %s.",
          parkingSpot.getSpotAvailability().toString()));
    }
  return true;
  }
}
