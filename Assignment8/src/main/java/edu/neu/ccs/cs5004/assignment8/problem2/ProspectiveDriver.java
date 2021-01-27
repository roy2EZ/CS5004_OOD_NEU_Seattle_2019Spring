package edu.neu.ccs.cs5004.assignment8.problem2;

/**
 * Represents a prospective driver class including first name and last name, dateOfBirth, driverLicense information,
 * vehicle information, vehicle Insurance information, driver History information, vehicle History information
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */
public class ProspectiveDriver extends AbstractDriver {

  public ProspectiveDriver(Name name, Date dateOfBirth,
      DriverLicense driverLicense, Vehicle vehicle,
      VehicleInsurance vehicleInsurance,
      DriverHistory driverHistory,
      VehicleHistory vehicleHistory) {
    super(name, dateOfBirth, driverLicense, vehicle, vehicleInsurance, driverHistory,
        vehicleHistory);
  }


}
