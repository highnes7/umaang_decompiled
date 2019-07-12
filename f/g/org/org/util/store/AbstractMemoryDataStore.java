package f.g.org.org.util.store;

import f.g.b.a.g.b.a;
import f.g.org.org.util.IOUtils;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AbstractMemoryDataStore<V extends Serializable>
  extends a<V>
{
  public HashMap<String, byte[]> keyValueMap = new HashMap();
  public final Lock lock = new ReentrantLock();
  
  public AbstractMemoryDataStore(DataStoreFactory paramDataStoreFactory, String paramString)
  {
    super(paramDataStoreFactory, paramString);
  }
  
  public final DataStore clear()
    throws IOException
  {
    lock.lock();
    try
    {
      keyValueMap.clear();
      save();
      lock.unlock();
      return this;
    }
    catch (Throwable localThrowable)
    {
      lock.unlock();
      throw localThrowable;
    }
  }
  
  public boolean containsKey(String paramString)
    throws IOException
  {
    if (paramString == null) {
      return false;
    }
    lock.lock();
    try
    {
      boolean bool = keyValueMap.containsKey(paramString);
      lock.unlock();
      return bool;
    }
    catch (Throwable paramString)
    {
      lock.unlock();
      throw paramString;
    }
  }
  
  public boolean containsValue(Serializable paramSerializable)
    throws IOException
  {
    if (paramSerializable == null) {
      return false;
    }
    lock.lock();
    try
    {
      paramSerializable = IOUtils.serialize(paramSerializable);
      Iterator localIterator = keyValueMap.values().iterator();
      boolean bool;
      do
      {
        bool = localIterator.hasNext();
        if (!bool) {
          break;
        }
        bool = Arrays.equals(paramSerializable, (byte[])localIterator.next());
      } while (!bool);
      lock.unlock();
      return true;
      lock.unlock();
      return false;
    }
    catch (Throwable paramSerializable)
    {
      lock.unlock();
      throw paramSerializable;
    }
  }
  
  public DataStore delete(String paramString)
    throws IOException
  {
    if (paramString == null) {
      return this;
    }
    lock.lock();
    try
    {
      keyValueMap.remove(paramString);
      save();
      lock.unlock();
      return this;
    }
    catch (Throwable paramString)
    {
      lock.unlock();
      throw paramString;
    }
  }
  
  public final Serializable get(String paramString)
    throws IOException
  {
    if (paramString == null) {
      return null;
    }
    lock.lock();
    try
    {
      paramString = IOUtils.deserialize((byte[])keyValueMap.get(paramString));
      lock.unlock();
      return paramString;
    }
    catch (Throwable paramString)
    {
      lock.unlock();
      throw paramString;
    }
  }
  
  public boolean isEmpty()
    throws IOException
  {
    lock.lock();
    try
    {
      boolean bool = keyValueMap.isEmpty();
      lock.unlock();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      lock.unlock();
      throw localThrowable;
    }
  }
  
  public final Set keySet()
    throws IOException
  {
    lock.lock();
    try
    {
      Set localSet = Collections.unmodifiableSet(keyValueMap.keySet());
      lock.unlock();
      return localSet;
    }
    catch (Throwable localThrowable)
    {
      lock.unlock();
      throw localThrowable;
    }
  }
  
  public void save()
    throws IOException
  {}
  
  public final DataStore set(String paramString, Serializable paramSerializable)
    throws IOException
  {
    if (paramString != null)
    {
      if (paramSerializable != null)
      {
        lock.lock();
        try
        {
          keyValueMap.put(paramString, IOUtils.serialize(paramSerializable));
          save();
          lock.unlock();
          return this;
        }
        catch (Throwable paramString)
        {
          lock.unlock();
          throw paramString;
        }
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public int size()
    throws IOException
  {
    lock.lock();
    try
    {
      int i = keyValueMap.size();
      lock.unlock();
      return i;
    }
    catch (Throwable localThrowable)
    {
      lock.unlock();
      throw localThrowable;
    }
  }
  
  public String toString()
  {
    return AdapterTime.toString(this);
  }
  
  public final Collection values()
    throws IOException
  {
    lock.lock();
    try
    {
      Object localObject = new ArrayList();
      Iterator localIterator = keyValueMap.values().iterator();
      for (;;)
      {
        boolean bool = localIterator.hasNext();
        if (!bool) {
          break;
        }
        ((List)localObject).add(IOUtils.deserialize((byte[])localIterator.next()));
      }
      localObject = Collections.unmodifiableList((List)localObject);
      lock.unlock();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      lock.unlock();
      throw localThrowable;
    }
  }
}
