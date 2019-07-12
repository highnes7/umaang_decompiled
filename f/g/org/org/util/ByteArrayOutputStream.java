package f.g.org.org.util;

import java.io.IOException;
import java.io.OutputStream;

public final class ByteArrayOutputStream
  extends OutputStream
{
  public long count;
  
  public ByteArrayOutputStream() {}
  
  public void write(int paramInt)
    throws IOException
  {
    count += 1L;
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    count += paramInt2;
  }
}
