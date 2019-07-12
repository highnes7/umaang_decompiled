package f.g.c.cache;

import f.g.c.l.a.oa;
import java.util.logging.Level;
import java.util.logging.Logger;

public class b
  implements Runnable
{
  public b(LocalCache.Segment paramSegment, Object paramObject, int paramInt, ClassWriter paramClassWriter, oa paramOa) {}
  
  public void run()
  {
    try
    {
      Object localObject = b.get(a, k, c, i);
      c.add(localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      LocalCache.logger.log(Level.WARNING, "Exception thrown during refresh", localThrowable);
      c.a(localThrowable);
    }
  }
}
