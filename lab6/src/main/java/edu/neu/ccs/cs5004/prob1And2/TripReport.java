package edu.neu.ccs.cs5004.prob1And2;

public class TripReport {
  private Vehicle vehicle;
  private Float speedMilePerMin;
  private Float dist;
  private Integer durationInMin;

  public TripReport(Vehicle vehicle, Float speedMilePerMin, Float dist,
      Integer durationInMin) {
    this.vehicle = vehicle;
    this.speedMilePerMin = speedMilePerMin;
    this.dist = dist;
    this.durationInMin = durationInMin;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public Float getSpeedMilePerMin() {
    return speedMilePerMin;
  }

  public Float getDist() {
    return dist;
  }

  public Integer getDurationInMin() {
    return durationInMin;
  }
}
