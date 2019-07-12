package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Sa;
import java.util.concurrent.ConcurrentMap;

@b
public abstract class ForwardingConcurrentMap<K, V>
  extends Sa<K, V>
  implements ConcurrentMap<K, V>
{
  public ForwardingConcurrentMap() {}
  
  public abstract ConcurrentMap delegate();
  
  public Object putIfAbsent(Object paramObject1, Object paramObject2)
  {
    return delegate().putIfAbsent(paramObject1, paramObject2);
  }
  
  public boolean remove(Object paramObject1, Object paramObject2)
  {
    return delegate().remove(paramObject1, paramObject2);
  }
  
  public Object replace(Object paramObject1, Object paramObject2)
  {
    return delegate().replace(paramObject1, paramObject2);
  }
  
  public boolean replace(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return delegate().replace(paramObject1, paramObject2, paramObject3);
  }
}
