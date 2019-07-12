package f.g.org.org.http;

import f.g.org.org.util.StreamingContent;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class GZipEncoding
  implements HttpEncoding
{
  public GZipEncoding() {}
  
  public void encode(StreamingContent paramStreamingContent, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream = new GZIPOutputStream(new GZipEncoding.1(this, paramOutputStream));
    paramStreamingContent.writeTo(paramOutputStream);
    paramOutputStream.close();
  }
  
  public String getName()
  {
    return "gzip";
  }
}
