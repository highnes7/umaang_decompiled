package l.a.a.a.a.g;

import android.content.Context;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import l.a.a.a.Item;
import l.a.a.a.Log;
import l.a.a.a.a.b.ClassWriter;
import l.a.a.a.a.b.G;
import l.a.a.a.a.b.Handle;
import l.a.a.a.a.b.Label;
import l.a.a.a.a.b.i;
import l.a.a.a.a.e.LayoutManager;

public class h
{
  public static final String F = "com.crashlytics.settings.json";
  public static final String t = "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings";
  public u b;
  public final CountDownLatch h = new CountDownLatch(1);
  public boolean r = false;
  public final AtomicReference<v> w = new AtomicReference();
  
  public h() {}
  
  private void a(e paramE)
  {
    w.set(paramE);
    h.countDown();
  }
  
  public static h c()
  {
    return s.a.a;
  }
  
  public Object a(s.b paramB, Object paramObject)
  {
    e localE = (e)w.get();
    if (localE == null) {
      return paramObject;
    }
    return paramB.a(localE);
  }
  
  public h a(Item paramItem, l.a.a.a.a.b.f paramF, LayoutManager paramLayoutManager, String paramString1, String paramString2, String paramString3, Label paramLabel)
  {
    try
    {
      boolean bool = r;
      if (bool) {
        return this;
      }
      if (b == null)
      {
        Context localContext = paramItem.getContext();
        String str4 = paramF.e();
        String str1 = new i().a(localContext);
        String str2 = paramF.b();
        G localG = new G();
        l localL = new l();
        j localJ = new j(paramItem);
        String str3 = ClassWriter.a(localContext);
        paramLayoutManager = new m(paramItem, paramString3, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", new Object[] { str4 }), paramLayoutManager);
        b = new k(paramItem, new y(str1, paramF.getString(), paramF.c(), paramF.format(), paramF.a(), ClassWriter.get(new String[] { ClassWriter.c(localContext) }), paramString2, paramString1, Handle.a(str2).getId(), str3), localG, localL, localJ, paramLayoutManager, paramLabel);
      }
      r = true;
      return this;
    }
    catch (Throwable paramItem)
    {
      throw paramItem;
    }
  }
  
  public boolean a()
  {
    try
    {
      e localE = b.a(t.b);
      a(localE);
      if (localE == null) {
        l.a.a.a.f.get().d("Fabric", "Failed to force reload of settings from Crashlytics.", null);
      }
      boolean bool;
      if (localE != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public e b()
  {
    Object localObject = h;
    try
    {
      ((CountDownLatch)localObject).await();
      localObject = w;
      localObject = ((AtomicReference)localObject).get();
      return (e)localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
    l.a.a.a.f.get().e("Fabric", "Interrupted while waiting for settings data.");
    return null;
  }
  
  public void e(u paramU)
  {
    b = paramU;
  }
  
  public boolean f()
  {
    try
    {
      e localE = b.a();
      a(localE);
      boolean bool;
      if (localE != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void initialize()
  {
    w.set(null);
  }
}
