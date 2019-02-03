package problem2;

public abstract class AbstractVehicle implements IVehicle {
  protected String color;
  protected MakeAndModel makeAndModel;
  protected License license;
  protected Integer velocity;
  protected Direction direction;
  public final static Integer MIN_VOLOCITY = 40;


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
