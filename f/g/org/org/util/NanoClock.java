package f.g.org.org.util;

public abstract interface NanoClock
{
  public static final NanoClock SYSTEM = new NanoClock()
  {
    public long nanoTime()
    {
      return System.nanoTime();
    }
  };
  
  public abstract long nanoTime();
}
