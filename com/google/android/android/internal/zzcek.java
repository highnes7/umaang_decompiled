package com.google.android.android.internal;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.util.Log;
import com.google.android.android.measurement.AppMeasurement.zzb;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import support.android.v4.util.ArrayMap;

public final class zzcek
  extends zzcdu
{
  public zzcen zzivj;
  public volatile AppMeasurement.zzb zzivk;
  public AppMeasurement.zzb zzivl;
  public long zzivm;
  public final Map<Activity, com.google.android.gms.internal.zzcen> zzivn = new ArrayMap();
  public final CopyOnWriteArrayList<com.google.android.gms.measurement.AppMeasurement.zza> zzivo = new CopyOnWriteArrayList();
  public boolean zzivp;
  public AppMeasurement.zzb zzivq;
  public String zzivr;
  
  public zzcek(zzccw paramZzccw)
  {
    super(paramZzccw);
  }
  
  public static void add(AppMeasurement.zzb paramZzb, Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramZzb != null) && (!paramBundle.containsKey("_sc")))
    {
      String str = zzikn;
      if (str != null) {
        paramBundle.putString("_sn", str);
      }
      paramBundle.putString("_sc", zziko);
      paramBundle.putLong("_si", zzikp);
    }
  }
  
  private final void persist(Activity paramActivity, zzcen paramZzcen, boolean paramBoolean)
  {
    Object localObject1 = zzivk;
    AppMeasurement.zzb localZzb2 = null;
    if (localObject1 != null) {
      localObject1 = zzivk;
    } else if ((zzivl != null) && (Math.abs(zzvx().elapsedRealtime() - zzivm) < 1000L)) {
      localObject1 = zzivl;
    } else {
      localObject1 = null;
    }
    if (localObject1 != null) {
      localZzb2 = new AppMeasurement.zzb((AppMeasurement.zzb)localObject1);
    }
    int i = 1;
    boolean bool1 = true;
    zzivp = true;
    localObject1 = zzivo;
    try
    {
      localObject1 = ((CopyOnWriteArrayList)localObject1).iterator();
      for (;;)
      {
        i = bool1;
        boolean bool2 = ((Iterator)localObject1).hasNext();
        i = bool1;
        if (!bool2) {
          break;
        }
        i = bool1;
        Object localObject2 = ((Iterator)localObject1).next();
        localObject2 = (com.google.android.android.measurement.AppMeasurement.zza)localObject2;
        try
        {
          bool2 = ((com.google.android.android.measurement.AppMeasurement.zza)localObject2).get(localZzb2, paramZzcen);
          bool1 &= bool2;
        }
        catch (Exception localException2)
        {
          i = bool1;
          zzaul().zzayd().append("onScreenChangeCallback threw exception", localException2);
        }
      }
    }
    catch (Throwable paramActivity) {}catch (Exception localException1)
    {
      for (;;)
      {
        zzaul().zzayd().append("onScreenChangeCallback loop threw exception", localException1);
      }
    }
    zzivp = false;
    AppMeasurement.zzb localZzb1;
    if (zzivk == null) {
      localZzb1 = zzivl;
    } else {
      localZzb1 = zzivk;
    }
    if (i != 0)
    {
      if (zziko == null) {
        zziko = zzjt(paramActivity.getClass().getCanonicalName());
      }
      paramActivity = new zzcen(paramZzcen);
      zzivl = zzivk;
      zzivm = zzvx().elapsedRealtime();
      zzivk = paramActivity;
      zzauk().e(new zzcel(this, paramBoolean, localZzb1, paramActivity));
      return;
      zzivp = false;
      throw paramActivity;
    }
  }
  
  private final void updateButton(zzcen paramZzcen)
  {
    zzatx().zzaj(zzvx().elapsedRealtime());
    if (zzauj().zzbs(zzivx)) {
      zzivx = false;
    }
  }
  
  public static String zzjt(String paramString)
  {
    Object localObject = paramString.split("\\.");
    if (localObject.length == 0) {
      return paramString.substring(0, 36);
    }
    localObject = localObject[(localObject.length - 1)];
    paramString = (String)localObject;
    if (((String)localObject).length() > 36) {
      paramString = ((String)localObject).substring(0, 36);
    }
    return paramString;
  }
  
  public final zzcen e(Activity paramActivity)
  {
    zzbp.append(paramActivity);
    zzcen localZzcen2 = (zzcen)zzivn.get(paramActivity);
    zzcen localZzcen1 = localZzcen2;
    if (localZzcen2 == null)
    {
      localZzcen1 = new zzcen(null, zzjt(paramActivity.getClass().getCanonicalName()), zzauh().zzazx());
      zzivn.put(paramActivity, localZzcen1);
    }
    return localZzcen1;
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    zzivn.remove(paramActivity);
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    paramActivity = e(paramActivity);
    zzivl = zzivk;
    zzivm = zzvx().elapsedRealtime();
    zzivk = null;
    zzauk().e(new zzcem(this, paramActivity));
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    persist(paramActivity, e(paramActivity), false);
    paramActivity = zzatx();
    long l = paramActivity.zzvx().elapsedRealtime();
    paramActivity.zzauk().e(new zzcaq(paramActivity, l));
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    paramActivity = (zzcen)zzivn.get(paramActivity);
    if (paramActivity == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("id", zzikp);
    localBundle.putString("name", zzikn);
    localBundle.putString("referrer_name", zziko);
    paramBundle.putBundle("com.google.firebase.analytics.screen_service", localBundle);
  }
  
  public final void purchaseBook(String paramString, AppMeasurement.zzb paramZzb)
  {
    zzuj();
    try
    {
      if ((zzivr == null) || (zzivr.equals(paramString)) || (paramZzb != null))
      {
        zzivr = paramString;
        zzivq = paramZzb;
      }
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public final void registerOnScreenChangeCallback(com.google.android.android.measurement.AppMeasurement.zza paramZza)
  {
    zzatv();
    if (paramZza == null)
    {
      zzaul().zzayf().append("Attempting to register null OnScreenChangeCallback");
      return;
    }
    zzivo.remove(paramZza);
    zzivo.add(paramZza);
  }
  
  public final void setCurrentScreen(Activity paramActivity, String paramString1, String paramString2)
  {
    if (paramActivity == null)
    {
      zzaul().zzayf().append("setCurrentScreen must be called with a non-null activity");
      return;
    }
    zzauk();
    if (!zzccr.zzaq())
    {
      zzaul().zzayf().append("setCurrentScreen must be called from the main thread");
      return;
    }
    if (zzivp)
    {
      zzaul().zzayf().append("Cannot call setCurrentScreen from onScreenChangeCallback");
      return;
    }
    if (zzivk == null)
    {
      zzaul().zzayf().append("setCurrentScreen cannot be called while no activity active");
      return;
    }
    if (zzivn.get(paramActivity) == null)
    {
      zzaul().zzayf().append("setCurrentScreen must be called with an activity in the activity lifecycle");
      return;
    }
    String str = paramString2;
    if (paramString2 == null) {
      str = zzjt(paramActivity.getClass().getCanonicalName());
    }
    boolean bool1 = zzivk.zziko.equals(str);
    boolean bool2 = zzcfw.zzas(zzivk.zzikn, paramString1);
    if ((bool1) && (bool2))
    {
      zzaul().zzayg().append("setCurrentScreen cannot be called with the same class and name");
      return;
    }
    int i;
    if (paramString1 != null) {
      if (paramString1.length() > 0)
      {
        i = paramString1.length();
        zzcax.zzavq();
        if (i <= 100) {}
      }
      else
      {
        zzaul().zzayf().append("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(paramString1.length()));
        return;
      }
    }
    if (str != null) {
      if (str.length() > 0)
      {
        i = str.length();
        zzcax.zzavq();
        if (i <= 100) {}
      }
      else
      {
        zzaul().zzayf().append("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
        return;
      }
    }
    zzcby localZzcby = zzaul().zzayj();
    if (paramString1 == null) {
      paramString2 = "null";
    } else {
      paramString2 = paramString1;
    }
    localZzcby.append("Setting current screen to name, class", paramString2, str);
    paramString1 = new zzcen(paramString1, str, zzauh().zzazx());
    zzivn.put(paramActivity, paramString1);
    persist(paramActivity, paramString1, true);
  }
  
  public final void unregisterOnScreenChangeCallback(com.google.android.android.measurement.AppMeasurement.zza paramZza)
  {
    zzatv();
    zzivo.remove(paramZza);
  }
  
  public final void zzatu()
  {
    zzccw.zzatu();
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void zzatv()
  {
    zzcax.zzawk();
  }
  
  public final zzcen zzazn()
  {
    zzwk();
    zzuj();
    return zzivj;
  }
  
  public final AppMeasurement.zzb zzazo()
  {
    zzatv();
    AppMeasurement.zzb localZzb = zzivk;
    if (localZzb == null) {
      return null;
    }
    return new AppMeasurement.zzb(localZzb);
  }
  
  public final void zzuk() {}
}
