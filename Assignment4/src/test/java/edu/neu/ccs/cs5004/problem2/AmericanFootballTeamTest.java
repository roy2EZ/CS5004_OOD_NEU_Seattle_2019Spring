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
  public void updateTeam() throws FutureGameException, TiedGameException, InvalidGameException {
    // Step 1: initialize test teams as off season team
    Integer EXPECTED_NUM = 0;
    assertEquals(EXPECTED_NUM, seaHawks.getGamePlayedNum());
    assertEquals(EXPECTED_NUM, seaHawks.getGameRemainingNum());
    assertEquals(EXPECTED_NUM, chiBears.getGamePlayedNum());
    assertEquals(EXPECTED_NUM, chiBears.getGameRemainingNum());
    assertEquals("Seattle Hawks", seaHawks.getTeamName());
    assertEquals(nfl, seaHawks.getLeague());
    assertEquals(EXPECTED_NUM, seaHawks.getRecord().getWinNum());
    assertEquals(EXPECTED_NUM, seaHawks.getRecord().getLoseNum());
    assertEquals(EXPECTED_NUM, seaHawks.getRecord().getDrawNum());
    assertEquals(EXPECTED_NUM, seaHawks.getPoint().getWinPoint());
    assertEquals(EXPECTED_NUM, seaHawks.getPoint().getDrawPoint());
    assertEquals(EXPECTED_NUM, seaHawks.getPoint().getLosePoint());

    // Step 2: update the teams with the played game
    seaHawks.updateTeam(testGame);
    chiBears.updateTeam(testGame);
    
    // Step 3: check each team's related field to see if they are updated
    // 3.1: if game played and remaining number updated
    Integer ADD_NUM = 1;
    assertEquals(ADD_NUM, seaHawks.getGamePlayedNum());
    assertEquals(ADD_NUM, chiBears.getGamePlayedNum());
    Integer EXPECTED_REMAIN_NUM = 15;
    assertEquals(EXPECTED_REMAIN_NUM, seaHawks.getGameRemainingNum());
    assertEquals(EXPECTED_REMAIN_NUM, chiBears.getGameRemainingNum());
    // 3.2: chiBears win the game, seaHawks lose the game, update related record and points
    assertEquals(ADD_NUM, seaHawks.getRecord().getLoseNum());
    assertEquals(ADD_NUM, chiBears.getRecord().getWinNum());
    assertEquals(ADD_NUM, chiBears.getPoint().getWinPoint());
    Integer NOT_ADD_NUM = 0;
    assertEquals(NOT_ADD_NUM, seaHawks.getRecord().getWinNum());
    assertEquals(NOT_ADD_NUM, seaHawks.getRecord().getDrawNum());
    assertEquals(NOT_ADD_NUM, seaHawks.getPoint().getWinPoint());
    assertEquals(NOT_ADD_NUM, seaHawks.getPoint().getDrawPoint());
    assertEquals(NOT_ADD_NUM, chiBears.getRecord().getLoseNum());
    assertEquals(NOT_ADD_NUM, chiBears.getRecord().getDrawNum());
    assertEquals(NOT_ADD_NUM, chiBears.getPoint().getLosePoint());
    assertEquals(NOT_ADD_NUM, chiBears.getPoint().getDrawPoint());
    // Step 4: update last game
    assertEquals(testGame, seaHawks.getLastGame());
    assertEquals(testGame, chiBears.getLastGame());
  }

  @Test(expected = InvalidGameException.class)
  public void getLastGameInvalid() throws InvalidGameException {
    assertEquals(null, seaHawks.getLastGame());
  }
}