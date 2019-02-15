package edu.neu.ccs.cs5004.problem2;

/**
 * represents a record with winning, losing and/or draw games of team performance in the season
 */
public class Record {
  private Integer winNum;
  private Integer drawNum;
  private Integer loseNum;

  /**
   * constructs for team in the League with win, lose and draw result of game.
   * @param winNum number of winning games till now in this season
   * @param drawNum number of draw games till now in this season
   * @param loseNum number of losing games till now in this season
   */
  public Record(Integer winNum, Integer drawNum, Integer loseNum) {
    this.winNum = winNum;
    this.drawNum = drawNum;
    this.loseNum = loseNum;
  }

  /**
   * constructs for team in the League without draw result of game.
   * @param winNum number of winning games till now in this season
   * @param loseNum number of losing games till now in this season
   */
  public Record(Integer winNum, Integer loseNum) {
    this.winNum = winNum;
    this.loseNum = loseNum;
  }

  public Integer getWinNum() {
    return winNum;
  }

  public Integer getDrawNum() {
    return drawNum;
  }

  public Integer getLoseNum() {
    return loseNum;
  }
}
