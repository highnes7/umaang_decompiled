package f.g.c.package_10;

import f.g.c.a.a;
import f.g.c.a.b;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.concurrent.TimeUnit;

@a
@b(emulated=true)
public final class Stopwatch
{
  public long elapsedNanos;
  public boolean isRunning;
  public long startTick;
  public final Ticker ticker;
  
  public Stopwatch()
  {
    this(Ticker.ticker);
  }
  
  public Stopwatch(Ticker paramTicker)
  {
    if (paramTicker != null)
    {
      ticker = paramTicker;
      return;
    }
    throw new NullPointerException();
  }
  
  public static String abbreviate(TimeUnit paramTimeUnit)
  {
    int i = 1.$SwitchMap$java$util$concurrent$TimeUnit[paramTimeUnit.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            return "s";
          }
          throw new AssertionError();
        }
        return "ms";
      }
      return "?s";
    }
    return "ns";
  }
  
  public static TimeUnit chooseUnit(long paramLong)
  {
    if (TimeUnit.SECONDS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) {
      return TimeUnit.SECONDS;
    }
    if (TimeUnit.MILLISECONDS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) {
      return TimeUnit.MILLISECONDS;
    }
    if (TimeUnit.MICROSECONDS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) {
      return TimeUnit.MICROSECONDS;
    }
    return TimeUnit.NANOSECONDS;
  }
  
  private long elapsedNanos()
  {
    if (isRunning) {
      return ticker.read() - startTick + elapsedNanos;
    }
    return elapsedNanos;
  }
  
  public long elapsedMillis()
  {
    return elapsedTime(TimeUnit.MILLISECONDS);
  }
  
  public long elapsedTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(elapsedNanos(), TimeUnit.NANOSECONDS);
  }
  
  public boolean isRunning()
  {
    return isRunning;
  }
  
  public Stopwatch reset()
  {
    elapsedNanos = 0L;
    isRunning = false;
    return this;
  }
  
  public Stopwatch start()
  {
    Preconditions.checkState(isRunning ^ true);
    isRunning = true;
    startTick = ticker.read();
    return this;
  }
  
  public Stopwatch stop()
  {
    long l1 = ticker.read();
    Preconditions.checkState(isRunning);
    isRunning = false;
    long l2 = elapsedNanos;
    elapsedNanos = (l1 - startTick + l2);
    return this;
  }
  
  public String toString()
  {
    return toString(4);
  }
  
  public String toString(int paramInt)
  {
    long l = elapsedNanos();
    TimeUnit localTimeUnit = chooseUnit(l);
    double d1 = l;
    double d2 = TimeUnit.NANOSECONDS.convert(1L, localTimeUnit);
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 /= d2;
    return String.format(StringBuilder.toString("%.", paramInt, "g %s"), new Object[] { Double.valueOf(d1), abbreviate(localTimeUnit) });
  }
}
