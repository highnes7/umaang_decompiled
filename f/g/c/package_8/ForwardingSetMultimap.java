package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Ua;
import f.g.c.d.bg;
import java.util.Set;

@b
public abstract class ForwardingSetMultimap<K, V>
  extends Ua<K, V>
  implements bg<K, V>
{
  public ForwardingSetMultimap() {}
  
  public abstract SetMultimap delegate();
  
  public Set entries()
  {
    return delegate().entries();
  }
  
  public Set get(Object paramObject)
  {
    return delegate().get(paramObject);
  }
  
  public Set removeAll(Object paramObject)
  {
    return delegate().removeAll(paramObject);
  }
  
  public Set replaceValues(Object paramObject, Iterable paramIterable)
  {
    return delegate().replaceValues(paramObject, paramIterable);
  }
}
