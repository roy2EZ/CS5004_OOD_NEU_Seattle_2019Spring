package edu.neu.ccs.cs5004.problem2;

import java.util.Date;

public class BaseballLeague extends AbstractLeague {

  private final Integer numOfGames;
  private final Sport leagueType;
  private final Integer startMonth;
  private final Integer endMonth;
  private Game nextGame;

  /**
   * construct a baseball league.
   * @param leagueName league name
   */
  public BaseballLeague(String leagueName) {
    super(leagueName);
    numOfGames = GAMES_NUM_OF_BASEBALL;
    leagueType = Sport.BASEBALL;
    startMonth = 5;
    endMonth = 12;
  }

  /**
   * Create a game between two teams on a given date. When a game is created, it should be recorded
   * as the next game in the league.
   */
  @Override
  public Game scheduleGame(AbstractTeam homeTeam, AbstractTeam awayTeam, Date gameDate) {
    Game newGame = new Game(Sport.BASEBALL, homeTeam.getTeamName(),
        awayTeam.getTeamName(), gameDate);
    this.nextGame = newGame;
    return newGame;
  }



  public Integer getNumOfGames() {
    return numOfGames;
  }

  public Sport getLeagueType() {
    return leagueType;
  }

  public Integer getStartMonth() {
    return startMonth;
  }

  public Integer getEndMonth() {
    return endMonth;
  }

  public Game getNextGame() {
    return nextGame;
  }
}
