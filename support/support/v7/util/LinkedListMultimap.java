package support.support.v7.util;

import b.a.a.b.c.c;
import b.a.a.b.c.f;
import b.b.a.N;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

@N({b.b.a.N.a.b})
public class LinkedListMultimap<K, V>
  implements Iterable<Map.Entry<K, V>>
{
  public c.c<K, V> head;
  public WeakHashMap<c.f<K, V>, Boolean> map = new WeakHashMap();
  public int size = 0;
  public c.c<K, V> tail;
  
  public LinkedListMultimap() {}
  
  public Node addNode(Object paramObject1, Object paramObject2)
  {
    paramObject1 = new Node(paramObject1, paramObject2);
    size += 1;
    paramObject2 = tail;
    if (paramObject2 == null)
    {
      head = paramObject1;
      tail = head;
      return paramObject1;
    }
    next = paramObject1;
    head = paramObject2;
    tail = paramObject1;
    return paramObject1;
  }
  
  public Iterator descendingIterator()
  {
    AbstractMap localAbstractMap = new AbstractMap(tail, head);
    map.put(localAbstractMap, Boolean.valueOf(false));
    return localAbstractMap;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof LinkedListMultimap)) {
      return false;
    }
    Object localObject1 = (LinkedListMultimap)paramObject;
    if (size() != ((LinkedListMultimap)localObject1).size()) {
      return false;
    }
    paramObject = iterator();
    localObject1 = ((LinkedListMultimap)localObject1).iterator();
    while ((paramObject.hasNext()) && (((Iterator)localObject1).hasNext()))
    {
      Map.Entry localEntry = (Map.Entry)paramObject.next();
      Object localObject2 = ((Iterator)localObject1).next();
      if ((localEntry == null) && (localObject2 != null)) {
        break label128;
      }
      if ((localEntry != null) && (!localEntry.equals(localObject2))) {
        return false;
      }
    }
    return (!paramObject.hasNext()) && (!((Iterator)localObject1).hasNext());
    label128:
    return false;
  }
  
  public Map.Entry get()
  {
    return head;
  }
  
  public Iterator iterator()
  {
    GenericData localGenericData = new GenericData(head, tail);
    map.put(localGenericData, Boolean.valueOf(false));
    return localGenericData;
  }
  
  public RefMap.SetIterator put()
  {
    RefMap.SetIterator localSetIterator = new RefMap.SetIterator(this, null);
    map.put(localSetIterator, Boolean.valueOf(false));
    return localSetIterator;
  }
  
  public Object remove(Object paramObject)
  {
    paramObject = toString(paramObject);
    if (paramObject == null) {
      return null;
    }
    size -= 1;
    if (!map.isEmpty())
    {
      localObject = map.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((FastMap.EntryImpl)((Iterator)localObject).next()).next(paramObject);
      }
    }
    Object localObject = head;
    if (localObject != null) {
      next = next;
    } else {
      head = next;
    }
    localObject = next;
    if (localObject != null) {
      head = head;
    } else {
      tail = head;
    }
    next = null;
    head = null;
    return value;
  }
  
  public Object remove(Object paramObject1, Object paramObject2)
  {
    Node localNode = toString(paramObject1);
    if (localNode != null) {
      return value;
    }
    addNode(paramObject1, paramObject2);
    return null;
  }
  
  public int size()
  {
    return size;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("[");
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(((Map.Entry)localIterator.next()).toString());
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public Node toString(Object paramObject)
  {
    for (Node localNode = head; localNode != null; localNode = next) {
      if (key.equals(paramObject)) {
        return localNode;
      }
    }
    return localNode;
  }
  
  public Map.Entry values()
  {
    return tail;
  }
}
