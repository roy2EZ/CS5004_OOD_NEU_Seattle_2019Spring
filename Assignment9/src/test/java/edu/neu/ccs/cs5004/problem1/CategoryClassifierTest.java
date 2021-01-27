package edu.neu.ccs.cs5004.problem1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class CategoryClassifierTest {
  CategoryClassifier cc;
  String[] args1;
  List<String> list;
  String cat;
  String tmpName;
  String output;

  @Before
  public void setUp() throws Exception {
    args1 = new String[]{"--email", "--email-template", "email-template.txt", "--output-dir",
        "C:\\Users\\Documents\\CS5004\\Assignment9\\output",
        "--csv-file", "insurance_company_members.csv"};
    list = Arrays.asList(args1);
    cc = new CategoryClassifier();

  }

  @Test
  public void classifyCategory() {
    cat = cc.classifyCategory(args1, list).category;
    tmpName = cc.classifyCategory(args1, list).templateName;
    output = cc.classifyCategory(args1, list).outPath;
    assertEquals("--email", cat);
    assertEquals("email-template.txt", tmpName);
    assertEquals("C:\\Users\\Documents\\CS5004\\Assignment9\\output", output);
  }
}