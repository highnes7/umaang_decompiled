package android.support.v4.package_7;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class BundleCompat
{
  public BundleCompat() {}
  
  public static IBinder getBinder(Bundle paramBundle, String paramString)
  {
    int i = Build.VERSION.SDK_INT;
    return paramBundle.getBinder(paramString);
  }
  
  public static void putBinder(Bundle paramBundle, String paramString, IBinder paramIBinder)
  {
    int i = Build.VERSION.SDK_INT;
    paramBundle.putBinder(paramString, paramIBinder);
  }
  
  public class BundleCompatBaseImpl
  {
    public static final String PAGE_KEY = "BundleCompatBaseImpl";
    public static Method sGetIBinderMethod;
    public static boolean sGetIBinderMethodFetched;
    public static Method sPutIBinderMethod;
    public static boolean sPutIBinderMethodFetched;
    
    public BundleCompatBaseImpl() {}
    
    public static IBinder getBinder(Bundle paramBundle, String paramString)
    {
      if (!sGetIBinderMethodFetched) {}
      try
      {
        localMethod = Bundle.class.getMethod("getIBinder", new Class[] { String.class });
        sGetIBinderMethod = localMethod;
        localMethod = sGetIBinderMethod;
        localMethod.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Method localMethod;
        for (;;) {}
      }
      sGetIBinderMethodFetched = true;
      localMethod = sGetIBinderMethod;
      if (localMethod != null)
      {
        try
        {
          paramBundle = localMethod.invoke(paramBundle, new Object[] { paramString });
          return (IBinder)paramBundle;
        }
        catch (InvocationTargetException paramBundle)
        {
          for (;;) {}
        }
        catch (IllegalAccessException paramBundle)
        {
          for (;;) {}
        }
        catch (IllegalArgumentException paramBundle)
        {
          for (;;) {}
        }
        sGetIBinderMethod = null;
        return null;
      }
      return null;
    }
    
    public static void putBinder(Bundle paramBundle, String paramString, IBinder paramIBinder)
    {
      if (!sPutIBinderMethodFetched) {}
      try
      {
        localMethod = Bundle.class.getMethod("putIBinder", new Class[] { String.class, IBinder.class });
        sPutIBinderMethod = localMethod;
        localMethod = sPutIBinderMethod;
        localMethod.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Method localMethod;
        for (;;) {}
      }
      sPutIBinderMethodFetched = true;
      localMethod = sPutIBinderMethod;
      if (localMethod != null)
      {
        try
        {
          localMethod.invoke(paramBundle, new Object[] { paramString, paramIBinder });
          return;
        }
        catch (InvocationTargetException paramBundle)
        {
          for (;;) {}
        }
        catch (IllegalAccessException paramBundle)
        {
          for (;;) {}
        }
        catch (IllegalArgumentException paramBundle)
        {
          for (;;) {}
        }
        sPutIBinderMethod = null;
        return;
      }
    }
  }
}
