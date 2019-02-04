package problem3;

import java.time.Year;

/**
 * represent an publication with title, author and year
 */
public abstract class AbstractPublication implements IPublication {

  protected String title;
  protected String author;
  protected Year year;

  /**
   * @param title The title of the publication
   * @param author the author of the publication
   * @param year the year that publication published
   */
  public AbstractPublication(String title, String author, Year year) {
    this.title = title;
    this.author = author;
    this.year = year;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public Year getYear() {
    return year;
  }
}
