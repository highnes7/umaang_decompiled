package f.g.org.org.apache.commons;

import f.g.b.a.g.h;
import f.g.org.org.util.Context;

@h
public class DataEmitterBase
  implements Context
{
  public long ended;
  public int report;
  
  public DataEmitterBase() {}
  
  public final long getEnded()
  {
    return ended;
  }
  
  public final int report()
  {
    return report;
  }
  
  public void report(long paramLong)
    throws InterruptedException
  {
    report += 1;
    ended = paramLong;
  }
}
