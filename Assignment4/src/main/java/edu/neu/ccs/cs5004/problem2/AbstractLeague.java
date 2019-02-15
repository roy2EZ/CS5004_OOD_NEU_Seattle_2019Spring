package edu.neu.ccs.cs5004.problem2;

import sun.util.calendar.BaseCalendar.Date;


public abstract class AbstractLeague implements ILeague {
  private String leagueName;
  private Sport leagueType;
  private Integer startMonth;
  private Integer endMonth;
  private Integer numOfGames;

  public AbstractLeague(String leagueName, Sport leagueType, Integer startMonth,
      Integer endMonth, Integer numOfGames) {
    this.leagueName = leagueName;
    this.leagueType = leagueType;
    this.startMonth = startMonth;
    this.endMonth = endMonth;
    this.numOfGames = numOfGames;
  }
}
