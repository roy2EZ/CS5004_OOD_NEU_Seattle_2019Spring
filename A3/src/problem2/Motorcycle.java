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
    if (velocity <= MAX_V_Motorcycle && velocity >= MIN_VELOCITY) {
      this.velocity = velocity;
    } else {
      throw new IllegalArgumentException(String.format("Velocity should be an integer between %d and %d", MIN_VELOCITY,
          MAX_V_Motorcycle));
    }
    this.direction = direction;
  }

  /**
   * @param accelerationFactor be added to vehicle's velocity to accelerate
   */
  @Override
  public Motorcycle accelerate(int accelerationFactor) throws Exception{
    if (accelerationFactor < MIN_ACC_FACTOR || accelerationFactor > MAX_ACC_FACTOR) {
      throw new Exception(String.format("accelerationFactor should be between %d and %d.", MIN_ACC_FACTOR, MAX_ACC_FACTOR));
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
  public Motorcycle decelerate(int decelerateFactor) throws Exception{
    if (decelerateFactor < MIN_DEC_FACTOR || decelerateFactor > MAX_DEC_FACTOR) {
      throw new Exception(String.format("decelerationFactor should be between %d and %d.", MIN_DEC_FACTOR, MAX_DEC_FACTOR));
    } else {
      Integer newSpeed = (int) Math.ceil(this.velocity * (1 - (double)decelerateFactor / 100));
      if (  newSpeed < MIN_VELOCITY) {
        throw new Exception("Velocity will be over max speed limitation");
      } else {
        return new Motorcycle(this.color, this.makeAndModel, this.license,
            this.velocity = newSpeed, this.direction);
      }
    }
  }

  /**
   * @param directionChange as an input argument to change the direction of the vehicle
   */
  @Override
  public Motorcycle directionChange(Direction directionChange) throws Exception {

    char dirChange = directionChange.toString().charAt(0);
    char currDir = this.direction.toString().charAt(0);
    String dirCase = String.valueOf(dirChange).concat(String.valueOf(currDir));
    if (dirCase.equals("EW") || dirCase.equals("WE") || dirCase.equals("NS") || dirCase.equals("SN")) {
      return new Motorcycle(this.color, this.makeAndModel, this.license,
          this.velocity, this.direction = directionChange);
    } else {
      throw new Exception(String.format("Vehicle cannot turn to %s",directionChange));
    }
  }


}
