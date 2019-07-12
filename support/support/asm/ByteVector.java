package support.support.asm;

import b.a.b.a.b;
import b.a.b.h.a;
import java.util.List;
import java.util.Map;

public class ByteVector
{
  public final Map<a.b, h.a> a;
  public final Map<h.a, List<a.b>> b;
  
  public ByteVector(Map paramMap) {}
  
  public static void a(List paramList, d paramD, c paramC, Object paramObject)
  {
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        ((Label)paramList.get(i)).a(paramD, paramC, paramObject);
        i -= 1;
      }
    }
  }
  
  public void a(d paramD, c paramC, Object paramObject)
  {
    a((List)b.get(paramC), paramD, paramC, paramObject);
    a((List)b.get(c.ON_ANY), paramD, paramC, paramObject);
  }
}
