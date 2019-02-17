package edu.neu.ccs.cs5004.problem2;

import static edu.neu.ccs.cs5004.problem2.ILeague.GAMES_NUM_OF_FOOTBALL;
import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;



public class AmericanFootballLeagueTest {
  private AmericanFootballLeague nfl;
  private DateFormat dateFormat;
  private Date gameDate;
  private Game testGame;
  private AmericanFootballTeam seaHawks;
  private AmericanFootballTeam chiBears;

  @Before
  public void setUp() throws Exception {

    nfl = new AmericanFootballLeague("NFL");
    // create game date
    dateFormat = new SimpleDateFormat("yyyy-mm-dd");
    gameDate = dateFormat.parse("2018-10-11");
    // set a new game
    testGame = new Game(Sport.AMERICAN_FOOTBALL,"Seattle Hawks",
        "Chicago Bears", gameDate, 17,24);
    seaHawks = new AmericanFootballTeam("Seattle Hawks", nfl,
        nfl.getNumOfGames(), 5, 11,
        new Record(3,1,1),
        new Point(3,0, 0), testGame);
    chiBears = new AmericanFootballTeam("Chicago Bears", nfl,
        nfl.getNumOfGames(), 5, 11,
        new Record(4,0,1),
        new Point(4,0, 0), testGame);
  }

  @Test
  public void getLeagueName() {
    assertEquals("NFL", nfl.getLeagueName());
  }

  @Test
  public void getLeagueType() {
    assertEquals(Sport.AMERICAN_FOOTBALL, nfl.getLeagueType());
  }

  @Test
  public void getStartMonth() {
    Integer EXPECTED_START_MON = 9;
    assertEquals(EXPECTED_START_MON, nfl.getStartMonth());
  }

  @Test
  public void getEndMonth() {
    Integer EXPECTED_END_MON = 12;
    assertEquals(EXPECTED_END_MON, nfl.getEndMonth());
  }

  @Test
  public void getNumOfGames() {
    assertEquals(GAMES_NUM_OF_FOOTBALL, nfl.getNumOfGames());

  }

  @Test
  public void compareTeams() throws TiedTeamsException {
    // Test case 1: compare two teams and return the one with higher points
    // chiBears should be return because it has more points than seaHawks
    assertEquals(chiBears, nfl.compareTeams(seaHawks, chiBears));

    // Test case 2: compare two teams with same points, return the one with higher winNum
    // generate a team with same points but more winNum with seaHawks, for test purpose
    AmericanFootballTeam seaHawks2 = new AmericanFootballTeam("Seattle Hawks", nfl,
        nfl.getNumOfGames(), 5, 11,
        new Record(5, 0, 0),
        new Point(3, 0, 0), testGame);
    // seaHawks2 should be return
    assertEquals(seaHawks2, nfl.compareTeams(seaHawks, seaHawks2));
  }

  @Test(expected = TiedTeamsException.class)
  public void compareTeamsTiedTeamException() throws TiedTeamsException {
    // Test a team with same points and winNum with seaHawks, should throw TiedTeamException
    AmericanFootballTeam testTeam = new AmericanFootballTeam("Seattle Hawks", nfl,
        nfl.getNumOfGames(), 5, 11,
        new Record(3, 1, 1),
        new Point(3, 0, 0), testGame);
    nfl.compareTeams(seaHawks, testTeam);
  }
}