package l.a.a.a;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public class c
  implements g
{
  public final CountDownLatch c = new CountDownLatch(a);
  
  public c(f paramF, int paramInt) {}
  
  public void a(Exception paramException)
  {
    f.b(b).a(paramException);
  }
  
  public void a(Object paramObject)
  {
    c.countDown();
    if (c.getCount() == 0L)
    {
      f.g(b).set(true);
      f.b(b).a(b);
    }
  }
}
