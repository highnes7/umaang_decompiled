package f.g.c.io;

import f.g.c.g.J;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public final class ByteVector
  implements J<OutputStreamWriter>
{
  public ByteVector(Object paramObject, Charset paramCharset) {}
  
  public OutputStreamWriter write()
    throws IOException
  {
    return new OutputStreamWriter((OutputStream)data.write(), buffer);
  }
}
