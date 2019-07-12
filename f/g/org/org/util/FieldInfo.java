package f.g.org.org.util;

import f.g.b.a.g.I;
import f.g.b.a.g.ca;
import f.g.b.a.g.v;
import f.g.b.a.g.z;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.WeakHashMap;

public class FieldInfo
{
  public static final Map<Field, v> CACHE = new WeakHashMap();
  public final Field field;
  public final boolean isPrimitive;
  public final String name;
  
  public FieldInfo(Field paramField, String paramString)
  {
    field = paramField;
    if (paramString == null) {
      paramField = null;
    } else {
      paramField = paramString.intern();
    }
    name = paramField;
    isPrimitive = Data.isPrimitive(getType());
  }
  
  public static Object getFieldValue(Field paramField, Object paramObject)
  {
    try
    {
      paramField = paramField.get(paramObject);
      return paramField;
    }
    catch (IllegalAccessException paramField)
    {
      throw new IllegalArgumentException(paramField);
    }
  }
  
  public static FieldInfo of(Enum paramEnum)
  {
    try
    {
      FieldInfo localFieldInfo = of(paramEnum.getClass().getField(paramEnum.name()));
      boolean bool;
      if (localFieldInfo != null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "enum constant missing @Value or @NullValue annotation: %s", new Object[] { paramEnum });
      return localFieldInfo;
    }
    catch (NoSuchFieldException paramEnum)
    {
      throw new RuntimeException(paramEnum);
    }
  }
  
  public static FieldInfo of(Field paramField)
  {
    Object localObject2 = null;
    if (paramField == null) {
      return null;
    }
    Map localMap = CACHE;
    try
    {
      FieldInfo localFieldInfo = (FieldInfo)CACHE.get(paramField);
      boolean bool = paramField.isEnumConstant();
      Object localObject1 = localFieldInfo;
      if (localFieldInfo == null) {
        if (!bool)
        {
          localObject1 = localFieldInfo;
          if (Modifier.isStatic(paramField.getModifiers())) {}
        }
        else
        {
          if (bool)
          {
            localObject1 = (Key)paramField.getAnnotation(ca.class);
            if (localObject1 != null) {
              localObject1 = ((Key)localObject1).value();
            } else if ((NullValue)paramField.getAnnotation(I.class) != null) {
              localObject1 = localObject2;
            } else {
              return null;
            }
          }
          else
          {
            localObject1 = (Value)paramField.getAnnotation(z.class);
            if (localObject1 == null) {
              return null;
            }
            localObject1 = ((Value)localObject1).value();
            paramField.setAccessible(true);
          }
          localObject2 = localObject1;
          if ("##default".equals(localObject1)) {
            localObject2 = paramField.getName();
          }
          localObject1 = new FieldInfo(paramField, (String)localObject2);
          CACHE.put(paramField, localObject1);
        }
      }
      return localObject1;
    }
    catch (Throwable paramField)
    {
      throw paramField;
    }
  }
  
  public static void setFieldValue(Field paramField, Object paramObject1, Object paramObject2)
  {
    if (Modifier.isFinal(paramField.getModifiers()))
    {
      Object localObject = getFieldValue(paramField, paramObject1);
      if (paramObject2 == null)
      {
        if (localObject != null) {}
      }
      else if (paramObject2.equals(localObject)) {
        return;
      }
      localObject = String.valueOf(localObject);
      paramObject2 = String.valueOf(paramObject2);
      paramField = String.valueOf(paramField.getName());
      paramObject1 = paramObject1.getClass().getName();
      int i = ((String)localObject).length();
      int j = paramObject2.length();
      int k = paramField.length();
      StringBuilder localStringBuilder = new StringBuilder(paramObject1.length() + (k + (j + (i + 48))));
      f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, "expected final value <", (String)localObject, "> but was <", paramObject2);
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.replace(localStringBuilder, "> on ", paramField, " field in ", paramObject1));
    }
    try
    {
      paramField.set(paramObject1, paramObject2);
      return;
    }
    catch (IllegalAccessException paramField)
    {
      throw new IllegalArgumentException(paramField);
    }
    catch (SecurityException paramField)
    {
      throw new IllegalArgumentException(paramField);
    }
  }
  
  public Enum enumValue()
  {
    return Enum.valueOf(field.getDeclaringClass(), field.getName());
  }
  
  public ClassInfo getClassInfo()
  {
    return ClassInfo.of(field.getDeclaringClass());
  }
  
  public Field getField()
  {
    return field;
  }
  
  public Type getGenericType()
  {
    return field.getGenericType();
  }
  
  public String getName()
  {
    return name;
  }
  
  public Class getType()
  {
    return field.getType();
  }
  
  public Object getValue(Object paramObject)
  {
    return getFieldValue(field, paramObject);
  }
  
  public boolean isFinal()
  {
    return Modifier.isFinal(field.getModifiers());
  }
  
  public boolean isPrimitive()
  {
    return isPrimitive;
  }
  
  public void setValue(Object paramObject1, Object paramObject2)
  {
    setFieldValue(field, paramObject1, paramObject2);
  }
}
