package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Ab;
import f.g.c.d.nb;
import java.util.Iterator;
import java.util.Map.Entry;

@b(emulated=true, serializable=true)
public class RegularImmutableBiMap<K, V>
  extends nb<K, V>
{
  public final transient Ab<K, V> delegate;
  public final transient nb<V, K> inverse;
  
  public RegularImmutableBiMap(ImmutableMap paramImmutableMap)
  {
    delegate = paramImmutableMap;
    Ab.a localA = ImmutableMap.builder();
    paramImmutableMap = paramImmutableMap.entrySet().iterator();
    while (paramImmutableMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramImmutableMap.next();
      localA.put(localEntry.getValue(), localEntry.getKey());
    }
    inverse = new RegularImmutableBiMap(localA.build(), this);
  }
  
  public RegularImmutableBiMap(ImmutableMap paramImmutableMap, ImmutableBiMap paramImmutableBiMap)
  {
    delegate = paramImmutableMap;
    inverse = paramImmutableBiMap;
  }
  
  public ImmutableMap delegate()
  {
    return delegate;
  }
  
  public ImmutableBiMap inverse()
  {
    return inverse;
  }
  
  public boolean isPartialView()
  {
    return (delegate.isPartialView()) || (inverse.delegate().isPartialView());
  }
}
