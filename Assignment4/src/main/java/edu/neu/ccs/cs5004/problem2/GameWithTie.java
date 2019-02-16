package edu.neu.ccs.cs5004.problem2;

import sun.util.calendar.BaseCalendar.Date;

public class GameWithTie extends AbstractGame {

  private GameOutcome isGameTie;

  public GameWithTie(String homeTeamName, String awayTeamName,
      Date gameDate, Integer homeScore, Integer awayScore,
      Sport sportType, GameOutcome isGameTie) {
    super(homeTeamName, awayTeamName, gameDate, homeScore, awayScore, sportType);
    if (homeScore == awayScore) {
      this.isGameTie = GameOutcome.TIE;
    } else {
      this.isGameTie = GameOutcome.NOT_TIE;
    }
  }

  public GameOutcome getIsGameTie() {
    return isGameTie;
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
  public String getWinner(GameWithTie game) throws TiedGameException, FutureGameException {
    if (game.isGameTie == GameOutcome.TIE) {
      throw new TiedGameException("No winner of this Game. Game is tie.");
    } else {
      if (homeScore>awayScore) {
        return homeTeamName;
      } else {
        return awayTeamName;
      }
    }
  }

  /**
   * this mothed is no need here
   * get the name of winning team of the abstractGame
   */
  @Override
  public String getWinner(AbstractGame abstractGame) throws TiedGameException, FutureGameException {
    return null;
  }
}
