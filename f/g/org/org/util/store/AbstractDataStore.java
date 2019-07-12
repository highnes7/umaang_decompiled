package f.g.org.org.util.store;

import f.g.b.a.g.b.d;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

public abstract class AbstractDataStore<V extends Serializable>
  implements d<V>
{
  public final DataStoreFactory dataStoreFactory;
  public final String id;
  
  public AbstractDataStore(DataStoreFactory paramDataStoreFactory, String paramString)
  {
    if (paramDataStoreFactory != null)
    {
      dataStoreFactory = paramDataStoreFactory;
      if (paramString != null)
      {
        id = paramString;
        return;
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public boolean containsKey(String paramString)
    throws IOException
  {
    return get(paramString) != null;
  }
  
  public boolean containsValue(Serializable paramSerializable)
    throws IOException
  {
    return values().contains(paramSerializable);
  }
  
  public DataStoreFactory getDataStoreFactory()
  {
    return dataStoreFactory;
  }
  
  public final String getId()
  {
    return id;
  }
  
  public boolean isEmpty()
    throws IOException
  {
    return size() == 0;
  }
  
  public int size()
    throws IOException
  {
    return keySet().size();
  }
}
