package edu.neu.ccs.cs5004.problem2;

import java.util.Date;

public class SoccerLeague extends AbstractLeague {

  private final Integer numOfGames;
  private final Sport leagueType;
  private final Integer startMonth;
  private final Integer endMonth;
  private Game nextGame;

  public SoccerLeague(String leagueName) {
    super(leagueName);
    numOfGames = GAMES_NUM_OF_SOCCER;
    leagueType = Sport.SOCCER;
    startMonth = 2;
    endMonth = 8;
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

  /**
   * Create a game between two teams on a given date. When a game is created, it should be recorded
   * as the next game in the league.
   */
  @Override
  public Game scheduleGame(AbstractTeam homeTeam, AbstractTeam awayTeam, Date gameDate) {
    Game newGame = new Game(Sport.SOCCER, homeTeam.getTeamName(),
        awayTeam.getTeamName(), gameDate);
    this.nextGame = newGame;
    return newGame;
  }
}
