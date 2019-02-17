package edu.neu.ccs.cs5004.problem2;

import java.util.Date;

public class AmericanFootballLeague extends AbstractLeague {

  private final Integer numOfGames;
  private final Sport leagueType;
  private final Integer startMonth;
  private final Integer endMonth;
  private Game nextGame;


  public AmericanFootballLeague(String leagueName) {
    super(leagueName);
    numOfGames = GAMES_NUM_OF_FOOTBALL;
    leagueType = Sport.AMERICAN_FOOTBALL;
    startMonth = 9;
    endMonth = 12;
  }

  public Game getNextGame() {
    return nextGame;
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

  @Override
  public Game scheduleGame(AbstractTeam homeTeam, AbstractTeam awayTeam, Date gameDate) {
    Game newGame = new Game(Sport.AMERICAN_FOOTBALL, homeTeam.getTeamName(),
        awayTeam.getTeamName(), gameDate);
    this.nextGame = newGame;
    return newGame;
  }

  /**
   * Update a game with the points scored during the game.
   */
  @Override
  public Game leaguePlayGame(Game game, AbstractTeam homeTeam, AbstractTeam awayTeam, Integer homeScore, Integer awayScore)
      throws FutureGameException, TiedGameException {
    Game playedGame = new Game(game.getSportType(),game.getHomeTeamName(),
        game.getAwayTeamName(),game.getGameDate(),
        homeScore,awayScore);
    homeTeam.updateTeam(playedGame);
    awayTeam.updateTeam(playedGame);
    return playedGame;
  }


}
