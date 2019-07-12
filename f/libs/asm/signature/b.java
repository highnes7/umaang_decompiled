package f.libs.asm.signature;

import f.c.a.b.a;
import java.util.Collections;
import java.util.Map;
import l.a.a.a.Log;
import l.a.a.a.a.b.q;
import l.a.a.a.f;
import l.a.a.a.n;

public class b
  extends n<Boolean>
  implements q
{
  public static final String a = "Beta";
  
  public b() {}
  
  public static b a()
  {
    return (b)f.add(a.class);
  }
  
  public String c()
  {
    return "1.2.10.27";
  }
  
  public String getId()
  {
    return "com.crashlytics.sdk.android:beta";
  }
  
  public Map getNested()
  {
    return Collections.emptyMap();
  }
  
  public Boolean run()
  {
    f.get().d("Beta", "Beta kit initializing...");
    return Boolean.valueOf(true);
  }
}
