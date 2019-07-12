package f.libs.asm.asm;

import java.util.Random;
import l.a.a.a.a.c.a.h;

public class Log
  implements h
{
  public final double c;
  public final Random r;
  public final h this$0;
  
  public Log(h paramH, double paramDouble)
  {
    this(paramH, paramDouble, new Random());
  }
  
  public Log(h paramH, double paramDouble, Random paramRandom)
  {
    if ((paramDouble >= 0.0D) && (paramDouble <= 1.0D))
    {
      if (paramH != null)
      {
        if (paramRandom != null)
        {
          this$0 = paramH;
          c = paramDouble;
          r = paramRandom;
          return;
        }
        throw new NullPointerException("random must not be null");
      }
      throw new NullPointerException("backoff must not be null");
    }
    throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
  }
  
  public double d()
  {
    double d1 = c;
    double d2 = 1.0D - d1;
    return (d1 + 1.0D - d2) * r.nextDouble() + d2;
  }
  
  public long log(int paramInt)
  {
    double d1 = d();
    double d2 = this$0.log(paramInt);
    Double.isNaN(d2);
    return (d1 * d2);
  }
}
