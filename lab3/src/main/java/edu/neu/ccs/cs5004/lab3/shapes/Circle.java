package edu.neu.ccs.cs5004.lab3.shapes;

/**
 * This class represents a circle.  It offers all the operations mandated by the
 * Shape interface.
 */
public class Circle extends AbstractShape {
  private double radius;

  /**
   * Construct a circle object using the given center and radius
   *
   * @param x1      x coordinate of the center of this circle
   * @param y1      y coordinate of the center of this circle
   * @param radius the radius of this circle
   */
  public Circle(double x1, double y1, double radius) throws InvalidRadiusException{
    //super(pin);
    //Point2D pin = new Point2D(x, y);
    super(new Point2D(x1, y1));
    //this.radius = radius;

    if(radius < 0){
      throw new InvalidRadiusException("Radius has to be positive!");
     }
     else {
       this.radius = radius;
    }
  }

  /**
   * Construct a circle object with the given radius. It is centered at (0,0)
   *
   * @param point2D
   * @param radius  the radius of this circle
   */
  public Circle(Point2D point2D, double radius){
    super(new Point2D(0, 0));
    this.radius = radius;
    //if (radius < 0) {
    //  throw new InvalidRadiusException("Radius has to be positive!");
    //} else {
    //  this.radius = radius;
    //}
  }

  //@Override
  public double area() {
    Point2D copyPoint = this.reference;
    Point2D copyPoint2 = super.reference;
    return Math.PI * radius * radius;

  }

  @Override
  public double perimeter() {
    try {
      return 2 * Math.PI * this.getRadius();
    } catch (InvalidRadiusException e) {
      System.err.println("Negative radius");
      return -10;
    }
  }

  @Override
  public Shape resize(double factor) {
    return new Circle(reference.getX(), reference.getY(), Math.sqrt(factor) *
        radius);
  }

  @Override
  public void moveX(Integer dx) {

  }

  @Override
  public void moveY(Integer dy) {

  }

  public String toString() {
    return String.format("Circle: center (%.3f,%.3f) radius %.3f",
        this.reference.getX(),this.reference.getY(),this.radius);
  }

  public double getRadius() throws InvalidRadiusException{
    if (radius < 0) {
      throw new InvalidRadiusException("This radius is somehow negative!");
    }else
    return radius;
  }
}