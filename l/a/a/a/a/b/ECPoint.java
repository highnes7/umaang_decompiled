package l.a.a.a.a.b;

import android.os.SystemClock;
import android.util.Log;

public class ECPoint
{
  public long base;
  public final boolean curve;
  public final String n;
  public final String x;
  public long y;
  
  public ECPoint(String paramString1, String paramString2)
  {
    x = paramString1;
    n = paramString2;
    curve = (Log.isLoggable(paramString2, 2) ^ true);
  }
  
  private void negate()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(x);
    localStringBuilder.append(": ");
    localStringBuilder.append(y);
    localStringBuilder.append("ms");
    localStringBuilder.toString();
  }
  
  public void add()
  {
    try
    {
      boolean bool = curve;
      if (bool) {
        return;
      }
      long l = y;
      if (l != 0L) {
        return;
      }
      y = (SystemClock.elapsedRealtime() - base);
      negate();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void assertECMultiplier()
  {
    try
    {
      boolean bool = curve;
      if (bool) {
        return;
      }
      base = SystemClock.elapsedRealtime();
      y = 0L;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public long getY()
  {
    return y;
  }
}
