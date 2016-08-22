import java.util.regex.*;

public class testRegex {

  private static Pattern pattern;
  private static Matcher matcher;

  public static String main(String pat, String match) {
    pattern = Pattern.compile(pat);
    matcher = pattern.matcher(match);
    boolean b = matcher.matches();
    if (b) {
      for (int i = 1; i <= matcher.groupCount(); i++) {
        return matcher.group(i);
      }
    }
    else
      System.out.println("Rien n'a été trouvé.");
      return "None";
  }
}