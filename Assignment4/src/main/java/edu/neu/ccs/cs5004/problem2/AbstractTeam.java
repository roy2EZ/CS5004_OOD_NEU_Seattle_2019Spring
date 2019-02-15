package edu.neu.ccs.cs5004.problem2;

/**
 * Represents an abstract team
 */
public abstract class AbstractTeam implements ITeam {
  protected String teamName;
  protected AbstractLeague League;
  protected Integer gamePlayedNum;
  protected Integer gameRemainingNum;
  protected Record record;
  protected Point point;
  protected AbstractGame lastGame;


  public AbstractTeam(String teamName, AbstractLeague league) {
    this.teamName = teamName;
    this.League = league;

  }

  @Override
  public void updateTeam(AbstractGame abstractGame) {

  }

  public String getTeamName() {
    return teamName;
  }

  public AbstractLeague getLeague() {
    return League;
  }

  public Integer getGamePlayedNum() {
    return gamePlayedNum;
  }

  public Integer getGameRemainingNum() {
    return gameRemainingNum;
  }

  public Record getRecord() {
    return record;
  }

  public Point getPoint() {
    return point;
  }

  public AbstractGame getLastGame() throws InvalidGameException {
    if (lastGame == null) {
      throw new InvalidGameException("");
    }
    return lastGame;
  }


}
