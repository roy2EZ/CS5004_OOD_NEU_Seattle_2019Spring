package edu.neu.ccs.cs5004.problem2;

import static edu.neu.ccs.cs5004.problem2.ILeague.GAMES_NUM_OF_SOCCER;
import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class SoccerLeagueTest {
  private SoccerLeague mls;
  private DateFormat dateFormat;
  private Date gameDate;
  private Game testGame;
  private SoccerTeam team1;
  private SoccerTeam team2;

  @Before
  public void setUp() throws Exception {

    mls = new SoccerLeague("MLS");
    // create game date
    dateFormat = new SimpleDateFormat("yyyy-mm-dd");
    gameDate = dateFormat.parse("2018-10-11");
    // set a new game
    testGame = new Game(Sport.AMERICAN_FOOTBALL,"Team1",
        "Team2", gameDate, 17,24);
    team1 = new SoccerTeam("Team1", mls,
        5, 11,
        new Record(3,1,1),
        new Point(9,1, 0), testGame);
    team2 = new SoccerTeam("Team2", mls,
        5, 11,
        new Record(4,0,1),
        new Point(12,0, 0), testGame);
  }

  @Test
  public void compareTeams() throws TiedTeamsException {
    // Test case 1: compare two teams and return the one with higher points
    // chiBears should be return because it has more points than seaHawks
    assertEquals(team2, mls.compareTeams(team1, team2));

    // Test case 2: compare two teams with same points, return the one with higher winNum
    // generate a team with same points but more winNum with seaHawks, for test purpose
    SoccerTeam team3 = new SoccerTeam("Team3",
        mls, 5, 11,
        new Record(4, 0, 0),
        new Point(9, 1, 0), testGame);
    // team3 should be return
    assertEquals(team3, mls.compareTeams(team1, team3));
  }

  @Test
  public void leaguePlayGame() throws FutureGameException, TiedGameException, InvalidGameException {
    // Step 1: schedule a new game and check the data of each team
    Game newScheduledGame = mls.scheduleGame(team1, team2, gameDate);
    assertEquals(null, newScheduledGame.getHomeScore());
    assertEquals(new Integer(5), team1.getGamePlayedNum());
    assertEquals(new Integer(5), team2.getGamePlayedNum());
    assertEquals(new Integer(1), team1.getRecord().getLoseNum());
    assertEquals(new Integer(4), team2.getRecord().getWinNum());
    assertEquals(new Integer(10), team1.getPoint().getTotalPoint());

    // Step 2: play the scheduled game, check the related data of each team base on game result
    Game playedGame = mls.leaguePlayGame(newScheduledGame, team1, team2,14,21);
    assertEquals(new Integer(14), playedGame.getHomeScore());
    assertEquals(new Integer(6), team1.getGamePlayedNum());
    assertEquals(new Integer(6), team2.getGamePlayedNum());
    assertEquals(new Integer(2), team1.getRecord().getLoseNum());
    assertEquals(new Integer(5), team2.getRecord().getWinNum());
    assertEquals(new Integer(11), team1.getPoint().getTotalPoint());
    assertEquals(new Integer(16), team2.getPoint().getTotalPoint());

    // test if the game updated as the last game of two teams
    assertEquals(playedGame, team1.getLastGame());
    assertEquals(team2.getTeamName(), team2.getLastGame().getWinner());
  }

  @Test
  public void scheduleGame() {
    mls.scheduleGame(team1, team2, gameDate);
    assertEquals("Team1",mls.getNextGame().getHomeTeamName());
    assertEquals("Team2",mls.getNextGame().getAwayTeamName());
    assertEquals(gameDate, mls.getNextGame().getGameDate());
    assertEquals(Sport.SOCCER, mls.getNextGame().getSportType());
  }
}