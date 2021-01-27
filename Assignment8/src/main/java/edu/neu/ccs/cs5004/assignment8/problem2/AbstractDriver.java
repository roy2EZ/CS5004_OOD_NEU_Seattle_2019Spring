package edu.neu.ccs.cs5004.assignment8.problem2;

import java.util.Objects;
import java.util.Calendar;


/**
 * Represents an abstract driver class.
 * Including first name and last name, dateOfBirth, driverLicense information,
 * vehicle information, vehicle Insurance information, driver History information,
 * and vehicle History information
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */
public abstract class AbstractDriver implements IDriver {
  protected Name name;
  protected Date dateOfBirth;
  protected DriverLicense driverLicense;
  protected Vehicle vehicle;
  protected VehicleInsurance vehicleInsurance;
  protected DriverHistory driverHistory;
  protected VehicleHistory vehicleHistory;

  /**
   * Constructs an AbstractDriver with its fields.
   * @param name driver's name
   * @param dateOfBirth driver's date of birth
   * @param driverLicense driver license
   * @param vehicle driver's vehicle
   * @param vehicleInsurance drivers vehicle insurance
   * @param driverHistory driver driving history
   * @param vehicleHistory vehicle history
   */
  public AbstractDriver(Name name, Date dateOfBirth,
      DriverLicense driverLicense, Vehicle vehicle,
      VehicleInsurance vehicleInsurance,
      DriverHistory driverHistory,
      VehicleHistory vehicleHistory) {
    this.name = name;
    this.dateOfBirth = dateOfBirth;
    this.driverLicense = driverLicense;
    this.vehicle = vehicle;
    this.vehicleInsurance = vehicleInsurance;
    this.driverHistory = driverHistory;
    this.vehicleHistory = vehicleHistory;
  }

  /**
   * @return - a driver's name
   */
  public Name getName() {
    return name;
  }

  /**
   * @return - a driver's date of birth
   */
  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  /**
   * @return - a driver's driver License information
   */
  public DriverLicense getDriverLicense() {
    return driverLicense;
  }

  /**
   * @return - a driver's Vehicle information
   */
  public Vehicle getVehicle() {
    return vehicle;
  }

  /**
   * @return - a prospective driver's Vehicle Insurance information
   */
  public VehicleInsurance getVehicleInsurance() {
    return vehicleInsurance;
  }

  /**
   * @return - a driver's driverHistory's information
   */
  public DriverHistory getDriverHistory() {
    return driverHistory;
  }

  /**
   * @return - a driver's Vehicle History information
   */
  public VehicleHistory getVehicleHistory() {
    return vehicleHistory;
  }

  @Override
  public String toString() {
    return "Driver{" +
        "name=" + name + ", dateOfBirth=" + dateOfBirth + ", driverLicense=" +
        driverLicense.getLicenseId() + '}';
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbstractDriver that = (AbstractDriver) obj;
    return Objects.equals(name, that.name) &&
        Objects.equals(dateOfBirth, that.dateOfBirth) &&
        Objects.equals(driverLicense, that.driverLicense) &&
        Objects.equals(vehicle, that.vehicle) &&
        Objects.equals(vehicleInsurance, that.vehicleInsurance) &&
        Objects.equals(driverHistory, that.driverHistory) &&
        Objects.equals(vehicleHistory, that.vehicleHistory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, dateOfBirth, driverLicense, vehicle, vehicleInsurance, driverHistory,
        vehicleHistory);
  }

  /**
   * Get the driver's age using his/her date of birth and today's date.
   * @return driver's age as Integer;
   */
  @Override
  public Integer getAge() {
    Calendar cal = Calendar.getInstance();
    Integer thisYear = cal.get(Calendar.YEAR);
    Integer thisMon = cal.get(Calendar.MONTH);
    Integer thisDay = cal.get(Calendar.DATE);
    Integer driverDOBYear = this.getDateOfBirth().getYear();
    Integer driverDOBMonth = this.getDateOfBirth().getMonth();
    Integer driverDOBDay = this.getDateOfBirth().getDay();

    Integer age = thisYear - driverDOBYear;
    if (thisMon <= driverDOBMonth) {
      if (thisMon.equals(driverDOBMonth)) {
        if ( thisDay > driverDOBDay) {
          age--;
        }
      } else {
        age--;
      }
    }
    return age;
  }
}
