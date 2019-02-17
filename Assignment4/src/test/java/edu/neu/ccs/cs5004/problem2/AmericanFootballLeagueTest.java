package edu.neu.ccs.cs5004.problem2;

import static edu.neu.ccs.cs5004.problem2.ILeague.GAMES_NUM_OF_FOOTBALL;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AmericanFootballLeagueTest {
  private AmericanFootballLeague nfl;

  @Before
  public void setUp() throws Exception {
    nfl = new AmericanFootballLeague("NFL");
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
}