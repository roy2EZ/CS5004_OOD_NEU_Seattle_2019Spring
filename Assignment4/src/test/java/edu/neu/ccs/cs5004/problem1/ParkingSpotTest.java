package edu.neu.ccs.cs5004.problem1;
/**
 * test parking methods in ParkingSpot class
 *
 * @author Roy Chen
 * @version 1.0
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static edu.neu.ccs.cs5004.problem1.Availability.*;
import static edu.neu.ccs.cs5004.problem1.Disabilities.*;
import static edu.neu.ccs.cs5004.problem1.Size.*;
import static org.junit.Assert.*;

public class ParkingSpotTest {
  private Vehicle smallRegCar;
  private Vehicle medCar;
  private Vehicle largeCar;
  private Vehicle disableCar;
  private ParkingSpot smallSpot;
  private ParkingSpot medSpot;
  private ParkingSpot largeSpot;
  private ParkingSpot disableSpot;
  private ParkingSpot takenSpot;

  @Before
  public void setUp() throws Exception {
    smallRegCar = new Vehicle(SMALL, REGULAR);
    medCar = new Vehicle(MEDUIM, REGULAR);
    largeCar = new Vehicle(LARGE, REGULAR);
    disableCar = new Vehicle(SMALL, DISABILITY);

    smallSpot = new ParkingSpot(SMALL, REGULAR, AVAILABLE);
    medSpot = new ParkingSpot(MEDUIM, REGULAR, AVAILABLE);
    largeSpot = new ParkingSpot(LARGE, REGULAR, AVAILABLE);
    disableSpot = new ParkingSpot(SMALL, DISABILITY, AVAILABLE);
    takenSpot = new ParkingSpot(SMALL, REGULAR, TAKEN);

  }

  /**
   * test isParkingValid() to see if it returns true for valid vehicle park can park into spot
   */
  @Test
  public void isParkingValid()
      throws InvalidSpotSizeException, InvalidSpotTypeException, UnavailableSpotException {
    // test about vehicle size matching spot size
    assertTrue(smallSpot.isParkingValid(smallRegCar));
    assertTrue(medSpot.isParkingValid(smallRegCar));
    assertTrue(medSpot.isParkingValid(medCar));
    assertTrue(largeSpot.isParkingValid(smallRegCar));
    assertTrue(largeSpot.isParkingValid(medCar));
    assertTrue(largeSpot.isParkingValid(largeCar));
    // test about disability/regular vehicle parking
    assertTrue(smallSpot.isParkingValid(disableCar));
    assertTrue(disableSpot.isParkingValid(disableCar));
    assertTrue(smallSpot.isParkingValid(smallRegCar));
  }

  /**
   * @throws InvalidSpotSizeException for vehicle size is larger than spot
   */
  @Test(expected = InvalidSpotSizeException.class)
  public void isParkingValidWithInvalidSize()
      throws InvalidSpotSizeException, UnavailableSpotException, InvalidSpotTypeException {
    smallSpot.isParkingValid(largeCar);
  }

  /**
   * @throws InvalidSpotTypeException for regular vehicle park in disability spot
   */
  @Test(expected = InvalidSpotTypeException.class)
  public void isParkingValidWithInvalidDisType()
      throws InvalidSpotSizeException, UnavailableSpotException, InvalidSpotTypeException {
    disableSpot.isParkingValid(smallRegCar);
  }

  /**
   * @throws UnavailableSpotException for spot was taken/not available
   */
  @Test(expected = UnavailableSpotException.class)
  public void isParkingValidWithSpotTaken()
      throws InvalidSpotSizeException, UnavailableSpotException, InvalidSpotTypeException {
    takenSpot.isParkingValid(smallRegCar);
  }

  @Test
  public void testParkVehicle() {
    // Test part 1
    // Vehicle can be parked if everything of the vehicle is valid for that spot
    assertTrue(medSpot.parkVehicle(medCar, medSpot));
    // Test about size: larger vehicle cannot park into smaller spot
    assertFalse(smallSpot.parkVehicle(largeCar, smallSpot));
    // Test part 2
    // Test about disability parking: regular car cannot park at disability spot
    assertFalse(disableSpot.parkVehicle(smallRegCar, disableSpot));
    // But disability vehicle can park in both disable or regular spot
    assertTrue(disableSpot.parkVehicle(disableCar, disableSpot));
    assertTrue(smallSpot.parkVehicle(disableCar, smallSpot));
    // Test part 3
    // taken spot cannot be parked anymore
    assertFalse(takenSpot.parkVehicle(smallRegCar, takenSpot));

  }
}