package edu.neu.ccs.cs5004.assignment8.problem2;

import java.util.Objects;

/**
 * Represents a date class including day, month, year;
 *
 * @author Hao Xu
 * @author Rongyi Chen
 * @author Cong Zhu
 */
public class Date {
  private int day;
  private int month;
  private int year;

  public Date(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  /**
   * @return - day
   */
  public int getDay() {
    return day;
  }

  /**
   * @return - month
   */
  public int getMonth() {
    return month;
  }

  /**
   * @return - year
   */
  public int getYear() {
    return year;
  }

  @Override
  public String toString() {
    return "Date{" +
        "day=" + day +
        ", month=" + month +
        ", year=" + year +
        '}';
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Date date = (Date) obj;
    return day == date.day &&
        month == date.month &&
        year == date.year;
  }

  @Override
  public int hashCode() {
    return Objects.hash(day, month, year);
  }
}
