package f.fasterxml.jackson.core.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;

public abstract class InputDecorator
  implements Serializable
{
  public static final long serialVersionUID = 1L;
  
  public InputDecorator() {}
  
  public abstract InputStream decorate(IOContext paramIOContext, InputStream paramInputStream)
    throws IOException;
  
  public abstract InputStream decorate(IOContext paramIOContext, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract Reader decorate(IOContext paramIOContext, Reader paramReader)
    throws IOException;
}
