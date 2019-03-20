package java.edu.neu.ccs.cs5004.prob1;

public abstract class FleetManager {

  TripReport drive(float distance, Vehicle vehicle) {
    Float speed = vehicle.getAveSpeed();
    Integer duration = Math.round(distance/speed);
    TripReport newReport = new TripReport(vehicle,speed, distance, duration);
    return newReport;
  }

}
