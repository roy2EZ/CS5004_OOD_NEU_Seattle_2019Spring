package edu.neu.ccs.cs5004.problem2;

/**
 * Represents an American Football team
 */
public class AmericanFootballTeam extends AbstractTeam {
  private final Integer WIN_POINT_PER_GAME = 1;
  private final Integer LOSE_POINT_PER_GAME = 0;
  private final Integer DRAW_POINT_PER_GAME = 0;

  /**
   * constructs a general off season team with init 0 to related fields
   */
  public AmericanFootballTeam(String teamName, AbstractLeague league) {
    super(teamName, league);
    this.record = new Record(0,0,0);
    this.point = new Point(0,0,0);
  }


  /**
   * update related parameters of a team with a played game result for game with tie sport.
   */
  @Override
  public void updateTeam(GameWithTie game) throws FutureGameException, TiedGameException {
    // update last game.
    this.lastGame = game;
    // update game played number.
    this.gamePlayedNum += 1;
    // update game remaining number.
    this.gameRemainingNum = GAMES_NUM_OF_FOOTBALL - this.gamePlayedNum;
    // update win/draw/lose record of this team, base on result of that game.
    if (game.getIsGameTie() == GameOutcome.TIE) {
      this.record = new Record(this.record.getWinNum(),
          this.record.getDrawNum() + 1, this.record.getLoseNum());
    } else {
      if (this.teamName == game.getWinner(game)) {
        this.record = new Record(this.record.getWinNum() + 1,
            this.record.getDrawNum(), this.record.getLoseNum());
      } else {
        this.record = new Record(this.record.getWinNum(),
            this.record.getDrawNum(), this.record.getLoseNum() + 1);
      }
    }
    // update team's point base on team's record and league rules
    this.point = new Point(this.record.getWinNum()*WIN_POINT_PER_GAME,
        this.record.getDrawNum()*DRAW_POINT_PER_GAME,
        this.record.getLoseNum()*LOSE_POINT_PER_GAME);
  }

  /**
   * this mothed is no need here for american football.
   * update related parameters of a team with a played game result for game without tie sport.
   */
  @Override
  public void updateTeam(GameWithoutTie game) {
  }
}
