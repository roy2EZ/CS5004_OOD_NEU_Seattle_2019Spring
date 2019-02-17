package edu.neu.ccs.cs5004.problem2;

import java.util.Date;

public interface ILeague {
  Integer GAMES_NUM_OF_FOOTBALL = 16;
  Integer GAMES_NUM_OF_SOCCER = 34;
  Integer GAMES_NUM_OF_BASEBALL = 162;

  /**
   * Given two teams, return the team that has the most points.
   * @param team1
   * @param team2
   * @return
   */
  AbstractTeam compareTeams(AbstractTeam team1, AbstractTeam team2) throws TiedTeamsException;

  /**
   * Create a game between two teams on a given date.
   * When a game is created, it should be recorded as the next game in the league.
   * @param homeTeam
   * @param awayTeam
   * @param gameDate
   */
  Game scheduleGame(AbstractTeam homeTeam, AbstractTeam awayTeam, Date gameDate);


  Game leaguePlayGame(Game game, AbstractTeam homeTeam, AbstractTeam awayTeam, Integer homeScore,
      Integer awayScore)
      throws FutureGameException, TiedGameException;
}
