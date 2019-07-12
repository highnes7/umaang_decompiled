package com.google.android.android.internal;

import android.os.Binder;
import android.text.TextUtils;
import b.b.a.G;
import com.google.android.android.common.DataProvider;
import com.google.android.android.common.TransactionInput;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.util.Connection;
import com.google.android.android.common.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class zzcdb
  extends zzcbp
{
  public final zzccw zziki;
  public Boolean zziuh;
  @G
  public String zziui;
  
  public zzcdb(zzccw paramZzccw)
  {
    zzbp.append(paramZzccw);
    zziki = paramZzccw;
    zziui = null;
  }
  
  public zzcdb(zzccw paramZzccw, String paramString)
  {
    zzbp.append(paramZzccw);
    zziki = paramZzccw;
    zziui = null;
  }
  
  private final void e(zzcas paramZzcas, boolean paramBoolean)
  {
    zzbp.append(paramZzcas);
    put(packageName, false);
    zziki.zzauh().zzkb(zzilu);
  }
  
  private final void put(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject;
      if (paramBoolean) {
        if (zziuh == null) {
          localObject = zziui;
        }
      }
      try
      {
        paramBoolean = "com.google.android.gms".equals(localObject);
        if (!paramBoolean)
        {
          localObject = zziki;
          paramBoolean = Connection.execute(((zzccw)localObject).getContext(), Binder.getCallingUid());
          if (!paramBoolean)
          {
            localObject = zziki;
            paramBoolean = DataProvider.zzbz(((zzccw)localObject).getContext()).zzbo(Binder.getCallingUid());
            if (!paramBoolean)
            {
              paramBoolean = false;
              break label87;
            }
          }
        }
        paramBoolean = true;
        label87:
        zziuh = Boolean.valueOf(paramBoolean);
        localObject = zziuh;
        paramBoolean = ((Boolean)localObject).booleanValue();
        if (paramBoolean) {
          return;
        }
        if (zziui == null)
        {
          localObject = zziki;
          paramBoolean = TransactionInput.connect(((zzccw)localObject).getContext(), Binder.getCallingUid(), paramString);
          if (paramBoolean) {
            zziui = paramString;
          }
        }
        localObject = zziui;
        paramBoolean = paramString.equals(localObject);
        if (paramBoolean) {
          return;
        }
        throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[] { paramString }));
      }
      catch (SecurityException localSecurityException)
      {
        zziki.zzaul().zzayd().append("Measurement Service called with invalid calling package. appId", zzcbw.zzjf(paramString));
        throw localSecurityException;
      }
    }
    zziki.zzaul().zzayd().append("Measurement Service called without app package");
    throw new SecurityException("Measurement Service called without app package");
  }
  
  public final void addPackage(zzcav paramZzcav)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a5 = a4\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public final void bindToService(zzcas paramZzcas)
  {
    e(paramZzcas, false);
    paramZzcas = new zzcdr(this, paramZzcas);
    if (zziki.zzauk().zzays())
    {
      paramZzcas.run();
      return;
    }
    zziki.zzauk().e(paramZzcas);
  }
  
  public final void getAbsoluteUrl(zzcas paramZzcas)
  {
    e(paramZzcas, false);
    zziki.zzauk().e(new zzcdc(this, paramZzcas));
  }
  
  public final String getAttachment(zzcas paramZzcas)
  {
    e(paramZzcas, false);
    return zziki.zzjs(packageName);
  }
  
  public final List getFromLocationName(zzcas paramZzcas, boolean paramBoolean)
  {
    e(paramZzcas, false);
    Object localObject1 = zziki.zzauk().getFromLocationName(new zzcdq(this, paramZzcas));
    try
    {
      localObject1 = ((Future)localObject1).get();
      Object localObject2 = (List)localObject1;
      localObject1 = new ArrayList(((List)localObject2).size());
      localObject2 = ((List)localObject2).iterator();
      for (;;)
      {
        boolean bool = ((Iterator)localObject2).hasNext();
        if (!bool) {
          break;
        }
        Object localObject3 = ((Iterator)localObject2).next();
        localObject3 = (zzcfv)localObject3;
        if (!paramBoolean)
        {
          String str = mName;
          bool = zzcfw.zzkd(str);
          if (bool) {}
        }
        else
        {
          ((List)localObject1).add(new zzcft((zzcfv)localObject3));
        }
      }
      return localObject1;
    }
    catch (ExecutionException localExecutionException) {}catch (InterruptedException localInterruptedException) {}
    zziki.zzaul().zzayd().append("Failed to get user attributes. appId", zzcbw.zzjf(packageName), localInterruptedException);
    return null;
  }
  
  public final List getFromLocationName(String paramString1, String paramString2, zzcas paramZzcas)
  {
    e(paramZzcas, false);
    paramString1 = zziki.zzauk().getFromLocationName(new zzcdj(this, paramZzcas, paramString1, paramString2));
    try
    {
      paramString1 = paramString1.get();
      return (List)paramString1;
    }
    catch (ExecutionException paramString1) {}catch (InterruptedException paramString1) {}
    zziki.zzaul().zzayd().append("Failed to get conditional user properties", paramString1);
    return Collections.emptyList();
  }
  
  public final List getFromLocationName(String paramString1, String paramString2, String paramString3)
  {
    put(paramString1, true);
    paramString1 = zziki.zzauk().getFromLocationName(new zzcdk(this, paramString1, paramString2, paramString3));
    try
    {
      paramString1 = paramString1.get();
      return (List)paramString1;
    }
    catch (ExecutionException paramString1) {}catch (InterruptedException paramString1) {}
    zziki.zzaul().zzayd().append("Failed to get conditional user properties", paramString1);
    return Collections.emptyList();
  }
  
  public final List getFromLocationName(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    put(paramString1, true);
    paramString2 = zziki.zzauk().getFromLocationName(new zzcdi(this, paramString1, paramString2, paramString3));
    try
    {
      paramString2 = paramString2.get();
      paramString3 = (List)paramString2;
      paramString2 = new ArrayList(paramString3.size());
      paramString3 = paramString3.iterator();
      for (;;)
      {
        boolean bool = paramString3.hasNext();
        if (!bool) {
          break;
        }
        Object localObject = paramString3.next();
        localObject = (zzcfv)localObject;
        if (!paramBoolean)
        {
          String str = mName;
          bool = zzcfw.zzkd(str);
          if (bool) {}
        }
        else
        {
          paramString2.add(new zzcft((zzcfv)localObject));
        }
      }
      return paramString2;
    }
    catch (ExecutionException paramString2) {}catch (InterruptedException paramString2) {}
    zziki.zzaul().zzayd().append("Failed to get user attributes. appId", zzcbw.zzjf(paramString1), paramString2);
    return Collections.emptyList();
  }
  
  public final List getFromLocationName(String paramString1, String paramString2, boolean paramBoolean, zzcas paramZzcas)
  {
    e(paramZzcas, false);
    paramString1 = zziki.zzauk().getFromLocationName(new zzcdh(this, paramZzcas, paramString1, paramString2));
    try
    {
      paramString1 = paramString1.get();
      paramString2 = (List)paramString1;
      paramString1 = new ArrayList(paramString2.size());
      paramString2 = paramString2.iterator();
      for (;;)
      {
        boolean bool = paramString2.hasNext();
        if (!bool) {
          break;
        }
        Object localObject = paramString2.next();
        localObject = (zzcfv)localObject;
        if (!paramBoolean)
        {
          String str = mName;
          bool = zzcfw.zzkd(str);
          if (bool) {}
        }
        else
        {
          paramString1.add(new zzcft((zzcfv)localObject));
        }
      }
      return paramString1;
    }
    catch (ExecutionException paramString1) {}catch (InterruptedException paramString1) {}
    zziki.zzaul().zzayd().append("Failed to get user attributes. appId", zzcbw.zzjf(packageName), paramString1);
    return Collections.emptyList();
  }
  
  public final void getPackageInfo(zzcav paramZzcav, zzcas paramZzcas)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a6 = a5\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public final void handleResult(zzcbk paramZzcbk, String paramString1, String paramString2)
  {
    zzbp.append(paramZzcbk);
    zzbp.zzgg(paramString1);
    put(paramString1, true);
    zziki.zzauk().e(new zzcdm(this, paramZzcbk, paramString1));
  }
  
  public final void onNetworkStateChanged(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    zziki.zzauk().e(new zzcds(this, paramString2, paramString3, paramString1, paramLong));
  }
  
  public final byte[] saveToFile(zzcbk paramZzcbk, String paramString)
  {
    zzbp.zzgg(paramString);
    zzbp.append(paramZzcbk);
    put(paramString, true);
    zziki.zzaul().zzayi().append("Log and bundle. event", zziki.zzaug().zzjc(name));
    long l1 = zziki.zzvx().nanoTime() / 1000000L;
    Object localObject1 = zziki.zzauk().get(new zzcdn(this, paramZzcbk, paramString));
    try
    {
      localObject1 = ((Future)localObject1).get();
      Object localObject2 = (byte[])localObject1;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = zziki;
        ((zzccw)localObject1).zzaul().zzayd().append("Log and bundle returned null. appId", zzcbw.zzjf(paramString));
        localObject1 = new byte[0];
      }
      localObject2 = zziki;
      long l2 = ((zzccw)localObject2).zzvx().nanoTime();
      l2 /= 1000000L;
      localObject2 = zziki;
      localObject2 = ((zzccw)localObject2).zzaul().zzayi();
      Object localObject3 = zziki;
      localObject3 = ((zzccw)localObject3).zzaug();
      String str = name;
      localObject3 = ((zzcbu)localObject3).zzjc(str);
      int i = localObject1.length;
      ((zzcby)localObject2).attribute("Log and bundle processed. event, size, time_ms", localObject3, Integer.valueOf(i), Long.valueOf(l2 - l1));
      return localObject1;
    }
    catch (ExecutionException localExecutionException) {}catch (InterruptedException localInterruptedException) {}
    zziki.zzaul().zzayd().attribute("Failed to log and bundle. appId, event, error", zzcbw.zzjf(paramString), zziki.zzaug().zzjc(name), localInterruptedException);
    return null;
  }
  
  public final void trim(zzcbk paramZzcbk, zzcas paramZzcas)
  {
    zzbp.append(paramZzcbk);
    e(paramZzcas, false);
    zziki.zzauk().e(new zzcdl(this, paramZzcbk, paramZzcas));
  }
  
  public final void trim(zzcft paramZzcft, zzcas paramZzcas)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a5 = a4\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
}
