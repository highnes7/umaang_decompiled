package f.g.c.cache;

import f.g.c.a.a;
import f.g.c.a.b;
import f.g.c.b.J;
import f.g.c.c.c;
import f.g.c.package_8.ImmutableMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

@a
@b
public abstract interface LoadingCache<K, V>
  extends c<K, V>, J<K, V>
{
  public abstract Object apply(Object paramObject);
  
  public abstract ConcurrentMap asMap();
  
  public abstract Object get(Object paramObject)
    throws ExecutionException;
  
  public abstract ImmutableMap getAll(Iterable paramIterable)
    throws ExecutionException;
  
  public abstract Object getUnchecked(Object paramObject);
  
  public abstract void refresh(Object paramObject);
}
