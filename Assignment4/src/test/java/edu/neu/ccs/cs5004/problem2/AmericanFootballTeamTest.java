package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class AmericanFootballTeamTest {
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
  public void updateTeam() throws FutureGameException, TiedGameException {
    // Step 1: initialize test teams as off season team
    Integer expectedNum = 0;
    assertEquals(expectedNum, seaHawks.getGamePlayedNum());
    assertEquals(expectedNum, seaHawks.getGameRemainingNum());
    assertEquals(expectedNum, chiBears.getGamePlayedNum());
    assertEquals(expectedNum, chiBears.getGameRemainingNum());
    assertEquals("Seattle Hawks", seaHawks.getTeamName());
    assertEquals(nfl, seaHawks.getLeague());
    assertEquals(expectedNum, seaHawks.getRecord().getWinNum());
    assertEquals(expectedNum, seaHawks.getRecord().getLoseNum());
    assertEquals(expectedNum, seaHawks.getRecord().getDrawNum());
    assertEquals(expectedNum, seaHawks.getPoint().getWinPoint());
    assertEquals(expectedNum, seaHawks.getPoint().getDrawPoint());
    assertEquals(expectedNum, seaHawks.getPoint().getLosePoint());

    // Step 2: update the teams with the played game
    seaHawks.updateTeam(testGame);
    chiBears.updateTeam(testGame);





  }

  @Test(expected = InvalidGameException.class)
  public void getLastGameInvalid() throws InvalidGameException {
    assertEquals(null, seaHawks.getLastGame());
  }
}