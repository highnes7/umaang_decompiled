package f.g.org.org.apache.http;

import f.g.b.a.g.h;
import f.g.org.org.util.Item;
import java.util.concurrent.atomic.AtomicLong;

@h
public class FixedClock
  implements Item
{
  public AtomicLong currentTime;
  
  public FixedClock()
  {
    this(0L);
  }
  
  public FixedClock(long paramLong)
  {
    currentTime = new AtomicLong(paramLong);
  }
  
  public long currentTimeMillis()
  {
    return currentTime.get();
  }
  
  public FixedClock setTime(long paramLong)
  {
    currentTime.set(paramLong);
    return this;
  }
}
