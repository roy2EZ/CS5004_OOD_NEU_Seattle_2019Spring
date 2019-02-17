package edu.neu.ccs.cs5004.problem2;

import static edu.neu.ccs.cs5004.problem2.GameOutcome.*;
import static edu.neu.ccs.cs5004.problem2.Sport.*;
import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class GameTest {
  private AmericanFootballTeam seaHawks;
  private AmericanFootballTeam chiBears;
  private AmericanFootballLeague nfl;
  private Game testGame;
  private DateFormat dateFormat;
  private Date gameDate;
  private Date gameFutureDate;


  @Before
  public void setUp() throws Exception {
    nfl = new AmericanFootballLeague("NFL");
    seaHawks = new AmericanFootballTeam("Seattle Hawks", nfl);
    chiBears = new AmericanFootballTeam("Chicago Bears", nfl);
    // create game date
    dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    gameDate = dateFormat.parse("2018-10-11");
    gameFutureDate = dateFormat.parse("2019-12-20");
    // set a new game
    testGame = new Game(AMERICAN_FOOTBALL,"Seattle Hawks",
        "Chicago Bears", gameDate, 17,24);
  }

  @Test
  public void getHomeTeamName() {
    assertEquals(seaHawks.getTeamName(), testGame.getHomeTeamName());
  }

  @Test
  public void getAwayTeamName() {
    assertEquals(chiBears.getTeamName(), testGame.getAwayTeamName());
  }

  @Test
  public void getGameDate() {
    assertEquals(gameDate, testGame.getGameDate());
    assertEquals("Thu Oct 11 00:00:00 PDT 2018", testGame.getGameDate().toString());
  }

  @Test
  public void getHomeScore() {
    Integer EXPECTED_HOME_SCORE = 17;
    assertEquals(EXPECTED_HOME_SCORE, testGame.getHomeScore());
  }

  @Test
  public void getAwayScore() {
    Integer EXPECTED_AWAY_SCORE = 24;
    assertEquals(EXPECTED_AWAY_SCORE, testGame.getAwayScore());
  }

  @Test
  public void getSportType() {
    assertEquals(AMERICAN_FOOTBALL, testGame.getSportType());
  }

  @Test
  public void getIsGameTie() {
    assertEquals(NOT_TIE, testGame.getIsGameTie());
  }

  @Test
  public void getWinner() throws FutureGameException, TiedGameException {
    assertEquals(chiBears.getTeamName(), testGame.getWinner());
  }



  @Test
  public void playGameAndUpdateTeam() {
  }


  @Test(expected = FutureGameException.class)
  public void getWinnerFutureException() throws FutureGameException, TiedGameException {
    Game futureGame = new Game(AMERICAN_FOOTBALL,"Seattle Hawks",
        "Chicago Bears", gameFutureDate, 14,10);
    futureGame.getWinner();
  }

  @Test(expected = TiedGameException.class)
  public void getWinnerTiedGameException() throws FutureGameException, TiedGameException {
    Game tiedGame = new Game(AMERICAN_FOOTBALL,"Seattle Hawks",
        "Chicago Bears", gameDate, 14,14);
    tiedGame.getWinner();
  }
}