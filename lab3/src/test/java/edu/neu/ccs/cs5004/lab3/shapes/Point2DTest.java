package edu.neu.ccs.cs5004.lab3.shapes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Point2DTest {
  private Point2D testPoint;

  @Before
  public void setUp() throws Exception {
    testPoint = new Point2D(3.2,4.5);
  }

  @Test
  public void distToOrigin() {
    assertEquals(5.5218,testPoint.distToOrigin(),4);
  }

  @Test
  public void getX() {
    assertEquals(3.2,testPoint.getX(),1);
  }

  @Test
  public void getY() {
    assertEquals(4.5,testPoint.getY(),1);
  }
}