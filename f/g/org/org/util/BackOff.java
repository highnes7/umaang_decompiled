package f.g.org.org.util;

import java.io.IOException;

public abstract interface BackOff
{
  public static final long STOP = -1L;
  public static final BackOff STOP_BACKOFF = new BackOff()
  {
    public long nextBackOffMillis()
      throws IOException
    {
      return -1L;
    }
    
    public void reset()
      throws IOException
    {}
  };
  public static final BackOff ZERO_BACKOFF = new BackOff()
  {
    public long nextBackOffMillis()
      throws IOException
    {
      return 0L;
    }
    
    public void reset()
      throws IOException
    {}
  };
  
  public abstract long nextBackOffMillis()
    throws IOException;
  
  public abstract void reset()
    throws IOException;
}
