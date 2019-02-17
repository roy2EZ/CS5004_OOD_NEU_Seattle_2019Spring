package edu.neu.ccs.cs5004.problem2;

public abstract class AbstractLeague implements ILeague {
  private String leagueName;



  public AbstractLeague(String leagueName) {
    this.leagueName = leagueName;
  }



  public String getLeagueName() {
    return leagueName;
  }

  /**
   * Compares two teams in the league, return the one with higher points.
   * If two teams are with same points, return the one with higher win game numbers.
   * If two teams are with same points and win game numbers, throws a TiedTeamsException
   * @param team1
   * @param team2
   * @return team with higher points. If with same points, return team with higher winNum.
   * @throws TiedTeamsException If two teams are with same points and win game numbers
   */
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
