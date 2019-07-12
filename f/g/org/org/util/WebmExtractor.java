package f.g.org.org.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class WebmExtractor
{
  public static final int MP3_MAX_INPUT_SIZE = 4096;
  
  public WebmExtractor() {}
  
  public static int read(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInputStream != null)
    {
      if (paramArrayOfByte != null)
      {
        if (paramInt2 >= 0)
        {
          int i = 0;
          while (i < paramInt2)
          {
            int j = paramInputStream.read(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
            if (j == -1) {
              return i;
            }
            i += j;
          }
          return i;
        }
        throw new IndexOutOfBoundsException("len is negative");
      }
      throw new NullPointerException();
    }
    paramInputStream = new NullPointerException();
    throw paramInputStream;
  }
  
  public static long read(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    if (paramInputStream != null)
    {
      if (paramOutputStream != null)
      {
        byte[] arrayOfByte = new byte['?'];
        int i;
        for (long l = 0L;; l += i)
        {
          i = paramInputStream.read(arrayOfByte);
          if (i == -1) {
            return l;
          }
          paramOutputStream.write(arrayOfByte, 0, i);
        }
      }
      throw new NullPointerException();
    }
    paramInputStream = new NullPointerException();
    throw paramInputStream;
  }
  
  public static InputStream read(InputStream paramInputStream, long paramLong)
  {
    return new BoundedInputStream(paramInputStream, paramLong);
  }
}
