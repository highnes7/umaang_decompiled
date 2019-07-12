package f.g.org.org.org.network;

import f.g.org.org.http.AbstractHttpContent;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpContent;
import f.g.org.org.http.HttpHeaders;
import f.g.org.org.http.HttpRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class MultipartContent
  extends AbstractHttpContent
{
  public static final String NEWLINE = "\r\n";
  public final HttpRequest request;
  
  public MultipartContent(HttpRequest paramHttpRequest)
  {
    super("application/http");
    request = paramHttpRequest;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(paramOutputStream, getCharset());
    localOutputStreamWriter.write(request.getRequestMethod());
    localOutputStreamWriter.write(" ");
    localOutputStreamWriter.write(request.getUrl().build());
    localOutputStreamWriter.write("\r\n");
    HttpHeaders localHttpHeaders = new HttpHeaders();
    localHttpHeaders.fromHttpHeaders(request.getHeaders());
    localHttpHeaders.setAcceptEncoding(null).setUserAgent(null).setContentEncoding(null).setContentType(null).setContentLength(null);
    HttpContent localHttpContent = request.getContent();
    if (localHttpContent != null)
    {
      localHttpHeaders.setContentType(localHttpContent.getType());
      long l = localHttpContent.getLength();
      if (l != -1L) {
        localHttpHeaders.setContentLength(Long.valueOf(l));
      }
    }
    HttpHeaders.serializeHeadersForMultipartRequests(localHttpHeaders, null, null, localOutputStreamWriter);
    if (localHttpContent != null)
    {
      localOutputStreamWriter.write("\r\n");
      localOutputStreamWriter.flush();
      localHttpContent.writeTo(paramOutputStream);
    }
  }
}
