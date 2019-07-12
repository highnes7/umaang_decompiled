package com.google.android.android.common.package_9.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.google.android.android.common.package_9.BitmapCache;
import com.google.android.gms.common.api.internal.zzs;
import com.google.android.gms.common.api.zze;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

public final class zzdl
  implements IBinder.DeathRecipient, zzdm
{
  public final WeakReference<zzs<?>> zzfpv;
  public final WeakReference<zze> zzfpw;
  public final WeakReference<IBinder> zzfpx;
  
  public zzdl(Log paramLog, BitmapCache paramBitmapCache, IBinder paramIBinder)
  {
    zzfpw = new WeakReference(paramBitmapCache);
    zzfpv = new WeakReference(paramLog);
    zzfpx = new WeakReference(paramIBinder);
  }
  
  private final void zzair()
  {
    Object localObject = (Log)zzfpv.get();
    BitmapCache localBitmapCache = (BitmapCache)zzfpw.get();
    if ((localBitmapCache != null) && (localObject != null)) {
      localBitmapCache.remove(((Log)localObject).zzafs().intValue());
    }
    localObject = (IBinder)zzfpx.get();
    if (localObject != null) {
      try
      {
        ((IBinder)localObject).unlinkToDeath(this, 0);
        return;
      }
      catch (NoSuchElementException localNoSuchElementException) {}
    }
  }
  
  public final void binderDied()
  {
    zzair();
  }
  
  public final void removeTask(Log paramLog)
  {
    zzair();
  }
}
