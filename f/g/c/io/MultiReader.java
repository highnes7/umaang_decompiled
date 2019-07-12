package f.g.c.io;

import f.g.c.g.y;
import f.g.c.package_10.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

public class MultiReader
  extends Reader
{
  public Reader current;
  public final Iterator<? extends y<? extends Reader>> it;
  
  public MultiReader(Iterator paramIterator)
    throws IOException
  {
    it = paramIterator;
    advance();
  }
  
  private void advance()
    throws IOException
  {
    close();
    if (it.hasNext()) {
      current = ((Reader)((InputSupplier)it.next()).getInput());
    }
  }
  
  public void close()
    throws IOException
  {
    Reader localReader = current;
    if (localReader != null) {
      try
      {
        localReader.close();
        current = null;
        return;
      }
      catch (Throwable localThrowable)
      {
        current = null;
        throw localThrowable;
      }
    }
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    Reader localReader = current;
    if (localReader == null) {
      return -1;
    }
    int i = localReader.read(paramArrayOfChar, paramInt1, paramInt2);
    if (i == -1)
    {
      advance();
      return read(paramArrayOfChar, paramInt1, paramInt2);
    }
    return i;
  }
  
  public boolean ready()
    throws IOException
  {
    Reader localReader = current;
    return (localReader != null) && (localReader.ready());
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    boolean bool;
    if (paramLong >= 0L) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "n is negative");
    if (paramLong > 0L) {
      for (;;)
      {
        Reader localReader = current;
        if (localReader == null) {
          break;
        }
        long l = localReader.skip(paramLong);
        if (l > 0L) {
          return l;
        }
        advance();
      }
    }
    return 0L;
  }
}
