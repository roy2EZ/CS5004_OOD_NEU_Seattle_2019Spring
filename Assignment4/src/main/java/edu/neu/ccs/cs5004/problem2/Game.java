package edu.neu.ccs.cs5004.problem2;

import java.util.Date;

/**
 * Represents a sport game
 */
public class Game implements IGame {
  private Team homeTeam;
  private Team awayTeam;
  private Date gameDate;
  private Integer homeTeamScore;
  private Integer awayTeamScore;

  @Override
  public Boolean isTie(Game game) {
    return null;
  }

  @Override
  public Team getWinnerTeam(Game game) throws TiedGameException {
    if (isTie(game)) {
      throw new TiedGameException("This game is tied. No winner. ");
    } else if (this.homeTeamScore>this.awayTeamScore){
     return this.homeTeam;
    } else {
      return this.awayTeam;
    }
  }
}
