package f.g.org.org.util.store;

import f.g.b.a.g.b.c;
import java.io.IOException;
import java.io.Serializable;

public class MemoryDataStoreFactory
  extends AbstractDataStoreFactory
{
  public MemoryDataStoreFactory() {}
  
  public static MemoryDataStoreFactory getDefaultInstance()
  {
    return InstanceHolder.INSTANCE;
  }
  
  public DataStore createDataStore(String paramString)
    throws IOException
  {
    return new MemoryDataStore(paramString);
  }
  
  public class InstanceHolder
  {
    public static final MemoryDataStoreFactory INSTANCE = new MemoryDataStoreFactory();
    
    public InstanceHolder() {}
  }
  
  public class MemoryDataStore<V extends Serializable>
    extends c<V>
  {
    public MemoryDataStore(String paramString)
    {
      super(paramString);
    }
    
    public MemoryDataStoreFactory getDataStoreFactory()
    {
      return (MemoryDataStoreFactory)dataStoreFactory;
    }
  }
}
