package edu.neu.ccs.cs5004.problem2;

import sun.util.calendar.BaseCalendar.Date;

public class AmericanFootballLeague extends AbstractLeague {

  private final Integer numOfGames;
  private final Sport leagueType;
  private final Integer startMonth;
  private final Integer endMonth;

  /**
   * a constructor for initialize an off season team
   * @param leagueName
   */
  public AmericanFootballLeague(String leagueName) {
    super(leagueName);
    numOfGames = GAMES_NUM_OF_FOOTBALL;
    leagueType = Sport.AMERICAN_FOOTBALL;
    startMonth = 9;
    endMonth = 12;
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

  /**
   * Create a game between two teams on a given date. When a game is created, it should be recorded
   * as the next game in the league.
   */
  @Override
  public Game scheduleGame(AbstractTeam homeTeam, AbstractTeam awayTeam, Date gameDate) {
    return null;
  }

  /**
   * Update a game with the points scored during the game.
   */
  @Override
  public void leaguePlayGame(Game game, Integer homeScore, Integer awayScore) {

  }
}
