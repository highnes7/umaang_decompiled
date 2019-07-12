package com.google.android.android.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.android.common.package_9.Status;
import com.google.android.android.common.util.Clock;
import com.google.android.android.internal.zzbl;
import com.google.android.android.internal.zzbo;
import com.google.android.android.internal.zzdbm;
import com.google.android.android.internal.zzdbn;
import com.google.android.android.internal.zzdbs;
import com.google.android.gms.common.api.internal.zzs;

public final class Waypoint
  extends zzs<com.google.android.gms.tagmanager.ContainerHolder>
{
  public final Context mContext;
  public final Looper zzakg;
  public final com.google.android.android.common.util.Log zzasc;
  public final String zzjoz;
  public long zzjpe;
  public final TagManager zzjpl;
  public final zzaf zzjpo;
  public final zzek zzjpp;
  public final int zzjpq;
  public final zzai zzjpr;
  public zzah zzjps;
  public zzdbn zzjpt;
  public volatile ServiceListener zzjpu;
  public volatile boolean zzjpv;
  public zzbo zzjpw;
  public String zzjpx;
  public zzag zzjpy;
  public zzac zzjpz;
  
  public Waypoint(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, zzah paramZzah, zzag paramZzag, zzdbn paramZzdbn, com.google.android.android.common.util.Log paramLog, zzek paramZzek, zzai paramZzai)
  {
    super(localLooper);
    mContext = paramContext;
    zzjpl = paramTagManager;
    paramContext = paramLooper;
    if (paramLooper == null) {
      paramContext = Looper.getMainLooper();
    }
    zzakg = paramContext;
    zzjoz = paramString;
    zzjpq = paramInt;
    zzjps = paramZzah;
    zzjpy = paramZzag;
    zzjpt = paramZzdbn;
    zzjpo = new zzaf(this, null);
    zzjpw = new zzbo();
    zzasc = paramLog;
    zzjpp = paramZzek;
    zzjpr = paramZzai;
    if (zzbcv()) {
      zzlh(zzei.zzbeh().zzbej());
    }
  }
  
  public Waypoint(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, zzal paramZzal)
  {
    this(paramContext, paramTagManager, paramLooper, paramString, paramInt, localZzey, localZzet, localZzdbn, localClock, new zzdh(1, 5, 900000L, 5000L, "refreshing", localClock), new zzai(paramContext, paramString));
    zzjpt.zznj(paramZzal.zzbdc());
  }
  
  private final void blur(zzbo paramZzbo)
  {
    try
    {
      if (zzjps != null)
      {
        zzdbm localZzdbm = new zzdbm();
        zzkfj = zzjpe;
        zzxx = new zzbl();
        zzkfk = paramZzbo;
        zzjps.loadMapTileAsync(localZzdbm);
      }
      return;
    }
    catch (Throwable paramZzbo)
    {
      throw paramZzbo;
    }
  }
  
  private final void draw(zzbo paramZzbo, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      if (isReady())
      {
        ServiceListener localServiceListener = zzjpu;
        if (localServiceListener == null) {
          return;
        }
      }
      zzjpw = paramZzbo;
      zzjpe = paramLong;
      long l = zzjpr.zzbcx();
      zzbf(Math.max(0L, Math.min(l, zzjpe + l - zzasc.currentTimeMillis())));
      paramZzbo = new Container(mContext, zzjpl.getDataLayer(), zzjoz, paramLong, paramZzbo);
      if (zzjpu == null) {
        zzjpu = new ServiceListener(zzjpl, zzakg, paramZzbo, zzjpo);
      } else {
        zzjpu.removeListener(paramZzbo);
      }
      if ((!isReady()) && (zzjpz.addLocation(paramZzbo))) {
        setResult(zzjpu);
      }
      return;
    }
    catch (Throwable paramZzbo)
    {
      throw paramZzbo;
    }
  }
  
  private final boolean zzbcv()
  {
    zzei localZzei = zzei.zzbeh();
    return ((localZzei.zzbei() == zzei.zza.zzjtn) || (localZzei.zzbei() == zzei.zza.zzjto)) && (zzjoz.equals(localZzei.getContainerId()));
  }
  
  private final void zzbf(long paramLong)
  {
    try
    {
      if (zzjpy == null)
      {
        zzdj.zzjss.zzcr("Refresh requested, but no network load scheduler.");
        return;
      }
      zzjpy.setSleepTimer(paramLong, zzjpw.zzxy);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private final void zzbt(boolean paramBoolean)
  {
    zzjps.addPauseListener(new zzad(this, null));
    zzjpy.xor(new zzae(this, null));
    zzdbs localZzdbs = zzjps.zzee(zzjpq);
    if (localZzdbs != null)
    {
      TagManager localTagManager = zzjpl;
      zzjpu = new ServiceListener(localTagManager, zzakg, new Container(mContext, localTagManager.getDataLayer(), zzjoz, 0L, localZzdbs), zzjpo);
    }
    zzjpz = new zzab(this, paramBoolean);
    if (zzbcv())
    {
      zzjpy.setSleepTimer(0L, "");
      return;
    }
    zzjps.zzbcw();
  }
  
  public final ContainerHolder zzai(Status paramStatus)
  {
    if (zzjpu != null) {
      return zzjpu;
    }
    if (paramStatus == Status.zzfhy) {
      zzdj.zzjss.get("timer expired: setting result to failure");
    }
    return new ServiceListener(paramStatus);
  }
  
  public final String zzbcp()
  {
    try
    {
      String str = zzjpx;
      return str;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void zzbcs()
  {
    Object localObject = zzjps.zzee(zzjpq);
    if (localObject != null)
    {
      localObject = new Container(mContext, zzjpl.getDataLayer(), zzjoz, 0L, (zzdbs)localObject);
      setResult(new ServiceListener(zzjpl, zzakg, (Container)localObject, new zzaa(this)));
    }
    else
    {
      zzdj.zzjss.get("Default was requested, but no default container was found");
      setResult(zzai(new Status(1, 10, "Default was requested, but no default container was found", null)));
    }
    zzjpy = null;
    zzjps = null;
  }
  
  public final void zzbct()
  {
    zzbt(false);
  }
  
  public final void zzbcu()
  {
    zzbt(true);
  }
  
  public final void zzlh(String paramString)
  {
    try
    {
      zzjpx = paramString;
      if (zzjpy != null) {
        zzjpy.zzli(paramString);
      }
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
}
