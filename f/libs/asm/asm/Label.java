package f.libs.asm.asm;

import android.app.Activity;
import f.c.a.a.X;
import java.util.Collections;
import java.util.Map;

public final class Label
{
  public static final String ATTRIBUTE_ACTIVITY = "activity";
  public static final String REACHABLE = "sessionId";
  public static final String TARGET = "installedAt";
  public static final String i = "exceptionName";
  public final String a;
  public final TextOrientationType b;
  public final Map<String, Object> c;
  public final Map<String, String> d;
  public final m e;
  public final String f;
  public final long g;
  public final Map<String, Object> k;
  public String text;
  
  public Label(m paramM, long paramLong, TextOrientationType paramTextOrientationType, Map paramMap1, String paramString1, Map paramMap2, String paramString2, Map paramMap3)
  {
    e = paramM;
    g = paramLong;
    b = paramTextOrientationType;
    d = paramMap1;
    f = paramString1;
    k = paramMap2;
    a = paramString2;
    c = paramMap3;
  }
  
  public static Frame a(long paramLong)
  {
    return new Frame(TextOrientationType.u).b(Collections.singletonMap("installedAt", String.valueOf(paramLong)));
  }
  
  public static Frame a(TextOrientationType paramTextOrientationType, Activity paramActivity)
  {
    paramActivity = Collections.singletonMap("activity", paramActivity.getClass().getName());
    return new Frame(paramTextOrientationType).b(paramActivity);
  }
  
  public static Frame a(b paramB)
  {
    return new Frame(TextOrientationType.e).init(paramB.getId()).init(paramB.a()).a(paramB.getTitle());
  }
  
  public static Frame a(q paramQ)
  {
    return new Frame(TextOrientationType.a).b(paramQ.a()).a(paramQ.getTitle());
  }
  
  public static Frame a(String paramString)
  {
    paramString = Collections.singletonMap("sessionId", paramString);
    return new Frame(TextOrientationType.r).b(paramString);
  }
  
  public static Frame a(String paramString1, String paramString2)
  {
    return a(paramString1).a(Collections.singletonMap("exceptionName", paramString2));
  }
  
  public String toString()
  {
    if (text == null)
    {
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("[");
      localStringBuilder.append(X.class.getSimpleName());
      localStringBuilder.append(": ");
      localStringBuilder.append("timestamp=");
      localStringBuilder.append(g);
      localStringBuilder.append(", type=");
      localStringBuilder.append(b);
      localStringBuilder.append(", details=");
      localStringBuilder.append(d);
      localStringBuilder.append(", customType=");
      localStringBuilder.append(f);
      localStringBuilder.append(", customAttributes=");
      localStringBuilder.append(k);
      localStringBuilder.append(", predefinedType=");
      localStringBuilder.append(a);
      localStringBuilder.append(", predefinedAttributes=");
      localStringBuilder.append(c);
      localStringBuilder.append(", metadata=[");
      text = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, e, "]]");
    }
    return text;
  }
}
