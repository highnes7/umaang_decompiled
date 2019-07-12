package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.rb;
import java.util.Map;

@b(emulated=true)
public abstract class ImmutableMapValues<K, V>
  extends rb<V>
{
  public ImmutableMapValues() {}
  
  public boolean contains(Object paramObject)
  {
    return map().containsValue(paramObject);
  }
  
  public ImmutableList createAsList()
  {
    return new ImmutableMapValues.2(this, map().entrySet().asList());
  }
  
  public boolean isPartialView()
  {
    return true;
  }
  
  public UnmodifiableIterator iterator()
  {
    return Maps.valueIterator(map().entrySet().iterator());
  }
  
  public abstract ImmutableMap map();
  
  public int size()
  {
    return map().size();
  }
  
  public Object writeReplace()
  {
    return new Fb.a(map());
  }
}
