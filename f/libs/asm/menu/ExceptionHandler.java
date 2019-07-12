package f.libs.asm.menu;

import java.util.concurrent.atomic.AtomicBoolean;
import l.a.a.a.Log;
import l.a.a.a.f;

public class ExceptionHandler
  implements Thread.UncaughtExceptionHandler
{
  public final boolean TAG;
  public final la.b context;
  public final la.a log;
  public final Thread.UncaughtExceptionHandler mContext;
  public final AtomicBoolean settings;
  
  public ExceptionHandler(la.a paramA, la.b paramB, boolean paramBoolean, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    log = paramA;
    context = paramB;
    TAG = paramBoolean;
    mContext = paramUncaughtExceptionHandler;
    settings = new AtomicBoolean(false);
  }
  
  public boolean get()
  {
    return settings.get();
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    settings.set(true);
    la.a localA = log;
    la.b localB = context;
    boolean bool = TAG;
    try
    {
      localA.e(localB, paramThread, paramThrowable, bool);
      f.get().d("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
      mContext.uncaughtException(paramThread, paramThrowable);
      settings.set(false);
      return;
    }
    catch (Throwable localThrowable) {}catch (Exception localException)
    {
      for (;;)
      {
        f.get().d("CrashlyticsCore", "An error occurred in the uncaught exception handler", localException);
      }
    }
    f.get().d("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
    mContext.uncaughtException(paramThread, paramThrowable);
    settings.set(false);
    throw localException;
  }
}
