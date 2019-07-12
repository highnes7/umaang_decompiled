package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Nb;
import java.util.Map;
import java.util.Map.Entry;

@b(emulated=true)
public abstract class ImmutableMapEntrySet<K, V>
  extends Nb<Map.Entry<K, V>>
{
  public ImmutableMapEntrySet() {}
  
  public boolean contains(Object paramObject)
  {
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      Object localObject = map().get(paramObject.getKey());
      if ((localObject != null) && (localObject.equals(paramObject.getValue()))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isPartialView()
  {
    return map().isPartialView();
  }
  
  public abstract ImmutableMap map();
  
  public int size()
  {
    return map().size();
  }
  
  public Object writeReplace()
  {
    return new Bb.a(map());
  }
}
