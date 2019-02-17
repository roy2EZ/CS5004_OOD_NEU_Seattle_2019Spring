package edu.neu.ccs.cs5004.problem2;

import java.util.Calendar;
import java.util.Date;

/**
 * Represents a abstract class of Game.
 */
public class Game implements IGame {
  protected String homeTeamName;
  protected String awayTeamName;
  protected Date gameDate;
  protected Integer homeScore;
  protected Integer awayScore;
  protected Sport sportType;
  private GameOutcome isGameTie;

  /**
   * normal constructor will all parameters need to be input.
   * include isGameTie, for the sports with tie result.
   * this is for test purpose.
   * @param sportType sport type
   * @param homeTeamName home Team Name
   * @param awayTeamName away Team Name
   * @param gameDate game Date
   * @param homeScore home Score
   * @param awayScore away Score
   */
  public Game(Sport sportType, String homeTeamName, String awayTeamName,
      Date gameDate, Integer homeScore, Integer awayScore) {
    this.homeTeamName = homeTeamName;
    this.awayTeamName = awayTeamName;
    this.gameDate = (Date)gameDate.clone();
    this.homeScore = homeScore;
    this.awayScore = awayScore;
    this.sportType = sportType;

    if (this.homeScore.equals(this.awayScore)) {
      this.isGameTie = GameOutcome.TIE;
    } else {
      this.isGameTie = GameOutcome.NOT_TIE;
    }
  }


  /**
   * constructs a game for scheduleGame() method in League.
   * @param homeTeamName homeTeamName
   * @param awayTeamName awayTeamName
   * @param gameDate gameDate
   * @param sportType sportType
   */
  public Game(Sport sportType, String homeTeamName, String awayTeamName, Date gameDate) {
    this.sportType = sportType;
    this.homeTeamName = homeTeamName;
    this.awayTeamName = awayTeamName;
    this.gameDate = (Date)gameDate.clone();

  }

  public String getHomeTeamName() {
    return homeTeamName;
  }

  public String getAwayTeamName() {
    return awayTeamName;
  }

  public Date getGameDate() {
    return (Date)gameDate.clone();
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
   * update the game class with scores of two team got in the game.
   */
  @Override
  public void playGameAndUpdateTeam(Integer homeScore, Integer awayScore) {

  }


  /**
   * get the name of winning team of the game.
   * @return a string of winner team's name.
   * @throws TiedGameException if game tie but calling this method
   * @throws FutureGameException if game in the future
   */
  @Override
  public String getWinner() throws TiedGameException, FutureGameException {
    Calendar calendar =  Calendar.getInstance();
    Date today = calendar.getTime();
    if (this.getGameDate().after(today)) {
      throw new FutureGameException("Game is not played yet.");
    }
    if (this.isGameTie == GameOutcome.TIE) {
      throw new TiedGameException("No winner of this Game. Game is tie.");
    } else {
      if (homeScore > awayScore) {
        return homeTeamName;
      } else {
        return awayTeamName;
      }
    }


  }
}

