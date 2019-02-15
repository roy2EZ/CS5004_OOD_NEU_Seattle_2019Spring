package edu.neu.ccs.cs5004.problem2;

import sun.util.calendar.BaseCalendar.Date;

public interface ILeague {

  /**
   * Given two teams, return the team that has the most points.
   * @param team1
   * @param team2
   * @return
   */
  AbstractTeam compareTeams(AbstractTeam team1, AbstractTeam team2);

  void scheduleGame(AbstractTeam homeTeam, AbstractTeam awayTeam, Date gameDate);
}
