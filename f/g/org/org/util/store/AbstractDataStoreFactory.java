package f.g.org.org.util.store;

import f.g.b.a.g.b.d;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractDataStoreFactory
  implements DataStoreFactory
{
  public static final Pattern ID_PATTERN = Pattern.compile("\\w{1,30}");
  public final Map<String, d<? extends Serializable>> dataStoreMap = new HashMap();
  public final Lock lock = new ReentrantLock();
  
  public AbstractDataStoreFactory() {}
  
  public abstract DataStore createDataStore(String paramString)
    throws IOException;
  
  public final DataStore getDataStore(String paramString)
    throws IOException
  {
    Preconditions.checkArgument(ID_PATTERN.matcher(paramString).matches(), "%s does not match pattern %s", new Object[] { paramString, ID_PATTERN });
    lock.lock();
    try
    {
      DataStore localDataStore2 = (DataStore)dataStoreMap.get(paramString);
      DataStore localDataStore1 = localDataStore2;
      if (localDataStore2 == null)
      {
        localDataStore2 = createDataStore(paramString);
        localDataStore1 = localDataStore2;
        dataStoreMap.put(paramString, localDataStore2);
      }
      lock.unlock();
      return localDataStore1;
    }
    catch (Throwable paramString)
    {
      lock.unlock();
      throw paramString;
    }
  }
}
