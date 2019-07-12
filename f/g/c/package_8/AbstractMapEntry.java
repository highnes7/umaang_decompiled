package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.package_10.Objects;
import java.util.Map.Entry;

@b
public abstract class AbstractMapEntry<K, V>
  implements Map.Entry<K, V>
{
  public AbstractMapEntry() {}
  
  public boolean equals(Object paramObject)
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
  
  public abstract Object getKey();
  
  public abstract Object getValue();
  
  public int hashCode()
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
  
  public Object setValue(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getKey());
    localStringBuilder.append("=");
    localStringBuilder.append(getValue());
    return localStringBuilder.toString();
  }
}
