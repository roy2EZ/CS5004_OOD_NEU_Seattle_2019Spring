package edu.neu.ccs.cs5004.problem2;

/**
 * Represents an soccer team
 */
public class SoccerTeam extends AbstractTeam {
  private final Integer WIN_POINT_PER_GAME = 3;
  private final Integer LOSE_POINT_PER_GAME = 1;
  private final Integer DRAW_POINT_PER_GAME = 0;

  /**
   * constructs a general off season team with init 0 to related fields
   */
  public SoccerTeam(String teamName, AbstractLeague league) {
    super(teamName, league);
    this.record = new Record(0,0,0);
    this.point = new Point(this.record.getWinNum()*WIN_POINT_PER_GAME,
        this.record.getDrawNum()*DRAW_POINT_PER_GAME,
        this.record.getLoseNum()*LOSE_POINT_PER_GAME);
  }


  /**
   * update related parameters of a team with a played game result for game with tie sport
   */
  @Override
  public void updateTeam(Game game) {

  }

}
