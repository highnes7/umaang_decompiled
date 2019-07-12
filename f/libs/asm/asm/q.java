package f.libs.asm.asm;

import f.c.a.a.d;
import f.c.a.a.v;

public class q
  extends d<v>
{
  public final String d;
  
  public q(String paramString)
  {
    if (paramString != null)
    {
      d = v.get(paramString);
      return;
    }
    throw new NullPointerException("eventName must not be null");
  }
  
  public String a()
  {
    return d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("{eventName:\"");
    f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, d, '"', ", customAttributes:");
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, c, "}");
  }
}
