package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.fh;
import java.util.Map.Entry;

@b(emulated=true)
public abstract class ImmutableMapKeySet<K, V>
  extends fh<Map.Entry<K, V>, K>
{
  public ImmutableMapKeySet(ImmutableSet paramImmutableSet)
  {
    super(paramImmutableSet);
  }
  
  public ImmutableMapKeySet(ImmutableSet paramImmutableSet, int paramInt)
  {
    super(paramImmutableSet, paramInt);
  }
  
  public boolean contains(Object paramObject)
  {
    return map().containsKey(paramObject);
  }
  
  public ImmutableList createAsList()
  {
    return new ImmutableMapValues.1(this, map().entrySet().asList());
  }
  
  public boolean isPartialView()
  {
    return true;
  }
  
  public abstract ImmutableMap map();
  
  public Object transform(Map.Entry paramEntry)
  {
    return paramEntry.getKey();
  }
  
  public Object writeReplace()
  {
    return new Db.a(map());
  }
}
