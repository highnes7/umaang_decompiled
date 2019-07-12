package com.google.android.android.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.android.common.ConnectionResult;
import com.google.android.android.common.internal.Log;
import com.google.android.android.common.internal.Point;
import com.google.android.android.common.internal.TaskManager;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.stats.Connector;

public final class zzcfb
  implements ServiceConnection, Point, Log
{
  public volatile boolean zziwm;
  public volatile zzcbv zziwn;
  
  public zzcfb(zzceo paramZzceo) {}
  
  public final void onConnected(Bundle paramBundle)
  {
    zzbp.zzfy("MeasurementServiceConnection.onConnected");
    try
    {
      paramBundle = zziwn;
      Object localObject;
      zziwn = null;
    }
    catch (Throwable paramBundle)
    {
      try
      {
        paramBundle = paramBundle.zzajj();
        paramBundle = (zzcbo)paramBundle;
        zziwn = null;
        localObject = zziwf;
        localObject = ((zzceo)localObject).zzauk();
        ((zzccr)localObject).e(new zzcfe(this, paramBundle));
      }
      catch (DeadObjectException paramBundle)
      {
        for (;;) {}
      }
      catch (IllegalStateException paramBundle)
      {
        for (;;) {}
      }
      paramBundle = paramBundle;
    }
    zziwm = false;
    return;
    throw paramBundle;
  }
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    zzbp.zzfy("MeasurementServiceConnection.onConnectionFailed");
    zzcbw localZzcbw = zziwf.zziki.zzayw();
    if (localZzcbw != null) {
      localZzcbw.zzayf().append("Service connection failed", paramConnectionResult);
    }
    try
    {
      zziwm = false;
      zziwn = null;
      zziwf.zzauk().e(new zzcfg(this));
      return;
    }
    catch (Throwable paramConnectionResult)
    {
      throw paramConnectionResult;
    }
  }
  
  public final void onConnectionSuspended(int paramInt)
  {
    zzbp.zzfy("MeasurementServiceConnection.onConnectionSuspended");
    zziwf.zzaul().zzayi().append("Service connection suspended");
    zziwf.zzauk().e(new zzcff(this));
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a10 = a9\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    zzbp.zzfy("MeasurementServiceConnection.onServiceDisconnected");
    zziwf.zzaul().zzayi().append("Service disconnected");
    zziwf.zzauk().e(new zzcfd(this, paramComponentName));
  }
  
  public final void parseFeed(Intent paramIntent)
  {
    zziwf.zzuj();
    Context localContext = zziwf.getContext();
    Connector localConnector = Connector.zzaky();
    try
    {
      if (zziwm)
      {
        zziwf.zzaul().zzayj().append("Connection attempt already in progress");
        return;
      }
      zziwm = true;
      localConnector.start(localContext, paramIntent, zziwf.zzivy, 129);
      return;
    }
    catch (Throwable paramIntent)
    {
      throw paramIntent;
    }
  }
  
  public final void zzazs()
  {
    zziwf.zzuj();
    Context localContext = zziwf.getContext();
    try
    {
      if (zziwm)
      {
        zziwf.zzaul().zzayj().append("Connection attempt already in progress");
        return;
      }
      if (zziwn != null)
      {
        zziwf.zzaul().zzayj().append("Already awaiting connection attempt");
        return;
      }
      zziwn = new zzcbv(localContext, Looper.getMainLooper(), this, this);
      zziwf.zzaul().zzayj().append("Connecting to remote service");
      zziwm = true;
      zziwn.zzajf();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
