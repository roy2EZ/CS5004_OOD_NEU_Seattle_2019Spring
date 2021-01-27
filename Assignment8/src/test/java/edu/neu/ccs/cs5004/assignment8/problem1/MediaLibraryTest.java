package edu.neu.ccs.cs5004.assignment8.problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class MediaLibraryTest {
  MediaLibrary testLib;
  HashMap<String, Media> library;

  // Matrix
  private String aliasM;
  private String titleM;
  private Year releaseYearM;
  private HashSet<Name> directorsM;
  private Name director1;
  private Name director2;
  private HashSet<Name> actorsM;
  private Name actor1;
  private Name actor2;
  private Name actor3;
  private Media matrix;

  // Cloud Atlas
  private String aliasC;
  private String titleC;
  private Year releaseYearC;
  private HashSet<Name> actorsC;
  private Name actor4;
  private Name actor5;
  private Name actor6;
  private HashSet<Name> directorsC;
  private Name director3;
  private Media cloudAtlas;
  
  @Before
  public void setUp() throws Exception {
    // media 1: Matrix
    aliasM = "Matrix";
    titleM = "The Matrix";
    releaseYearM = new Year(1999);

    // directors
    director1 = new Name("Lana", "Wachowski");
    director2 = new Name("Lilly", "Wachowski");
    directorsM = new HashSet<>();
    directorsM.add(director1);
    directorsM.add(director2);

    // actors
    actor1 = new Name("Keanu", "Reeves");
    actor2 = new Name("Laurence", "Fishburne");
    actor3 = new Name("Carrie-Anne", "Moss");
    actorsM = new HashSet<>();
    actorsM.add(actor1);
    actorsM.add(actor2);
    actorsM.add(actor3);

    matrix = new Media(aliasM, titleM, releaseYearM, directorsM, actorsM);

    // Media 2: Cloud Atlas
    aliasC = "cloudAtlas";
    titleC = "Cloud Atlas";
    actorsC = new HashSet<>();
    releaseYearC = new Year(2012);
    actor4 = new Name("Tom", "Hanks");
    actor5 = new Name("Halle", "Berry");
    actor6 = new Name("Hugh", "Grant");
    directorsC = new HashSet<>();
    director3 = new Name("Tom",  "Tykwer");
    directorsC.add(director3);
    directorsC.add(director1);
    cloudAtlas = new Media(aliasC, titleC, releaseYearC, directorsC, actorsC);
    // initial library
    library = new HashMap<>();
    testLib = new MediaLibrary(library);
    testLib.addMedia(matrix);
  }

  @Test
  public void directorMedia() throws SameAliasException {
    List<Media> result = testLib.directorMedia(director1);
    // director has just one movie Matrix
    assertTrue(result.contains(matrix));
    assertFalse(result.contains(cloudAtlas));

    // if the library did not include any media of a director, this method return an empty list.
    List<Media> result2 = testLib.directorMedia(director3);
    assertEquals(new ArrayList<>(), result2);
    assertFalse(result2.contains(matrix));
    assertFalse(result2.contains(cloudAtlas));

    // add another movie of the director
    testLib.addMedia(cloudAtlas);
    List<Media> updateResult = testLib.directorMedia(director1);
    // now should include the new added movie of that director
    assertTrue(updateResult.contains(cloudAtlas));
    assertTrue(updateResult.contains(matrix));

  }

  @Test(expected = SameAliasException.class)
  public void addSameMedia() throws SameAliasException {
    // add same media again
    testLib.addMedia(matrix);
  }
  @Test
  public void testAddStreamedTimes() throws NoSuchAliasException {
    assertEquals(new Integer(0),testLib.getStreamedTimes(aliasM));
    testLib.addStreamedTimes(aliasM);
    assertEquals(new Integer(1),testLib.getStreamedTimes(aliasM));
    testLib.addStreamedTimes(aliasM);
    assertEquals(new Integer(2),testLib.getStreamedTimes(aliasM));
    testLib.addStreamedTimes(aliasM);
    assertEquals(new Integer(3),testLib.getStreamedTimes(aliasM));

  }

  @Test(expected = NoSuchAliasException.class)
  public void testGetStreamedTimes() throws NoSuchAliasException {
    testLib.getStreamedTimes(aliasC);
  }

  @Test(expected = NoSuchAliasException.class)
  public void testAddNoSuchAlias() throws NoSuchAliasException {
    // movie aliasC is not in library yet, add steamed time will throw an exception
    testLib.addStreamedTimes(aliasC);
  }


  @Test
  public void getMostStreamedMedia() throws NoSuchAliasException, SameAliasException {
    // add another movie, now library had two movies
    testLib.addMedia(cloudAtlas);

    // movie M streamed 5 times
    for (int i = 0; i < 5; i++) {
      testLib.addStreamedTimes(aliasM);
    }
    // movie C streamed 3 times
    for (int i = 0; i < 3; i++) {
      testLib.addStreamedTimes(aliasC);
    }
    assertTrue(matrix.equals(testLib.getMostStreamedMedia()));

    // movie C streamed 3 more times
    for (int i = 0; i < 3; i++) {
      testLib.addStreamedTimes(aliasC);
    }
    // now the most streamed media updated to movie C
    assertTrue(cloudAtlas.equals(testLib.getMostStreamedMedia()));


  }

  @Test
  public void equals() throws SameAliasException, NoSuchAliasException {
    MediaLibrary same = new MediaLibrary(library);
    MediaLibrary copy = testLib;
    MediaLibrary another = copy;
    assertTrue(testLib.equals(testLib));
    assertTrue(testLib.equals(same));
    assertTrue(testLib.equals(copy));
    assertTrue(testLib.equals(another));
    assertFalse(testLib.equals(null));
    assertFalse(testLib.equals(actor1));
    // change streamed times and test equal
    testLib.addStreamedTimes(aliasM);
    copy.addStreamedTimes(aliasM);
    assertTrue(testLib.equals(copy));

    // create another media library with different movie
    HashMap<String, Media> library2 = new HashMap<>();
    MediaLibrary testLib2 = new MediaLibrary(library2);
    testLib2.addMedia(cloudAtlas);
    assertFalse(testLib.equals(testLib2));

  }

  @Test
  public void testHashCode() {
    MediaLibrary same = new MediaLibrary(library);
    assertTrue(testLib.hashCode() == same.hashCode());

  }

  @Test
  public void testToString() {
    assertEquals("MediaLibrary{{Matrix=The Matrix (or named \"Matrix\",1999), 2 directors, 3 actors, requestTime = 0}}", testLib.toString());
  }
}