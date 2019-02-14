package edu.neu.ccs.cs5004.problem2;

public abstract class AbstractRecord implements IRecord {
  protected Sport sport;
  protected Integer winNum;
  protected Integer loseNum;

  public AbstractRecord(Sport sport, Integer winNum, Integer loseNum) {
    this.sport = sport;
    this.winNum = winNum;
    this.loseNum = loseNum;
  }

  public Sport getSport() {
    return sport;
  }

  public Integer getWinNum() {
    return winNum;
  }

  public Integer getLoseNum() {
    return loseNum;
  }
}
