package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Wa;
import f.g.c.package_10.Objects;
import java.util.Map.Entry;

@b
public abstract class ForwardingMapEntry<K, V>
  extends Wa
  implements Map.Entry<K, V>
{
  public ForwardingMapEntry() {}
  
  public abstract Map.Entry delegate();
  
  public boolean equals(Object paramObject)
  {
    return delegate().equals(paramObject);
  }
  
  public Object getKey()
  {
    return delegate().getKey();
  }
  
  public Object getValue()
  {
    return delegate().getValue();
  }
  
  public int hashCode()
  {
    return delegate().hashCode();
  }
  
  public Object setValue(Object paramObject)
  {
    return delegate().setValue(paramObject);
  }
  
  public boolean standardEquals(Object paramObject)
  {
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      if ((Objects.equal(getKey(), paramObject.getKey())) && (Objects.equal(getValue(), paramObject.getValue()))) {
        return true;
      }
    }
    return false;
  }
  
  public int standardHashCode()
  {
    Object localObject1 = getKey();
    Object localObject2 = getValue();
    int j = 0;
    int i;
    if (localObject1 == null) {
      i = 0;
    } else {
      i = localObject1.hashCode();
    }
    if (localObject2 != null) {
      j = localObject2.hashCode();
    }
    return i ^ j;
  }
  
  public String standardToString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getKey());
    localStringBuilder.append("=");
    localStringBuilder.append(getValue());
    return localStringBuilder.toString();
  }
}
