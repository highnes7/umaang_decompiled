package com.google.android.android.analytics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import com.google.android.android.internal.zzamj;
import com.google.android.android.internal.zzams;
import com.google.android.android.internal.zzamu;
import com.google.android.android.internal.zzant;
import com.google.android.android.internal.zzaod;
import com.google.android.android.internal.zzaoe;
import com.google.android.android.internal.zzaom;
import com.google.android.android.internal.zzapa;
import com.google.android.android.internal.zzapc;
import com.google.android.android.internal.zzape;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class GoogleAnalytics
  extends MyLog
{
  public static List<Runnable> zzdjw = new ArrayList();
  public boolean zzaqf;
  public Set<com.google.android.gms.analytics.GoogleAnalytics.zza> zzdjx = new HashSet();
  public boolean zzdjy;
  public boolean zzdjz;
  public volatile boolean zzdka;
  public boolean zzdkb;
  
  public GoogleAnalytics(zzamu paramZzamu)
  {
    super(paramZzamu);
  }
  
  public static GoogleAnalytics getInstance(Context paramContext)
  {
    return zzamu.zzbg(paramContext).zzwn();
  }
  
  public static void zztw()
  {
    try
    {
      if (zzdjw != null)
      {
        Iterator localIterator = zzdjw.iterator();
        while (localIterator.hasNext()) {
          ((Runnable)localIterator.next()).run();
        }
        zzdjw = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void closeTracker(zza paramZza)
  {
    zzdjx.remove(paramZza);
  }
  
  public final void dispatchLocalHits()
  {
    zztr().zzwc().zzvs();
  }
  
  public final void enableAutoActivityReports(Application paramApplication)
  {
    if (!zzdjy)
    {
      paramApplication.registerActivityLifecycleCallbacks(new zzb());
      zzdjy = true;
    }
  }
  
  public final boolean getAppOptOut()
  {
    return zzdka;
  }
  
  public final void getInstance(zza paramZza)
  {
    zzdjx.add(paramZza);
    paramZza = zztr().getContext();
    if ((paramZza instanceof Application)) {
      enableAutoActivityReports((Application)paramZza);
    }
  }
  
  public final Logger getLogger()
  {
    return zzaom.zzdth;
  }
  
  public final void initialize()
  {
    zzape localZzape = zztr().zzwe();
    localZzape.zzzn();
    if (localZzape.zzzo()) {
      setDryRun(localZzape.zzzp());
    }
    localZzape.zzzn();
    zzaqf = true;
  }
  
  public final boolean isDryRunEnabled()
  {
    return zzdjz;
  }
  
  public final boolean isInitialized()
  {
    return zzaqf;
  }
  
  public final void multiply(Activity paramActivity)
  {
    Iterator localIterator = zzdjx.iterator();
    while (localIterator.hasNext()) {
      ((zza)localIterator.next()).xor(paramActivity);
    }
  }
  
  public final Tracker newTracker(int paramInt)
  {
    try
    {
      Tracker localTracker = new Tracker(zztr(), null, null);
      if (paramInt > 0)
      {
        zzapc localZzapc = (zzapc)new zzapa(zztr()).zzat(paramInt);
        if (localZzapc != null) {
          localTracker.track(localZzapc);
        }
      }
      localTracker.initialize();
      return localTracker;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final Tracker newTracker(String paramString)
  {
    try
    {
      paramString = new Tracker(zztr(), paramString, null);
      paramString.initialize();
      return paramString;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public final void reportActivityStart(Activity paramActivity)
  {
    if (!zzdjy) {
      setFlags(paramActivity);
    }
  }
  
  public final void reportActivityStop(Activity paramActivity)
  {
    if (!zzdjy) {
      multiply(paramActivity);
    }
  }
  
  public final void setAppOptOut(boolean paramBoolean)
  {
    zzdka = paramBoolean;
    if (zzdka) {
      zztr().zzwc().zzvr();
    }
  }
  
  public final void setDryRun(boolean paramBoolean)
  {
    zzdjz = paramBoolean;
  }
  
  public final void setFlags(Activity paramActivity)
  {
    Iterator localIterator = zzdjx.iterator();
    while (localIterator.hasNext()) {
      ((zza)localIterator.next()).update(paramActivity);
    }
  }
  
  public final void setLocalDispatchPeriod(int paramInt)
  {
    zztr().zzwc().setLocalDispatchPeriod(paramInt);
  }
  
  public final void setLogger(Logger paramLogger)
  {
    zzaom.zzdth = paramLogger;
    if (!zzdkb)
    {
      paramLogger = (String)zzaod.zzdrb.setDoOutput();
      paramLogger = (String)zzaod.zzdrb.setDoOutput();
      StringBuilder localStringBuilder = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramLogger, 112));
      localStringBuilder.append("GoogleAnalytics.setLogger() is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.");
      localStringBuilder.append(paramLogger);
      localStringBuilder.append(" DEBUG");
      localStringBuilder.toString();
      zzdkb = true;
    }
  }
  
  public abstract interface zza
  {
    public abstract void update(Activity paramActivity);
    
    public abstract void xor(Activity paramActivity);
  }
  
  @TargetApi(14)
  public final class zzb
    implements Application.ActivityLifecycleCallbacks
  {
    public zzb() {}
    
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityDestroyed(Activity paramActivity) {}
    
    public final void onActivityPaused(Activity paramActivity) {}
    
    public final void onActivityResumed(Activity paramActivity) {}
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityStarted(Activity paramActivity)
    {
      setFlags(paramActivity);
    }
    
    public final void onActivityStopped(Activity paramActivity)
    {
      multiply(paramActivity);
    }
  }
}
