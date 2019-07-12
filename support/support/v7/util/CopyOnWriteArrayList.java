package support.support.v7.util;

import b.a.a.b.c;
import b.a.a.b.c.c;
import b.b.a.N;
import java.util.HashMap;
import java.util.Map.Entry;

@N({b.b.a.N.a.b})
public class CopyOnWriteArrayList<K, V>
  extends c<K, V>
{
  public HashMap<K, c.c<K, V>> map = new HashMap();
  
  public CopyOnWriteArrayList() {}
  
  public boolean contains(Object paramObject)
  {
    return map.containsKey(paramObject);
  }
  
  public Map.Entry get(Object paramObject)
  {
    if (contains(paramObject)) {
      return map.get(paramObject)).head;
    }
    return null;
  }
  
  public Object remove(Object paramObject)
  {
    Object localObject = super.remove(paramObject);
    map.remove(paramObject);
    return localObject;
  }
  
  public Object remove(Object paramObject1, Object paramObject2)
  {
    Node localNode = toString(paramObject1);
    if (localNode != null) {
      return value;
    }
    map.put(paramObject1, addNode(paramObject1, paramObject2));
    return null;
  }
  
  public Node toString(Object paramObject)
  {
    return (Node)map.get(paramObject);
  }
}
