package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.a.c;
import f.g.c.d.Ye;
import f.g.c.d.cd;
import f.g.c.package_10.Objects;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

@b(emulated=true, serializable=true)
public class LinkedListMultimap<K, V>
  implements cd<K, V>, Serializable
{
  @c("java serialization not supported")
  public static final long serialVersionUID = 0L;
  public transient Map<K, f.g.c.d.Zc.c<K, V>> data;
  public transient List<Map.Entry<K, V>> entries;
  public transient f.g.c.d.Zc.c<K, V> head;
  public transient Set<K> keySet;
  public transient Ye<K> keys;
  public transient Map<K, Collection<V>> map;
  public transient Map<K, f.g.c.d.Zc.c<K, V>> next;
  public transient f.g.c.d.Zc.c<K, V> size;
  public transient Ye<K> this$0;
  public transient List<V> values;
  
  public LinkedListMultimap()
  {
    this$0 = new LinkedHashMultiset();
    data = Maps.getString();
    next = Maps.getString();
  }
  
  public LinkedListMultimap(int paramInt)
  {
    this$0 = new LinkedHashMultiset(paramInt);
    data = Maps.newHashMapWithExpectedSize(paramInt);
    next = Maps.newHashMapWithExpectedSize(paramInt);
  }
  
  public LinkedListMultimap(Multimap paramMultimap)
  {
    this(paramMultimap.keySet().size());
    putAll(paramMultimap);
  }
  
  private Zc.c addNode(Object paramObject1, Object paramObject2, Zc.c paramC)
  {
    paramObject2 = new Zc.c(paramObject1, paramObject2);
    if (size == null)
    {
      head = paramObject2;
      size = paramObject2;
      data.put(paramObject1, paramObject2);
      next.put(paramObject1, paramObject2);
    }
    else if (paramC == null)
    {
      paramC = head;
      size = paramObject2;
      head = paramC;
      paramC = (Zc.c)next.get(paramObject1);
      if (paramC == null)
      {
        data.put(paramObject1, paramObject2);
      }
      else
      {
        next = paramObject2;
        previous = paramC;
      }
      next.put(paramObject1, paramObject2);
      head = paramObject2;
    }
    else
    {
      head = head;
      previous = previous;
      size = paramC;
      next = paramC;
      Zc.c localC = previous;
      if (localC == null) {
        data.put(paramObject1, paramObject2);
      } else {
        next = paramObject2;
      }
      localC = head;
      if (localC == null) {
        size = paramObject2;
      } else {
        size = paramObject2;
      }
      head = paramObject2;
      previous = paramObject2;
    }
    this$0.add(paramObject1);
    return paramObject2;
  }
  
  public static LinkedListMultimap create()
  {
    return new LinkedListMultimap();
  }
  
  public static LinkedListMultimap create(int paramInt)
  {
    return new LinkedListMultimap(paramInt);
  }
  
  public static LinkedListMultimap create(Multimap paramMultimap)
  {
    return new LinkedListMultimap(paramMultimap);
  }
  
  public static Map.Entry createEntry(Zc.c paramC)
  {
    return new HashBiMap.EntrySet.1.MapEntry(paramC);
  }
  
  private List getCopy(Object paramObject)
  {
    return Collections.unmodifiableList(Lists.newArrayList(new Zc.e(this, paramObject)));
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this$0 = new LinkedHashMultiset();
    data = Maps.getString();
    next = Maps.getString();
    int j = paramObjectInputStream.readInt();
    int i = 0;
    while (i < j)
    {
      put(paramObjectInputStream.readObject(), paramObjectInputStream.readObject());
      i += 1;
    }
  }
  
  private void removeAllNodes(Object paramObject)
  {
    paramObject = new Zc.e(this, paramObject);
    while (paramObject.hasNext())
    {
      paramObject.next();
      paramObject.remove();
    }
  }
  
  private void removeNode(Zc.c paramC)
  {
    Zc.c localC = head;
    if (localC != null) {
      size = size;
    } else {
      size = size;
    }
    localC = size;
    if (localC != null) {
      head = head;
    } else {
      head = head;
    }
    localC = previous;
    if (localC != null)
    {
      next = next;
    }
    else
    {
      localC = next;
      if (localC != null) {
        data.put(key, localC);
      } else {
        data.remove(key);
      }
    }
    localC = next;
    if (localC != null)
    {
      previous = previous;
    }
    else
    {
      localC = previous;
      if (localC != null) {
        next.put(key, localC);
      } else {
        next.remove(key);
      }
    }
    this$0.remove(key);
  }
  
  public static void toString(Object paramObject)
  {
    if (paramObject != null) {
      return;
    }
    throw new NoSuchElementException();
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeInt(size());
    Iterator localIterator = entries().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramObjectOutputStream.writeObject(localEntry.getKey());
      paramObjectOutputStream.writeObject(localEntry.getValue());
    }
  }
  
  public Map asMap()
  {
    Object localObject = map;
    if (localObject == null)
    {
      localObject = new LinkedListMultimap.6(this);
      map = ((Map)localObject);
      return localObject;
    }
    return localObject;
  }
  
  public void clear()
  {
    size = null;
    head = null;
    this$0.clear();
    data.clear();
    next.clear();
  }
  
  public boolean containsEntry(Object paramObject1, Object paramObject2)
  {
    paramObject1 = new Zc.e(this, paramObject1);
    while (paramObject1.hasNext()) {
      if (Objects.equal(paramObject1.next(), paramObject2)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean containsKey(Object paramObject)
  {
    return data.containsKey(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    Zc.d localD = new Zc.d(this);
    while (localD.hasNext()) {
      if (Objects.equal(nextvalue, paramObject)) {
        return true;
      }
    }
    return false;
  }
  
  public List entries()
  {
    Object localObject = entries;
    if (localObject == null)
    {
      localObject = new LinkedListMultimap.5(this);
      entries = ((List)localObject);
      return localObject;
    }
    return localObject;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof Multimap))
    {
      paramObject = (Multimap)paramObject;
      return asMap().equals(paramObject.asMap());
    }
    return false;
  }
  
  public List get(Object paramObject)
  {
    return new LinkedListMultimap.1(this, paramObject);
  }
  
  public int hashCode()
  {
    return asMap().hashCode();
  }
  
  public boolean isEmpty()
  {
    return size == null;
  }
  
  public Set keySet()
  {
    Object localObject = keySet;
    if (localObject == null)
    {
      localObject = new TDoubleIntHashMap.TKeyView(this);
      keySet = ((Set)localObject);
      return localObject;
    }
    return localObject;
  }
  
  public Multiset keys()
  {
    Object localObject = keys;
    if (localObject == null)
    {
      localObject = new Zc.b(this, null);
      keys = ((Multiset)localObject);
      return localObject;
    }
    return localObject;
  }
  
  public boolean put(Object paramObject1, Object paramObject2)
  {
    addNode(paramObject1, paramObject2, null);
    return true;
  }
  
  public boolean putAll(Multimap paramMultimap)
  {
    paramMultimap = paramMultimap.entries().iterator();
    boolean bool = false;
    while (paramMultimap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMultimap.next();
      bool |= put(localEntry.getKey(), localEntry.getValue());
    }
    return bool;
  }
  
  public boolean putAll(Object paramObject, Iterable paramIterable)
  {
    paramIterable = paramIterable.iterator();
    boolean bool = false;
    while (paramIterable.hasNext()) {
      bool |= put(paramObject, paramIterable.next());
    }
    return bool;
  }
  
  public boolean remove(Object paramObject1, Object paramObject2)
  {
    paramObject1 = new Zc.e(this, paramObject1);
    while (paramObject1.hasNext()) {
      if (Objects.equal(paramObject1.next(), paramObject2))
      {
        paramObject1.remove();
        return true;
      }
    }
    return false;
  }
  
  public List removeAll(Object paramObject)
  {
    List localList = getCopy(paramObject);
    removeAllNodes(paramObject);
    return localList;
  }
  
  public List replaceValues(Object paramObject, Iterable paramIterable)
  {
    List localList = getCopy(paramObject);
    paramObject = new Zc.e(this, paramObject);
    paramIterable = paramIterable.iterator();
    while ((paramObject.hasNext()) && (paramIterable.hasNext()))
    {
      paramObject.next();
      paramObject.set(paramIterable.next());
    }
    while (paramObject.hasNext())
    {
      paramObject.next();
      paramObject.remove();
    }
    while (paramIterable.hasNext()) {
      paramObject.add(paramIterable.next());
    }
    return localList;
  }
  
  public int size()
  {
    return this$0.size();
  }
  
  public String toString()
  {
    return asMap().toString();
  }
  
  public List values()
  {
    Object localObject = values;
    if (localObject == null)
    {
      localObject = new LinkedListMultimap.3(this);
      values = ((List)localObject);
      return localObject;
    }
    return localObject;
  }
}
