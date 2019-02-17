package edu.neu.ccs.cs5004.problem2;

import sun.util.calendar.BaseCalendar.Date;


public abstract class AbstractLeague implements ILeague {
  private String leagueName;


  public AbstractLeague(String leagueName) {
    this.leagueName = leagueName;
  }



  public String getLeagueName() {
    return leagueName;
  }

  @Override
  public AbstractTeam compareTeams(AbstractTeam team1, AbstractTeam team2)
      throws TiedTeamsException {
    if (team1.getPoint().getTotalPoint() > team2.getPoint().getTotalPoint()) {
      return team1;
    } else if (team1.getPoint().getTotalPoint() < team2.getPoint().getTotalPoint()) {
      return team2;
    } else {
      if (team1.getRecord().getWinNum() > team2.getRecord().getWinNum()) {
        return team1;
      } else if (team1.getRecord().getWinNum() < team2.getRecord().getWinNum()) {
        return team2;
      } else {
        throw new TiedTeamsException("This two teams have same points and winning games.");
      }
    }

  }
}
