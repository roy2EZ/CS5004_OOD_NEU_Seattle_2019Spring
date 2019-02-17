package edu.neu.ccs.cs5004.problem2;

import sun.util.calendar.BaseCalendar.Date;


public abstract class AbstractLeague implements ILeague {
  private String leagueName;

  public AbstractLeague(String leagueName) {
    this.leagueName = leagueName;
  }

  public String getLeagueName() {
    return leagueName;
  }

}
