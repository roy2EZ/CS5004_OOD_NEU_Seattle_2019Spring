package edu.neu.ccs.cs5004.problem2;

import sun.util.calendar.BaseCalendar.Date;

public class GameWithoutTie extends AbstractGame {

  public GameWithoutTie(String homeTeamName, String awayTeamName,
      Date gameDate, Integer homeScore, Integer awayScore,
      Sport sportType) {
    super(homeTeamName, awayTeamName, gameDate, homeScore, awayScore, sportType);
  }

  /**
   * update the game class with scores of two team got in the game
   */
  @Override
  public void playGameAndUpdateTeam(Integer homeScore, Integer awayScore) {

  }

  /**
   * get the name of winning team of the abstractGame
   */
  @Override
  public String getWinner(AbstractGame abstractGame) throws TiedGameException, FutureGameException {
    return null;
  }

}
