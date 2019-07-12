package android.support.v4.package_7;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;
import b.b.a.K;
import b.b.a.N;

@K(api=28)
@N({b.b.a.N.a.b})
public class CoreComponentFactory
  extends AppComponentFactory
{
  public static final String PAGE_KEY = "CoreComponentFactory";
  
  public CoreComponentFactory() {}
  
  public static Object checkCompatWrapper(Object paramObject)
  {
    if ((paramObject instanceof CompatWrapped))
    {
      Object localObject = ((CompatWrapped)paramObject).getWrapper();
      if (localObject != null) {
        return localObject;
      }
    }
    return paramObject;
  }
  
  public Activity instantiateActivity(ClassLoader paramClassLoader, String paramString, Intent paramIntent)
    throws InstantiationException, IllegalAccessException, ClassNotFoundException
  {
    return (Activity)checkCompatWrapper(super.instantiateActivity(paramClassLoader, paramString, paramIntent));
  }
  
  public Application instantiateApplication(ClassLoader paramClassLoader, String paramString)
    throws InstantiationException, IllegalAccessException, ClassNotFoundException
  {
    return (Application)checkCompatWrapper(super.instantiateApplication(paramClassLoader, paramString));
  }
  
  public ContentProvider instantiateProvider(ClassLoader paramClassLoader, String paramString)
    throws InstantiationException, IllegalAccessException, ClassNotFoundException
  {
    return (ContentProvider)checkCompatWrapper(super.instantiateProvider(paramClassLoader, paramString));
  }
  
  public BroadcastReceiver instantiateReceiver(ClassLoader paramClassLoader, String paramString, Intent paramIntent)
    throws InstantiationException, IllegalAccessException, ClassNotFoundException
  {
    return (BroadcastReceiver)checkCompatWrapper(super.instantiateReceiver(paramClassLoader, paramString, paramIntent));
  }
  
  public Service instantiateService(ClassLoader paramClassLoader, String paramString, Intent paramIntent)
    throws InstantiationException, IllegalAccessException, ClassNotFoundException
  {
    return (Service)checkCompatWrapper(super.instantiateService(paramClassLoader, paramString, paramIntent));
  }
  
  @N({b.b.a.N.a.b})
  public abstract interface CompatWrapped
  {
    public abstract Object getWrapper();
  }
}
