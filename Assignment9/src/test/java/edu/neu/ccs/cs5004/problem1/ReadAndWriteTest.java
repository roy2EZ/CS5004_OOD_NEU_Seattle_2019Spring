package edu.neu.ccs.cs5004.problem1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class ReadAndWriteTest {
  String[] args1;
  String cat;
  String tmpName;
  String output;
  String[] allInformation;
  Map<Integer, String> map;
  ReadAndWriter rw;
  CategoryClassifier cc;
  List<String> list;



  @Before
  public void setUp() throws Exception {

    allInformation = new String[3];
    allInformation[0] = "\"James\",\"Butt\",\"Benton, John B Jr\",\"6649 N Blue Gum St\",\"New Orleans\",\"Orleans\",\"LA\",\"70116\",\"504-621-8927\",\"504-845-1427\",\"jbutt@gmail.com\",\"http://www.bentonjohnbjr.com\"";
    map = new HashMap<>();
    cat = "--email";
    tmpName = "email-template.txt";
    output = "C:\\Users\\roych\\Documents\\CS5004\\Assignment9\\output\\";
    rw = new ReadAndWriter();
    map.put(0,"[[first_name]]");
    map.put(1,"[[last_name]]");
    map.put(10,"[[email]]");


  }

  @Test
  public void readAndWriteTemplate() {
    rw.readAndWriteTemplate(tmpName, 0, allInformation, cat, map, output);

    // test not valid template file name
    rw.readAndWriteTemplate("not valid", 0, allInformation, cat, map, output);

  }
}
