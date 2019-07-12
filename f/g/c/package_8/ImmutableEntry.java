package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.m;
import java.io.Serializable;

@b(serializable=true)
public class ImmutableEntry<K, V>
  extends m<K, V>
  implements Serializable
{
  public static final long serialVersionUID = 0L;
  public final K key;
  public final V value;
  
  public ImmutableEntry(Object paramObject1, Object paramObject2)
  {
    key = paramObject1;
    value = paramObject2;
  }
  
  public Object getKey()
  {
    return key;
  }
  
  public Object getValue()
  {
    return value;
  }
  
  public final Object setValue(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
}
