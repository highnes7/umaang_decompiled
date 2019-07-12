package f.libs.asm.asm;

import f.c.a.a.I;
import f.c.a.a.d;
import java.util.Map;

public abstract class b<T extends I>
  extends d<T>
{
  public final c c = new c(v);
  
  public b() {}
  
  public Map a()
  {
    return c.c;
  }
  
  public abstract String getId();
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("{type:\"");
    localStringBuilder.append(getId());
    localStringBuilder.append('"');
    localStringBuilder.append(", predefinedAttributes:");
    localStringBuilder.append(c);
    localStringBuilder.append(", customAttributes:");
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, c, "}");
  }
}
