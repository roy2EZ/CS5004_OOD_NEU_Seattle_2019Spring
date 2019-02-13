package edu.neu.ccs.cs5004.problem1;

/**
 * Represents the interface of parking spot
 * @author Roy Chen
 * @version 1.0
 */
public interface IParkingSpot {

  /**
   * @param vehicle the vehicle which is looking for parking spot
   * @param parkingSpot the parking spot
   * @return returns true if a vehicle was successfully parked, and false otherwise
   */
  Boolean parkVehicle(Vehicle vehicle, ParkingSpot parkingSpot);

  /**
   * @param vehicle the vehicle which is looking for parking spot
   * @return returns true if a vehicle was successfully parked
   * @throws UnavailableSpotException if vehicle can't park for spot is taken
   * @throws InvalidSpotTypeException if vehicle can't park for disability type not matching spot
   * @throws InvalidSpotSizeException if vehicle can't park for size not matching spot
   */
  Boolean isParkingValid(Vehicle vehicle)
      throws InvalidSpotSizeException, InvalidSpotTypeException, UnavailableSpotException;
}
