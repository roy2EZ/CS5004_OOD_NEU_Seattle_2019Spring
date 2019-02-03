package problem2;


/**
 * Represent vehicle with its color, make and model, license plate info, velocity and direction
 */
public abstract class AbstractVehicle implements IVehicle {
  protected String color;
  protected MakeAndModel makeAndModel;
  protected License license;
  protected Integer velocity;
  protected Direction direction;
  public final static Integer MIN_VELOCITY = 40;
  public final static Integer MIN_ACC_FACTOR = 10;
  public final static Integer MAX_ACC_FACTOR = 50;
  public final static Integer MIN_DEC_FACTOR = 20;
  public final static Integer MAX_DEC_FACTOR = 50;

  /**
   * @return the color of the vehicle
   */
  public String getColor() {
    return color;
  }

  /**
   * @return the make and model info
   */
  public MakeAndModel getMakeAndModel() {
    return makeAndModel;
  }

  /**
   * @return the license plate info
   */
  public License getLicense() {
    return license;
  }

  /**
   * @return the current velocity
   */
  public Integer getVelocity() {
    return velocity;
  }

  /**
   * @return the current direction
   */
  public Direction getDirection() {
    return direction;
  }

}
