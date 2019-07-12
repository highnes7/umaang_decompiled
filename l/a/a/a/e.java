package l.a.a.a;

import android.content.Context;
import android.os.Handler;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import l.a.a.a.a.b.Label;

public class e
{
  public final Context a;
  public boolean b;
  public String c;
  public k<g> d;
  public Item[] e;
  public String f;
  public l.a.a.a.a.c.Item g;
  public Handler h;
  public Log j;
  
  public e(Context paramContext)
  {
    if (paramContext != null)
    {
      a = paramContext;
      return;
    }
    throw new IllegalArgumentException("Context must not be null.");
  }
  
  public e a(Handler paramHandler)
  {
    return this;
  }
  
  public e a(String paramString)
  {
    if (paramString != null)
    {
      if (f == null)
      {
        f = paramString;
        return this;
      }
      throw new IllegalStateException("appInstallIdentifier already set.");
    }
    throw new IllegalArgumentException("appInstallIdentifier must not be null.");
  }
  
  public e a(ExecutorService paramExecutorService)
  {
    return this;
  }
  
  public e a(Log paramLog)
  {
    if (paramLog != null)
    {
      if (j == null)
      {
        j = paramLog;
        return this;
      }
      throw new IllegalStateException("Logger already set.");
    }
    throw new IllegalArgumentException("Logger must not be null.");
  }
  
  public e a(l.a.a.a.a.c.Item paramItem)
  {
    if (paramItem != null)
    {
      if (g == null)
      {
        g = paramItem;
        return this;
      }
      throw new IllegalStateException("PriorityThreadPoolExecutor already set.");
    }
    throw new IllegalArgumentException("PriorityThreadPoolExecutor must not be null.");
  }
  
  public e a(g paramG)
  {
    if (paramG != null)
    {
      if (d == null)
      {
        d = paramG;
        return this;
      }
      throw new IllegalStateException("initializationCallback already set.");
    }
    throw new IllegalArgumentException("initializationCallback must not be null.");
  }
  
  public e a(boolean paramBoolean)
  {
    b = paramBoolean;
    return this;
  }
  
  public e a(Item... paramVarArgs)
  {
    if (e == null)
    {
      Object localObject = paramVarArgs;
      if (!Label.a(a).a())
      {
        localObject = new ArrayList();
        int n = paramVarArgs.length;
        int k = 0;
        int i;
        for (int m = 0; k < n; m = i)
        {
          Item localItem = paramVarArgs[k];
          String str = localItem.getId();
          i = -1;
          int i1 = str.hashCode();
          if (i1 != 607220212)
          {
            if ((i1 == 1830452504) && (str.equals("com.crashlytics.sdk.android:crashlytics"))) {
              i = 0;
            }
          }
          else if (str.equals("com.crashlytics.sdk.android:answers")) {
            i = 1;
          }
          if ((i != 0) && (i != 1))
          {
            i = m;
            if (m == 0)
            {
              f.get().remove("Fabric", "Fabric will not initialize any kits when Firebase automatic data collection is disabled; to use Third-party kits with automatic data collection disabled, initialize these kits via non-Fabric means.");
              i = 1;
            }
          }
          else
          {
            ((List)localObject).add(localItem);
            i = m;
          }
          k += 1;
        }
        localObject = (Item[])((List)localObject).toArray(new Item[0]);
      }
      e = ((Item[])localObject);
      return this;
    }
    paramVarArgs = new IllegalStateException("Kits already set.");
    throw paramVarArgs;
  }
  
  public f a()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a3 = a2\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public e b(String paramString)
  {
    if (paramString != null)
    {
      if (c == null)
      {
        c = paramString;
        return this;
      }
      throw new IllegalStateException("appIdentifier already set.");
    }
    throw new IllegalArgumentException("appIdentifier must not be null.");
  }
}
