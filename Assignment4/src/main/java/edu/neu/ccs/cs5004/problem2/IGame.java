package edu.neu.ccs.cs5004.problem2;

/**
 * represents an interface of game
 */
public interface IGame {

  /**
   * update the game class with scores of two team got in the game
   * @param homeScore
   * @param awayScore
   */
  void updateGame(Integer homeScore, Integer awayScore);

  /**
   * get the result of whether the game is tie or not tie
   * for league with draw games allowed and for team in those leagues
   * @param game
   * @return the outcome
   */
  GameOutcome getOutcome(Game game) throws FutureGameException;

  /**
   * get the name of winning team of the game
   * @param game
   * @return
   * @throws TiedGameException
   */
  String getWinner(Game game) throws TiedGameException, FutureGameException;
}
