package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.a.c;
import f.g.c.d.d;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

@b(emulated=true)
public final class HashBiMap<K, V>
  extends d<K, V>
{
  @c("Not needed in emulated source")
  public static final long size = 0L;
  
  public HashBiMap()
  {
    super(new HashMap(), new HashMap());
  }
  
  public HashBiMap(int paramInt)
  {
    super(Maps.newHashMapWithExpectedSize(paramInt), Maps.newHashMapWithExpectedSize(paramInt));
  }
  
  public static HashBiMap create()
  {
    return new HashBiMap();
  }
  
  public static HashBiMap create(int paramInt)
  {
    return new HashBiMap(paramInt);
  }
  
  public static HashBiMap create(Map paramMap)
  {
    HashBiMap localHashBiMap = new HashBiMap(paramMap.size());
    localHashBiMap.putAll(paramMap);
    return localHashBiMap;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    int i = paramObjectInputStream.readInt();
    setDelegates(Maps.newHashMapWithExpectedSize(i), Maps.newHashMapWithExpectedSize(i));
    Serialization.populateMap(this, paramObjectInputStream, i);
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    Serialization.writeMap(this, paramObjectOutputStream);
  }
  
  public boolean containsValue(Object paramObject)
  {
    return inverse.containsKey(paramObject);
  }
  
  public Object forcePut(Object paramObject1, Object paramObject2)
  {
    return super.forcePut(paramObject1, paramObject2);
  }
  
  public BiMap inverse()
  {
    return inverse;
  }
  
  public Object put(Object paramObject1, Object paramObject2)
  {
    return super.put(paramObject1, paramObject2);
  }
}
