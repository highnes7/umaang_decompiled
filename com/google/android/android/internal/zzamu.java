package com.google.android.android.internal;

import android.content.Context;
import com.google.android.android.analytics.GoogleAnalytics;
import com.google.android.android.analytics.TerminalManager;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.util.Clock;
import com.google.android.android.common.util.Log;

public class zzamu
{
  public static volatile zzamu zzdog;
  public final Context mContext;
  public final Log zzasc;
  public final Context zzdoh;
  public final zzanv zzdoi;
  public final zzaon zzdoj;
  public final TerminalManager zzdok;
  public final zzamj zzdol;
  public final zzaoa zzdom;
  public final zzape zzdon;
  public final zzaor zzdoo;
  public final GoogleAnalytics zzdop;
  public final zzanm zzdoq;
  public final zzami zzdor;
  public final zzanf zzdos;
  public final zzanz zzdot;
  
  public zzamu(zzamw paramZzamw)
  {
    Object localObject1 = paramZzamw.getApplicationContext();
    zzbp.get(localObject1, "Application context can't be null");
    Object localObject2 = paramZzamw.zzwl();
    zzbp.append(localObject2);
    mContext = ((Context)localObject1);
    zzdoh = ((Context)localObject2);
    zzasc = Clock.zzfyr;
    zzdoi = new zzanv(this);
    localObject2 = new zzaon(this);
    ((zzams)localObject2).initialize();
    zzdoj = ((zzaon)localObject2);
    localObject2 = zzvy();
    Object localObject3 = zzamt.VERSION;
    Object localObject4 = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(localObject3, 134));
    ((StringBuilder)localObject4).append("Google Analytics ");
    ((StringBuilder)localObject4).append((String)localObject3);
    ((StringBuilder)localObject4).append(" is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4");
    ((zzamr)localObject2).zzdo(((StringBuilder)localObject4).toString());
    localObject2 = new zzaor(this);
    ((zzams)localObject2).initialize();
    zzdoo = ((zzaor)localObject2);
    localObject2 = new zzape(this);
    ((zzams)localObject2).initialize();
    zzdon = ((zzape)localObject2);
    paramZzamw = new zzamj(this, paramZzamw);
    localObject2 = new zzanm(this);
    localObject3 = new zzami(this);
    localObject4 = new zzanf(this);
    zzanz localZzanz = new zzanz(this);
    localObject1 = TerminalManager.zzbf((Context)localObject1);
    ((TerminalManager)localObject1).onCreate(new zzamv(this));
    zzdok = ((TerminalManager)localObject1);
    localObject1 = new GoogleAnalytics(this);
    ((zzams)localObject2).initialize();
    zzdoq = ((zzanm)localObject2);
    ((zzams)localObject3).initialize();
    zzdor = ((zzami)localObject3);
    ((zzams)localObject4).initialize();
    zzdos = ((zzanf)localObject4);
    localZzanz.initialize();
    zzdot = localZzanz;
    localObject2 = new zzaoa(this);
    ((zzams)localObject2).initialize();
    zzdom = ((zzaoa)localObject2);
    paramZzamw.initialize();
    zzdol = paramZzamw;
    ((GoogleAnalytics)localObject1).initialize();
    zzdop = ((GoogleAnalytics)localObject1);
    paramZzamw.start();
  }
  
  public static void dispatchEvent(zzams paramZzams)
  {
    zzbp.get(paramZzams, "Analytics service not created/initialized");
    zzbp.get(paramZzams.isInitialized(), "Analytics service not initialized");
  }
  
  public static zzamu zzbg(Context paramContext)
  {
    zzbp.append(paramContext);
    if (zzdog == null) {
      try
      {
        if (zzdog == null)
        {
          Clock localClock = Clock.zzfyr;
          long l1 = localClock.elapsedRealtime();
          paramContext = new zzamu(new zzamw(paramContext));
          zzdog = paramContext;
          GoogleAnalytics.zztw();
          l1 = localClock.elapsedRealtime() - l1;
          long l2 = ((Long)zzaod.zzdsp.setDoOutput()).longValue();
          if (l1 > l2) {
            paramContext.zzvy().append("Slow initialization (ms)", Long.valueOf(l1), Long.valueOf(l2));
          }
        }
      }
      catch (Throwable paramContext)
      {
        throw paramContext;
      }
    }
    return zzdog;
  }
  
  public final Context getContext()
  {
    return mContext;
  }
  
  public final Log zzvx()
  {
    return zzasc;
  }
  
  public final zzaon zzvy()
  {
    dispatchEvent(zzdoj);
    return zzdoj;
  }
  
  public final zzanv zzvz()
  {
    return zzdoi;
  }
  
  public final TerminalManager zzwa()
  {
    zzbp.append(zzdok);
    return zzdok;
  }
  
  public final zzamj zzwc()
  {
    dispatchEvent(zzdol);
    return zzdol;
  }
  
  public final zzaoa zzwd()
  {
    dispatchEvent(zzdom);
    return zzdom;
  }
  
  public final zzape zzwe()
  {
    dispatchEvent(zzdon);
    return zzdon;
  }
  
  public final zzaor zzwf()
  {
    dispatchEvent(zzdoo);
    return zzdoo;
  }
  
  public final zzanf zzwi()
  {
    dispatchEvent(zzdos);
    return zzdos;
  }
  
  public final zzanz zzwj()
  {
    return zzdot;
  }
  
  public final Context zzwl()
  {
    return zzdoh;
  }
  
  public final zzaon zzwm()
  {
    return zzdoj;
  }
  
  public final GoogleAnalytics zzwn()
  {
    zzbp.append(zzdop);
    zzbp.get(zzdop.isInitialized(), "Analytics instance not initialized");
    return zzdop;
  }
  
  public final zzaor zzwo()
  {
    zzaor localZzaor = zzdoo;
    if ((localZzaor != null) && (localZzaor.isInitialized())) {
      return zzdoo;
    }
    return null;
  }
  
  public final zzami zzwp()
  {
    dispatchEvent(zzdor);
    return zzdor;
  }
  
  public final zzanm zzwq()
  {
    dispatchEvent(zzdoq);
    return zzdoq;
  }
}
