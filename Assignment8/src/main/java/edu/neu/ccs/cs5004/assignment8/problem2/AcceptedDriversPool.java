package edu.neu.ccs.cs5004.assignment8.problem2;

/**
 * Represents an accepted divers pool including driver and vehicle matching information
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AcceptedDriversPool {

  private Map<ProspectiveDriver, Set<Vehicle>> driverToVehicle;

  public AcceptedDriversPool() {
    driverToVehicle = new HashMap<>();
  }

  public Map<ProspectiveDriver, Set<Vehicle>> getDriverToVehicle() {
    return driverToVehicle;
  }

  /**
   * A function to add a prospective driver into accepted driver pool
   */
  public void addToPool(ProspectiveDriver driver) {
    if (!RegistrationValidator.isApplicantAccepted(driver)) {
      return;
    }
    addToMap(driver);
  }

  /**
   * A helper function to add a prospective driver and his vehicle into driverToVehicle map
   */
  public void addToMap(ProspectiveDriver driver) {
    if (!driverToVehicle.containsKey(driver)) {
      driverToVehicle.put(driver, new HashSet<>());
      driverToVehicle.get(driver).add(driver.getVehicle());
    }
    driverToVehicle.get(driver).add(driver.getVehicle());
  }
}