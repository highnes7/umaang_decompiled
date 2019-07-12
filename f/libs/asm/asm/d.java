package f.libs.asm.asm;

import android.content.Context;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import l.a.a.a.Item;
import l.a.a.a.Log;
import l.a.a.a.a.d.m;
import l.a.a.a.a.e.LayoutManager;
import l.a.a.a.a.g.b;
import l.a.a.a.f;

public class d
  implements m
{
  public final Plot a;
  public AnnotationWriter b = new w();
  public final Item g;
  public final Type h;
  public final Context i;
  public final LayoutManager j;
  public final ClassReader k;
  public final ScheduledExecutorService n;
  
  public d(Item paramItem, Context paramContext, Plot paramPlot, Type paramType, LayoutManager paramLayoutManager, ScheduledExecutorService paramScheduledExecutorService, ClassReader paramClassReader)
  {
    g = paramItem;
    i = paramContext;
    a = paramPlot;
    h = paramType;
    j = paramLayoutManager;
    n = paramScheduledExecutorService;
    k = paramClassReader;
  }
  
  private void a(Runnable paramRunnable)
  {
    ScheduledExecutorService localScheduledExecutorService = n;
    try
    {
      localScheduledExecutorService.submit(paramRunnable);
      return;
    }
    catch (Exception paramRunnable)
    {
      f.get().d("Answers", "Failed to submit events task", paramRunnable);
    }
  }
  
  private void close(Runnable paramRunnable)
  {
    ScheduledExecutorService localScheduledExecutorService = n;
    try
    {
      localScheduledExecutorService.submit(paramRunnable).get();
      return;
    }
    catch (Exception paramRunnable)
    {
      f.get().d("Answers", "Failed to run events task", paramRunnable);
    }
  }
  
  public void a()
  {
    a(new NumberPicker.BeginSoftInputOnLongPressCommand(this));
  }
  
  public void a(Frame paramFrame)
  {
    a(paramFrame, false, false);
  }
  
  public void a(Frame paramFrame, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramFrame = new Plot.a(this, paramFrame, paramBoolean2);
    if (paramBoolean1)
    {
      close(paramFrame);
      return;
    }
    a(paramFrame);
  }
  
  public void a(b paramB, String paramString)
  {
    a(new Widget(this, paramB, paramString));
  }
  
  public void b()
  {
    a(new AppCompatDelegateImplV7.4(this));
  }
  
  public void b(Frame paramFrame)
  {
    a(paramFrame, false, true);
  }
  
  public void d()
  {
    a(new TestActivity.1(this));
  }
  
  public void d(Frame paramFrame)
  {
    a(paramFrame, true, false);
  }
  
  public void d(String paramString)
  {
    a(new ShowcaseView.1(this));
  }
}
