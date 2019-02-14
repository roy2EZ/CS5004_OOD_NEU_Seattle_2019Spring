package edu.neu.ccs.cs5004.problem2;

/**
 * Represents an interface of game
 */
public interface IGame {
  Boolean isTie(Game game);
  Team getWinnerTeam(Game game) throws TiedGameException;
}
