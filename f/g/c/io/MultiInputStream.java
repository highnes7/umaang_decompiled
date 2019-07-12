package f.g.c.io;

import f.g.c.g.y;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public final class MultiInputStream
  extends InputStream
{
  public InputStream in;
  public Iterator<? extends y<? extends InputStream>> it;
  
  public MultiInputStream(Iterator paramIterator)
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
      in = ((InputStream)((InputSupplier)it.next()).getInput());
    }
  }
  
  public int available()
    throws IOException
  {
    InputStream localInputStream = in;
    if (localInputStream == null) {
      return 0;
    }
    return localInputStream.available();
  }
  
  public void close()
    throws IOException
  {
    InputStream localInputStream = in;
    if (localInputStream != null) {
      try
      {
        localInputStream.close();
        in = null;
        return;
      }
      catch (Throwable localThrowable)
      {
        in = null;
        throw localThrowable;
      }
    }
  }
  
  public boolean markSupported()
  {
    return false;
  }
  
  public int read()
    throws IOException
  {
    InputStream localInputStream = in;
    if (localInputStream == null) {
      return -1;
    }
    int j = localInputStream.read();
    int i = j;
    if (j == -1)
    {
      advance();
      i = read();
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    InputStream localInputStream = in;
    if (localInputStream == null) {
      return -1;
    }
    int i = localInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
    if (i == -1)
    {
      advance();
      return read(paramArrayOfByte, paramInt1, paramInt2);
    }
    return i;
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    InputStream localInputStream = in;
    if (localInputStream != null)
    {
      if (paramLong <= 0L) {
        return 0L;
      }
      long l = localInputStream.skip(paramLong);
      if (l != 0L) {
        return l;
      }
      if (read() == -1) {
        return 0L;
      }
      return in.skip(paramLong - 1L) + 1L;
    }
    return 0L;
  }
}
