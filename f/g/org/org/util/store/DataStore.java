package f.g.org.org.util.store;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

public abstract interface DataStore<V extends Serializable>
{
  public abstract DataStore clear()
    throws IOException;
  
  public abstract boolean containsKey(String paramString)
    throws IOException;
  
  public abstract boolean containsValue(Serializable paramSerializable)
    throws IOException;
  
  public abstract DataStore delete(String paramString)
    throws IOException;
  
  public abstract Serializable get(String paramString)
    throws IOException;
  
  public abstract DataStoreFactory getDataStoreFactory();
  
  public abstract String getId();
  
  public abstract boolean isEmpty()
    throws IOException;
  
  public abstract Set keySet()
    throws IOException;
  
  public abstract DataStore set(String paramString, Serializable paramSerializable)
    throws IOException;
  
  public abstract int size()
    throws IOException;
  
  public abstract Collection values()
    throws IOException;
}
