package f.g.org.org.http;

import f.g.b.a.g.h;
import java.io.IOException;

@Deprecated
@h
public abstract interface BackOffPolicy
{
  public static final long STOP = -1L;
  
  public abstract long getNextBackOffMillis()
    throws IOException;
  
  public abstract boolean isBackOffRequired(int paramInt);
  
  public abstract void reset();
}
