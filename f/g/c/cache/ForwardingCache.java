package f.g.c.cache;

import f.g.c.a.a;
import f.g.c.c.c;
import f.g.c.d.Wa;
import f.g.c.package_8.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

@a
public abstract class ForwardingCache<K, V>
  extends Wa
  implements c<K, V>
{
  public ForwardingCache() {}
  
  public ConcurrentMap asMap()
  {
    return delegate().asMap();
  }
  
  public void cleanUp()
  {
    delegate().cleanUp();
  }
  
  public abstract Cache delegate();
  
  public Object get(Object paramObject, Callable paramCallable)
    throws ExecutionException
  {
    return delegate().get(paramObject, paramCallable);
  }
  
  public ImmutableMap getAllPresent(Iterable paramIterable)
  {
    return delegate().getAllPresent(paramIterable);
  }
  
  public Object getIfPresent(Object paramObject)
  {
    return delegate().getIfPresent(paramObject);
  }
  
  public void invalidate(Object paramObject)
  {
    delegate().invalidate(paramObject);
  }
  
  public void invalidateAll()
  {
    delegate().invalidateAll();
  }
  
  public void invalidateAll(Iterable paramIterable)
  {
    delegate().invalidateAll(paramIterable);
  }
  
  public void put(Object paramObject1, Object paramObject2)
  {
    delegate().put(paramObject1, paramObject2);
  }
  
  public void putAll(Map paramMap)
  {
    delegate().putAll(paramMap);
  }
  
  public long size()
  {
    return delegate().size();
  }
  
  public Handle stats()
  {
    return delegate().stats();
  }
}
