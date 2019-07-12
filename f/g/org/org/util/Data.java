package f.g.org.org.util;

import f.g.b.a.g.a;
import f.g.b.a.g.t;
import f.g.b.a.g.w;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class Data
{
  public static final BigDecimal NULL_BIG_DECIMAL;
  public static final BigInteger NULL_BIG_INTEGER;
  public static final Boolean NULL_BOOLEAN = new Boolean(true);
  public static final Byte NULL_BYTE;
  public static final ConcurrentHashMap<Class<?>, Object> NULL_CACHE;
  public static final Character NULL_CHARACTER;
  public static final DateTime NULL_DATE_TIME;
  public static final Double NULL_DOUBLE;
  public static final Float NULL_FLOAT;
  public static final Integer NULL_INTEGER;
  public static final Long NULL_LONG;
  public static final Short NULL_SHORT;
  public static final String NULL_STRING = new String();
  
  static
  {
    NULL_CHARACTER = new Character('\000');
    NULL_BYTE = new Byte((byte)0);
    NULL_SHORT = new Short((short)0);
    NULL_INTEGER = new Integer(0);
    NULL_FLOAT = new Float(0.0F);
    NULL_LONG = new Long(0L);
    NULL_DOUBLE = new Double(0.0D);
    NULL_BIG_INTEGER = new BigInteger("0");
    NULL_BIG_DECIMAL = new BigDecimal("0");
    NULL_DATE_TIME = new DateTime(0L);
    NULL_CACHE = new ConcurrentHashMap();
    NULL_CACHE.put(Boolean.class, NULL_BOOLEAN);
    NULL_CACHE.put(String.class, NULL_STRING);
    NULL_CACHE.put(Character.class, NULL_CHARACTER);
    NULL_CACHE.put(Byte.class, NULL_BYTE);
    NULL_CACHE.put(Short.class, NULL_SHORT);
    NULL_CACHE.put(Integer.class, NULL_INTEGER);
    NULL_CACHE.put(Float.class, NULL_FLOAT);
    NULL_CACHE.put(Long.class, NULL_LONG);
    NULL_CACHE.put(Double.class, NULL_DOUBLE);
    NULL_CACHE.put(BigInteger.class, NULL_BIG_INTEGER);
    NULL_CACHE.put(BigDecimal.class, NULL_BIG_DECIMAL);
    NULL_CACHE.put(t.class, NULL_DATE_TIME);
  }
  
  public Data() {}
  
  public static Object clone(Object paramObject)
  {
    if (paramObject != null)
    {
      if (isPrimitive(paramObject.getClass())) {
        return paramObject;
      }
      if ((paramObject instanceof GenericData)) {
        return ((GenericData)paramObject).clone();
      }
      Object localObject = paramObject.getClass();
      if (((Class)localObject).isArray()) {
        localObject = Array.newInstance(((Class)localObject).getComponentType(), Array.getLength(paramObject));
      } else if ((paramObject instanceof ArrayMap)) {
        localObject = ((ArrayMap)paramObject).clone();
      } else {
        localObject = Types.newInstance((Class)localObject);
      }
      deepCopy(paramObject, localObject);
      return localObject;
    }
    return paramObject;
  }
  
  public static void deepCopy(Object paramObject1, Object paramObject2)
  {
    Object localObject1 = paramObject1.getClass();
    Object localObject2 = paramObject2.getClass();
    boolean bool2 = true;
    int i = 0;
    int j = 0;
    if (localObject1 == localObject2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.append(bool1);
    if (((Class)localObject1).isArray())
    {
      if (Array.getLength(paramObject1) == Array.getLength(paramObject2)) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      Preconditions.append(bool1);
      paramObject1 = Types.iterableOf(paramObject1).iterator();
      i = j;
      while (paramObject1.hasNext())
      {
        Array.set(paramObject2, i, clone(paramObject1.next()));
        i += 1;
      }
    }
    if (Collection.class.isAssignableFrom((Class)localObject1))
    {
      paramObject1 = (Collection)paramObject1;
      if (ArrayList.class.isAssignableFrom((Class)localObject1)) {
        ((ArrayList)paramObject2).ensureCapacity(paramObject1.size());
      }
      paramObject2 = (Collection)paramObject2;
      paramObject1 = paramObject1.iterator();
      while (paramObject1.hasNext()) {
        paramObject2.add(clone(paramObject1.next()));
      }
    }
    boolean bool1 = w.class.isAssignableFrom((Class)localObject1);
    if ((!bool1) && (Map.class.isAssignableFrom((Class)localObject1)))
    {
      if (a.class.isAssignableFrom((Class)localObject1))
      {
        paramObject2 = (ArrayMap)paramObject2;
        paramObject1 = (ArrayMap)paramObject1;
        j = paramObject1.size();
        while (i < j)
        {
          paramObject2.set(i, clone(paramObject1.get(i)));
          i += 1;
        }
      }
      paramObject2 = (Map)paramObject2;
      paramObject1 = ((Map)paramObject1).entrySet().iterator();
    }
    while (paramObject1.hasNext())
    {
      localObject1 = (Map.Entry)paramObject1.next();
      paramObject2.put(((Map.Entry)localObject1).getKey(), clone(((Map.Entry)localObject1).getValue()));
      continue;
      if (bool1) {
        localObject1 = classInfo;
      } else {
        localObject1 = ClassInfo.of((Class)localObject1);
      }
      localObject2 = names.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        FieldInfo localFieldInfo = ((ClassInfo)localObject1).getFieldInfo((String)((Iterator)localObject2).next());
        if ((!localFieldInfo.isFinal()) && ((!bool1) || (!localFieldInfo.isPrimitive())))
        {
          Object localObject3 = localFieldInfo.getValue(paramObject1);
          if (localObject3 != null) {
            localFieldInfo.setValue(paramObject2, clone(localObject3));
          }
        }
      }
    }
  }
  
  public static boolean isNull(Object paramObject)
  {
    return (paramObject != null) && (paramObject == NULL_CACHE.get(paramObject.getClass()));
  }
  
  public static boolean isPrimitive(Type paramType)
  {
    Type localType = paramType;
    if ((paramType instanceof WildcardType)) {
      localType = Types.getBound((WildcardType)paramType);
    }
    if (!(localType instanceof Class)) {
      return false;
    }
    paramType = (Class)localType;
    return (paramType.isPrimitive()) || (paramType == Character.class) || (paramType == String.class) || (paramType == Integer.class) || (paramType == Long.class) || (paramType == Short.class) || (paramType == Byte.class) || (paramType == Float.class) || (paramType == Double.class) || (paramType == BigInteger.class) || (paramType == BigDecimal.class) || (paramType == t.class) || (paramType == Boolean.class);
  }
  
  public static boolean isValueOfPrimitiveType(Object paramObject)
  {
    return (paramObject == null) || (isPrimitive(paramObject.getClass()));
  }
  
  public static Map mapOf(Object paramObject)
  {
    if ((paramObject != null) && (!isNull(paramObject)))
    {
      if ((paramObject instanceof Map)) {
        return (Map)paramObject;
      }
      return new DataMap(paramObject, false);
    }
    return Collections.emptyMap();
  }
  
  public static Collection newCollectionInstance(Type paramType)
  {
    Object localObject = paramType;
    if ((paramType instanceof WildcardType)) {
      localObject = Types.getBound((WildcardType)paramType);
    }
    paramType = (Type)localObject;
    if ((localObject instanceof ParameterizedType)) {
      paramType = ((ParameterizedType)localObject).getRawType();
    }
    if ((paramType instanceof Class)) {
      localObject = (Class)paramType;
    } else {
      localObject = null;
    }
    if ((paramType != null) && (!(paramType instanceof GenericArrayType)) && ((localObject == null) || ((!((Class)localObject).isArray()) && (!((Class)localObject).isAssignableFrom(ArrayList.class)))))
    {
      if (localObject != null)
      {
        if (((Class)localObject).isAssignableFrom(HashSet.class)) {
          return new HashSet();
        }
        if (((Class)localObject).isAssignableFrom(TreeSet.class)) {
          return new TreeSet();
        }
        return (Collection)Types.newInstance((Class)localObject);
      }
      paramType = String.valueOf(paramType);
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(new StringBuilder(paramType.length() + 39), "unable to create new instance of type: ", paramType));
    }
    return new ArrayList();
  }
  
  public static Map newMapInstance(Class paramClass)
  {
    if ((paramClass != null) && (!paramClass.isAssignableFrom(a.class)))
    {
      if (paramClass.isAssignableFrom(TreeMap.class)) {
        return new TreeMap();
      }
      return (Map)Types.newInstance(paramClass);
    }
    return new ArrayMap();
  }
  
  public static Object nullOf(Class paramClass)
  {
    Object localObject1 = NULL_CACHE.get(paramClass);
    if (localObject1 == null)
    {
      ConcurrentHashMap localConcurrentHashMap = NULL_CACHE;
      try
      {
        Object localObject2 = NULL_CACHE.get(paramClass);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          boolean bool = paramClass.isArray();
          int i = 0;
          if (bool)
          {
            localObject1 = paramClass;
            int j;
            do
            {
              localObject2 = ((Class)localObject1).getComponentType();
              localObject1 = localObject2;
              j = i + 1;
              i = j;
            } while (((Class)localObject2).isArray());
            localObject1 = Array.newInstance((Class)localObject2, new int[j]);
          }
          else if (paramClass.isEnum())
          {
            localObject1 = ClassInfo.of(paramClass).getFieldInfo(null);
            Preconditions.checkNotNull(localObject1, "enum missing constant with @NullValue annotation: %s", new Object[] { paramClass });
            localObject1 = ((FieldInfo)localObject1).enumValue();
          }
          else
          {
            localObject1 = Types.newInstance(paramClass);
          }
          NULL_CACHE.put(paramClass, localObject1);
        }
        return localObject1;
      }
      catch (Throwable paramClass)
      {
        throw paramClass;
      }
    }
    return localObject1;
  }
  
  public static Object parsePrimitiveValue(Type paramType, String paramString)
  {
    Class localClass;
    if ((paramType instanceof Class)) {
      localClass = (Class)paramType;
    } else {
      localClass = null;
    }
    if ((paramType == null) || (localClass != null))
    {
      if (localClass == Void.class) {
        return null;
      }
      if ((paramString == null) || (localClass == null)) {
        return paramString;
      }
      if (localClass.isAssignableFrom(String.class)) {
        return paramString;
      }
      if ((localClass == Character.class) || (localClass == Character.TYPE)) {
        break label310;
      }
      if ((localClass == Boolean.class) || (localClass == Boolean.TYPE)) {
        break label305;
      }
      if ((localClass == Byte.class) || (localClass == Byte.TYPE)) {
        break label300;
      }
      if ((localClass == Short.class) || (localClass == Short.TYPE)) {
        break label295;
      }
      if ((localClass == Integer.class) || (localClass == Integer.TYPE)) {
        break label290;
      }
      if ((localClass == Long.class) || (localClass == Long.TYPE)) {
        break label285;
      }
      if ((localClass == Float.class) || (localClass == Float.TYPE)) {
        break label280;
      }
      if ((localClass == Double.class) || (localClass == Double.TYPE)) {
        break label275;
      }
      if (localClass == t.class) {
        return DateTime.parseRfc3339(paramString);
      }
      if (localClass == BigInteger.class) {
        return new BigInteger(paramString);
      }
      if (localClass == BigDecimal.class) {
        return new BigDecimal(paramString);
      }
      if (localClass.isEnum()) {
        return ClassInfo.of(localClass).getFieldInfo(paramString).enumValue();
      }
    }
    paramType = String.valueOf(paramType);
    throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(new StringBuilder(paramType.length() + 35), "expected primitive class, but got: ", paramType));
    label275:
    return Double.valueOf(paramString);
    label280:
    return Float.valueOf(paramString);
    label285:
    return Long.valueOf(paramString);
    label290:
    return Integer.valueOf(paramString);
    label295:
    return Short.valueOf(paramString);
    label300:
    return Byte.valueOf(paramString);
    label305:
    return Boolean.valueOf(paramString);
    label310:
    if (paramString.length() == 1) {
      return Character.valueOf(paramString.charAt(0));
    }
    paramType = String.valueOf(localClass);
    throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(new StringBuilder(paramType.length() + 37), "expected type Character/char but got ", paramType));
    return paramString;
  }
  
  public static Type resolveWildcardTypeOrTypeVariable(List paramList, Type paramType)
  {
    Type localType1 = paramType;
    if ((paramType instanceof WildcardType)) {
      localType1 = Types.getBound((WildcardType)paramType);
    }
    while ((localType1 instanceof TypeVariable))
    {
      Type localType2 = Types.resolveTypeVariable(paramList, (TypeVariable)localType1);
      paramType = localType1;
      if (localType2 != null) {
        paramType = localType2;
      }
      localType1 = paramType;
      if ((paramType instanceof TypeVariable)) {
        localType1 = ((TypeVariable)paramType).getBounds()[0];
      }
    }
    return localType1;
  }
}
