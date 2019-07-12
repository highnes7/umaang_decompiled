package com.google.android.android.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

public abstract class zzaf
{
  public static final Object zzfut = new Object();
  public static zzaf zzfuu;
  
  public zzaf() {}
  
  public static zzaf zzce(Context paramContext)
  {
    Object localObject = zzfut;
    try
    {
      if (zzfuu == null) {
        zzfuu = new zzah(paramContext.getApplicationContext());
      }
      return zzfuu;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public abstract void close(zzag paramZzag, ServiceConnection paramServiceConnection, String paramString);
  
  public final boolean connect(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString)
  {
    return open(new zzag(paramComponentName, 129), paramServiceConnection, paramString);
  }
  
  public abstract boolean open(zzag paramZzag, ServiceConnection paramServiceConnection, String paramString);
  
  public final void send(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString)
  {
    close(new zzag(paramComponentName, 129), paramServiceConnection, paramString);
  }
  
  public final void uninstall(String paramString1, String paramString2, int paramInt, ServiceConnection paramServiceConnection, String paramString3)
  {
    close(new zzag(paramString1, paramString2, paramInt), paramServiceConnection, paramString3);
  }
}
