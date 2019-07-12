package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Ua;
import f.g.c.d.cd;
import java.util.List;

@b
public abstract class ForwardingListMultimap<K, V>
  extends Ua<K, V>
  implements cd<K, V>
{
  public ForwardingListMultimap() {}
  
  public abstract ListMultimap delegate();
  
  public List get(Object paramObject)
  {
    return delegate().get(paramObject);
  }
  
  public List removeAll(Object paramObject)
  {
    return delegate().removeAll(paramObject);
  }
  
  public List replaceValues(Object paramObject, Iterable paramIterable)
  {
    return delegate().replaceValues(paramObject, paramIterable);
  }
}
