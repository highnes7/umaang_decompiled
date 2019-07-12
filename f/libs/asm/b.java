package f.libs.asm;

import f.libs.asm.asm.e;
import f.libs.asm.menu.Paint;
import f.libs.asm.menu.TDoubleCollection;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import l.a.a.a.Item;
import l.a.a.a.Log;
import l.a.a.a.a.b.Label;
import l.a.a.a.n;
import l.a.a.a.o;

public class b
  extends n<Void>
  implements o
{
  public static final String g = "Crashlytics";
  public final e a;
  public final f.libs.asm.menu.f b;
  public final Collection<? extends n> c;
  public final f.libs.asm.signature.b e;
  
  public b()
  {
    this(new e(), new f.libs.asm.signature.b(), new f.libs.asm.menu.f());
  }
  
  public b(e paramE, f.libs.asm.signature.b paramB, f.libs.asm.menu.f paramF)
  {
    a = paramE;
    e = paramB;
    b = paramF;
    c = Collections.unmodifiableCollection(Arrays.asList(new Item[] { paramE, paramB, paramF }));
  }
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    write();
    getValueb.c(paramInt, paramString1, paramString2);
  }
  
  public static void a(String paramString)
  {
    write();
    getValueb.b(paramString);
  }
  
  public static void a(String paramString, double paramDouble)
  {
    write();
    getValueb.a(paramString, paramDouble);
  }
  
  public static void a(String paramString, float paramFloat)
  {
    write();
    getValueb.b(paramString, paramFloat);
  }
  
  public static void a(String paramString, int paramInt)
  {
    write();
    getValueb.f(paramString, paramInt);
  }
  
  public static void a(String paramString, long paramLong)
  {
    write();
    getValueb.a(paramString, paramLong);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    write();
    getValueb.a(paramString1, paramString2);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    write();
    getValueb.f(paramString, paramBoolean);
  }
  
  public static void a(boolean paramBoolean)
  {
    write();
    Label.a(getValue().getContext()).a(paramBoolean);
  }
  
  public static boolean a()
  {
    write();
    return Label.a(getValue().getContext()).a();
  }
  
  public static void b(String paramString)
  {
    write();
    getValueb.f(paramString);
  }
  
  public static void d(String paramString)
  {
    write();
    getValueb.c(paramString);
  }
  
  public static void d(Throwable paramThrowable)
  {
    write();
    getValueb.a(paramThrowable);
  }
  
  public static void e(TDoubleCollection paramTDoubleCollection)
  {
    l.a.a.a.f.get().remove("Crashlytics", "Use of Crashlytics.setPinningInfoProvider is deprecated");
  }
  
  public static b getValue()
  {
    return (b)l.a.a.a.f.add(f.c.a.b.class);
  }
  
  public static TDoubleCollection onCreateView()
  {
    write();
    return getValueb.b();
  }
  
  public static void run(String paramString)
  {
    write();
    getValueb.a(paramString);
  }
  
  public static void write()
  {
    if (getValue() != null) {
      return;
    }
    throw new IllegalStateException("Crashlytics must be initialized by calling Fabric.with(Context) prior to calling Crashlytics.getInstance()");
  }
  
  public void a(Paint paramPaint)
  {
    try
    {
      b.a(paramPaint);
      return;
    }
    catch (Throwable paramPaint)
    {
      throw paramPaint;
    }
  }
  
  public boolean a(URL paramURL)
  {
    return b.c(paramURL);
  }
  
  public Collection b()
  {
    return c;
  }
  
  public String c()
  {
    return "2.10.0.33";
  }
  
  public void close(boolean paramBoolean)
  {
    l.a.a.a.f.get().remove("Crashlytics", "Use of Crashlytics.setDebugMode is deprecated.");
  }
  
  public void d()
  {
    b.l();
  }
  
  public String getId()
  {
    return "com.crashlytics.sdk.android:crashlytics";
  }
  
  public boolean onClick()
  {
    l.a.a.a.f.get().remove("Crashlytics", "Use of Crashlytics.getDebugMode is deprecated.");
    e();
    return l.a.a.a.f.d();
  }
  
  public Void run()
  {
    return null;
  }
}
