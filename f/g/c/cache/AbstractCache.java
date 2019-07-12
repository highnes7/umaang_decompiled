package f.g.c.cache;

import f.g.c.a.a;
import f.g.c.a.b;
import f.g.c.c.c;
import f.g.c.package_8.ImmutableMap;
import f.g.c.package_8.Maps;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

@a
@b
public abstract class AbstractCache<K, V>
  implements c<K, V>
{
  public AbstractCache() {}
  
  public ConcurrentMap asMap()
  {
    throw new UnsupportedOperationException();
  }
  
  public void cleanUp() {}
  
  public Object get(Object paramObject, Callable paramCallable)
    throws ExecutionException
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableMap getAllPresent(Iterable paramIterable)
  {
    LinkedHashMap localLinkedHashMap = Maps.newLinkedHashMap();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (!localLinkedHashMap.containsKey(localObject)) {
        localLinkedHashMap.put(localObject, getIfPresent(localObject));
      }
    }
    return ImmutableMap.copyOf(localLinkedHashMap);
  }
  
  public void invalidate(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public void invalidateAll()
  {
    throw new UnsupportedOperationException();
  }
  
  public void invalidateAll(Iterable paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      invalidate(paramIterable.next());
    }
  }
  
  public void put(Object paramObject1, Object paramObject2)
  {
    throw new UnsupportedOperationException();
  }
  
  public void putAll(Map paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public long size()
  {
    throw new UnsupportedOperationException();
  }
  
  public Handle stats()
  {
    throw new UnsupportedOperationException();
  }
  
  @a
  public final class SimpleStatsCounter
    implements AbstractCache.StatsCounter
  {
    public final LongAdder evictionCount = new LongAdder();
    public final LongAdder hitCount = new LongAdder();
    public final LongAdder loadExceptionCount = new LongAdder();
    public final LongAdder loadSuccessCount = new LongAdder();
    public final LongAdder missCount = new LongAdder();
    public final LongAdder totalLoadTime = new LongAdder();
    
    public SimpleStatsCounter() {}
    
    public void incrementBy(AbstractCache.StatsCounter paramStatsCounter)
    {
      paramStatsCounter = paramStatsCounter.snapshot();
      hitCount.add(paramStatsCounter.missCount());
      missCount.add(paramStatsCounter.getOwner());
      loadSuccessCount.add(paramStatsCounter.getName());
      loadExceptionCount.add(paramStatsCounter.getDesc());
      totalLoadTime.add(paramStatsCounter.loadSuccessCount());
      evictionCount.add(paramStatsCounter.values());
    }
    
    public void recordEviction()
    {
      evictionCount.increment();
    }
    
    public void recordHits(int paramInt)
    {
      hitCount.add(paramInt);
    }
    
    public void recordLoadException(long paramLong)
    {
      loadExceptionCount.increment();
      totalLoadTime.add(paramLong);
    }
    
    public void recordLoadSuccess(long paramLong)
    {
      loadSuccessCount.increment();
      totalLoadTime.add(paramLong);
    }
    
    public void recordMisses(int paramInt)
    {
      missCount.add(paramInt);
    }
    
    public Handle snapshot()
    {
      return new Handle(hitCount.sum(), missCount.sum(), loadSuccessCount.sum(), loadExceptionCount.sum(), totalLoadTime.sum(), evictionCount.sum());
    }
  }
  
  @a
  public abstract interface StatsCounter
  {
    public abstract void recordEviction();
    
    public abstract void recordHits(int paramInt);
    
    public abstract void recordLoadException(long paramLong);
    
    public abstract void recordLoadSuccess(long paramLong);
    
    public abstract void recordMisses(int paramInt);
    
    public abstract Handle snapshot();
  }
}
