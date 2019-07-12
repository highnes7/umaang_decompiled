package f.libs.asm.asm;

import android.content.Context;
import android.os.Bundle;
import java.lang.reflect.Method;

public class l
  implements k
{
  public static final String c = "getInstance";
  public static final String e = "logEventInternal";
  public static final String g = "com.google.android.gms.measurement.AppMeasurement";
  public final Object b;
  public final Method d;
  
  public l(Object paramObject, Method paramMethod)
  {
    b = paramObject;
    d = paramMethod;
  }
  
  public static k a(Context paramContext)
  {
    Class localClass = create(paramContext);
    if (localClass == null) {
      return null;
    }
    Object localObject = get(paramContext, localClass);
    if (localObject == null) {
      return null;
    }
    paramContext = search(paramContext, localClass);
    if (paramContext == null) {
      return null;
    }
    return new l(localObject, paramContext);
  }
  
  public static Class create(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement");
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static Object get(Context paramContext, Class paramClass)
  {
    try
    {
      Method localMethod = paramClass.getDeclaredMethod("getInstance", new Class[] { Context.class });
      paramContext = localMethod.invoke(paramClass, new Object[] { paramContext });
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static Method search(Context paramContext, Class paramClass)
  {
    try
    {
      paramContext = paramClass.getDeclaredMethod("logEventInternal", new Class[] { String.class, String.class, Bundle.class });
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    return null;
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    a("fab", paramString, paramBundle);
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    Method localMethod = d;
    Object localObject = b;
    try
    {
      localMethod.invoke(localObject, new Object[] { paramString1, paramString2, paramBundle });
      return;
    }
    catch (Exception paramString1) {}
  }
}
