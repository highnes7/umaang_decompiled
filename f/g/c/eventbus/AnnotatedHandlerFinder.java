package f.g.c.eventbus;

import f.g.c.e.a;
import f.g.c.e.m;
import f.g.c.k.l;
import f.g.c.k.l.c;
import f.g.c.k.l.f;
import f.g.c.package_8.HashMultimap;
import f.g.c.package_8.Multimap;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Set;

public class AnnotatedHandlerFinder
  implements HandlerFindingStrategy
{
  public AnnotatedHandlerFinder() {}
  
  public static EventHandler makeHandler(Object paramObject, Method paramMethod)
  {
    if (methodIsDeclaredThreadSafe(paramMethod)) {
      return new EventHandler(paramObject, paramMethod);
    }
    return new SynchronizedEventHandler(paramObject, paramMethod);
  }
  
  public static boolean methodIsDeclaredThreadSafe(Method paramMethod)
  {
    return paramMethod.getAnnotation(a.class) != null;
  }
  
  public Multimap findAllHandlers(Object paramObject)
  {
    HashMultimap localHashMultimap = new HashMultimap();
    Object localObject1 = paramObject.getClass();
    Set localSet = new l.c((Type)localObject1).g().A();
    localObject1 = ((Class)localObject1).getMethods();
    int j = localObject1.length;
    int i = 0;
    Method localMethod;
    Iterator localIterator;
    if (i < j)
    {
      localMethod = localObject1[i];
      localIterator = localSet.iterator();
    }
    for (;;)
    {
      Object localObject2;
      if (localIterator.hasNext()) {
        localObject2 = (Class)localIterator.next();
      }
      try
      {
        boolean bool = ((Class)localObject2).getMethod(localMethod.getName(), localMethod.getParameterTypes()).isAnnotationPresent(m.class);
        if (!bool) {
          continue;
        }
        localObject2 = localMethod.getParameterTypes();
        if (localObject2.length == 1)
        {
          localObject2 = localObject2[0];
          localHashMultimap.put(localObject2, makeHandler(paramObject, localMethod));
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Method ");
          localStringBuilder.append(localMethod);
          localStringBuilder.append(" has @Subscribe annotation, but requires ");
          int k = localObject2.length;
          localStringBuilder.append(k);
          localStringBuilder.append(" arguments.  Event handler methods must require a single argument.");
          localObject2 = new IllegalArgumentException(localStringBuilder.toString());
          throw ((Throwable)localObject2);
        }
        i += 1;
      }
      catch (NoSuchMethodException localNoSuchMethodException) {}
      return localHashMultimap;
    }
  }
}
