package edu.neu.ccs.cs5004.problem2;

/**
 * represents an interface of game.
 */
public interface IGame {

  /**
   * update the game class with scores of two team got in the game.
   * @param homeScore home team score
   * @param awayScore away team score
   */
  void playGameAndUpdateTeam(Integer homeScore, Integer awayScore);

  /**
   * get the name of winning team of the abstractGame.
   * @return winner team name
   * @throws TiedGameException when game is tie
   */
  String getWinner() throws TiedGameException, FutureGameException;
}
