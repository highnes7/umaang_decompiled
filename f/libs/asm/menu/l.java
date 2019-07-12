package f.libs.asm.menu;

import android.content.Context;
import android.os.Bundle;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import l.a.a.a.Item;
import l.a.a.a.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class l
  implements CopyOnWriteArrayList
{
  public static final String COLUMN_SKILLS_NAME = "name";
  public static final String EQUAL = "equals";
  public static final String GET_INSTANCE_METHOD_NAME = "getInstance";
  public static final String ON_EVENT_METHOD_NAME = "onEvent";
  public static final String PARAMETERS = "parameters";
  public static final List<Class<?>> a = Collections.unmodifiableList(Arrays.asList(new Class[] { String.class, String.class, Bundle.class, Long.class }));
  public static final String b = "Cannot register AppMeasurement Listener for Crashlytics breadcrumbs: ";
  public static final String e = "registerOnMeasurementEventListener";
  public static final String f = "toString";
  public static final String fHASH_CODE = "hashCode";
  public static final String g = "com.google.android.gms.measurement.AppMeasurement$OnEventListener";
  public static final String i = "crash";
  public static final String l = "com.google.android.gms.measurement.AppMeasurement";
  public final f c;
  public Object d;
  
  public l(f paramF)
  {
    c = paramF;
  }
  
  private Object a(Class paramClass)
  {
    try
    {
      Method localMethod = paramClass.getDeclaredMethod("getInstance", new Class[] { Context.class });
      Object localObject = c;
      localObject = ((Item)localObject).getContext();
      paramClass = localMethod.invoke(paramClass, new Object[] { localObject });
      return paramClass;
    }
    catch (Exception paramClass)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static String a(String paramString, Bundle paramBundle)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localJSONObject2.put(str, paramBundle.get(str));
    }
    localJSONObject1.put("name", paramString);
    localJSONObject1.put("parameters", localJSONObject2);
    return localJSONObject1.toString();
  }
  
  public static boolean a(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length != a.size()) {
      return false;
    }
    Iterator localIterator = a.iterator();
    int k = paramArrayOfObject.length;
    int j = 0;
    while (j < k)
    {
      if (!paramArrayOfObject[j].getClass().equals(localIterator.next())) {
        return false;
      }
      j += 1;
    }
    return true;
  }
  
  public static void b(f paramF, String paramString, Bundle paramBundle)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("$A$:");
      localStringBuilder.append(a(paramString, paramBundle));
      paramF.c(localStringBuilder.toString());
      return;
    }
    catch (JSONException paramF)
    {
      for (;;) {}
    }
    paramF = l.a.a.a.f.get();
    paramBundle = new StringBuilder();
    paramBundle.append("Unable to serialize Firebase Analytics event; ");
    paramBundle.append(paramString);
    paramF.remove("CrashlyticsCore", paramBundle.toString());
  }
  
  private Class create(String paramString)
  {
    f localF = c;
    try
    {
      paramString = localF.getContext().getClassLoader().loadClass(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    return null;
  }
  
  public boolean a()
  {
    Object localObject3 = create("com.google.android.gms.measurement.AppMeasurement");
    if (localObject3 == null)
    {
      l.a.a.a.f.get().d("CrashlyticsCore", "Firebase Analytics is not present; you will not see automatic logging of events before a crash occurs.");
      return false;
    }
    Object localObject1 = a((Class)localObject3);
    if (localObject1 == null)
    {
      l.a.a.a.f.get().remove("CrashlyticsCore", "Cannot register AppMeasurement Listener for Crashlytics breadcrumbs: Could not create an instance of Firebase Analytics.");
      return false;
    }
    Object localObject2 = create("com.google.android.gms.measurement.AppMeasurement$OnEventListener");
    if (localObject2 == null)
    {
      l.a.a.a.f.get().remove("CrashlyticsCore", "Cannot register AppMeasurement Listener for Crashlytics breadcrumbs: Could not get class com.google.android.gms.measurement.AppMeasurement$OnEventListener");
      return false;
    }
    try
    {
      localObject3 = ((Class)localObject3).getDeclaredMethod("registerOnMeasurementEventListener", new Class[] { localObject2 });
      localObject2 = b((Class)localObject2);
      ((Method)localObject3).invoke(localObject1, new Object[] { localObject2 });
      return true;
    }
    catch (Exception localException)
    {
      localObject2 = l.a.a.a.f.get();
      localObject3 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Cannot register AppMeasurement Listener for Crashlytics breadcrumbs: ");
      ((StringBuilder)localObject3).append(localException.getMessage());
      ((Log)localObject2).w("CrashlyticsCore", ((StringBuilder)localObject3).toString(), localException);
      return true;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      l.a.a.a.f.get().w("CrashlyticsCore", "Cannot register AppMeasurement Listener for Crashlytics breadcrumbs: Method registerOnMeasurementEventListener not found.", localNoSuchMethodException);
    }
    return false;
  }
  
  public Object b(Class paramClass)
  {
    try
    {
      if (d == null)
      {
        ClassLoader localClassLoader = c.getContext().getClassLoader();
        ResponseProxyHandler localResponseProxyHandler = new ResponseProxyHandler(this);
        d = Proxy.newProxyInstance(localClassLoader, new Class[] { paramClass }, localResponseProxyHandler);
      }
      paramClass = d;
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      throw paramClass;
    }
  }
}
