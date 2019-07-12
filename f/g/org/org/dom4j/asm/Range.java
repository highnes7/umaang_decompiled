package f.g.org.org.dom4j.asm;

import f.g.b.a.a.b.q;
import f.g.b.a.g.h;
import f.g.org.org.util.Objects.ToStringHelper;
import f.g.org.org.util.store.DataStore;
import f.g.org.org.util.store.DataStoreFactory;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@h
public final class Range
  implements Serializable
{
  public static final long serialVersionUID = 1L;
  public static final String value = "q";
  public String current;
  public String name;
  public Long start;
  public final Lock this$0 = new ReentrantLock();
  
  public Range() {}
  
  public Range(ClassWriter paramClassWriter)
  {
    set(paramClassWriter.getKey());
    copy(paramClassWriter.getFile());
    set(paramClassWriter.get());
  }
  
  public static DataStore set(DataStoreFactory paramDataStoreFactory)
    throws IOException
  {
    return paramDataStoreFactory.getDataStore(value);
  }
  
  public Range copy(String paramString)
  {
    this$0.lock();
    try
    {
      name = paramString;
      this$0.unlock();
      return this;
    }
    catch (Throwable paramString)
    {
      this$0.unlock();
      throw paramString;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Range)) {
      return false;
    }
    paramObject = (Range)paramObject;
    return (f.g.org.org.codehaus.libs.objectweb.asm.asm.Objects.equals(get(), paramObject.get())) && (f.g.org.org.codehaus.libs.objectweb.asm.asm.Objects.equals(getName(), paramObject.getName())) && (f.g.org.org.codehaus.libs.objectweb.asm.asm.Objects.equals(start(), paramObject.start()));
  }
  
  public String get()
  {
    this$0.lock();
    try
    {
      String str = current;
      this$0.unlock();
      return str;
    }
    catch (Throwable localThrowable)
    {
      this$0.unlock();
      throw localThrowable;
    }
  }
  
  public String getName()
  {
    this$0.lock();
    try
    {
      String str = name;
      this$0.unlock();
      return str;
    }
    catch (Throwable localThrowable)
    {
      this$0.unlock();
      throw localThrowable;
    }
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { get(), getName(), start() });
  }
  
  public Range set(Long paramLong)
  {
    this$0.lock();
    try
    {
      start = paramLong;
      this$0.unlock();
      return this;
    }
    catch (Throwable paramLong)
    {
      this$0.unlock();
      throw paramLong;
    }
  }
  
  public Range set(String paramString)
  {
    this$0.lock();
    try
    {
      current = paramString;
      this$0.unlock();
      return this;
    }
    catch (Throwable paramString)
    {
      this$0.unlock();
      throw paramString;
    }
  }
  
  public Long start()
  {
    this$0.lock();
    try
    {
      Long localLong = start;
      this$0.unlock();
      return localLong;
    }
    catch (Throwable localThrowable)
    {
      this$0.unlock();
      throw localThrowable;
    }
  }
  
  public String toString()
  {
    return f.g.org.org.util.Objects.toStringHelper(q.class).add("accessToken", get()).add("refreshToken", getName()).add("expirationTimeMilliseconds", start()).toString();
  }
}
