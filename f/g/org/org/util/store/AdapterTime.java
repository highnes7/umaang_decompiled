package f.g.org.org.util.store;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public final class AdapterTime
{
  public AdapterTime() {}
  
  public static String toString(DataStore paramDataStore)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('{');
      int i = 1;
      Iterator localIterator = paramDataStore.keySet().iterator();
      for (;;)
      {
        boolean bool = localIterator.hasNext();
        if (!bool) {
          break;
        }
        Object localObject = localIterator.next();
        localObject = (String)localObject;
        if (i != 0) {
          i = 0;
        } else {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append((String)localObject);
        localStringBuilder.append('=');
        localStringBuilder.append(paramDataStore.get((String)localObject));
      }
      localStringBuilder.append('}');
      paramDataStore = localStringBuilder.toString();
      return paramDataStore;
    }
    catch (IOException paramDataStore)
    {
      paramDataStore = new RuntimeException(paramDataStore);
      throw paramDataStore;
    }
  }
}
