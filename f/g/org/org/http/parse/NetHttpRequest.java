package f.g.org.org.http.parse;

import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.http.LowLevelHttpRequest;
import f.g.org.org.http.LowLevelHttpResponse;
import f.g.org.org.util.StreamingContent;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public final class NetHttpRequest
  extends LowLevelHttpRequest
{
  public final HttpURLConnection connection;
  
  public NetHttpRequest(HttpURLConnection paramHttpURLConnection)
  {
    connection = paramHttpURLConnection;
    paramHttpURLConnection.setInstanceFollowRedirects(false);
  }
  
  public void addHeader(String paramString1, String paramString2)
  {
    connection.addRequestProperty(paramString1, paramString2);
  }
  
  public LowLevelHttpResponse execute()
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = connection;
    Object localObject;
    if (getStreamingContent() != null)
    {
      localObject = getContentType();
      if (localObject != null) {
        addHeader("Content-Type", (String)localObject);
      }
      localObject = getContentEncoding();
      if (localObject != null) {
        addHeader("Content-Encoding", (String)localObject);
      }
      long l = getContentLength();
      if (l >= 0L) {
        addHeader("Content-Length", Long.toString(l));
      }
      localObject = localHttpURLConnection.getRequestMethod();
      if ((!"POST".equals(localObject)) && (!"PUT".equals(localObject)))
      {
        boolean bool;
        if (l == 0L) {
          bool = true;
        } else {
          bool = false;
        }
        Preconditions.checkArgument(bool, "%s with non-zero content length is not supported", new Object[] { localObject });
      }
      else
      {
        localHttpURLConnection.setDoOutput(true);
        if ((l >= 0L) && (l <= 2147483647L)) {
          localHttpURLConnection.setFixedLengthStreamingMode((int)l);
        } else {
          localHttpURLConnection.setChunkedStreamingMode(0);
        }
        localObject = localHttpURLConnection.getOutputStream();
        try
        {
          getStreamingContent().writeTo((OutputStream)localObject);
          ((OutputStream)localObject).close();
        }
        catch (Throwable localThrowable1)
        {
          ((OutputStream)localObject).close();
          throw localThrowable1;
        }
      }
    }
    try
    {
      localThrowable1.connect();
      localObject = new NetHttpResponse(localThrowable1);
      return localObject;
    }
    catch (Throwable localThrowable2)
    {
      localThrowable1.disconnect();
      throw localThrowable2;
    }
  }
  
  public void setTimeout(int paramInt1, int paramInt2)
  {
    connection.setReadTimeout(paramInt2);
    connection.setConnectTimeout(paramInt1);
  }
}
