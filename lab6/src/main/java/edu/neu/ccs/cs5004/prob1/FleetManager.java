package edu.neu.ccs.cs5004.prob1;

public abstract class FleetManager {

  public static TripReport drive(Float distance, Vehicle vehicle) {
    Float speed = vehicle.getAveSpeed();
    Integer duration = Math.round(distance/speed);
    TripReport newReport = new TripReport(vehicle,speed, distance, duration);
    return newReport;
  }

  public static TripReport drive(Float distance, Float speed, Float speedLimit, String id) {
    Vehicle vehicle = new Vehicle(id, speed, speedLimit);
    Integer duration;
    if (speed > speedLimit) {
      duration = Math.round(distance/speedLimit);
    } else {
      duration = Math.round(distance/speed);
    }
    TripReport newReport = new TripReport(vehicle,speed,distance,duration);
    return newReport;
  }

  public static TripReport drive(Integer duration, Float distance, String id, Float speedLimit) {
    Float speed;
    if (distance/duration>speedLimit) {
      speed = speedLimit;
    } else {
      speed = distance/duration;
    }
    Vehicle vehicle = new Vehicle(id, speed, speedLimit);
    TripReport newReport = new TripReport(vehicle,speed,distance, duration);
    return newReport;
  }

}
