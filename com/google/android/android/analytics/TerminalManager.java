package com.google.android.android.analytics;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.internal.zzalv;
import com.google.android.android.internal.zzama;
import com.google.android.android.internal.zzapd;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

public final class TerminalManager
{
  public static volatile TerminalManager zzdkx;
  public final Context mContext;
  public final List<Object> zzdky;
  public final ID3v1Tag zzdkz;
  public final zzj.zza zzdla;
  public volatile zzalv zzdlb;
  public Thread.UncaughtExceptionHandler zzdlc;
  
  public TerminalManager(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext();
    zzbp.append(paramContext);
    mContext = paramContext;
    zzdla = new zzj.zza(this);
    zzdky = new CopyOnWriteArrayList();
    zzdkz = new ID3v1Tag();
  }
  
  public static void onPostExecute(PingManager paramPingManager)
  {
    zzbp.zzgh("deliver should be called from worker thread");
    zzbp.get(paramPingManager.zzub(), "Measurement must be submitted");
    Object localObject = paramPingManager.getTransports();
    if (((List)localObject).isEmpty()) {
      return;
    }
    HashSet localHashSet = new HashSet();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Dictionary localDictionary = (Dictionary)((Iterator)localObject).next();
      Uri localUri = localDictionary.zztu();
      if (!localHashSet.contains(localUri))
      {
        localHashSet.add(localUri);
        localDictionary.write(paramPingManager);
      }
    }
  }
  
  public static TerminalManager zzbf(Context paramContext)
  {
    zzbp.append(paramContext);
    if (zzdkx == null) {
      try
      {
        if (zzdkx == null) {
          zzdkx = new TerminalManager(paramContext);
        }
      }
      catch (Throwable paramContext)
      {
        throw paramContext;
      }
    }
    return zzdkx;
  }
  
  public static void zzuj()
  {
    if ((Thread.currentThread() instanceof zzj.zzc)) {
      return;
    }
    throw new IllegalStateException("Call expected from worker thread");
  }
  
  public final void d(Runnable paramRunnable)
  {
    zzbp.append(paramRunnable);
    zzdla.submit(paramRunnable);
  }
  
  public final Future execute(Callable paramCallable)
  {
    zzbp.append(paramCallable);
    if ((Thread.currentThread() instanceof zzj.zzc))
    {
      paramCallable = new FutureTask(paramCallable);
      paramCallable.run();
      return paramCallable;
    }
    return zzdla.submit(paramCallable);
  }
  
  public final Context getContext()
  {
    return mContext;
  }
  
  public final void onCreate(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    zzdlc = paramUncaughtExceptionHandler;
  }
  
  public final void removeEntry(PingManager paramPingManager)
  {
    if (!paramPingManager.zzue())
    {
      if (!paramPingManager.zzub())
      {
        paramPingManager = paramPingManager.zztx();
        paramPingManager.zzuc();
        zzdla.execute(new IonBitmapRequestBuilder.1(this, paramPingManager));
        return;
      }
      throw new IllegalStateException("Measurement can only be submitted once");
    }
    throw new IllegalStateException("Measurement prototype can't be submitted");
  }
  
  public final zzalv zzuh()
  {
    Object localObject2 = zzdlb;
    Object localObject1 = this;
    if (localObject2 == null) {}
    for (;;)
    {
      try
      {
        localObject2 = zzdlb;
        localObject4 = localObject1;
        if (localObject2 == null)
        {
          localZzalv = new zzalv();
          localPackageManager = mContext.getPackageManager();
          str = mContext.getPackageName();
          localObject1 = str;
          localZzalv.setAppId(str);
          localZzalv.setAppInstallerId(localPackageManager.getInstallerPackageName(str));
          localObject5 = null;
          localObject2 = mContext;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject4;
        zzalv localZzalv;
        PackageManager localPackageManager;
        String str;
        Object localObject5;
        PackageInfo localPackageInfo;
        Object localObject3;
        boolean bool;
        throw localThrowable;
      }
      try
      {
        localPackageInfo = localPackageManager.getPackageInfo(((Context)localObject2).getPackageName(), 0);
        localObject2 = localObject1;
        localObject3 = localObject5;
        if (localPackageInfo == null) {
          continue;
        }
        localObject2 = applicationInfo;
        localObject3 = localPackageManager.getApplicationLabel((ApplicationInfo)localObject2);
        bool = TextUtils.isEmpty((CharSequence)localObject3);
        localObject2 = localObject1;
        if (!bool) {
          localObject2 = ((CharSequence)localObject3).toString();
        }
        localObject3 = versionName;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    }
    localObject2 = String.valueOf(str);
    if (((String)localObject2).length() != 0)
    {
      "Error retrieving package info: appName set to ".concat((String)localObject2);
      localObject2 = localObject1;
      localObject3 = localObject5;
    }
    else
    {
      new String("Error retrieving package info: appName set to ");
      localObject3 = localObject5;
      localObject2 = localObject1;
    }
    localZzalv.setAppName((String)localObject2);
    localZzalv.setAppVersion((String)localObject3);
    zzdlb = localZzalv;
    return zzdlb;
  }
  
  public final zzama zzui()
  {
    DisplayMetrics localDisplayMetrics = mContext.getResources().getDisplayMetrics();
    zzama localZzama = new zzama();
    localZzama.setLanguage(zzapd.query(Locale.getDefault()));
    zzceu = widthPixels;
    zzcev = heightPixels;
    return localZzama;
  }
}
