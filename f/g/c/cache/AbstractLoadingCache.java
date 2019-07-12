package f.g.c.cache;

import f.g.c.c.n;
import f.g.c.l.a.Oa;
import f.g.c.package_8.ImmutableMap;
import f.g.c.package_8.Maps;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@f.g.c.a.a
public abstract class AbstractLoadingCache<K, V>
  extends f.g.c.c.a<K, V>
  implements n<K, V>
{
  public AbstractLoadingCache() {}
  
  public final Object apply(Object paramObject)
  {
    return getUnchecked(paramObject);
  }
  
  public ImmutableMap getAll(Iterable paramIterable)
    throws ExecutionException
  {
    LinkedHashMap localLinkedHashMap = Maps.newLinkedHashMap();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (!localLinkedHashMap.containsKey(localObject)) {
        localLinkedHashMap.put(localObject, get(localObject));
      }
    }
    return ImmutableMap.copyOf(localLinkedHashMap);
  }
  
  public Object getUnchecked(Object paramObject)
  {
    try
    {
      paramObject = get(paramObject);
      return paramObject;
    }
    catch (ExecutionException paramObject)
    {
      throw ((Throwable)new Oa(paramObject.getCause()));
    }
  }
  
  public void refresh(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
}
