package support.support.asm;

import b.a.b.a.a;
import b.a.b.h.a;
import b.a.b.j;
import b.a.b.t;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ClassWriter
{
  public static final int COMPUTE_FRAMES = 2;
  public static final int COMPUTE_MAXS = 1;
  public static final int L = 0;
  public static ClassWriter b = new ClassWriter();
  public final Map<Class, Boolean> c = new HashMap();
  public final Map<Class, a.a> d = new HashMap();
  
  public ClassWriter() {}
  
  private ByteVector a(Class paramClass, Method[] paramArrayOfMethod)
  {
    Object localObject1 = paramClass.getSuperclass();
    HashMap localHashMap = new HashMap();
    if (localObject1 != null)
    {
      localObject1 = b((Class)localObject1);
      if (localObject1 != null) {
        localHashMap.putAll(a);
      }
    }
    localObject1 = paramClass.getInterfaces();
    int j = localObject1.length;
    int i = 0;
    Object localObject2;
    Object localObject3;
    while (i < j)
    {
      localObject2 = ba.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        a(localHashMap, (Label)((Map.Entry)localObject3).getKey(), (c)((Map.Entry)localObject3).getValue(), paramClass);
      }
      i += 1;
    }
    if (paramArrayOfMethod == null) {
      paramArrayOfMethod = getMethod(paramClass);
    }
    int k = paramArrayOfMethod.length;
    j = 0;
    boolean bool = false;
    while (j < k)
    {
      localObject1 = paramArrayOfMethod[j];
      localObject3 = (x)((Method)localObject1).getAnnotation(t.class);
      if (localObject3 != null)
      {
        localObject2 = ((Method)localObject1).getParameterTypes();
        if (localObject2.length > 0)
        {
          if (localObject2[0].isAssignableFrom(j.class)) {
            i = 1;
          } else {
            throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
          }
        }
        else {
          i = 0;
        }
        localObject3 = ((x)localObject3).value();
        if (localObject2.length > 1) {
          if (localObject2[1].isAssignableFrom(h.a.class))
          {
            if (localObject3 == c.ON_ANY) {
              i = 2;
            } else {
              throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
            }
          }
          else {
            throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
          }
        }
        if (localObject2.length <= 2)
        {
          a(localHashMap, new Label(i, (Method)localObject1), (c)localObject3, paramClass);
          bool = true;
        }
      }
      else
      {
        j += 1;
        continue;
      }
      throw new IllegalArgumentException("cannot have more than 2 params");
    }
    paramArrayOfMethod = new ByteVector(localHashMap);
    d.put(paramClass, paramArrayOfMethod);
    c.put(paramClass, Boolean.valueOf(bool));
    return paramArrayOfMethod;
  }
  
  private void a(Map paramMap, Label paramLabel, c paramC, Class paramClass)
  {
    c localC = (c)paramMap.get(paramLabel);
    if ((localC != null) && (paramC != localC))
    {
      paramMap = b;
      paramLabel = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Method ");
      paramLabel.append(paramMap.getName());
      paramLabel.append(" in ");
      paramLabel.append(paramClass.getName());
      paramLabel.append(" already declared with different @OnLifecycleEvent value: previous value ");
      paramLabel.append(localC);
      paramLabel.append(", new value ");
      paramLabel.append(paramC);
      throw new IllegalArgumentException(paramLabel.toString());
    }
    if (localC == null) {
      paramMap.put(paramLabel, paramC);
    }
  }
  
  private Method[] getMethod(Class paramClass)
  {
    try
    {
      paramClass = paramClass.getDeclaredMethods();
      return paramClass;
    }
    catch (NoClassDefFoundError paramClass)
    {
      throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", paramClass);
    }
  }
  
  public boolean a(Class paramClass)
  {
    if (c.containsKey(paramClass)) {
      return ((Boolean)c.get(paramClass)).booleanValue();
    }
    Method[] arrayOfMethod = getMethod(paramClass);
    int j = arrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      if ((x)arrayOfMethod[i].getAnnotation(t.class) != null)
      {
        a(paramClass, arrayOfMethod);
        return true;
      }
      i += 1;
    }
    c.put(paramClass, Boolean.valueOf(false));
    return false;
  }
  
  public ByteVector b(Class paramClass)
  {
    ByteVector localByteVector = (ByteVector)d.get(paramClass);
    if (localByteVector != null) {
      return localByteVector;
    }
    return a(paramClass, null);
  }
}
