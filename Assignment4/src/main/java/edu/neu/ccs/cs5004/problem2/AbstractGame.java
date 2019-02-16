package edu.neu.ccs.cs5004.problem2;

import sun.util.calendar.BaseCalendar.Date;

/**
 * Represents a abstract class of Game
 */
public abstract class AbstractGame implements IGame {
  protected String homeTeamName;
  protected String awayTeamName;
  protected Date gameDate;
  protected Integer homeScore;
  protected Integer awayScore;
  protected Sport sportType;

  public AbstractGame(String homeTeamName, String awayTeamName,
      Date gameDate, Integer homeScore, Integer awayScore,
      Sport sportType) {
    this.homeTeamName = homeTeamName;
    this.awayTeamName = awayTeamName;
    this.gameDate = gameDate;
    this.homeScore = homeScore;
    this.awayScore = awayScore;
    this.sportType = sportType;
  }


  public abstract String getWinner(GameWithTie game) throws TiedGameException, FutureGameException;
}

