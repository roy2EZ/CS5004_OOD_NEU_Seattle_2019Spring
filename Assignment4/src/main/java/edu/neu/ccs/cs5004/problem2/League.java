package edu.neu.ccs.cs5004.problem2;

import sun.util.calendar.BaseCalendar.Date;

/**
 * Represents a sport league
 */
public class League implements ILeague {
  private String leagueName;
  private Sport leagueType;
  private Integer seasonStartMon;
  private Integer seasonEndMon;
  private Integer numOfGames;
  private Game nextGame;

  public final Integer FOOTBALL_GAME_NUM = 16;
  public final Integer BASEBALL_GAME_NUN = 162;
  public final Integer SOCCER_GAME_NUM = 38;


  @Override
  public Team compareTeam(Team team1, Team team2) throws TiedTeamsException {
    if (team1.getPoints() > team2.getPoints()) {
      return team1;
    } else if (team1.getPoints() < team2.getPoints()) {
      return team2;
    } else {
      if (team1.getRecord().getWinNum() > team2.getRecord().getWinNum()) {
        return team1;
      } else if (team1.getRecord().getWinNum() < team2.getRecord().getWinNum()) {
        return team2;
      } else {
        throw new TiedTeamsException("These two teams have same record.");
      }
    }
  }

  @Override
  public Game scheduleGame(Team team1, Team team2, Date date) {
    return null;
  }

  @Override
  public Game playGame(Integer homeTeamScore, Integer awayTeamScore) {
    return null;
  }

}
