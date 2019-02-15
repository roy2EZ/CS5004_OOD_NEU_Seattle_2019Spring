package edu.neu.ccs.cs5004.problem2;

import sun.util.calendar.BaseCalendar.Date;

public class Game implements IGame {
  private String homeTeamName;
  private String awayTeamName;
  private Date gameDate;
  private Integer homeScore;
  private Integer awayScore;
  private GameOutcome gameTieResult;


  /**
   * update the game class with scores of two team got in the game
   */
  @Override
  public void updateGame(Integer homeScore, Integer awayScore) {

  }

  /**
   * get the result of whether the game is tie or not tie for league with draw games allowed and for
   * team in those leagues
   *
   * @return the outcome
   */
  @Override
  public GameOutcome getOutcome(Game game) throws FutureGameException {
    return null;
  }

  /**
   * get the name of winning team of the game
   */
  @Override
  public String getWinner(Game game) throws TiedGameException, FutureGameException {
    return null;
  }
}

