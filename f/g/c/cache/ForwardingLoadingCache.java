package f.g.c.cache;

import f.g.c.a.a;
import f.g.c.c.l;
import f.g.c.c.m;
import f.g.c.c.n;
import f.g.c.package_8.ImmutableMap;
import java.util.concurrent.ExecutionException;

@a
public abstract class ForwardingLoadingCache<K, V>
  extends l<K, V>
  implements n<K, V>
{
  public ForwardingLoadingCache() {}
  
  public Object apply(Object paramObject)
  {
    return delegate().apply(paramObject);
  }
  
  public abstract LoadingCache delegate();
  
  public Object get(Object paramObject)
    throws ExecutionException
  {
    return delegate().get(paramObject);
  }
  
  public ImmutableMap getAll(Iterable paramIterable)
    throws ExecutionException
  {
    return delegate().getAll(paramIterable);
  }
  
  public Object getUnchecked(Object paramObject)
  {
    return delegate().getUnchecked(paramObject);
  }
  
  public void refresh(Object paramObject)
  {
    delegate().refresh(paramObject);
  }
  
  @a
  public abstract class SimpleForwardingLoadingCache<K, V>
    extends m<K, V>
  {
    public SimpleForwardingLoadingCache()
    {
      if (ForwardingLoadingCache.this != null) {
        return;
      }
      throw new NullPointerException();
    }
    
    public final LoadingCache delegate()
    {
      return ForwardingLoadingCache.this;
    }
  }
}
