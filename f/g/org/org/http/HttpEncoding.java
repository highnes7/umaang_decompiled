package f.g.org.org.http;

import f.g.org.org.util.StreamingContent;
import java.io.IOException;
import java.io.OutputStream;

public abstract interface HttpEncoding
{
  public abstract void encode(StreamingContent paramStreamingContent, OutputStream paramOutputStream)
    throws IOException;
  
  public abstract String getName();
}
