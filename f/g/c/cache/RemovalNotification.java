package f.g.c.cache;

import f.g.c.a.a;
import f.g.c.package_10.Objects;
import java.util.Map.Entry;
import m.a.h;

@a
public final class RemovalNotification<K, V>
  implements Map.Entry<K, V>
{
  public static final long serialVersionUID = 0L;
  public final MapMaker.RemovalCause cause;
  @h
  public final K key;
  @h
  public final V value;
  
  public RemovalNotification(Object paramObject1, Object paramObject2, MapMaker.RemovalCause paramRemovalCause)
  {
    key = paramObject1;
    value = paramObject2;
    if (paramRemovalCause != null)
    {
      cause = paramRemovalCause;
      return;
    }
    throw new NullPointerException();
  }
  
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
  
  public MapMaker.RemovalCause getCause()
  {
    return cause;
  }
  
  public Object getKey()
  {
    return key;
  }
  
  public Object getValue()
  {
    return value;
  }
  
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
  
  public final Object setValue(Object paramObject)
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
  
  public boolean wasEvicted()
  {
    return cause.wasEvicted();
  }
}
