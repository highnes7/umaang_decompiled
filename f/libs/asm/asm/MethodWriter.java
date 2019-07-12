package f.libs.asm.asm;

import android.content.Context;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import l.a.a.a.Item;
import l.a.a.a.Log;
import l.a.a.a.a.b.ClassWriter;
import l.a.a.a.a.b.i;
import l.a.a.a.a.d.e;
import l.a.a.a.a.d.s;
import l.a.a.a.a.e.LayoutManager;
import l.a.a.a.a.g.b;
import l.a.a.a.f;

public class MethodWriter
  implements AnnotationWriter
{
  public static final int FRAMES = -1;
  public final Context a;
  public final o b;
  public final AtomicReference<ScheduledFuture<?>> c = new AtomicReference();
  public final m e;
  public final ScheduledExecutorService f;
  public boolean g = true;
  public volatile int h = -1;
  public final LayoutManager i;
  public final Item j;
  public boolean k = false;
  public i l = new i();
  public boolean m = true;
  public final ClassReader n;
  public boolean p = false;
  public x q = new NavigationMenuPresenter();
  public l.a.a.a.a.d.p r;
  
  public MethodWriter(Item paramItem, Context paramContext, ScheduledExecutorService paramScheduledExecutorService, o paramO, LayoutManager paramLayoutManager, m paramM, ClassReader paramClassReader)
  {
    j = paramItem;
    a = paramContext;
    f = paramScheduledExecutorService;
    b = paramO;
    i = paramLayoutManager;
    e = paramM;
    n = paramClassReader;
  }
  
  public void a()
  {
    if (r == null)
    {
      ClassWriter.b(a, "skipping files send because we don't yet know the target endpoint");
      return;
    }
    ClassWriter.b(a, "Sending all files");
    Object localObject1 = b.d();
    int i1 = 0;
    for (;;)
    {
      int i2 = i1;
      try
      {
        int i3 = ((List)localObject1).size();
        i2 = i1;
        if (i3 > 0)
        {
          localObject2 = a;
          localObject3 = Locale.US;
          i2 = i1;
          i3 = ((List)localObject1).size();
          i2 = i1;
          ClassWriter.b((Context)localObject2, String.format((Locale)localObject3, "attempt to send batch of %d files", new Object[] { Integer.valueOf(i3) }));
          localObject2 = r;
          i2 = i1;
          boolean bool = ((l.a.a.a.a.d.p)localObject2).a((List)localObject1);
          i3 = i1;
          if (bool)
          {
            i2 = i1;
            i3 = ((List)localObject1).size();
            i3 = i1 + i3;
            localObject2 = b;
            i2 = i3;
            ((e)localObject2).a((List)localObject1);
          }
          if (!bool)
          {
            i2 = i3;
          }
          else
          {
            localObject1 = b;
            i2 = i3;
            localObject1 = ((e)localObject1).d();
            i1 = i3;
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject2 = a;
        Object localObject3 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Failed to send batch of analytics files to server: ");
        ((StringBuilder)localObject3).append(localException.getMessage());
        ClassWriter.a((Context)localObject2, ((StringBuilder)localObject3).toString(), localException);
        if (i2 == 0) {
          b.b();
        }
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    int i1;
    if (c.get() == null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      Object localObject1 = new s(a, this);
      Object localObject2 = a;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("Scheduling time based file roll over every ");
      ((StringBuilder)localObject3).append(paramLong2);
      ((StringBuilder)localObject3).append(" seconds");
      ClassWriter.b((Context)localObject2, ((StringBuilder)localObject3).toString());
      localObject2 = c;
      localObject3 = f;
      TimeUnit localTimeUnit = TimeUnit.SECONDS;
      localObject1 = (Runnable)localObject1;
      try
      {
        ((AtomicReference)localObject2).set(((ScheduledExecutorService)localObject3).scheduleAtFixedRate((Runnable)localObject1, paramLong1, paramLong2, localTimeUnit));
        return;
      }
      catch (RejectedExecutionException localRejectedExecutionException)
      {
        ClassWriter.a(a, "Failed to schedule time based file roll over", localRejectedExecutionException);
      }
    }
  }
  
  public void a(Frame paramFrame)
  {
    paramFrame = paramFrame.a(e);
    Object localObject2;
    if ((!m) && (TextOrientationType.a.equals(b)))
    {
      localObject1 = f.get();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Custom events tracking disabled - skipping event: ");
      ((StringBuilder)localObject2).append(paramFrame);
      ((Log)localObject1).d("Answers", ((StringBuilder)localObject2).toString());
      return;
    }
    if ((!g) && (TextOrientationType.e.equals(b)))
    {
      localObject1 = f.get();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Predefined events tracking disabled - skipping event: ");
      ((StringBuilder)localObject2).append(paramFrame);
      ((Log)localObject1).d("Answers", ((StringBuilder)localObject2).toString());
      return;
    }
    if (q.a(paramFrame))
    {
      localObject1 = f.get();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Skipping filtered event: ");
      ((StringBuilder)localObject2).append(paramFrame);
      ((Log)localObject1).d("Answers", ((StringBuilder)localObject2).toString());
      return;
    }
    Object localObject1 = b;
    StringBuilder localStringBuilder;
    try
    {
      ((e)localObject1).a(paramFrame);
    }
    catch (IOException localIOException)
    {
      localObject2 = f.get();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to write event: ");
      localStringBuilder.append(paramFrame);
      ((Log)localObject2).d("Answers", localStringBuilder.toString(), localIOException);
    }
    visitInsn();
    int i1;
    if ((!TextOrientationType.a.equals(b)) && (!TextOrientationType.e.equals(b))) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    boolean bool = "purchase".equals(a);
    if (p)
    {
      if (i1 == 0) {
        return;
      }
      if ((bool) && (!k)) {
        return;
      }
      ClassReader localClassReader = n;
      try
      {
        localClassReader.a(paramFrame);
        return;
      }
      catch (Exception localException)
      {
        localObject2 = f.get();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to map event to Firebase: ");
        localStringBuilder.append(paramFrame);
        ((Log)localObject2).d("Answers", localStringBuilder.toString(), localException);
      }
    }
  }
  
  public void a(b paramB, String paramString)
  {
    r = p.a(new XYPlotZoomPan(j, paramString, b, i, l.a(a)));
    b.a(paramB);
    p = c;
    k = g;
    Log localLog = f.get();
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Firebase analytics forwarding ");
    boolean bool = p;
    String str = "enabled";
    if (bool) {
      paramString = "enabled";
    } else {
      paramString = "disabled";
    }
    localStringBuilder.append(paramString);
    localLog.d("Answers", localStringBuilder.toString());
    localLog = f.get();
    localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Firebase analytics including purchase events ");
    if (k) {
      paramString = "enabled";
    } else {
      paramString = "disabled";
    }
    localStringBuilder.append(paramString);
    localLog.d("Answers", localStringBuilder.toString());
    m = m;
    localLog = f.get();
    localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Custom event tracking ");
    if (m) {
      paramString = "enabled";
    } else {
      paramString = "disabled";
    }
    localStringBuilder.append(paramString);
    localLog.d("Answers", localStringBuilder.toString());
    g = h;
    localLog = f.get();
    localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Predefined event tracking ");
    if (g) {
      paramString = str;
    } else {
      paramString = "disabled";
    }
    localStringBuilder.append(paramString);
    localLog.d("Answers", localStringBuilder.toString());
    if (j > 1)
    {
      f.get().d("Answers", "Event sampling enabled");
      q = new v(j);
    }
    h = i;
    a(0L, h);
  }
  
  public boolean c()
  {
    o localO = b;
    try
    {
      boolean bool = localO.h();
      return bool;
    }
    catch (IOException localIOException)
    {
      ClassWriter.a(a, "Failed to roll file over.", localIOException);
    }
    return false;
  }
  
  public void put()
  {
    b.a();
  }
  
  public void visitInsn()
  {
    int i1;
    if (h != -1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      a(h, h);
    }
  }
  
  public void visitMethodInsn()
  {
    if (c.get() != null)
    {
      ClassWriter.b(a, "Cancelling time-based rollover because no events are currently being generated.");
      ((ScheduledFuture)c.get()).cancel(false);
      c.set(null);
    }
  }
}
