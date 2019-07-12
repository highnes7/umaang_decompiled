package l.a.a.a.a.b;

import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l.a.a.a.a.e.LayoutManager;
import l.a.a.a.a.e.MathArrays.OrderDirection;

public abstract class XYPlot
{
  public static final String A = "X-CRASHLYTICS-DEVELOPER-TOKEN";
  public static final String ACCEPT = "Accept";
  public static final String E = "android";
  public static final String F = "X-REQUEST-ID";
  public static final String I = "Crashlytics Android SDK/";
  public static final String T = "470fa2b4ae81cd56ecbcda9735803434cec591fa";
  public static final int UNKNOWN_INT = 10000;
  public static final String USER_AGENT = "User-Agent";
  public static final String e = "X-CRASHLYTICS-API-KEY";
  public static final String i = "application/json";
  public static final String l = "X-CRASHLYTICS-API-CLIENT-VERSION";
  public static final Pattern r = Pattern.compile("http(s?)://[^\\/]+", 2);
  public static final String w = "X-CRASHLYTICS-API-CLIENT-TYPE";
  public final MathArrays.OrderDirection c;
  public final String d;
  public final String g;
  public final LayoutManager j;
  public final l.a.a.a.Item o;
  
  public XYPlot(l.a.a.a.Item paramItem, String paramString1, String paramString2, LayoutManager paramLayoutManager, MathArrays.OrderDirection paramOrderDirection)
  {
    if (paramString2 != null)
    {
      if (paramLayoutManager != null)
      {
        o = paramItem;
        d = paramString1;
        g = a(paramString2);
        j = paramLayoutManager;
        c = paramOrderDirection;
        return;
      }
      throw new IllegalArgumentException("requestFactory must not be null.");
    }
    throw new IllegalArgumentException("url must not be null.");
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (!ClassWriter.put(d)) {
      str = r.matcher(paramString).replaceFirst(d);
    }
    return str;
  }
  
  public String a()
  {
    return g;
  }
  
  public l.a.a.a.a.e.Item b(Map paramMap)
  {
    paramMap = j.a(c, a(), paramMap).a(false).get(10000);
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Crashlytics Android SDK/");
    localStringBuilder.append(o.c());
    return paramMap.get("User-Agent", localStringBuilder.toString()).get("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
  }
  
  public l.a.a.a.a.e.Item d()
  {
    return b(Collections.emptyMap());
  }
}
