package f.g.org.org.util;

import f.g.org.org.codehaus.libs.objectweb.asm.asm.Objects;
import java.util.Map.Entry;

public final class Attribute
  implements Map.Entry<K, V>
{
  public int key;
  
  public Attribute(ArrayMap paramArrayMap, int paramInt)
  {
    key = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Map.Entry)) {
      return false;
    }
    paramObject = (Map.Entry)paramObject;
    return (Objects.equals(getKey(), paramObject.getKey())) && (Objects.equals(getValue(), paramObject.getValue()));
  }
  
  public Object getKey()
  {
    return this$0.getKey(key);
  }
  
  public Object getValue()
  {
    return this$0.get(key);
  }
  
  public int hashCode()
  {
    return getKey().hashCode() ^ getValue().hashCode();
  }
  
  public Object setValue(Object paramObject)
  {
    return this$0.set(key, paramObject);
  }
}
