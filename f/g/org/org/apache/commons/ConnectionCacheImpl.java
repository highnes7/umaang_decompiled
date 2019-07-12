package f.g.org.org.apache.commons;

import f.g.b.a.g.h;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@h
public class ConnectionCacheImpl
  extends ByteArrayOutputStream
{
  public boolean isClosed;
  
  public ConnectionCacheImpl() {}
  
  public final byte[] byteArray()
  {
    return buf;
  }
  
  public void close()
    throws IOException
  {
    isClosed = true;
  }
  
  public final boolean isClosed()
  {
    return isClosed;
  }
}
