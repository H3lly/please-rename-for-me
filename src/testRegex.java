import java.util.regex.*;

public class testRegex {

  private static Pattern pattern;
  private static Matcher matcher;

  public static String[] match(String pat, String match) {
    pattern = Pattern.compile(pat);
    matcher = pattern.matcher(match);
    boolean b = matcher.matches();
    String[] groupList = new String[1];
    groupList[0] = "None";
    if (b) {
      groupList = new String[matcher.groupCount()+1];
      for (int i = 0; i <= matcher.groupCount(); i++) {
        groupList[i] = matcher.group(i);
      }
      return groupList;
    }
    return groupList;
  }

  public static String match_group(String pat, String match, int group) {
    pattern = Pattern.compile(pat);
    matcher = pattern.matcher(match);
    boolean b = matcher.matches();
    if (b) {
      for (int i = 0; i <= matcher.groupCount(); i++) {
        if (i == group)
          return matcher.group(i);
      }
    }
    return "None";
  }
}