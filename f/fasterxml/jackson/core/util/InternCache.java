package f.fasterxml.jackson.core.util;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public final class InternCache
  extends LinkedHashMap<String, String>
{
  public static final int MAX_ENTRIES = 100;
  public static final InternCache instance = new InternCache();
  
  public InternCache()
  {
    super(100, 0.8F, true);
  }
  
  public String intern(String paramString)
  {
    try
    {
      String str2 = (String)get(paramString);
      String str1 = str2;
      if (str2 == null)
      {
        paramString = paramString.intern();
        str1 = paramString;
        put(paramString, paramString);
      }
      return str1;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public boolean removeEldestEntry(Map.Entry paramEntry)
  {
    return size() > 100;
  }
}
