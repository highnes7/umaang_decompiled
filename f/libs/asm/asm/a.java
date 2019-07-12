package f.libs.asm.asm;

import f.c.a.a.s.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import l.a.a.a.Log;
import l.a.a.a.f;

public class a
{
  public static final int j = 5000;
  public boolean a = true;
  public volatile boolean b = true;
  public final AtomicReference<ScheduledFuture<?>> c = new AtomicReference();
  public final ScheduledExecutorService e;
  public final List<s.a> f = new ArrayList();
  
  public a(ScheduledExecutorService paramScheduledExecutorService)
  {
    e = paramScheduledExecutorService;
  }
  
  private void b()
  {
    Iterator localIterator = f.iterator();
    while (localIterator.hasNext()) {
      ((y)localIterator.next()).b();
    }
  }
  
  public void a()
  {
    a = false;
    ScheduledFuture localScheduledFuture = (ScheduledFuture)c.getAndSet(null);
    if (localScheduledFuture != null) {
      localScheduledFuture.cancel(false);
    }
  }
  
  public void a(y paramY)
  {
    f.add(paramY);
  }
  
  public void a(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public void close()
  {
    if ((b) && (!a))
    {
      a = true;
      AtomicReference localAtomicReference = c;
      ScheduledExecutorService localScheduledExecutorService = e;
      try
      {
        SelectSyncedCalendarsMultiAccountAdapter.2 local2 = new SelectSyncedCalendarsMultiAccountAdapter.2(this);
        TimeUnit localTimeUnit = TimeUnit.MILLISECONDS;
        localAtomicReference.compareAndSet(null, localScheduledExecutorService.schedule(local2, 5000L, localTimeUnit));
        return;
      }
      catch (RejectedExecutionException localRejectedExecutionException)
      {
        f.get().log("Answers", "Failed to schedule background detector", localRejectedExecutionException);
      }
    }
  }
}
