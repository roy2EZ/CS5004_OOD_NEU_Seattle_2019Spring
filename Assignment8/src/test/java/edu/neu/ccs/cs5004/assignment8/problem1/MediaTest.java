package edu.neu.ccs.cs5004.assignment8.problem1;

import static org.junit.Assert.*;

import java.util.HashSet;
import org.junit.Before;
import org.junit.Test;

public class MediaTest {
  private String alias;
  private String title;
  private Year releaseYear;
  private Year releaseYear1;
  private HashSet<Name> directors;
  private HashSet<Name> directors1;
  private Name director1;
  private Name director2;
  private HashSet<Name> actors;
  private HashSet<Name> actors1;
  private Name actor1;
  private Name actor2;
  private Name actor3;

  private Media matrix;

  @Before
  public void setUp() throws Exception {
    alias = "Matrix";
    title = "The Matrix";
    releaseYear = new Year(1999);
    releaseYear1 = new Year(1996);

    // directors
    director1 = new Name("Lana", "Wachowski");
    director2 = new Name("Lilly", "Wachowski");
    directors = new HashSet<>();
    directors1 = new HashSet<>();
    directors.add(director1);
    directors.add(director2);
    directors1.add(director1);
    // actors
    actor1 = new Name("Keanu", "Reeves");
    actor2 = new Name("Laurence", "Fishburne");
    actor3 = new Name("Carrie-Anne", "Moss");
    actors = new HashSet<>();
    actors1 = new HashSet<>();
    actors.add(actor1);
    actors.add(actor2);
    actors.add(actor3);
    actors1.add(actor1);

    matrix = new Media(alias, title, releaseYear, directors, actors);

  }

  @Test
  public void equals() {
    Media copy = matrix;
    Media same = new Media(alias, title, releaseYear, directors, actors);
    Media another = copy;
    assertTrue(matrix.equals(matrix));
    assertTrue(matrix.equals(copy));
    assertTrue(matrix.equals(same));
    assertTrue(matrix.equals(another));
    assertFalse(matrix.equals(null));
    assertFalse(matrix.equals(alias));

    Media diffMedia1 = new Media("diff", title, releaseYear, directors, actors);
    Media diffMedia2 = new Media(alias, "diff", releaseYear, directors, actors);
    Media diffMedia3 = new Media(alias, title, releaseYear1, directors, actors);
    Media diffMedia4 = new Media(alias, title, releaseYear, directors1, actors);
    Media diffMedia5 = new Media(alias, title, releaseYear, directors, actors1);
    assertFalse(matrix.equals(diffMedia1));
    assertFalse(matrix.equals(diffMedia2));
    assertFalse(matrix.equals(diffMedia3));
    assertFalse(matrix.equals(diffMedia4));
    assertFalse(matrix.equals(diffMedia5));
  }

  @Test
  public void testHashCode() {
    Media copy = matrix;
    assertTrue(matrix.hashCode() == copy.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("The Matrix (or named \"Matrix\",1999), 2 directors, 3 actors, requestTime = 0", matrix.toString());
  }
}