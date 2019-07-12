package f.fasterxml.jackson.core.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;

public abstract class OutputDecorator
  implements Serializable
{
  public static final long serialVersionUID = 1L;
  
  public OutputDecorator() {}
  
  public abstract OutputStream decorate(IOContext paramIOContext, OutputStream paramOutputStream)
    throws IOException;
  
  public abstract Writer decorate(IOContext paramIOContext, Writer paramWriter)
    throws IOException;
}
