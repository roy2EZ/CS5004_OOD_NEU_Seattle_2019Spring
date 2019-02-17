package edu.neu.ccs.cs5004.problem2;

/**
 * Represents an abstract team
 */
public abstract class AbstractTeam implements ITeam {
  protected String teamName;
  protected AbstractLeague league;
  protected Integer gamePlayedNum;
  protected Integer gameRemainingNum;
  protected Record record;
  protected Point point;
  protected Game lastGame;

  /**
   * constructs a general off season team with init 0 to related fields
   * @param teamName
   * @param league
   */
  public AbstractTeam(String teamName, AbstractLeague league) {
    this.teamName = teamName;
    this.league = league;
    this.gamePlayedNum = 0;
    this.gameRemainingNum = 0;
    this.record = null;
    this.point = null;
    this.lastGame = null;
  }

  /**
   * a normal constructor with all parameters to initial, for test purpose.
   * @param teamName
   * @param league
   * @param gamePlayedNum
   * @param gameRemainingNum
   * @param record
   * @param point
   * @param lastGame
   */
  public AbstractTeam(String teamName, AbstractLeague league, Integer gamePlayedNum,
      Integer gameRemainingNum, Record record, Point point, Game lastGame) {
    this.teamName = teamName;
    this.league = league;
    this.gamePlayedNum = gamePlayedNum;
    this.gameRemainingNum = gameRemainingNum;
    this.record = record;
    this.point = point;
    this.lastGame = lastGame;
  }

  public String getTeamName() {
    return teamName;
  }

  public AbstractLeague getLeague() {
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
      throw new InvalidGameException("There is no last game.");
    }
    return lastGame;
  }

}
