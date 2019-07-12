package com.google.android.android.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.android.analytics.TerminalManager;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.stats.Connector;

public final class zzana
  implements ServiceConnection
{
  public volatile zzaoj zzdpf;
  public volatile boolean zzdpg;
  
  public zzana(zzamy paramZzamy) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a10 = a9\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    zzbp.zzfy("AnalyticsServiceConnection.onServiceDisconnected");
    zzdpe.zzwa().d(new zzanc(this, paramComponentName));
  }
  
  public final zzaoj zzwy()
  {
    TerminalManager.zzuj();
    Object localObject = new Intent("com.google.android.gms.analytics.service.START");
    ((Intent)localObject).setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
    Context localContext = zzdpe.getContext();
    ((Intent)localObject).putExtra("app_package_name", localContext.getPackageName());
    Connector localConnector = Connector.zzaky();
    for (;;)
    {
      try
      {
        zzdpf = null;
        zzdpg = true;
        boolean bool = localConnector.start(localContext, (Intent)localObject, zzdpe.zzdpa, 129);
        zzdpe.d("Bind to service requested", Boolean.valueOf(bool));
        if (!bool)
        {
          zzdpg = false;
          return null;
        }
        localObject = zzaod.zzdsk;
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      try
      {
        localObject = ((zzaoe)localObject).setDoOutput();
        localObject = (Long)localObject;
        wait(((Long)localObject).longValue());
      }
      catch (InterruptedException localInterruptedException) {}
    }
    zzdpe.zzdp("Wait for service connect was interrupted");
    zzdpg = false;
    localObject = zzdpf;
    zzdpf = null;
    if (localObject == null) {
      zzdpe.zzdq("Successfully bound to service but never got onServiceConnected callback");
    }
    return localObject;
  }
}
