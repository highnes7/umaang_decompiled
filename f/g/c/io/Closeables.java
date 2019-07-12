package f.g.c.io;

import f.g.c.a.a;
import f.g.c.a.d;
import f.g.c.g.o;
import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@a
public final class Closeables
{
  @d
  public static final Logger logger = Logger.getLogger(o.class.getName());
  
  public Closeables() {}
  
  public static void close(Closeable paramCloseable, boolean paramBoolean)
    throws IOException
  {
    if (paramCloseable == null) {
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      if (paramBoolean)
      {
        logger.log(Level.WARNING, "IOException thrown while closing Closeable.", paramCloseable);
        return;
      }
      throw paramCloseable;
    }
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    try
    {
      close(paramCloseable, true);
      return;
    }
    catch (IOException paramCloseable)
    {
      logger.log(Level.SEVERE, "IOException should not have been thrown.", paramCloseable);
    }
  }
}
