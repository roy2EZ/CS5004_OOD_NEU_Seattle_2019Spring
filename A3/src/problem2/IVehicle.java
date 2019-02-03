package problem2;

/**
 * Represent Vehicle with three method to accelerate and decelerate the vehicle's velocity and
 * change the direction
 */
public interface IVehicle {

  /**
   * @param accelerationFactor be added to vehicle's velocity to accelerate
   */
  IVehicle accelerate(int accelerationFactor) throws Exception;

  /**
   * @param decelerateFactor the vehicle's velocity will sub the decelerateFactor to decelerate
   */
  IVehicle decelerate(int decelerateFactor) throws Exception;

  /**
   * @param directionChange as an input argument to change the direction of the vehicle
   */
  IVehicle directionChange( Direction directionChange) throws Exception;

}
