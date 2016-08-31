public class MainExecV1 {

  public static String userInput() {
    return "NONE";
  }

  public static String[] getFileListV1() {
    String[] fileList = { "Amercian Horror Story S1E1", "american horror story S01E02", "american horror story 1X3",
        "AHS Saison 1 Episode 4", "ash Saison01.Episode05 " };
    return fileList;
  }

  public static String[] rename(String[] fileList, /* String nameFormat, */ String name) {
    for (int i = 0; i < fileList.length; ++i) {
      String[] tab = testRegex.match(".*S(\\d+)E(\\d+).*", fileList[i]);
      if (tab[0] != "None") {
        String season = tab[1];
        if (season.length() == 1)
          season = "0" + season;
        String episode = tab[2];
        if (episode.length() == 1)
          episode = "0" + episode;
        fileList[i] = name + " S" + season + "E" + episode;
      } else {
        tab = testRegex.match(".*(\\d+).(\\d+).*", fileList[i]);
        if (tab[0] != "None") {
          String season = tab[1];
          if (season.length() == 1)
            season = "0" + season;
          String episode = tab[2];
          if (episode.length() == 1)
            episode = "0" + episode;
          fileList[i] = name + " S" + season + "E" + episode;
        } else {
          tab = testRegex.match(".*.aison ?(\\d+).*.pisode ?(\\d+) ?.*", fileList[i]);
          if (tab[0] != "None") {
            String season = tab[1];
            if (season.length() == 1)
              season = "0" + season;
            String episode = tab[2];
            if (episode.length() == 1)
              episode = "0" + episode;
            fileList[i] = name + " S" + season + "E" + episode;
          }
        }
      }
    }
    return fileList;
  }

  public static String getName() {
    String tmp = "American Horror Story";
    return tmp;
  }

  public static void main(String[] args) {
    String[] fileList = getFileListV1();
    String name = getName();
    String[] renamed = rename(fileList, name);
    System.out.println(renamed[0] + "\n" + renamed[1] + "\n" + renamed[2] + "\n" + renamed[3] + "\n" + renamed[4]);
  }
}
