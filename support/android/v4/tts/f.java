package support.android.v4.tts;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import b.b.a.N;
import b.b.a.t;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@N({b.b.a.N.a.b})
public class f
{
  public static final int A = 1;
  public static final int x = 0;
  public final int a;
  public final Object b = new Object();
  public Handler.Callback c = new SnackbarManager.1(this);
  @t("mLock")
  public Handler handler;
  @t("mLock")
  public int r;
  public final int s;
  public final String t;
  @t("mLock")
  public HandlerThread thread;
  
  public f(String paramString, int paramInt1, int paramInt2)
  {
    t = paramString;
    s = paramInt1;
    a = paramInt2;
    r = 0;
  }
  
  private void close(Runnable paramRunnable)
  {
    Object localObject = b;
    try
    {
      if (thread == null)
      {
        thread = new HandlerThread(t, s);
        thread.start();
        handler = new Handler(thread.getLooper(), c);
        r += 1;
      }
      handler.removeMessages(0);
      handler.sendMessage(handler.obtainMessage(1, paramRunnable));
      return;
    }
    catch (Throwable paramRunnable)
    {
      throw paramRunnable;
    }
  }
  
  public int a()
  {
    Object localObject = b;
    try
    {
      int i = r;
      return i;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    paramRunnable.run();
    paramRunnable = b;
    try
    {
      handler.removeMessages(0);
      handler.sendMessageDelayed(handler.obtainMessage(0), a);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void a(Callable paramCallable, c paramC)
  {
    close(new RequestFutureTarget(this, paramCallable, new Handler(), paramC));
  }
  
  public boolean accept()
  {
    Object localObject = b;
    for (;;)
    {
      try
      {
        if (thread != null)
        {
          bool = true;
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      boolean bool = false;
    }
  }
  
  public void close()
  {
    Object localObject = b;
    try
    {
      if (handler.hasMessages(1)) {
        return;
      }
      thread.quit();
      thread = null;
      handler = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public Object get(Callable paramCallable, int paramInt)
    throws InterruptedException
  {
    localReentrantLock = new ReentrantLock();
    Condition localCondition = localReentrantLock.newCondition();
    AtomicReference localAtomicReference = new AtomicReference();
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(true);
    close(new Task.2(this, localAtomicReference, paramCallable, localReentrantLock, localAtomicBoolean, localCondition));
    localReentrantLock.lock();
    label109:
    do
    {
      try
      {
        bool = localAtomicBoolean.get();
        if (!bool)
        {
          paramCallable = localAtomicReference.get();
          localReentrantLock.unlock();
          return paramCallable;
        }
        l1 = TimeUnit.MILLISECONDS.toNanos(paramInt);
      }
      catch (Throwable paramCallable)
      {
        boolean bool;
        long l1;
        long l2;
        localReentrantLock.unlock();
        throw paramCallable;
      }
      try
      {
        l2 = localCondition.awaitNanos(l1);
        l1 = l2;
      }
      catch (InterruptedException paramCallable)
      {
        break label109;
      }
      bool = localAtomicBoolean.get();
      if (!bool)
      {
        paramCallable = localAtomicReference.get();
        localReentrantLock.unlock();
        return paramCallable;
      }
    } while (l1 > 0L);
    throw new InterruptedException("timeout");
  }
}
