package f.g.org.org.apache.commons;

import f.g.b.a.g.h;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@h
public class TestableByteArrayInputStream
  extends ByteArrayInputStream
{
  public boolean closed;
  
  public TestableByteArrayInputStream(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  public TestableByteArrayInputStream(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramArrayOfByte);
  }
  
  public void close()
    throws IOException
  {
    closed = true;
  }
  
  public final byte[] getBuffer()
  {
    return buf;
  }
  
  public final boolean isClosed()
  {
    return closed;
  }
}
