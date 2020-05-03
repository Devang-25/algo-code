package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Strings;

public class RegexMatcher {

  private static final Pattern ATTRIBUTION_REGEX = Pattern
      .compile("(userAcquired(?:Engaged)?|lastClick|lastEngaged)(Adwords)?(?:Session)?(\\w+)(.*)");

  public static void main(String[] args) {
    String[] testStrings = new String[] { "lastEngagedCampaignAdGroupName", "asdifhaks",
        "userAcquiredEngagedCampaignAdGroupName", "userAcquiredCampaignAdGroupName",
        "lastClickAdwordsSessionAdGroupName", };

    for (String s : testStrings) {
      Matcher m = ATTRIBUTION_REGEX.matcher(s);
      if (m.find()) {
        System.out.println(m.groupCount());
        List<String> groups = new ArrayList<>();
        for (int i = 0; i < m.groupCount(); i++) {
          groups.add(m.group(i));
        }
        if (m.group(1).contentEquals("lastEngaged") || m.group(1).contentEquals("userAcquiredEngaged")) {
          if (Strings.nullToEmpty(m.group(3)).contentEquals("Adwords")) {
            System.out.println("ADWORD_PREFERRED_LAST_ENGAGEMENT");
          } else {
            System.out.println("CROSS_CHANNEL_LAST_ENGAGEMENT");
          }
        } else {
          if (m.group(1).contentEquals("lastClick") || m.group(1).contentEquals("userAcquired")) {
            if (Strings.nullToEmpty(m.group(3)).contentEquals("Adwords")) {
              System.out.println("ADWORD_PREFERRED_LAST_CLICK");
            } else {
              System.out.println("CROSS_CHANNEL_LAST_CLICK");
            }
          }
        }
      }
    }
  }
}
