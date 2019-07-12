package com.google.android.android.common.package_9.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.android.gms.common.api.internal.zzl;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class DefaultAppLock
  implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2
{
  public static final DefaultAppLock zzfis = new DefaultAppLock();
  public final ArrayList<zzl> mListeners = new ArrayList();
  public boolean zzdoe = false;
  public final AtomicBoolean zzfit = new AtomicBoolean();
  public final AtomicBoolean zzfiu = new AtomicBoolean();
  
  public DefaultAppLock() {}
  
  public static void enable(Application paramApplication)
  {
    DefaultAppLock localDefaultAppLock = zzfis;
    try
    {
      if (!zzfiszzdoe)
      {
        paramApplication.registerActivityLifecycleCallbacks(zzfis);
        paramApplication.registerComponentCallbacks(zzfis);
        zzfiszzdoe = true;
      }
      return;
    }
    catch (Throwable paramApplication)
    {
      throw paramApplication;
    }
  }
  
  public static DefaultAppLock zzafz()
  {
    return zzfis;
  }
  
  private final void zzbe(boolean paramBoolean)
  {
    DefaultAppLock localDefaultAppLock = zzfis;
    try
    {
      ArrayList localArrayList = mListeners;
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        Object localObject = localArrayList.get(i);
        i += 1;
        ((Transform)localObject).zzbe(paramBoolean);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    boolean bool = zzfit.compareAndSet(true, false);
    zzfiu.set(true);
    if (bool) {
      zzbe(false);
    }
  }
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity)
  {
    boolean bool = zzfit.compareAndSet(true, false);
    zzfiu.set(true);
    if (bool) {
      zzbe(false);
    }
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onLowMemory() {}
  
  public final void onTrimMemory(int paramInt)
  {
    if ((paramInt == 20) && (zzfit.compareAndSet(false, true)))
    {
      zzfiu.set(true);
      zzbe(true);
    }
  }
  
  public final void set(Transform paramTransform)
  {
    DefaultAppLock localDefaultAppLock = zzfis;
    try
    {
      mListeners.add(paramTransform);
      return;
    }
    catch (Throwable paramTransform)
    {
      throw paramTransform;
    }
  }
  
  public final boolean zzaga()
  {
    return zzfit.get();
  }
  
  public final boolean zzbd(boolean paramBoolean)
  {
    if (!zzfiu.get())
    {
      int i = Build.VERSION.SDK_INT;
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
      ActivityManager.getMyMemoryState(localRunningAppProcessInfo);
      if ((!zzfiu.getAndSet(true)) && (importance > 100)) {
        zzfit.set(true);
      }
    }
    return zzfit.get();
  }
}
