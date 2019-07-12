package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.a.c;
import f.g.c.d.d;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

@b(emulated=true)
public final class EnumHashBiMap<K extends Enum<K>, V>
  extends d<K, V>
{
  @c("only needed in emulated source.")
  public static final long serialVersionUID = 0L;
  public transient Class<K> keyType;
  
  public EnumHashBiMap(Class paramClass)
  {
    super(new WellBehavedMap(new EnumMap(paramClass)), Maps.newHashMapWithExpectedSize(((Enum[])paramClass.getEnumConstants()).length));
    keyType = paramClass;
  }
  
  public static EnumHashBiMap create(Class paramClass)
  {
    return new EnumHashBiMap(paramClass);
  }
  
  public static EnumHashBiMap create(Map paramMap)
  {
    EnumHashBiMap localEnumHashBiMap = new EnumHashBiMap(EnumBiMap.inferKeyType(paramMap));
    localEnumHashBiMap.putAll(paramMap);
    return localEnumHashBiMap;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    keyType = ((Class)paramObjectInputStream.readObject());
    setDelegates(new WellBehavedMap(new EnumMap(keyType)), new HashMap(((Enum[])keyType.getEnumConstants()).length * 3 / 2));
    Serialization.populateMap(this, paramObjectInputStream, paramObjectInputStream.readInt());
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(keyType);
    Serialization.writeMap(this, paramObjectOutputStream);
  }
  
  public Enum checkKey(Enum paramEnum)
  {
    if (paramEnum != null) {
      return paramEnum;
    }
    throw new NullPointerException();
  }
  
  public boolean containsValue(Object paramObject)
  {
    return inverse.containsKey(paramObject);
  }
  
  public Object forcePut(Enum paramEnum, Object paramObject)
  {
    return super.forcePut(paramEnum, paramObject);
  }
  
  public BiMap inverse()
  {
    return inverse;
  }
  
  public Class keyType()
  {
    return keyType;
  }
  
  public Object put(Enum paramEnum, Object paramObject)
  {
    return super.put(paramEnum, paramObject);
  }
}
