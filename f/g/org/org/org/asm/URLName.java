package f.g.org.org.org.asm;

import f.g.b.a.b.h.d;
import f.g.b.a.g.h;
import f.g.org.org.util.Objects;
import f.g.org.org.util.Objects.ToStringHelper;
import f.g.org.org.util.store.DataStore;
import f.g.org.org.util.store.DataStoreFactory;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@h
public final class URLName
  implements Serializable
{
  public static final long EXTRA_GOTO_DATE = 1L;
  public static final String ref = "d";
  public final Attribute buffer;
  public final String file;
  public String host;
  public String mId;
  public Long port;
  public final Lock this$0 = new ReentrantLock();
  
  public URLName(Attribute paramAttribute)
  {
    this(paramAttribute, ECDomainParameters.getSeed());
  }
  
  public URLName(Attribute paramAttribute, String paramString)
  {
    if (paramAttribute != null)
    {
      buffer = paramAttribute;
      if (paramString != null)
      {
        file = paramString;
        return;
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static DataStore getRef(DataStoreFactory paramDataStoreFactory)
    throws IOException
  {
    return paramDataStoreFactory.getDataStore(ref);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof URLName)) {
      return false;
    }
    paramObject = (URLName)paramObject;
    return getFile().equals(paramObject.getFile());
  }
  
  public Attribute get()
  {
    this$0.lock();
    try
    {
      Attribute localAttribute = buffer;
      this$0.unlock();
      return localAttribute;
    }
    catch (Throwable localThrowable)
    {
      this$0.unlock();
      throw localThrowable;
    }
  }
  
  public URLName getFile(String paramString)
  {
    this$0.lock();
    try
    {
      host = paramString;
      this$0.unlock();
      return this;
    }
    catch (Throwable paramString)
    {
      this$0.unlock();
      throw paramString;
    }
  }
  
  public String getFile()
  {
    this$0.lock();
    try
    {
      String str = file;
      this$0.unlock();
      return str;
    }
    catch (Throwable localThrowable)
    {
      this$0.unlock();
      throw localThrowable;
    }
  }
  
  public String getHost()
  {
    this$0.lock();
    try
    {
      String str = host;
      this$0.unlock();
      return str;
    }
    catch (Throwable localThrowable)
    {
      this$0.unlock();
      throw localThrowable;
    }
  }
  
  public String getId()
  {
    this$0.lock();
    try
    {
      String str = mId;
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
    return getFile().hashCode();
  }
  
  public URLName init(Long paramLong)
  {
    this$0.lock();
    try
    {
      port = paramLong;
      this$0.unlock();
      return this;
    }
    catch (Throwable paramLong)
    {
      this$0.unlock();
      throw paramLong;
    }
  }
  
  public Long lookup()
  {
    this$0.lock();
    try
    {
      Long localLong = port;
      this$0.unlock();
      return localLong;
    }
    catch (Throwable localThrowable)
    {
      this$0.unlock();
      throw localThrowable;
    }
  }
  
  public URLName toString(DataStore paramDataStore)
    throws IOException
  {
    this$0.lock();
    try
    {
      paramDataStore.set(getFile(), this);
      this$0.unlock();
      return this;
    }
    catch (Throwable paramDataStore)
    {
      this$0.unlock();
      throw paramDataStore;
    }
  }
  
  public URLName toString(DataStoreFactory paramDataStoreFactory)
    throws IOException
  {
    return toString(getRef(paramDataStoreFactory));
  }
  
  public URLName toString(String paramString)
  {
    this$0.lock();
    try
    {
      mId = paramString;
      this$0.unlock();
      return this;
    }
    catch (Throwable paramString)
    {
      this$0.unlock();
      throw paramString;
    }
  }
  
  public String toString()
  {
    return Objects.toStringHelper(d.class).add("notificationCallback", get()).add("clientToken", getHost()).add("expiration", lookup()).add("id", getFile()).add("topicId", getId()).toString();
  }
}
