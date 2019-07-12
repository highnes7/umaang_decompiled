package f.g.c.cache;

import f.g.c.c.q.y;
import f.g.c.l.a.Aa;
import f.g.c.l.a.Qa;
import f.g.c.l.a.ja;
import f.g.c.l.a.oa;
import f.g.c.package_10.Stopwatch;
import f.g.c.package_10.Ticker;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ClassWriter<K, V>
  implements q.y<K, V>
{
  public final Aa<V> d = new Aa();
  public volatile q.y<K, V> oldValue;
  public final Stopwatch stopwatch = new Stopwatch(Ticker.ticker);
  
  public ClassWriter()
  {
    this(LocalCache.map);
  }
  
  public ClassWriter(LocalCache.ValueReference paramValueReference)
  {
    oldValue = paramValueReference;
  }
  
  private oa c(Throwable paramThrowable)
  {
    Aa localAa = new Aa();
    c(localAa, paramThrowable);
    return localAa;
  }
  
  public static boolean c(Aa paramAa, Throwable paramThrowable)
  {
    try
    {
      boolean bool = paramAa.a(paramThrowable);
      return bool;
    }
    catch (Error paramAa)
    {
      for (;;) {}
    }
    return false;
  }
  
  public oa a(Object paramObject, CacheLoader paramCacheLoader)
  {
    stopwatch.start();
    Object localObject = oldValue.get();
    if (localObject == null) {}
    try
    {
      paramObject = paramCacheLoader.load(paramObject);
      boolean bool = add(paramObject);
      if (bool)
      {
        paramObject = d;
        return paramObject;
      }
      paramObject = ja.b(paramObject);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      if (!(paramObject instanceof InterruptedException)) {
        break label89;
      }
      Thread.currentThread().interrupt();
      if (!a(paramObject)) {
        break label102;
      }
      return d;
    }
    paramObject = paramCacheLoader.reload(paramObject, localObject);
    if (paramObject != null) {
      return paramObject;
    }
    paramObject = ja.b(null);
    return paramObject;
    label89:
    label102:
    return c(paramObject);
  }
  
  public boolean a(Throwable paramThrowable)
  {
    return c(d, paramThrowable);
  }
  
  public boolean add(Object paramObject)
  {
    return d.a(paramObject);
  }
  
  public LocalCache.ValueReference copyFor(ReferenceQueue paramReferenceQueue, Object paramObject, MapMakerInternalMap.ReferenceEntry paramReferenceEntry)
  {
    return this;
  }
  
  public long elapsedNanos()
  {
    return stopwatch.elapsedTime(TimeUnit.NANOSECONDS);
  }
  
  public Object get()
  {
    return oldValue.get();
  }
  
  public MapMakerInternalMap.ReferenceEntry getEntry()
  {
    return null;
  }
  
  public int getWeight()
  {
    return oldValue.getWeight();
  }
  
  public boolean isActive()
  {
    return oldValue.isActive();
  }
  
  public boolean isLoading()
  {
    return true;
  }
  
  public void notifyNewValue(Object paramObject)
  {
    if (paramObject != null)
    {
      add(paramObject);
      return;
    }
    oldValue = LocalCache.map;
  }
  
  public LocalCache.ValueReference put()
  {
    return oldValue;
  }
  
  public Object waitForValue()
    throws ExecutionException
  {
    return Qa.a((Future)d);
  }
}
