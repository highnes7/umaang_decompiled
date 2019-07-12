package f.g.org.org.util;

import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import java.io.IOException;

public class ExponentialBackOff
  implements BackOff
{
  public static final int DEFAULT_MAX_ELAPSED_TIME_MILLIS = 900000;
  public static final int DEFAULT_MAX_INTERVAL_MILLIS = 60000;
  public static final double DEFAULT_MULTIPLIER = 1.5D;
  public static final double DEFAULT_RANDOMIZATION_FACTOR = 0.5D;
  public static final int DELAY_WAIT_FOR_RUNNER_TO_STOP = 500;
  public int currentIntervalMillis;
  public final int initialIntervalMillis;
  public final int maxElapsedTimeMillis;
  public final int maxIntervalMillis;
  public final double multiplier;
  public final NanoClock nanoClock;
  public final double randomizationFactor;
  public long startTimeNanos;
  
  public ExponentialBackOff()
  {
    this(new f());
  }
  
  public ExponentialBackOff(f paramF)
  {
    initialIntervalMillis = a;
    randomizationFactor = b;
    multiplier = e;
    maxIntervalMillis = q;
    maxElapsedTimeMillis = g;
    nanoClock = f;
    int i = initialIntervalMillis;
    boolean bool2 = true;
    boolean bool1;
    if (i > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.append(bool1);
    double d = randomizationFactor;
    if ((0.0D <= d) && (d < 1.0D)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.append(bool1);
    if (multiplier >= 1.0D) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.append(bool1);
    if (maxIntervalMillis >= initialIntervalMillis) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.append(bool1);
    if (maxElapsedTimeMillis > 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Preconditions.append(bool1);
    reset();
  }
  
  public static int getRandomValueFromInterval(double paramDouble1, double paramDouble2, int paramInt)
  {
    double d1 = paramInt;
    Double.isNaN(d1);
    paramDouble1 *= d1;
    Double.isNaN(d1);
    double d2 = d1 - paramDouble1;
    Double.isNaN(d1);
    return (int)((d1 + paramDouble1 - d2 + 1.0D) * paramDouble2 + d2);
  }
  
  private void incrementCurrentInterval()
  {
    int i = currentIntervalMillis;
    double d2 = i;
    int j = maxIntervalMillis;
    double d3 = j;
    double d1 = multiplier;
    Double.isNaN(d3);
    if (d2 >= d3 / d1)
    {
      currentIntervalMillis = j;
      return;
    }
    d2 = i;
    Double.isNaN(d2);
    currentIntervalMillis = ((int)(d2 * d1));
  }
  
  public final int getCurrentIntervalMillis()
  {
    return currentIntervalMillis;
  }
  
  public final long getElapsedTimeMillis()
  {
    return (nanoClock.nanoTime() - startTimeNanos) / 1000000L;
  }
  
  public final int getInitialIntervalMillis()
  {
    return initialIntervalMillis;
  }
  
  public final int getMaxElapsedTimeMillis()
  {
    return maxElapsedTimeMillis;
  }
  
  public final int getMaxIntervalMillis()
  {
    return maxIntervalMillis;
  }
  
  public final double getMultiplier()
  {
    return multiplier;
  }
  
  public final double getRandomizationFactor()
  {
    return randomizationFactor;
  }
  
  public long nextBackOffMillis()
    throws IOException
  {
    if (getElapsedTimeMillis() > maxElapsedTimeMillis) {
      return -1L;
    }
    int i = getRandomValueFromInterval(randomizationFactor, Math.random(), currentIntervalMillis);
    incrementCurrentInterval();
    return i;
  }
  
  public final void reset()
  {
    currentIntervalMillis = initialIntervalMillis;
    startTimeNanos = nanoClock.nanoTime();
  }
}
