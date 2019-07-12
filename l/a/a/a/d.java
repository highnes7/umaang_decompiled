package l.a.a.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Future;
import l.a.a.a.a.b.Handle;
import l.a.a.a.a.e.LayoutManager;
import l.a.a.a.a.g.A;
import l.a.a.a.a.g.e;
import l.a.a.a.a.g.h;
import l.a.a.a.a.g.o;

public class d
  extends n<Boolean>
{
  public static final String ENC_BINARY = "binary";
  public static final String F = "com.crashlytics.ApiEndpoint";
  public String a;
  public String b;
  public final Collection<n> c;
  public final LayoutManager h = new l.a.a.a.a.e.ClassWriter();
  public String i;
  public final Future<Map<String, p>> j;
  public PackageInfo mContext;
  public PackageManager mPackageManager;
  public String mPackageName;
  public String q;
  public String x;
  
  public d(Future paramFuture, Collection paramCollection)
  {
    j = paramFuture;
    c = paramCollection;
  }
  
  private l.a.a.a.a.g.d a(o paramO, Collection paramCollection)
  {
    Object localObject = getContext();
    String str = new l.a.a.a.a.b.i().a((Context)localObject);
    localObject = l.a.a.a.a.b.ClassWriter.get(new String[] { l.a.a.a.a.b.ClassWriter.c((Context)localObject) });
    int k = Handle.a(x).getId();
    return new l.a.a.a.a.g.d(str, getName().e(), b, a, (String)localObject, i, k, q, "0", paramO, paramCollection);
  }
  
  private boolean a(String paramString, l.a.a.a.a.g.Label paramLabel, Collection paramCollection)
  {
    return b(paramLabel, o.a(getContext(), paramString), paramCollection);
  }
  
  private e b()
  {
    try
    {
      Object localObject = h.c();
      l.a.a.a.a.b.f localF = c;
      LayoutManager localLayoutManager = h;
      String str1 = a;
      String str2 = b;
      ((h)localObject).a(this, localF, localLayoutManager, str1, str2, a(), l.a.a.a.a.b.Label.a(getContext())).f();
      localObject = h.c().b();
      return localObject;
    }
    catch (Exception localException)
    {
      f.get().d("Fabric", "Error dealing with settings", localException);
    }
    return null;
  }
  
  private boolean b(String paramString, l.a.a.a.a.g.Label paramLabel, Collection paramCollection)
  {
    if ("new".equals(e))
    {
      if (c(paramString, paramLabel, paramCollection)) {
        return h.c().a();
      }
      f.get().d("Fabric", "Failed to create app with Crashlytics service.", null);
      return false;
    }
    if ("configured".equals(e)) {
      return h.c().a();
    }
    if (f)
    {
      f.get().d("Fabric", "Server says an update is required - forcing a full App update.");
      b(paramLabel, o.a(getContext(), paramString), paramCollection);
    }
    return true;
  }
  
  private boolean b(l.a.a.a.a.g.Label paramLabel, o paramO, Collection paramCollection)
  {
    paramO = a(paramO, paramCollection);
    return new A(this, a(), c, h).a(paramO);
  }
  
  private boolean c(String paramString, l.a.a.a.a.g.Label paramLabel, Collection paramCollection)
  {
    paramString = a(o.a(getContext(), paramString), paramCollection);
    return new l.a.a.a.a.g.i(this, a(), c, h).a(paramString);
  }
  
  public String a()
  {
    return l.a.a.a.a.b.ClassWriter.a(getContext(), "com.crashlytics.ApiEndpoint");
  }
  
  public String c()
  {
    return "1.4.8.32";
  }
  
  public String getId()
  {
    return "io.fabric.sdk.android:fabric";
  }
  
  public boolean onCreate()
  {
    try
    {
      Object localObject = getName().b();
      x = ((String)localObject);
      localObject = getContext().getPackageManager();
      mPackageManager = ((PackageManager)localObject);
      localObject = getContext().getPackageName();
      mPackageName = ((String)localObject);
      localObject = mPackageManager;
      String str = mPackageName;
      localObject = ((PackageManager)localObject).getPackageInfo(str, 0);
      mContext = ((PackageInfo)localObject);
      int k = mContext.versionCode;
      localObject = Integer.toString(k);
      a = ((String)localObject);
      if (mContext.versionName == null) {
        localObject = "0.0";
      } else {
        localObject = mContext.versionName;
      }
      b = ((String)localObject);
      localObject = mPackageManager;
      localObject = ((PackageManager)localObject).getApplicationLabel(getContext().getApplicationInfo()).toString();
      i = ((String)localObject);
      localObject = getContext().getApplicationInfo();
      k = targetSdkVersion;
      localObject = Integer.toString(k);
      q = ((String)localObject);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      f.get().d("Fabric", "Failed init", localNameNotFoundException);
    }
    return false;
  }
  
  public Boolean run()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a7 = a6\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public Map update(Map paramMap, Collection paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Item localItem = (Item)paramCollection.next();
      if (!paramMap.containsKey(localItem.getId())) {
        paramMap.put(localItem.getId(), new p(localItem.getId(), localItem.c(), "binary"));
      }
    }
    return paramMap;
  }
}
