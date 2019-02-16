package edu.neu.ccs.cs5004.problem2;

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

  @Before
  public void setUp() throws Exception {
    nfl = new AmericanFootballLeague("NFL");
    seaHawks = new AmericanFootballTeam("Seattle Hawks", nfl);
    chiBears = new AmericanFootballTeam("Chicago Bears", nfl);
    // create game date
    dateFormat = new SimpleDateFormat("yyyy-mm-dd");
    gameDate = dateFormat.parse("2018-10-11");
    // set a new game
    testGame = new Game(Sport.AMERICAN_FOOTBALL,"Seattle Hawks",
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
    
  }

  @Test
  public void getHomeScore() {
  }

  @Test
  public void getAwayScore() {
  }

  @Test
  public void getSportType() {
  }

  @Test
  public void getIsGameTie() {
  }

  @Test
  public void getWinner() {
  }
}