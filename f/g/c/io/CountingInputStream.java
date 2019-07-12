package f.g.c.io;

import f.g.c.a.a;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@a
public final class CountingInputStream
  extends FilterInputStream
{
  public long count;
  public long mark = -1L;
  
  public CountingInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public long getCount()
  {
    return count;
  }
  
  public void mark(int paramInt)
  {
    try
    {
      in.mark(paramInt);
      mark = count;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public int read()
    throws IOException
  {
    int i = in.read();
    if (i != -1) {
      count += 1L;
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt1 = in.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != -1) {
      count += paramInt1;
    }
    return paramInt1;
  }
  
  public void reset()
    throws IOException
  {
    try
    {
      if (in.markSupported())
      {
        if (mark != -1L)
        {
          in.reset();
          count = mark;
          return;
        }
        throw new IOException("Mark not set");
      }
      throw new IOException("Mark not supported");
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    paramLong = in.skip(paramLong);
    count += paramLong;
    return paramLong;
  }
}
