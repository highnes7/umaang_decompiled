package f.g.org.org.http.gzip;

import f.g.org.org.util.StreamingContent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.AbstractHttpEntity;

public final class InputStreamEntity
  extends AbstractHttpEntity
{
  public final StreamingContent content;
  public final long length;
  
  public InputStreamEntity(long paramLong, StreamingContent paramStreamingContent)
  {
    length = paramLong;
    if (paramStreamingContent != null)
    {
      content = paramStreamingContent;
      return;
    }
    throw new NullPointerException();
  }
  
  public InputStream getContent()
  {
    throw new UnsupportedOperationException();
  }
  
  public long getContentLength()
  {
    return length;
  }
  
  public boolean isRepeatable()
  {
    return false;
  }
  
  public boolean isStreaming()
  {
    return true;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    if (length != 0L) {
      content.writeTo(paramOutputStream);
    }
  }
}
