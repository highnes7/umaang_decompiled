package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.a.c;
import f.g.c.a.d;
import f.g.c.d.v;
import f.g.c.package_10.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@b(emulated=true, serializable=true)
public final class HashMultimap<K, V>
  extends v<K, V>
{
  public static final int DEFAULT_VALUES_PER_KEY = 2;
  @c("Not needed in emulated source")
  public static final long serialVersionUID = 0L;
  @d
  public transient int expectedValuesPerKey = 2;
  
  public HashMultimap()
  {
    super(new HashMap());
  }
  
  public HashMultimap(int paramInt1, int paramInt2)
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
  
  public HashMultimap(Multimap paramMultimap)
  {
    super(Maps.newHashMapWithExpectedSize(paramMultimap.keySet().size()));
    putAll(paramMultimap);
  }
  
  public static HashMultimap create()
  {
    return new HashMultimap();
  }
  
  public static HashMultimap create(int paramInt1, int paramInt2)
  {
    return new HashMultimap(paramInt1, paramInt2);
  }
  
  public static HashMultimap create(Multimap paramMultimap)
  {
    return new HashMultimap(paramMultimap);
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
  
  public Set createCollection()
  {
    return Sets.newHashSetWithExpectedSize(expectedValuesPerKey);
  }
  
  public int size()
  {
    return totalSize;
  }
}
