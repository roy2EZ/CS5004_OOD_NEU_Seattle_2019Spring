package edu.neu.ccs.cs5004.problem2;

import sun.util.calendar.BaseCalendar.Date;

/**
 * Represents an interface of a sport league
 */
public interface ILeague {
  Team compareTeam(Team team1, Team team2) throws TiedTeamsException;
  Game scheduleGame(Team team1, Team team2, Date date);
  Game playGame(Integer homeTeamScore, Integer awayTeamScore);
}
