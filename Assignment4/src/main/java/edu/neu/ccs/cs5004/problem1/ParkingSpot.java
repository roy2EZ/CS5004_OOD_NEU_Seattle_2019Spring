package edu.neu.ccs.cs5004.problem1;

public class ParkingSpot implements IParkingSpot {
  private Size spotSize;
  private Disabilities spotDisType;
  private Availability spotAvailability;

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
  public Boolean isParkingValid(AbstractVehicle vehicle, IParkingSpot parkingSpot)
      throws Exception {
    return null;
  }
}
