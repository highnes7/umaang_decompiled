package f.g.c.io;

import f.g.c.a.a;
import f.g.c.package_10.Preconditions;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@a
public final class LimitInputStream
  extends FilterInputStream
{
  public long left;
  public long mark = -1L;
  
  public LimitInputStream(InputStream paramInputStream, long paramLong)
  {
    super(paramInputStream);
    if (paramInputStream != null)
    {
      boolean bool;
      if (paramLong >= 0L) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "limit must be non-negative");
      left = paramLong;
      return;
    }
    throw new NullPointerException();
  }
  
  public int available()
    throws IOException
  {
    return (int)Math.min(in.available(), left);
  }
  
  public void mark(int paramInt)
  {
    try
    {
      in.mark(paramInt);
      mark = left;
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
    if (left == 0L) {
      return -1;
    }
    int i = in.read();
    if (i != -1) {
      left -= 1L;
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    long l = left;
    if (l == 0L) {
      return -1;
    }
    paramInt2 = (int)Math.min(paramInt2, l);
    paramInt1 = in.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != -1) {
      left -= paramInt1;
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
          left = mark;
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
    paramLong = Math.min(paramLong, left);
    paramLong = in.skip(paramLong);
    left -= paramLong;
    return paramLong;
  }
}
