package f.g.c.io;

import f.g.c.a.a;
import f.g.c.g.x;
import java.io.Flushable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@a
public final class Flushables
{
  public static final Logger logger = Logger.getLogger(x.class.getName());
  
  public Flushables() {}
  
  public static void flush(Flushable paramFlushable, boolean paramBoolean)
    throws IOException
  {
    try
    {
      paramFlushable.flush();
      return;
    }
    catch (IOException paramFlushable)
    {
      if (paramBoolean)
      {
        logger.log(Level.WARNING, "IOException thrown while flushing Flushable.", paramFlushable);
        return;
      }
      throw paramFlushable;
    }
  }
  
  public static void flushQuietly(Flushable paramFlushable)
  {
    try
    {
      flush(paramFlushable, true);
      return;
    }
    catch (IOException paramFlushable)
    {
      logger.log(Level.SEVERE, "IOException should not have been thrown.", paramFlushable);
    }
  }
}
