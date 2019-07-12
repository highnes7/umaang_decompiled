package l.a.a.a.a.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import l.a.a.a.Log;
import l.a.a.a.f;

public class Label
{
  public static final String RESOLVED = "com.google.firebase.crashlytics.prefs";
  public static final String TARGET = "firebase_crashlytics_collection_enabled";
  public static Label c;
  public static Object d = new Object();
  public final v a;
  public boolean e;
  public volatile boolean f;
  public volatile boolean h;
  public final SharedPreferences p;
  
  public Label(Context paramContext)
  {
    boolean bool3 = false;
    e = false;
    if (paramContext != null)
    {
      p = paramContext.getSharedPreferences("com.google.firebase.crashlytics.prefs", 0);
      a = w.a(paramContext);
      if (p.contains("firebase_crashlytics_collection_enabled")) {
        bool1 = p.getBoolean("firebase_crashlytics_collection_enabled", true);
      }
      boolean bool2;
      for (;;)
      {
        bool2 = true;
        break;
        try
        {
          Object localObject = paramContext.getPackageManager();
          if (localObject != null)
          {
            localObject = ((PackageManager)localObject).getApplicationInfo(paramContext.getPackageName(), 128);
            if ((localObject != null) && (metaData != null))
            {
              Bundle localBundle = metaData;
              bool1 = localBundle.containsKey("firebase_crashlytics_collection_enabled");
              if (bool1)
              {
                localObject = metaData;
                bool1 = ((Bundle)localObject).getBoolean("firebase_crashlytics_collection_enabled");
              }
            }
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          f.get().log("Fabric", "Unable to get PackageManager. Falling through", localNameNotFoundException);
          bool1 = true;
          bool2 = false;
        }
      }
      h = bool1;
      f = bool2;
      boolean bool1 = bool3;
      if (ClassWriter.getString(paramContext) != null) {
        bool1 = true;
      }
      e = bool1;
      return;
    }
    paramContext = new RuntimeException("null context");
    throw paramContext;
  }
  
  public static Label a(Context paramContext)
  {
    Object localObject = d;
    try
    {
      if (c == null) {
        c = new Label(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public static void visitMaxs(Context paramContext)
  {
    Object localObject = d;
    try
    {
      c = new Label(paramContext);
      return;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    h = paramBoolean;
    f = true;
    p.edit().putBoolean("firebase_crashlytics_collection_enabled", paramBoolean).commit();
  }
  
  public boolean a()
  {
    if ((e) && (f)) {
      return h;
    }
    v localV = a;
    if (localV != null) {
      return localV.a();
    }
    return true;
  }
  
  public boolean b()
  {
    return h;
  }
}
