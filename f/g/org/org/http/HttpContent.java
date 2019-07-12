package f.g.org.org.http;

import f.g.org.org.util.StreamingContent;
import java.io.IOException;
import java.io.OutputStream;

public abstract interface HttpContent
  extends StreamingContent
{
  public abstract long getLength()
    throws IOException;
  
  public abstract String getType();
  
  public abstract boolean retrySupported();
  
  public abstract void writeTo(OutputStream paramOutputStream)
    throws IOException;
}
