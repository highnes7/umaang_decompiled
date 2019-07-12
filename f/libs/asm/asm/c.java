package f.libs.asm.asm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class c
{
  public final Map<String, Object> c = new ConcurrentHashMap();
  public final ByteVector d;
  
  public c(ByteVector paramByteVector)
  {
    d = paramByteVector;
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (!d.add(c, paramString)) {
      c.put(paramString, paramObject);
    }
  }
  
  public void add(String paramString, Number paramNumber)
  {
    if (!d.add(paramString, "key"))
    {
      if (d.add(paramNumber, "value")) {
        return;
      }
      a(d.get(paramString), paramNumber);
    }
  }
  
  public void add(String paramString1, String paramString2)
  {
    if (!d.add(paramString1, "key"))
    {
      if (d.add(paramString2, "value")) {
        return;
      }
      a(d.get(paramString1), d.get(paramString2));
    }
  }
  
  public String toString()
  {
    return new JSONObject(c).toString();
  }
}
