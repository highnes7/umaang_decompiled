package f.g.org.org.util;

import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class BoundedInputStream
  extends FilterInputStream
{
  public long mark = -1L;
  public long pos;
  
  public BoundedInputStream(InputStream paramInputStream, long paramLong)
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
      pos = paramLong;
      return;
    }
    throw new NullPointerException();
  }
  
  public int available()
    throws IOException
  {
    return (int)Math.min(in.available(), pos);
  }
  
  public void mark(int paramInt)
  {
    try
    {
      in.mark(paramInt);
      mark = pos;
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
    if (pos == 0L) {
      return -1;
    }
    int i = in.read();
    if (i != -1) {
      pos -= 1L;
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    long l = pos;
    if (l == 0L) {
      return -1;
    }
    paramInt2 = (int)Math.min(paramInt2, l);
    paramInt1 = in.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != -1) {
      pos -= paramInt1;
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
          pos = mark;
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
    paramLong = Math.min(paramLong, pos);
    paramLong = in.skip(paramLong);
    pos -= paramLong;
    return paramLong;
  }
}
