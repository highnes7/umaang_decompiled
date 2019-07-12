package f.libs.asm.asm;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import java.util.concurrent.ScheduledExecutorService;
import l.a.a.a.Item;
import l.a.a.a.Log;
import l.a.a.a.a.b.LayoutManager;
import l.a.a.a.a.e.ClassWriter;
import l.a.a.a.a.f.MethodWriter;

public class f
  implements y
{
  public static final String A = "onCrash called from main thread!!!";
  public static final String t = "Answers Events Handler";
  public final d a;
  public final l.a.a.a.b c;
  public final a j;
  public final long l;
  public final Settings n;
  
  public f(d paramD, l.a.a.a.b paramB, a paramA, Settings paramSettings, long paramLong)
  {
    a = paramD;
    c = paramB;
    j = paramA;
    n = paramSettings;
    l = paramLong;
  }
  
  public static f a(Item paramItem, Context paramContext, l.a.a.a.a.b.f paramF, String paramString1, String paramString2, long paramLong)
  {
    paramF = new Type(paramContext, paramF, paramString1, paramString2);
    paramString1 = new Plot(paramContext, new MethodWriter(paramItem));
    paramString2 = new ClassWriter(l.a.a.a.f.get());
    l.a.a.a.b localB = new l.a.a.a.b(paramContext);
    ScheduledExecutorService localScheduledExecutorService = LayoutManager.get("Answers Events Handler");
    a localA = new a(localScheduledExecutorService);
    return new f(new d(paramItem, paramContext, paramString1, paramF, paramString2, localScheduledExecutorService, new ClassReader(paramContext)), localB, localA, Settings.read(paramContext), paramLong);
  }
  
  public void a()
  {
    a.d();
    c.a(new i(this, j));
    j.a(this);
    if (d())
    {
      a(l);
      n.clear();
    }
  }
  
  public void a(long paramLong)
  {
    l.a.a.a.f.get().d("Answers", "Logged install");
    a.b(Label.a(paramLong));
  }
  
  public void a(Activity paramActivity, TextOrientationType paramTextOrientationType)
  {
    Log localLog = l.a.a.a.f.get();
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Logged lifecycle event: ");
    localStringBuilder.append(paramTextOrientationType.name());
    localLog.d("Answers", localStringBuilder.toString());
    a.a(Label.a(paramTextOrientationType, paramActivity));
  }
  
  public void a(b paramB)
  {
    Log localLog = l.a.a.a.f.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Logged predefined event: ");
    localStringBuilder.append(paramB);
    localLog.d("Answers", localStringBuilder.toString());
    a.a(Label.a(paramB));
  }
  
  public void a(q paramQ)
  {
    Log localLog = l.a.a.a.f.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Logged custom event: ");
    localStringBuilder.append(paramQ);
    localLog.d("Answers", localStringBuilder.toString());
    a.a(Label.a(paramQ));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      l.a.a.a.f.get().d("Answers", "Logged crash");
      a.d(Label.a(paramString1, paramString2));
      return;
    }
    throw new IllegalStateException("onCrash called from main thread!!!");
  }
  
  public void a(l.a.a.a.a.g.b paramB, String paramString)
  {
    j.a(l);
    a.a(paramB, paramString);
  }
  
  public void b()
  {
    l.a.a.a.f.get().d("Answers", "Flush events when app is backgrounded");
    a.a();
  }
  
  public void b(String paramString) {}
  
  public void c()
  {
    c.a();
    a.b();
  }
  
  public boolean d()
  {
    return n.get() ^ true;
  }
}
