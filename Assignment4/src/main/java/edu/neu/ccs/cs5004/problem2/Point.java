package edu.neu.ccs.cs5004.problem2;

/**
 * represents the points a team having now in a season.
 * in different League, the rules to get points from a game is different designed.
 */
public class Point {
  private Integer winPoint;
  private Integer drawPoint;
  private Integer losePoint;
  private Integer totalPoint;

  /**
   * constructs point for League with win, lose and draw game result.
   * @param winPoint win point
   * @param drawPoint draw point
   * @param losePoint lose point
   */
  public Point(Integer winPoint, Integer drawPoint, Integer losePoint) {
    this.winPoint = winPoint;
    this.drawPoint = drawPoint;
    this.losePoint = losePoint;
    this.totalPoint = this.winPoint + this.drawPoint + this.losePoint;
  }
  /**
   * constructs point for League without draw game result.
   * @param winPoint win point
   * @param losePoint lose point
   */
  public Point(Integer winPoint, Integer losePoint) {
    this.winPoint = winPoint;
    this.losePoint = losePoint;
    this.totalPoint = this.winPoint + this.losePoint;
  }

  public Integer getWinPoint() {
    return winPoint;
  }

  public Integer getDrawPoint() {
    return drawPoint;
  }

  public Integer getLosePoint() {
    return losePoint;
  }

  public Integer getTotalPoint() {
    return totalPoint;
  }
}
