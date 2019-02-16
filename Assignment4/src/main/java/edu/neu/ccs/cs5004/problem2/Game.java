package edu.neu.ccs.cs5004.problem2;

import java.util.Date;
import java.util.Calendar;
import javax.swing.plaf.FontUIResource;

/**
 * Represents a abstract class of Game
 */
public class Game implements IGame {
  protected String homeTeamName;
  protected String awayTeamName;
  protected Date gameDate;
  protected Integer homeScore;
  protected Integer awayScore;
  protected Sport sportType;
  private GameOutcome isGameTie;

  public Game(Sport sportType, String homeTeamName, String awayTeamName,
      Date gameDate, Integer homeScore, Integer awayScore) {
    this.homeTeamName = homeTeamName;
    this.awayTeamName = awayTeamName;
    this.gameDate = gameDate;
    this.homeScore = homeScore;
    this.awayScore = awayScore;
    this.sportType = sportType;

    if (homeScore == awayScore) {
      this.isGameTie = GameOutcome.TIE;
    } else {
      this.isGameTie = GameOutcome.NOT_TIE;
    }
  }

  public String getHomeTeamName() {
    return homeTeamName;
  }

  public String getAwayTeamName() {
    return awayTeamName;
  }

  public Date getGameDate() {
    return gameDate;
  }

  public Integer getHomeScore() {
    return homeScore;
  }

  public Integer getAwayScore() {
    return awayScore;
  }

  public Sport getSportType() {
    return sportType;
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
  public String getWinner(Game game) throws TiedGameException, FutureGameException {
    Calendar calendar =  Calendar.getInstance();
    Date today = calendar.getTime();
    if (game.getGameDate().after(today)){
      throw new FutureGameException("Game is not played yet.");
    }

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
}

