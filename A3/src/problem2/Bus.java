package problem2;

public class Bus extends BigCommercialVehicle {

  /**
   * @param color color of the vehicle
   * @param makeAndModel make and model
   * @param license license plate information
   * @param velocity velocity of the vehicle
   * @param direction direction of the vehicle
   * @throws Exception for velocity out of range
   */
  public Bus(String color, MakeAndModel makeAndModel, License license,
      Integer velocity, Direction direction) throws IllegalArgumentException {
    super(color, makeAndModel, license, velocity, direction);
  }
}
