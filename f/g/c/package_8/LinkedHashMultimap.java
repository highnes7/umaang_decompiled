package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.a.c;
import f.g.c.a.d;
import f.g.c.d.v;
import f.g.c.package_10.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@b(emulated=true, serializable=true)
public final class LinkedHashMultimap<K, V>
  extends v<K, V>
{
  public static final int DEFAULT_KEY_CAPACITY = 16;
  public static final int DEFAULT_VALUE_SET_CAPACITY = 2;
  public static final int MAX_VALUE_SET_TABLE_SIZE = 1073741824;
  @c("java serialization not supported")
  public static final long serialVersionUID = 1L;
  public transient f.g.c.d.Mc.a<K, V> data;
  @d
  public transient int valueSetCapacity = 2;
  
  public LinkedHashMultimap(int paramInt1, int paramInt2)
  {
    super(new LinkedHashMap(paramInt1));
    boolean bool;
    if (paramInt2 >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "expectedValuesPerKey must be >= 0 but was %s", new Object[] { Integer.valueOf(paramInt2) });
    valueSetCapacity = paramInt2;
    data = new Mc.a(null, null, 0, null);
    Mc.a localA = data;
    localA.append(localA);
    localA.get(localA);
  }
  
  public static void c(Mc.c paramC)
  {
    Mc.c localC = paramC.b();
    paramC = paramC.a();
    localC.a(paramC);
    paramC.b(localC);
  }
  
  public static LinkedHashMultimap create()
  {
    return new LinkedHashMultimap(16, 2);
  }
  
  public static LinkedHashMultimap create(int paramInt1, int paramInt2)
  {
    return new LinkedHashMultimap(Maps.capacity(paramInt1), Maps.capacity(paramInt2));
  }
  
  public static LinkedHashMultimap create(Multimap paramMultimap)
  {
    LinkedHashMultimap localLinkedHashMultimap = create(paramMultimap.keySet().size(), 2);
    localLinkedHashMultimap.putAll(paramMultimap);
    return localLinkedHashMultimap;
  }
  
  public static void put(Mc.a paramA1, Mc.a paramA2)
  {
    paramA1.append(paramA2);
    paramA2.get(paramA1);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    int j = 0;
    data = new Mc.a(null, null, 0, null);
    Object localObject1 = data;
    ((Mc.a)localObject1).append((Mc.a)localObject1);
    ((Mc.a)localObject1).get((Mc.a)localObject1);
    valueSetCapacity = paramObjectInputStream.readInt();
    int k = paramObjectInputStream.readInt();
    localObject1 = new LinkedHashMap(Maps.capacity(k));
    int i = 0;
    Object localObject2;
    while (i < k)
    {
      localObject2 = paramObjectInputStream.readObject();
      ((Map)localObject1).put(localObject2, createCollection(localObject2));
      i += 1;
    }
    k = paramObjectInputStream.readInt();
    i = j;
    while (i < k)
    {
      localObject2 = paramObjectInputStream.readObject();
      Object localObject3 = paramObjectInputStream.readObject();
      ((Collection)((Map)localObject1).get(localObject2)).add(localObject3);
      i += 1;
    }
    setMap((Map)localObject1);
  }
  
  public static void removeAll(Mc.a paramA)
  {
    Mc.a localA = paramA.get();
    paramA = paramA.remove();
    localA.append(paramA);
    paramA.get(localA);
  }
  
  public static void setQwertyMode(Mc.c paramC1, Mc.c paramC2)
  {
    paramC1.a(paramC2);
    paramC2.b(paramC1);
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeInt(valueSetCapacity);
    paramObjectOutputStream.writeInt(keySet().size());
    Iterator localIterator = keySet().iterator();
    while (localIterator.hasNext()) {
      paramObjectOutputStream.writeObject(localIterator.next());
    }
    paramObjectOutputStream.writeInt(size());
    localIterator = entries().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramObjectOutputStream.writeObject(localEntry.getKey());
      paramObjectOutputStream.writeObject(localEntry.getValue());
    }
  }
  
  public void clear()
  {
    super.clear();
    Mc.a localA = data;
    localA.append(localA);
    localA.get(localA);
  }
  
  public boolean containsKey(Object paramObject)
  {
    return map.containsKey(paramObject);
  }
  
  public Collection createCollection(Object paramObject)
  {
    return new Mc.b(this, paramObject, valueSetCapacity);
  }
  
  public Set createCollection()
  {
    return new LinkedHashSet(valueSetCapacity);
  }
  
  public Set entries()
  {
    return super.entries();
  }
  
  public Iterator entryIterator()
  {
    return new LinkedListMultimap.DistinctKeyIterator(this);
  }
  
  public Set replaceValues(Object paramObject, Iterable paramIterable)
  {
    return super.replaceValues(paramObject, paramIterable);
  }
  
  public int size()
  {
    return totalSize;
  }
  
  public Collection values()
  {
    return super.values();
  }
}
