package f.g.c.io;

import f.g.c.a.a;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@a
public final class CountingOutputStream
  extends FilterOutputStream
{
  public long count;
  
  public CountingOutputStream(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public long getCount()
  {
    return count;
  }
  
  public void write(int paramInt)
    throws IOException
  {
    out.write(paramInt);
    count += 1L;
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    out.write(paramArrayOfByte, paramInt1, paramInt2);
    count += paramInt2;
  }
}
