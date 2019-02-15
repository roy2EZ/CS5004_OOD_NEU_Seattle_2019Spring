package edu.neu.ccs.cs5004.problem2;

import sun.util.calendar.BaseCalendar.Date;

public class GameWithTie extends AbstractGame {

  private GameOutcome isGameTie;

  public GameWithTie(String homeTeamName, String awayTeamName,
      Date gameDate, Integer homeScore, Integer awayScore,
      Sport sportType, GameOutcome isGameTie) {
    super(homeTeamName, awayTeamName, gameDate, homeScore, awayScore, sportType);
    this.isGameTie = isGameTie;
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
