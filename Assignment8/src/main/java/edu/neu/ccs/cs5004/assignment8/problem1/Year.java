package edu.neu.ccs.cs5004.assignment8.problem1;

import java.util.Calendar;
import java.util.Objects;

/**
 * Represent the publish aYear of media.
 */
public class Year {
  private static final int MIN = 1000;
  private static final int MAX = Calendar.getInstance().get(Calendar.YEAR);
  private static final String INVALID_YEAR = "It is an invalid aYear!";

  private int aYear;

  /**
   * Create an Year object.
   * @param aYear aYear in int
   * @throws IllegalYearException when the aYear is invalid.
   */
  public Year(int aYear) throws IllegalYearException {
    setYear(aYear);
  }



  /**
   * Gets aYear.
   * @return publish aYear in int
   */
  public int getYear() {
    return this.aYear;
  }

  /**
   * Set publish aYear.
   * @param aYear publish aYear
   * @throws IllegalYearException when the aYear is invalid.
   */
  public void setYear(int aYear) throws IllegalYearException {
    if (aYear < MIN || aYear > MAX) {
      throw new IllegalYearException(INVALID_YEAR);
    }
    this.aYear = aYear;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Year year1 = (Year) obj;
    return aYear == year1.aYear;
  }

  @Override
  public int hashCode() {
    return Objects.hash(aYear);
  }

  @Override
  public String toString() {
    return Integer.toString(aYear);
  }
}

