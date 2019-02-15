package edu.neu.ccs.cs5004.problem2;

import sun.util.calendar.BaseCalendar.Date;

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
  AbstractTeam compareTeams(AbstractTeam team1, AbstractTeam team2);

  /**
   * Create a game between two teams on a given date.
   * When a game is created, it should be recorded as the next game in the league.
   * @param homeTeam
   * @param awayTeam
   * @param gameDate
   */
  AbstractGame scheduleGame(AbstractTeam homeTeam, AbstractTeam awayTeam, Date gameDate);

  /**
   * Update a game with the points scored during the game.
   * @param game
   * @param homeScore
   * @param awayScore
   */
  void leaguePlayGame( AbstractGame game, Integer homeScore, Integer awayScore);
}
