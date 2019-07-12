package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.a.c;
import f.g.c.a.d;
import f.g.c.d.i;
import f.g.c.package_10.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@b(emulated=true, serializable=true)
public final class ArrayListMultimap<K, V>
  extends i<K, V>
{
  public static final int DEFAULT_VALUES_PER_KEY = 3;
  @c("Not needed in emulated source.")
  public static final long serialVersionUID = 0L;
  @d
  public transient int expectedValuesPerKey;
  
  public ArrayListMultimap()
  {
    super(new HashMap());
    expectedValuesPerKey = 3;
  }
  
  public ArrayListMultimap(int paramInt1, int paramInt2)
  {
    super(Maps.newHashMapWithExpectedSize(paramInt1));
    boolean bool;
    if (paramInt2 >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    expectedValuesPerKey = paramInt2;
  }
  
  public ArrayListMultimap(Multimap paramMultimap)
  {
    this(j, i);
    putAll(paramMultimap);
  }
  
  public static ArrayListMultimap create()
  {
    return new ArrayListMultimap();
  }
  
  public static ArrayListMultimap create(int paramInt1, int paramInt2)
  {
    return new ArrayListMultimap(paramInt1, paramInt2);
  }
  
  public static ArrayListMultimap create(Multimap paramMultimap)
  {
    return new ArrayListMultimap(paramMultimap);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    expectedValuesPerKey = paramObjectInputStream.readInt();
    int i = paramObjectInputStream.readInt();
    setMap(Maps.newHashMapWithExpectedSize(i));
    Serialization.populateMultimap(this, paramObjectInputStream, i);
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeInt(expectedValuesPerKey);
    Serialization.writeMultimap(this, paramObjectOutputStream);
  }
  
  public boolean containsKey(Object paramObject)
  {
    return map.containsKey(paramObject);
  }
  
  public List createCollection()
  {
    return new ArrayList(expectedValuesPerKey);
  }
  
  public int size()
  {
    return totalSize;
  }
  
  public void trimToSize()
  {
    Iterator localIterator = backingMap().values().iterator();
    while (localIterator.hasNext()) {
      ((ArrayList)localIterator.next()).trimToSize();
    }
  }
}
