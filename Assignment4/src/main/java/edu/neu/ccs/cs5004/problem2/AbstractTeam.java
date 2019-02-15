package edu.neu.ccs.cs5004.problem2;

/**
 * Represents an abstract team
 */
public abstract class AbstractTeam implements ITeam {
  protected String teamName;
  protected League league;
  protected Integer gamePlayedNum;
  protected Integer gameRemainingNum;
  protected Record record;
  protected Point point;
  protected Game lastGame;


  @Override
  public void updateTeam(Game game) {

  }

  public String getTeamName() {
    return teamName;
  }

  public League getLeague() {
    return league;
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

  public Game getLastGame() throws InvalidGameException {
    if (lastGame == null) {
      throw new InvalidGameException("");
    }
    return lastGame;
  }


}
