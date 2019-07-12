package f.g.org.org.http;

import f.g.org.org.util.StreamingContent;
import java.io.IOException;
import java.io.OutputStream;

public final class HttpEncodingStreamingContent
  implements StreamingContent
{
  public final StreamingContent content;
  public final HttpEncoding encoding;
  
  public HttpEncodingStreamingContent(StreamingContent paramStreamingContent, HttpEncoding paramHttpEncoding)
  {
    if (paramStreamingContent != null)
    {
      content = paramStreamingContent;
      if (paramHttpEncoding != null)
      {
        encoding = paramHttpEncoding;
        return;
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public StreamingContent getContent()
  {
    return content;
  }
  
  public HttpEncoding getEncoding()
  {
    return encoding;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    encoding.encode(content, paramOutputStream);
  }
}
