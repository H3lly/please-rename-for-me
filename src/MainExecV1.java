public class MainExecV1 {

  public static String userInput() {
    return "NONE";
  }

  public static String[] getFileListV1() {
    String[] fileList = { "Sense8 S1E1", "S01E02", "5X3", "Saison 1 Episode 4", "Saison01.Episode05 " };
    return fileList;
  }

//  public static String getNameFormatV1(int n) {
//    if (n == 1)
//      return "S[0-9]+E[0-9]+";
//    if (n == 2)
//      return "S0[0-9]+E0[0-9]+";
//    if (n == 3)
//      return "[0-9]+x[0-9]+";
//    if (n == 4)
//      return "Saison [0-9]+ Episode [0-9]+";
//    else
//      return "Saison\\.[0-9]+\\.Episode\\.[0-9]+";
//  }

  public static String[] rename(String[] fileList, /* String nameFormat, */ String name) {
    for (int i = 0; i < fileList.length; ++i) {
      String tmp = testRegex.main(".*(S\\d*E\\d*).*", fileList[i]);
      if (tmp != "None") {
        String season = testRegex.main(".*S(\\d*)E\\d*.*", tmp);
        int sint = Integer.parseInt(season);
        if (sint < 10)
          season = "0" + sint;
        String episode = testRegex.main(".*S\\d*E(\\d*).*", tmp);
        int sepisode = Integer.parseInt(episode);
        if (sepisode < 10)
          episode = "0" + sepisode;
        fileList[i] = name + " - " + "S" + season + "E" + episode;
      } else {
        tmp = testRegex.main("\\D*(\\d*X\\d*)\\D*", fileList[i]);
        if (tmp != "None") {
          System.out.println("heho");
          String season = testRegex.main("\\D*(\\d*)X.*", tmp);
          System.out.println("Season = " + season);
          int sint = Integer.parseInt(season);
          if (sint < 10)
            season = "0" + sint;
          String episode = testRegex.main(".*X(\\d*).*", tmp);
          int sepisode = Integer.parseInt(episode);
          if (sepisode < 10)
            episode = "0" + sepisode;
          fileList[i] = name + " - " + "S" + season + "E" + episode;
        }
      }
    }
    return fileList;
  }

  public static void main(String[] args) {
    String[] fileList = getFileListV1();
    // String nameFormat = getNameFormatV1(1);
    String[] renamed = rename(fileList, /* nameFormat, */ "American Horror Story");
    System.out.println("\n" + renamed[0] + "\n" + renamed[1]+ "\n" + renamed[2]+ "\n" + renamed[3]+ "\n" + renamed[4]);
  }
}
