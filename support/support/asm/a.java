package support.support.asm;

import b.b.a.N;
import java.util.HashMap;
import java.util.Map;

@N({b.b.a.N.a.b})
public class a
{
  public Map<String, Integer> d = new HashMap();
  
  public a() {}
  
  public boolean a(String paramString, int paramInt)
  {
    Integer localInteger = (Integer)d.get(paramString);
    int j = 0;
    int i;
    if (localInteger != null) {
      i = localInteger.intValue();
    } else {
      i = 0;
    }
    if ((i & paramInt) != 0) {
      j = 1;
    }
    d.put(paramString, Integer.valueOf(paramInt | i));
    return j ^ 0x1;
  }
}
