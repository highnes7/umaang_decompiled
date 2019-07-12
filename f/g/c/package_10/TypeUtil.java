package f.g.c.package_10;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class TypeUtil
{
  public static final Map<Class<?>, Object> cache;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Boolean.TYPE, Boolean.valueOf(false));
    localHashMap.put(Character.TYPE, Character.valueOf('\000'));
    localHashMap.put(Byte.TYPE, Byte.valueOf((byte)0));
    localHashMap.put(Short.TYPE, Short.valueOf((short)0));
    localHashMap.put(Integer.TYPE, Integer.valueOf(0));
    localHashMap.put(Long.TYPE, Long.valueOf(0L));
    localHashMap.put(Float.TYPE, Float.valueOf(0.0F));
    localHashMap.put(Double.TYPE, Double.valueOf(0.0D));
    cache = Collections.unmodifiableMap(localHashMap);
  }
  
  public TypeUtil() {}
  
  public static Object call(Class paramClass)
  {
    return cache.get(paramClass);
  }
  
  public static void call(Map paramMap, Class paramClass, Object paramObject)
  {
    paramMap.put(paramClass, paramObject);
  }
}
