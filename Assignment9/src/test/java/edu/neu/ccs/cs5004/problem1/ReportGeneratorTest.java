package edu.neu.ccs.cs5004.problem1;

import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class ReportGeneratorTest {
  String[] args1;
  String[] args2;

  @Before
  public void setUp() throws Exception {
    args1 = new String[]{"--email", "--email-template", "email-template.txt", "--output-dir",
        "C:\\Users\\roych\\Documents\\CS5004\\Assignment9\\output\\",
        "--csv-file", "insurance_company_members.csv"};

    args2 = new String[]{"--letter", "--letter-template", "letter-template.txt", "--output-dir",
        "C:\\Users\\roych\\Documents\\CS5004\\Assignment9\\output\\",
        "--csv-file", "insurance_company_members.csv"};

  }

  @Test
  public void testMain() throws IOException {
    ReportGenerator.main(args1);
    ReportGenerator.main(args2);
  }
}