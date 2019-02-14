package edu.neu.ccs.cs5004.problem2;

import static edu.neu.ccs.cs5004.problem2.Sport.*;

public abstract class AbstractRecord implements IRecord {
  protected Sport sport;
  protected Integer winNum;
  protected Integer loseNum;
  protected Integer tieNum;

  public AbstractRecord(Sport sport, Integer winNum, Integer loseNum) {
    if (sport == AMERICAN_FOOTBALL || sport == SOCCER) {
      this.sport = sport;
      this.winNum = winNum;
      this.loseNum = loseNum;
    }
  }

  public AbstractRecord(Sport sport, Integer winNum, Integer loseNum, Integer tieNum) {
    if (sport == BASEBALL) {
      this.sport = sport;
      this.winNum = winNum;
      this.loseNum = loseNum;
      this.tieNum = tieNum;
    }
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
