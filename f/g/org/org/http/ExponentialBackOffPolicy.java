package f.g.org.org.http;

import f.g.b.a.g.h;
import f.g.org.org.util.ExponentialBackOff;
import java.io.IOException;

@Deprecated
@h
public class ExponentialBackOffPolicy
  implements BackOffPolicy
{
  public static final int DEFAULT_MAX_ELAPSED_TIME_MILLIS = 900000;
  public static final int DEFAULT_MAX_INTERVAL_MILLIS = 60000;
  public static final double DEFAULT_MULTIPLIER = 1.5D;
  public static final double DEFAULT_RANDOMIZATION_FACTOR = 0.5D;
  public static final int DELAY_WAIT_FOR_RUNNER_TO_STOP = 500;
  public final ExponentialBackOff exponentialBackOff;
  
  public ExponentialBackOffPolicy()
  {
    exponentialBackOff = localF.build();
  }
  
  public ExponentialBackOffPolicy(f paramF)
  {
    exponentialBackOff = b.build();
  }
  
  public static f f()
  {
    return new f();
  }
  
  public final int getCurrentIntervalMillis()
  {
    return exponentialBackOff.getCurrentIntervalMillis();
  }
  
  public final long getElapsedTimeMillis()
  {
    return exponentialBackOff.getElapsedTimeMillis();
  }
  
  public final int getInitialIntervalMillis()
  {
    return exponentialBackOff.getInitialIntervalMillis();
  }
  
  public final int getMaxElapsedTimeMillis()
  {
    return exponentialBackOff.getMaxElapsedTimeMillis();
  }
  
  public final int getMaxIntervalMillis()
  {
    return exponentialBackOff.getMaxIntervalMillis();
  }
  
  public final double getMultiplier()
  {
    return exponentialBackOff.getMultiplier();
  }
  
  public long getNextBackOffMillis()
    throws IOException
  {
    return exponentialBackOff.nextBackOffMillis();
  }
  
  public final double getRandomizationFactor()
  {
    return exponentialBackOff.getRandomizationFactor();
  }
  
  public boolean isBackOffRequired(int paramInt)
  {
    return (paramInt == 500) || (paramInt == 503);
  }
  
  public final void reset()
  {
    exponentialBackOff.reset();
  }
}
