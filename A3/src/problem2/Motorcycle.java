package problem2;

/**
 * represents motorcycle
 */
public class Motorcycle extends AbstractVehicle {

  private final static Integer MAX_V_Motorcycle = 65;

  /**
   * @param color color of the vehicle
   * @param makeAndModel make and model
   * @param license license plate information
   * @param velocity velocity of the vehicle
   * @param direction direction of the vehicle
   */
  public Motorcycle(String color, MakeAndModel makeAndModel, License license, Integer velocity, Direction direction)
      throws IllegalArgumentException {
    this.color = color;
    this.makeAndModel = makeAndModel;
    this.license = license;
    if (velocity <= MAX_V_Motorcycle && velocity >= MIN_VOLOCITY) {
      this.velocity = velocity;
    } else {
      throw new IllegalArgumentException(String.format("Velocity should be an integer between %d and %d", MIN_VOLOCITY,
          MAX_V_Motorcycle));
    }
    this.direction = direction;
  }

  /**
   * @param accelerationFactor be added to vehicle's velocity to accelerate
   */
  @Override
  public Motorcycle accelerate(int accelerationFactor) throws Exception{
    if (accelerationFactor < 10 || accelerationFactor > 50) {
      throw new IllegalArgumentException("accelerationFactor should be between 10 and 50.");
    } else {
      Integer newSpeed = (int) Math.ceil(this.velocity * (1 + (double)accelerationFactor / 100));
      if (  newSpeed > MAX_V_Motorcycle) {
        throw new Exception("Velocity will be over max speed limitation");
      } else {
        return new Motorcycle(this.color, this.makeAndModel, this.license,
            this.velocity = newSpeed, this.direction);
      }
    }


  }

  /**
   * @param decelerateFactor the vehicle's velocity will sub the decelerateFactor to decelerate
   */
  @Override
  public Motorcycle decelerate(int decelerateFactor) {

    return null;
  }

  /**
   * @param directionChange as an input argument to change the direction of the vehicle
   */
  @Override
  public Motorcycle directionChange(Direction directionChange) {

    return null;
  }
}
