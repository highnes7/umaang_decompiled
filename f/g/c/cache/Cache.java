package f.g.c.cache;

import f.g.c.a.a;
import f.g.c.a.b;
import f.g.c.package_8.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

@a
@b
public abstract interface Cache<K, V>
{
  public abstract ConcurrentMap asMap();
  
  public abstract void cleanUp();
  
  public abstract Object get(Object paramObject, Callable paramCallable)
    throws ExecutionException;
  
  public abstract ImmutableMap getAllPresent(Iterable paramIterable);
  
  public abstract Object getIfPresent(Object paramObject);
  
  public abstract void invalidate(Object paramObject);
  
  public abstract void invalidateAll();
  
  public abstract void invalidateAll(Iterable paramIterable);
  
  public abstract void put(Object paramObject1, Object paramObject2);
  
  public abstract void putAll(Map paramMap);
  
  public abstract long size();
  
  public abstract Handle stats();
}
