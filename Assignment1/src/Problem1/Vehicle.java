/**
 * Class Vehicle, containing information about a vehicle. This class
 is used as a part of Problem 1.
 */
package Problem1;
/**
 * Vehicle is a simple object that has a unique Vehicle
 Identification Number (VIN), corresponding license plate and owner.
 */
public class Vehicle {
    private Integer VIN;
    private String licensePlate;
    private Owner owner;

    /**
     * Constructor that creates a new vehicle object with the
     specified VIN and license plate.
     * @param VIN - VIN of the new Vehicle object.
     * @param licensePlate - license plate of the new Vehicle.
     * @param owner - onwer of the new Vehicle.
     */
    public Vehicle(Integer VIN, String licensePlate, Owner owner) {
        this.VIN = VIN;
        this.licensePlate = licensePlate;
        this.owner = owner;
    }

    /**
     * Returns the VIN of the Vehicle.
     * @return the VIN of the Vehicle.
     */
    public Integer getVIN() {
        return this.VIN;
    }
    /**
     * Returns the licensePlate of the Vehicle.
     * @return the licensePlate of the Vehicle.
     */
    public String getLicensePlate() {
        return this.licensePlate;
    }
    /**
     * Returns the owner.
     * @return the owner.
     */
    public Owner getOwner() {
        return this.owner;
    }

    /**
     * Sets the VIN of the Vehicle.
     */
    public void setVIN(Integer VIN) {
        this.VIN = VIN;
    }
    /**
     * Sets the licensePlate of the Vehicle.
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }


}