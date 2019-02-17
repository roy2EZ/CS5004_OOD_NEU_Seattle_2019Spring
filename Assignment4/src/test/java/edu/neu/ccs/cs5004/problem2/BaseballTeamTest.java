package edu.neu.ccs.cs5004.problem2;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class BaseballTeamTest {
  private BaseballTeam team1;
  private BaseballTeam team2;
  private BaseballLeague mlb;
  private Game testGame;
  private DateFormat dateFormat;
  private Date gameDate;

  @Before
  public void setUp() throws Exception {
    mlb = new BaseballLeague("NFL");
    team1 = new BaseballTeam("team1", mlb);
    team2 = new BaseballTeam("team2", mlb);
    // create game date
    dateFormat = new SimpleDateFormat("yyyy-mm-dd");
    gameDate = dateFormat.parse("2018-10-11");
    // set a new game
    testGame = new Game(Sport.BASEBALL,"team1",
        "team2", gameDate, 17,24);
  }

  @Test
  public void updateTeam() throws FutureGameException, TiedGameException, InvalidGameException {
    // Step 1: initialize test teams as off season team
    Integer EXPECTED_NUM = 0;
    assertEquals(EXPECTED_NUM, team1.getGamePlayedNum());
    assertEquals(EXPECTED_NUM, team1.getGameRemainingNum());
    assertEquals(EXPECTED_NUM, team2.getGamePlayedNum());
    assertEquals(EXPECTED_NUM, team2.getGameRemainingNum());
    assertEquals("team1", team1.getTeamName());
    assertEquals(mlb, team1.getLeague());
    assertEquals(EXPECTED_NUM, team1.getRecord().getWinNum());
    assertEquals(EXPECTED_NUM, team1.getRecord().getLoseNum());
    assertEquals(null, team1.getRecord().getDrawNum());
    assertEquals(EXPECTED_NUM, team1.getPoint().getWinPoint());
    assertEquals(null, team1.getPoint().getDrawPoint());
    assertEquals(EXPECTED_NUM, team1.getPoint().getLosePoint());
    // Step 2: update the teams with the played game
    team1.updateTeam(testGame);
    team2.updateTeam(testGame);
    // Step 3: check each team's related field to see if they are updated
    // 3.1: if game played and remaining number updated
    Integer ADD_NUM = 1;
    assertEquals(ADD_NUM, team1.getGamePlayedNum());
    assertEquals(ADD_NUM, team2.getGamePlayedNum());
    Integer EXPECTED_REMAIN_NUM = 161;
    assertEquals(EXPECTED_REMAIN_NUM, team1.getGameRemainingNum());
    assertEquals(EXPECTED_REMAIN_NUM, team2.getGameRemainingNum());
    // 3.2: team2 win the game, team1 lose the game, update related record and points
    assertEquals(ADD_NUM, team1.getRecord().getLoseNum());
    assertEquals(ADD_NUM, team2.getRecord().getWinNum());
    assertEquals(ADD_NUM, team2.getPoint().getWinPoint());
    Integer NOT_ADD_NUM = 0;
    assertEquals(NOT_ADD_NUM, team1.getRecord().getWinNum());
    assertEquals(NOT_ADD_NUM, team1.getPoint().getWinPoint());
    assertEquals(NOT_ADD_NUM, team2.getRecord().getLoseNum());
    assertEquals(NOT_ADD_NUM, team2.getPoint().getLosePoint());
    // Step 4: update last game
    assertEquals(testGame, team1.getLastGame());
    assertEquals(testGame, team2.getLastGame());
  }
}