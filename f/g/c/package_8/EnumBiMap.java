package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.a.c;
import f.g.c.d.d;
import f.g.c.package_10.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@b(emulated=true)
public final class EnumBiMap<K extends Enum<K>, V extends Enum<V>>
  extends d<K, V>
{
  @c("not needed in emulated source.")
  public static final long serialVersionUID = 0L;
  public transient Class<K> keyType;
  public transient Class<V> valueType;
  
  public EnumBiMap(Class paramClass1, Class paramClass2)
  {
    super(new WellBehavedMap(new EnumMap(paramClass1)), new WellBehavedMap(new EnumMap(paramClass2)));
    keyType = paramClass1;
    valueType = paramClass2;
  }
  
  public static EnumBiMap create(Class paramClass1, Class paramClass2)
  {
    return new EnumBiMap(paramClass1, paramClass2);
  }
  
  public static EnumBiMap create(Map paramMap)
  {
    EnumBiMap localEnumBiMap = new EnumBiMap(inferKeyType(paramMap), inferValueType(paramMap));
    localEnumBiMap.putAll(paramMap);
    return localEnumBiMap;
  }
  
  public static Class inferKeyType(Map paramMap)
  {
    if ((paramMap instanceof EnumBiMap)) {
      return ((EnumBiMap)paramMap).keyType();
    }
    if ((paramMap instanceof EnumHashBiMap)) {
      return ((EnumHashBiMap)paramMap).keyType();
    }
    Preconditions.checkArgument(paramMap.isEmpty() ^ true);
    return ((Enum)paramMap.keySet().iterator().next()).getDeclaringClass();
  }
  
  public static Class inferValueType(Map paramMap)
  {
    if ((paramMap instanceof EnumBiMap)) {
      return valueType;
    }
    Preconditions.checkArgument(paramMap.isEmpty() ^ true);
    return ((Enum)paramMap.values().iterator().next()).getDeclaringClass();
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    keyType = ((Class)paramObjectInputStream.readObject());
    valueType = ((Class)paramObjectInputStream.readObject());
    setDelegates(new WellBehavedMap(new EnumMap(keyType)), new WellBehavedMap(new EnumMap(valueType)));
    Serialization.populateMap(this, paramObjectInputStream, paramObjectInputStream.readInt());
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(keyType);
    paramObjectOutputStream.writeObject(valueType);
    Serialization.writeMap(this, paramObjectOutputStream);
  }
  
  public Enum checkKey(Enum paramEnum)
  {
    if (paramEnum != null) {
      return paramEnum;
    }
    throw new NullPointerException();
  }
  
  public Enum checkValue(Enum paramEnum)
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
  
  public BiMap inverse()
  {
    return inverse;
  }
  
  public Class keyType()
  {
    return keyType;
  }
  
  public Class valueType()
  {
    return valueType;
  }
}
