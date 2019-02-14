package edu.neu.ccs.cs5004.problem2;

/**
 * Represent a sport team
 */
public class Team implements ITeam {
  private String teamName;
  private League league;
  private Integer gamePlayed;
  private Integer gameRemaining;
  private AbstractRecord record;
  private Integer points;
  private Game lastGame;

  @Override
  public Team playGame(Game game) {
    return null;
  }

  public String getTeamName() {
    return teamName;
  }

  public League getLeague() {
    return league;
  }

  public Integer getGamePlayed() {
    return gamePlayed;
  }

  public Integer getGameRemaining() {
    return gameRemaining;
  }

  public AbstractRecord getRecord() {
    return record;
  }

  public Integer getPoints() {
    return points;
  }

  public Game getLastGame() throws InvalidGameException {
    if (this.lastGame == null) {
      throw new InvalidGameException("This is the first game of this season. No last game.");
    }
    return lastGame;
  }
}
