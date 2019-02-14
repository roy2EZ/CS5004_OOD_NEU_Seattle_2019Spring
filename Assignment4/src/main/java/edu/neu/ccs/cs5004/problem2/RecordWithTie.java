package edu.neu.ccs.cs5004.problem2;

public class RecordWithTie extends AbstractRecord {
  private Integer tieNum;

  public RecordWithTie(Sport sport, Integer winNum, Integer loseNum, Integer tieNum) {
    super(sport, winNum, loseNum);
    this.tieNum = tieNum;
  }

  public Integer getTieNum() {
    return tieNum;
  }
}
