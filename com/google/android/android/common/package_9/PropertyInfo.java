package com.google.android.android.common.package_9;

import android.os.Looper;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.package_9.internal.RealmObject;
import com.google.android.android.common.package_9.internal.zzcz;

public final class PropertyInfo
{
  public Looper zzakg;
  public zzcz zzfgu;
  
  public PropertyInfo() {}
  
  public final PropertyInfo setFlags(Looper paramLooper)
  {
    zzbp.get(paramLooper, "Looper must not be null.");
    zzakg = paramLooper;
    return this;
  }
  
  public final PropertyInfo setFlags(zzcz paramZzcz)
  {
    zzbp.get(paramZzcz, "StatusExceptionMapper must not be null.");
    zzfgu = paramZzcz;
    return this;
  }
  
  public final GoogleApi.zza zzafn()
  {
    if (zzfgu == null) {
      zzfgu = new RealmObject();
    }
    if (zzakg == null)
    {
      Looper localLooper;
      if (Looper.myLooper() != null) {
        localLooper = Looper.myLooper();
      } else {
        localLooper = Looper.getMainLooper();
      }
      zzakg = localLooper;
    }
    return new GoogleApi.zza(zzfgu, null, zzakg, null);
  }
}
