package support.support.asm;

import android.arch.lifecycle.CompositeGeneratedAdaptersObserver;
import android.arch.lifecycle.FullLifecycleObserver;
import android.arch.lifecycle.FullLifecycleObserverAdapter;
import android.arch.lifecycle.GenericLifecycleObserver;
import android.arch.lifecycle.ReflectiveGenericLifecycleObserver;
import android.arch.lifecycle.SingleGeneratedAdapterObserver;
import b.a.b.g;
import b.a.b.i;
import b.b.a.N;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@N({b.b.a.N.a.b})
public class Frame
{
  public static final int BOOLEAN = 1;
  public static final int SIZE = 2;
  public static Map<Class, Integer> c = new HashMap();
  public static Map<Class, List<Constructor<? extends g>>> d = new HashMap();
  
  public Frame() {}
  
  public static GenericLifecycleObserver a(Object paramObject)
  {
    if ((paramObject instanceof FullLifecycleObserver)) {
      return new FullLifecycleObserverAdapter((FullLifecycleObserver)paramObject);
    }
    if ((paramObject instanceof GenericLifecycleObserver)) {
      return (GenericLifecycleObserver)paramObject;
    }
    Object localObject = paramObject.getClass();
    if (get((Class)localObject) == 2)
    {
      localObject = (List)d.get(localObject);
      int j = ((List)localObject).size();
      int i = 0;
      if (j == 1) {
        return new SingleGeneratedAdapterObserver(get((Constructor)((List)localObject).get(0), paramObject));
      }
      Attribute[] arrayOfAttribute = new Attribute[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        arrayOfAttribute[i] = get((Constructor)((List)localObject).get(i), paramObject);
        i += 1;
      }
      return new CompositeGeneratedAdaptersObserver(arrayOfAttribute);
    }
    return new ReflectiveGenericLifecycleObserver(paramObject);
  }
  
  public static int get(Class paramClass)
  {
    if (c.containsKey(paramClass)) {
      return ((Integer)c.get(paramClass)).intValue();
    }
    int i = init(paramClass);
    c.put(paramClass, Integer.valueOf(i));
    return i;
  }
  
  public static Attribute get(Constructor paramConstructor, Object paramObject)
  {
    try
    {
      paramConstructor = paramConstructor.newInstance(new Object[] { paramObject });
      return (Attribute)paramConstructor;
    }
    catch (InvocationTargetException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
    catch (InstantiationException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
    catch (IllegalAccessException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
  }
  
  public static String getID(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.replace(".", "_"));
    localStringBuilder.append("_LifecycleAdapter");
    return localStringBuilder.toString();
  }
  
  public static int init(Class paramClass)
  {
    if (paramClass.getCanonicalName() == null) {
      return 1;
    }
    Object localObject1 = toString(paramClass);
    if (localObject1 != null)
    {
      d.put(paramClass, Collections.singletonList(localObject1));
      return 2;
    }
    if (ClassWriter.b.a(paramClass)) {
      return 1;
    }
    Object localObject2 = paramClass.getSuperclass();
    localObject1 = null;
    if (put((Class)localObject2))
    {
      if (get((Class)localObject2) == 1) {
        return 1;
      }
      localObject1 = new ArrayList((Collection)d.get(localObject2));
    }
    Class[] arrayOfClass = paramClass.getInterfaces();
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Class localClass = arrayOfClass[i];
      if (put(localClass))
      {
        if (get(localClass) == 1) {
          return 1;
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        ((List)localObject2).addAll((Collection)d.get(localClass));
        localObject1 = localObject2;
      }
      i += 1;
    }
    if (localObject1 != null)
    {
      d.put(paramClass, localObject1);
      return 2;
    }
    return 1;
  }
  
  public static boolean put(Class paramClass)
  {
    return (paramClass != null) && (i.class.isAssignableFrom(paramClass));
  }
  
  public static Constructor toString(Class paramClass)
  {
    try
    {
      Object localObject1 = paramClass.getPackage();
      String str = paramClass.getCanonicalName();
      Object localObject2 = str;
      if (localObject1 != null) {
        localObject1 = ((Package)localObject1).getName();
      } else {
        localObject1 = "";
      }
      boolean bool = ((String)localObject1).isEmpty();
      if (!bool)
      {
        int i = ((String)localObject1).length();
        localObject2 = str.substring(i + 1);
      }
      str = getID((String)localObject2);
      localObject2 = str;
      bool = ((String)localObject1).isEmpty();
      if (bool)
      {
        localObject1 = localObject2;
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(".");
        ((StringBuilder)localObject2).append(str);
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = Class.forName((String)localObject1);
      paramClass = ((Class)localObject1).getDeclaredConstructor(new Class[] { paramClass });
      bool = paramClass.isAccessible();
      if (!bool)
      {
        paramClass.setAccessible(true);
        return paramClass;
      }
    }
    catch (NoSuchMethodException paramClass)
    {
      throw new RuntimeException(paramClass);
      return null;
    }
    catch (ClassNotFoundException paramClass)
    {
      for (;;) {}
    }
    return paramClass;
  }
}
