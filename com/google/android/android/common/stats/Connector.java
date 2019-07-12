package com.google.android.android.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.google.android.android.common.util.Filter;
import java.util.Collections;
import java.util.List;

public final class Connector
{
  public static final Object zzfut = new Object();
  public static volatile Connector zzfxj;
  public static boolean zzfxk = false;
  public final List<String> zzfxl;
  public final List<String> zzfxm;
  public final List<String> zzfxn;
  public final List<String> zzfxo;
  
  public Connector()
  {
    List localList = Collections.EMPTY_LIST;
    zzfxl = localList;
    zzfxm = localList;
    zzfxn = localList;
    zzfxo = localList;
  }
  
  public static Connector zzaky()
  {
    if (zzfxj == null)
    {
      Object localObject = zzfut;
      try
      {
        if (zzfxj == null) {
          zzfxj = new Connector();
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return zzfxj;
  }
  
  public final boolean start(Context paramContext, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    return start(paramContext, paramContext.getClass().getName(), paramIntent, paramServiceConnection, paramInt);
  }
  
  public final boolean start(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    paramString = paramIntent.getComponent();
    boolean bool;
    if (paramString == null) {
      bool = false;
    } else {
      bool = Filter.zzab(paramContext, paramString.getPackageName());
    }
    if (bool) {
      return false;
    }
    return paramContext.bindService(paramIntent, paramServiceConnection, paramInt);
  }
}
