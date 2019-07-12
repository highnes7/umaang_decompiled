package f.g.org.org.apache.commons;

import f.g.b.a.g.h;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.util.BackOff;
import java.io.IOException;

@h
public class MockBackOff
  implements BackOff
{
  public long backOffMillis;
  public int maxTries = 10;
  public int numTries;
  
  public MockBackOff() {}
  
  public final int getMaxTries()
  {
    return numTries;
  }
  
  public final int getNumberOfTries()
  {
    return numTries;
  }
  
  public long nextBackOffMillis()
    throws IOException
  {
    int i = numTries;
    if (i < maxTries)
    {
      long l = backOffMillis;
      if (l == -1L) {
        return -1L;
      }
      numTries = (i + 1);
      return l;
    }
    return -1L;
  }
  
  public void reset()
    throws IOException
  {
    numTries = 0;
  }
  
  public MockBackOff setBackOffMillis(long paramLong)
  {
    boolean bool;
    if ((paramLong != -1L) && (paramLong < 0L)) {
      bool = false;
    } else {
      bool = true;
    }
    Preconditions.append(bool);
    backOffMillis = paramLong;
    return this;
  }
  
  public MockBackOff setMaxTries(int paramInt)
  {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.append(bool);
    maxTries = paramInt;
    return this;
  }
}
