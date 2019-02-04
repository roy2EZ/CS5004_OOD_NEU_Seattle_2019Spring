package problem2;

/**
 * Represents make and model of a vehicle
 */
public class MakeAndModel {
  private String make;
  private String model;

  /**
   * @param make the vehicle's make, for example "Audi"
   * @param model the vehicle's model, for example "A4 Sedan"
   */
  public MakeAndModel(String make, String model) {
    this.make = make;
    this.model = model;
  }

  /**
   * @return the make of vehicle as a string
   */
  public String getMake() {
    return make;
  }

  /**
   * @return the model of vehicle as a string
   */
  public String getModel() {
    return model;
  }
}
