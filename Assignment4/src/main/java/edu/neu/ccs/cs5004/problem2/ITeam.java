package edu.neu.ccs.cs5004.problem2;

/**
 * Represent an interface of sport teams
 */
public interface ITeam {
  Integer GAMES_NUM_OF_FOOTBALL = 16;
  Integer GAMES_NUM_OF_SOCCER = 34;
  Integer GAMES_NUM_OF_BASEBALL = 162;

  /**
   * update related parameters of a team with a played game result for game with tie sport
   */
  void updateTeam(Game game) throws FutureGameException, TiedGameException;


}
