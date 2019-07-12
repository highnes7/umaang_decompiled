package support.android.v4.text.view;

import b.b.a.N;
import java.util.Locale;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

@N({b.b.a.N.a.b})
public class Pattern
{
  public static final String ACTION_ERROR = "(?:one|\\d+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)";
  public static final String ACTION_UPDATE_ALL = ",*?\t ????????????????\n\013\f\r???";
  public static final String CANCEL_MENU = "(?=[,*?\t ????????????????\n\013\f\r???]|$)";
  public static final String EVENTLOG_URL = ":,\"'\t ????????????????\n\013\f\r???";
  public static final String EXTRA_SEARCH_TERM = ",\"'\t ????????????????\n\013\f\r???";
  public static final String MODULE_PACKAGE = "(?=[,\"'\t ????????????????\n\013\f\r???]|$)";
  public static final int NONE = 4;
  public static final int NO_NODE = 14;
  public static final int NUMBER_OF_TYPES = 5;
  public static final java.util.regex.Pattern P = java.util.regex.Pattern.compile("(?:\\d{5}(?:-\\d{4})?)(?=[,*?\t ????????????????\n\013\f\r???]|$)", 2);
  public static final String PAGE_KEY = "\t ????????????????\n\013\f\r???";
  public static final int TAG_GPS_DEST_DISTANCE_REF = 25;
  public static final int TRANSACTION_getInfo = 5;
  public static final java.util.regex.Pattern b;
  public static final f[] c = { new f(99, 99, -1, -1), new f(35, 36, -1, -1), new f(71, 72, -1, -1), new f(96, 96, -1, -1), new f(85, 86, -1, -1), new f(90, 96, -1, -1), new f(80, 81, -1, -1), new f(6, 6, -1, -1), new f(20, 20, -1, -1), new f(19, 19, -1, -1), new f(32, 34, -1, -1), new f(96, 96, -1, -1), new f(30, 31, -1, -1), new f(96, 96, -1, -1), new f(96, 96, -1, -1), new f(50, 52, -1, -1), new f(83, 83, -1, -1), new f(60, 62, -1, -1), new f(46, 47, -1, -1), new f(66, 67, 73, -1), new f(40, 42, -1, -1), new f(70, 71, -1, -1), new f(1, 2, -1, -1), new f(20, 21, -1, -1), new f(3, 4, -1, -1), new f(96, 96, -1, -1), new f(48, 49, -1, -1), new f(55, 56, -1, -1), new f(63, 65, -1, -1), new f(96, 96, -1, -1), new f(38, 39, -1, -1), new f(55, 56, -1, -1), new f(27, 28, -1, -1), new f(58, 58, -1, -1), new f(68, 69, -1, -1), new f(3, 4, -1, -1), new f(7, 8, -1, -1), new f(87, 88, 86, -1), new f(88, 89, 96, -1), new f(10, 14, 0, 6), new f(43, 45, -1, -1), new f(73, 74, -1, -1), new f(97, 97, -1, -1), new f(15, 19, -1, -1), new f(6, 6, 0, 9), new f(96, 96, -1, -1), new f(2, 2, -1, -1), new f(29, 29, -1, -1), new f(57, 57, -1, -1), new f(37, 38, -1, -1), new f(75, 79, 87, 88), new f(84, 84, -1, -1), new f(22, 24, 20, -1), new f(6, 9, -1, -1), new f(5, 5, -1, -1), new f(98, 99, -1, -1), new f(53, 54, -1, -1), new f(24, 26, -1, -1), new f(82, 83, -1, -1) };
  public static final java.util.regex.Pattern p;
  public static final java.util.regex.Pattern r = java.util.regex.Pattern.compile("[^,*?\t ????????????????\n\013\f\r???]+(?=[,*?\t ????????????????\n\013\f\r???]|$)", 2);
  public static final String string = "\t ????????????????";
  public static final java.util.regex.Pattern tokens;
  public static final java.util.regex.Pattern uriPattern;
  public static final String value = "\n\013\f\r???";
  
  static
  {
    b = java.util.regex.Pattern.compile("(?:one|\\d+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)(?:-(?:one|\\d+([a-z](?=[^a-z]|$)|st|nd|rd|th)?))*(?=[,\"'\t ????????????????\n\013\f\r???]|$)", 2);
    uriPattern = java.util.regex.Pattern.compile("(?:(ak|alaska)|(al|alabama)|(ar|arkansas)|(as|american[\t ????????????????]+samoa)|(az|arizona)|(ca|california)|(co|colorado)|(ct|connecticut)|(dc|district[\t ????????????????]+of[\t ????????????????]+columbia)|(de|delaware)|(fl|florida)|(fm|federated[\t ????????????????]+states[\t ????????????????]+of[\t ????????????????]+micronesia)|(ga|georgia)|(gu|guam)|(hi|hawaii)|(ia|iowa)|(id|idaho)|(il|illinois)|(in|indiana)|(ks|kansas)|(ky|kentucky)|(la|louisiana)|(ma|massachusetts)|(md|maryland)|(me|maine)|(mh|marshall[\t ????????????????]+islands)|(mi|michigan)|(mn|minnesota)|(mo|missouri)|(mp|northern[\t ????????????????]+mariana[\t ????????????????]+islands)|(ms|mississippi)|(mt|montana)|(nc|north[\t ????????????????]+carolina)|(nd|north[\t ????????????????]+dakota)|(ne|nebraska)|(nh|new[\t ????????????????]+hampshire)|(nj|new[\t ????????????????]+jersey)|(nm|new[\t ????????????????]+mexico)|(nv|nevada)|(ny|new[\t ????????????????]+york)|(oh|ohio)|(ok|oklahoma)|(or|oregon)|(pa|pennsylvania)|(pr|puerto[\t ????????????????]+rico)|(pw|palau)|(ri|rhode[\t ????????????????]+island)|(sc|south[\t ????????????????]+carolina)|(sd|south[\t ????????????????]+dakota)|(tn|tennessee)|(tx|texas)|(ut|utah)|(va|virginia)|(vi|virgin[\t ????????????????]+islands)|(vt|vermont)|(wa|washington)|(wi|wisconsin)|(wv|west[\t ????????????????]+virginia)|(wy|wyoming))(?=[,*?\t ????????????????\n\013\f\r???]|$)", 2);
    p = java.util.regex.Pattern.compile("(?:alley|annex|arcade|ave[.]?|avenue|alameda|bayou|beach|bend|bluffs?|bottom|boulevard|branch|bridge|brooks?|burgs?|bypass|broadway|camino|camp|canyon|cape|causeway|centers?|circles?|cliffs?|club|common|corners?|course|courts?|coves?|creek|crescent|crest|crossing|crossroad|curve|circulo|dale|dam|divide|drives?|estates?|expressway|extensions?|falls?|ferry|fields?|flats?|fords?|forest|forges?|forks?|fort|freeway|gardens?|gateway|glens?|greens?|groves?|harbors?|haven|heights|highway|hills?|hollow|inlet|islands?|isle|junctions?|keys?|knolls?|lakes?|land|landing|lane|lights?|loaf|locks?|lodge|loop|mall|manors?|meadows?|mews|mills?|mission|motorway|mount|mountains?|neck|orchard|oval|overpass|parks?|parkways?|pass|passage|path|pike|pines?|plains?|plaza|points?|ports?|prairie|privada|radial|ramp|ranch|rapids?|rd[.]?|rest|ridges?|river|roads?|route|row|rue|run|shoals?|shores?|skyway|springs?|spurs?|squares?|station|stravenue|stream|st[.]?|streets?|summit|speedway|terrace|throughway|trace|track|trafficway|trail|tunnel|turnpike|underpass|unions?|valleys?|viaduct|views?|villages?|ville|vista|walks?|wall|ways?|wells?|xing|xrd)(?=[,*?\t ????????????????\n\013\f\r???]|$)", 2);
    tokens = java.util.regex.Pattern.compile("(\\d+)(st|nd|rd|th)", 2);
  }
  
  public Pattern() {}
  
  public static String format(String paramString)
  {
    Matcher localMatcher = b.matcher(paramString);
    int i = 0;
    while (localMatcher.find(i)) {
      if (get(localMatcher.group(0)))
      {
        i = localMatcher.start();
        int j = parse(paramString, localMatcher);
        if (j > 0) {
          return paramString.substring(i, j);
        }
        i = -j;
      }
      else
      {
        i = localMatcher.end();
      }
    }
    return null;
  }
  
  public static boolean get(String paramString)
  {
    int i = 0;
    int k;
    for (int j = 0; i < paramString.length(); j = k)
    {
      k = j;
      if (Character.isDigit(paramString.charAt(i))) {
        k = j + 1;
      }
      i += 1;
    }
    if (j > 5) {
      return false;
    }
    paramString = tokens.matcher(paramString);
    if (paramString.find())
    {
      i = Integer.parseInt(paramString.group(1));
      if (i == 0) {
        return false;
      }
      String str = paramString.group(2).toLowerCase(Locale.getDefault());
      j = i % 10;
      paramString = "th";
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3) {
            return str.equals("th");
          }
          if (i % 100 != 13) {
            paramString = "rd";
          }
          return str.equals(paramString);
        }
        if (i % 100 != 12) {
          paramString = "nd";
        }
        return str.equals(paramString);
      }
      if (i % 100 != 11) {
        paramString = "st";
      }
      return str.equals(paramString);
    }
    return true;
  }
  
  public static MatchResult getValue(String paramString, int paramInt)
  {
    if ((paramInt > 0) && (":,\"'\t ????????????????\n\013\f\r???".indexOf(paramString.charAt(paramInt - 1)) == -1)) {
      return null;
    }
    paramString = b.matcher(paramString).region(paramInt, paramString.length());
    if (paramString.lookingAt())
    {
      paramString = paramString.toMatchResult();
      if (get(paramString.group(0))) {
        return paramString;
      }
    }
    return null;
  }
  
  public static boolean getValue(String paramString)
  {
    return P.matcher(paramString).matches();
  }
  
  public static boolean invoke(String paramString1, String paramString2)
  {
    return match(paramString1, parse(paramString2, 0));
  }
  
  public static boolean match(String paramString, MatchResult paramMatchResult)
  {
    if (paramMatchResult == null) {
      return false;
    }
    int j;
    for (int i = paramMatchResult.groupCount();; i = j)
    {
      j = i;
      if (i <= 0) {
        break;
      }
      j = i - 1;
      if (paramMatchResult.group(i) != null) {
        break;
      }
    }
    return (P.matcher(paramString).matches()) && (c[j].add(paramString));
  }
  
  public static boolean matches(String paramString)
  {
    return p.matcher(paramString).matches();
  }
  
  public static int parse(String paramString, MatchResult paramMatchResult)
  {
    int j = paramMatchResult.end();
    Matcher localMatcher = r.matcher(paramString);
    paramMatchResult = "";
    int i3 = 1;
    int i4 = 1;
    int i2 = 1;
    int i1 = 0;
    int k = -1;
    int i;
    int i7;
    for (int m = -1;; m = i7)
    {
      i = j;
      if (j >= paramString.length()) {
        break;
      }
      if (!localMatcher.find(j)) {}
      for (i = paramString.length();; i = localMatcher.end())
      {
        return -i;
        i = j;
        if (localMatcher.end() - localMatcher.start() <= 25) {
          break;
        }
      }
      while (i < localMatcher.start())
      {
        j = i3;
        if ("\n\013\f\r???".indexOf(paramString.charAt(i)) != -1) {
          j = i3 + 1;
        }
        i += 1;
        i3 = j;
      }
      if (i3 > 5) {
        break;
      }
      i4 += 1;
      if (i4 > 14) {
        break;
      }
      int n;
      int i5;
      int i6;
      if (getValue(paramString, i) != null)
      {
        if ((i2 != 0) && (i3 > 1)) {
          return -i;
        }
        n = i2;
        i5 = i1;
        i6 = k;
        i7 = m;
        if (k == -1)
        {
          n = i2;
          i5 = i1;
          i6 = i;
          i7 = m;
        }
      }
      else if (matches(localMatcher.group(0)))
      {
        n = 0;
        i5 = 1;
        i6 = k;
        i7 = m;
      }
      else
      {
        if ((i4 == 5) && (i1 == 0))
        {
          i = localMatcher.end();
          break;
        }
        j = m;
        if (i1 != 0)
        {
          j = m;
          if (i4 > 4)
          {
            MatchResult localMatchResult = parse(paramString, i);
            j = m;
            if (localMatchResult != null)
            {
              if ((paramMatchResult.equals("et")) && (localMatchResult.group(0).equals("al")))
              {
                i = localMatchResult.end();
                break;
              }
              paramMatchResult = r.matcher(paramString);
              if (paramMatchResult.find(localMatchResult.end()))
              {
                j = m;
                if (match(paramMatchResult.group(0), localMatchResult)) {
                  return paramMatchResult.end();
                }
              }
              else
              {
                j = localMatchResult.end();
              }
            }
          }
        }
        n = 0;
        i7 = j;
        i6 = k;
        i5 = i1;
      }
      paramMatchResult = localMatcher.group(0);
      j = localMatcher.end();
      i2 = n;
      i1 = i5;
      k = i6;
    }
    if (m > 0) {
      return m;
    }
    if (k > 0) {
      i = k;
    }
    return -i;
  }
  
  public static MatchResult parse(String paramString, int paramInt)
  {
    if ((paramInt > 0) && (",*?\t ????????????????\n\013\f\r???".indexOf(paramString.charAt(paramInt - 1)) == -1)) {
      return null;
    }
    paramString = uriPattern.matcher(paramString).region(paramInt, paramString.length());
    if (paramString.lookingAt()) {
      return paramString.toMatchResult();
    }
    return null;
  }
}
