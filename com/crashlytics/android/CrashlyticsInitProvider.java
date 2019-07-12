package com.crashlytics.android;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.crashlytics.android.ndk.CrashlyticsNdk;
import f.libs.asm.b;
import f.libs.asm.e;
import l.a.a.a.Item;
import l.a.a.a.Log;
import l.a.a.a.a.b.h;
import l.a.a.a.f;

public class CrashlyticsInitProvider
  extends ContentProvider
{
  public static final String ACTION_UPDATE_ALL = "firebase_crashlytics_ndk_enabled";
  public static final String PAGE_KEY = "CrashlyticsInitProvider";
  
  public CrashlyticsInitProvider() {}
  
  private Item[] init(Context paramContext)
  {
    int i;
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      paramContext = metaData;
      if (paramContext != null)
      {
        boolean bool = paramContext.getBoolean("firebase_crashlytics_ndk_enabled", false);
        if (bool) {
          i = 1;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      f.get().log("Fabric", "Unable to get PackageManager while determining if Crashlytics NDK should be initialized", paramContext);
      i = 0;
    }
    paramContext = new b();
    if (i != 0) {
      try
      {
        f.get().i("Fabric", "Crashlytics is initializing NDK crash reporter.");
        CrashlyticsNdk localCrashlyticsNdk = new CrashlyticsNdk();
        return (Item[])new Item[] { paramContext, localCrashlyticsNdk };
      }
      catch (Throwable localThrowable)
      {
        f.get().d("Fabric", "Crashlytics failed to initialize NDK crash reporting. Attempting to intialize SDK...", localThrowable);
      }
    }
    return new Item[] { paramContext };
  }
  
  public boolean a(Context paramContext, h paramH, a paramA)
  {
    if (paramH.a(paramContext)) {
      return paramA.b(paramContext);
    }
    return paramH.f(paramContext);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    Context localContext = getContext();
    if (a(localContext, new h(), new e())) {}
    try
    {
      f.a(localContext, init(localContext.getApplicationContext()));
      f.get().i("CrashlyticsInitProvider", "CrashlyticsInitProvider initialization successful");
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;) {}
    }
    f.get().i("CrashlyticsInitProvider", "CrashlyticsInitProvider initialization unsuccessful");
    return false;
    f.get().i("CrashlyticsInitProvider", "CrashlyticsInitProvider skipping initialization");
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public static abstract interface a
  {
    public abstract boolean b(Context paramContext);
  }
}
