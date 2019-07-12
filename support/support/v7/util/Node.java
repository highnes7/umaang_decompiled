package support.support.v7.util;

import b.a.a.b.c.c;
import b.b.a.F;
import java.util.Map.Entry;

public class Node<K, V>
  implements Map.Entry<K, V>
{
  public c.c<K, V> head;
  @F
  public final K key;
  public c.c<K, V> next;
  @F
  public final V value;
  
  public Node(Object paramObject1, Object paramObject2)
  {
    key = paramObject1;
    value = paramObject2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Node)) {
      return false;
    }
    paramObject = (Node)paramObject;
    return (key.equals(key)) && (value.equals(value));
  }
  
  public Object getKey()
  {
    return key;
  }
  
  public Object getValue()
  {
    return value;
  }
  
  public Object setValue(Object paramObject)
  {
    throw new UnsupportedOperationException("An entry modification is not supported");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(key);
    localStringBuilder.append("=");
    localStringBuilder.append(value);
    return localStringBuilder.toString();
  }
}
