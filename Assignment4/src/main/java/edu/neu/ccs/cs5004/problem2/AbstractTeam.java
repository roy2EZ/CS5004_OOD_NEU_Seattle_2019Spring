package edu.neu.ccs.cs5004.problem2;

/**
 * Represents an abstract team.
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
   * constructs a general off season team with init 0 to related fields.
   * @param teamName the name of team
   * @param league the league that team in
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
   * @param teamName the name of the team
   * @param league the league
   * @param gamePlayedNum how many games played
   * @param gameRemainingNum how many games remaining
   * @param record team record of win/draw/lose game numbers
   * @param point team points
   * @param lastGame the last game this team play
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

  /**
   * get last game of the team
   * @return last game
   * @throws InvalidGameException if the team if off season with no last game.
   */
  public Game getLastGame() throws InvalidGameException {
    if (lastGame == null) {
      throw new InvalidGameException("There is no last game.");
    }
    return lastGame;
  }

}
