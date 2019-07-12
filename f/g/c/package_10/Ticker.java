package f.g.c.package_10;

import f.g.c.a.a;
import f.g.c.a.b;

@a
@b
public abstract class Ticker
{
  public static final Ticker ticker = new CacheBuilder.3();
  
  public Ticker() {}
  
  public static Ticker getTicker()
  {
    return ticker;
  }
  
  public abstract long read();
}
