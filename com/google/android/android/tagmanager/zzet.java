package com.google.android.android.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzbo;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class zzet
  implements zzag
{
  public boolean mClosed;
  public final Context mContext;
  public final String zzjoz;
  public String zzjpx;
  public com.google.android.gms.tagmanager.zzdi<zzbo> zzjty;
  public zzal zzjtz;
  public final ScheduledExecutorService zzjub;
  public final zzew zzjuc;
  public ScheduledFuture<?> zzjud;
  
  public zzet(Context paramContext, String paramString, zzal paramZzal)
  {
    this(paramContext, paramString, paramZzal, null, null);
  }
  
  public zzet(Context paramContext, String paramString, zzal paramZzal, zzex paramZzex, zzew paramZzew)
  {
    zzjtz = paramZzal;
    mContext = paramContext;
    zzjoz = paramString;
    zzjub = Executors.newSingleThreadScheduledExecutor();
    zzjuc = new zzev(this);
  }
  
  private final void zzbek()
  {
    try
    {
      boolean bool = mClosed;
      if (!bool) {
        return;
      }
      throw new IllegalStateException("called method after closed");
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void release()
  {
    try
    {
      zzbek();
      if (zzjud != null) {
        zzjud.cancel(false);
      }
      zzjub.shutdown();
      mClosed = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void setSleepTimer(long paramLong, String paramString)
  {
    try
    {
      Object localObject1 = zzjoz;
      Object localObject2 = new StringBuilder(String.valueOf(localObject1).length() + 55);
      ((StringBuilder)localObject2).append("loadAfterDelay: containerId=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" delay=");
      ((StringBuilder)localObject2).append(paramLong);
      localObject1 = ((StringBuilder)localObject2).toString();
      zzdj.zzjss.append((String)localObject1);
      zzbek();
      if (zzjty != null)
      {
        if (zzjud != null) {
          zzjud.cancel(false);
        }
        localObject1 = zzjub;
        localObject2 = zzjuc.getMapTile(zzjtz);
        ((zzes)localObject2).setBounds(zzjty);
        ((zzes)localObject2).zzli(zzjpx);
        ((zzes)localObject2).zzly(paramString);
        zzjud = ((ScheduledExecutorService)localObject1).schedule((Runnable)localObject2, paramLong, TimeUnit.MILLISECONDS);
        return;
      }
      throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public final void xor(zzdi paramZzdi)
  {
    try
    {
      zzbek();
      zzjty = paramZzdi;
      return;
    }
    catch (Throwable paramZzdi)
    {
      throw paramZzdi;
    }
  }
  
  public final void zzli(String paramString)
  {
    try
    {
      zzbek();
      zzjpx = paramString;
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
}
