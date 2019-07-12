package f.libs.asm.menu;

import java.util.concurrent.CountDownLatch;

public class ac
{
  public boolean c = false;
  public final CountDownLatch latch = new CountDownLatch(1);
  
  public ac() {}
  
  public boolean a()
  {
    return c;
  }
  
  public void cancel(boolean paramBoolean)
  {
    c = paramBoolean;
    latch.countDown();
  }
  
  public void get()
  {
    CountDownLatch localCountDownLatch = latch;
    try
    {
      localCountDownLatch.await();
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}
