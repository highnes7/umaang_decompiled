package f.g.org.org.http;

import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.util.Charsets;
import f.g.org.org.util.DfsInserter.PackStream;
import f.g.org.org.util.IOUtils;
import f.g.org.org.util.ObjectParser;
import f.g.org.org.util.StringUtils;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

public final class HttpResponse
{
  public InputStream content;
  public final String contentEncoding;
  public int contentLoggingLimit;
  public boolean contentRead;
  public final String contentType;
  public boolean loggingEnabled;
  public final HttpMediaType mediaType;
  public final HttpRequest request;
  public LowLevelHttpResponse response;
  public final int statusCode;
  public final String statusMessage;
  
  public HttpResponse(HttpRequest paramHttpRequest, LowLevelHttpResponse paramLowLevelHttpResponse)
    throws IOException
  {
    request = paramHttpRequest;
    contentLoggingLimit = paramHttpRequest.getContentLoggingLimit();
    loggingEnabled = paramHttpRequest.isLoggingEnabled();
    response = paramLowLevelHttpResponse;
    contentEncoding = paramLowLevelHttpResponse.getContentEncoding();
    int k = paramLowLevelHttpResponse.getStatusCode();
    int i = k;
    int j = 0;
    if (k < 0) {
      i = 0;
    }
    statusCode = i;
    Object localObject4 = paramLowLevelHttpResponse.getReasonPhrase();
    statusMessage = ((String)localObject4);
    Logger localLogger = HttpTransport.LOGGER;
    i = j;
    if (loggingEnabled)
    {
      i = j;
      if (localLogger.isLoggable(Level.CONFIG)) {
        i = 1;
      }
    }
    Object localObject3 = null;
    Object localObject1;
    if (i != 0)
    {
      localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("-------------- RESPONSE --------------");
      localObject1 = localObject2;
      ((StringBuilder)localObject2).append(StringUtils.LINE_SEPARATOR);
      String str = paramLowLevelHttpResponse.getStatusLine();
      if (str != null)
      {
        ((StringBuilder)localObject2).append(str);
      }
      else
      {
        ((StringBuilder)localObject2).append(statusCode);
        if (localObject4 != null)
        {
          ((StringBuilder)localObject2).append(' ');
          ((StringBuilder)localObject2).append((String)localObject4);
        }
      }
      ((StringBuilder)localObject2).append(StringUtils.LINE_SEPARATOR);
    }
    else
    {
      localObject1 = null;
    }
    localObject4 = paramHttpRequest.getResponseHeaders();
    if (i != 0) {
      localObject2 = localObject1;
    } else {
      localObject2 = null;
    }
    ((HttpHeaders)localObject4).fromHttpResponse(paramLowLevelHttpResponse, (StringBuilder)localObject2);
    Object localObject2 = paramLowLevelHttpResponse.getContentType();
    paramLowLevelHttpResponse = (LowLevelHttpResponse)localObject2;
    if (localObject2 == null) {
      paramLowLevelHttpResponse = paramHttpRequest.getResponseHeaders().getContentType();
    }
    contentType = paramLowLevelHttpResponse;
    if (paramLowLevelHttpResponse == null) {
      paramHttpRequest = localObject3;
    } else {
      paramHttpRequest = new HttpMediaType(paramLowLevelHttpResponse);
    }
    mediaType = paramHttpRequest;
    if (i != 0) {
      localLogger.config(localObject1.toString());
    }
  }
  
  private boolean hasMessageBody()
    throws IOException
  {
    int i = getStatusCode();
    if ((!getRequest().getRequestMethod().equals("HEAD")) && (i / 100 != 1) && (i != 204) && (i != 304)) {
      return true;
    }
    ignore();
    return false;
  }
  
  public void disconnect()
    throws IOException
  {
    ignore();
    response.disconnect();
  }
  
  public void execute(OutputStream paramOutputStream)
    throws IOException
  {
    IOUtils.copy(getContent(), paramOutputStream, true);
  }
  
  public InputStream getContent()
    throws IOException
  {
    if (!contentRead)
    {
      Object localObject5 = response.getContent();
      Object localObject2 = localObject5;
      if (localObject5 != null)
      {
        Object localObject3 = localObject2;
        try
        {
          Object localObject6 = contentEncoding;
          Object localObject1 = localObject2;
          Object localObject4;
          if (localObject6 != null)
          {
            localObject3 = localObject2;
            localObject4 = localObject2;
          }
          boolean bool;
          int i;
          ((InputStream)localObject4).close();
        }
        catch (Throwable localThrowable)
        {
          try
          {
            bool = ((String)localObject6).contains("gzip");
            localObject1 = localObject2;
            if (bool)
            {
              localObject3 = localObject2;
              localObject4 = localObject2;
              localObject1 = new GZIPInputStream((InputStream)localObject5);
            }
            localObject3 = localObject1;
            localObject5 = HttpTransport.LOGGER;
            localObject3 = localObject1;
            bool = loggingEnabled;
            localObject2 = localObject1;
            if (bool)
            {
              localObject2 = Level.CONFIG;
              localObject3 = localObject1;
              localObject4 = localObject1;
              bool = ((Logger)localObject5).isLoggable((Level)localObject2);
              localObject2 = localObject1;
              if (bool)
              {
                localObject2 = Level.CONFIG;
                i = contentLoggingLimit;
                localObject6 = (InputStream)localObject1;
                localObject3 = localObject1;
                localObject4 = localObject1;
                localObject2 = new DfsInserter.PackStream((InputStream)localObject6, (Logger)localObject5, (Level)localObject2, i);
              }
            }
            localObject3 = localObject2;
            content = ((InputStream)localObject2);
          }
          catch (EOFException localEOFException)
          {
            for (;;) {}
          }
          localThrowable = localThrowable;
          ((InputStream)localObject3).close();
          throw localThrowable;
        }
      }
      contentRead = true;
    }
    return content;
  }
  
  public Charset getContentCharset()
  {
    HttpMediaType localHttpMediaType = mediaType;
    if ((localHttpMediaType != null) && (localHttpMediaType.getCharsetParameter() != null)) {
      return mediaType.getCharsetParameter();
    }
    return Charsets.ISO_8859_1;
  }
  
  public String getContentEncoding()
  {
    return contentEncoding;
  }
  
  public int getContentLoggingLimit()
  {
    return contentLoggingLimit;
  }
  
  public String getContentType()
  {
    return contentType;
  }
  
  public HttpHeaders getHeaders()
  {
    return request.getResponseHeaders();
  }
  
  public HttpMediaType getMediaType()
  {
    return mediaType;
  }
  
  public HttpRequest getRequest()
  {
    return request;
  }
  
  public int getStatusCode()
  {
    return statusCode;
  }
  
  public String getStatusMessage()
  {
    return statusMessage;
  }
  
  public HttpTransport getTransport()
  {
    return request.getTransport();
  }
  
  public void ignore()
    throws IOException
  {
    InputStream localInputStream = getContent();
    if (localInputStream != null) {
      localInputStream.close();
    }
  }
  
  public boolean isLoggingEnabled()
  {
    return loggingEnabled;
  }
  
  public boolean isSuccessStatusCode()
  {
    return HttpStatus.isSuccess(statusCode);
  }
  
  public Object parseAs(Class paramClass)
    throws IOException
  {
    if (!hasMessageBody()) {
      return null;
    }
    return request.getParser().parseAndClose(getContent(), getContentCharset(), paramClass);
  }
  
  public Object parseAs(Type paramType)
    throws IOException
  {
    if (!hasMessageBody()) {
      return null;
    }
    return request.getParser().parseAndClose(getContent(), getContentCharset(), paramType);
  }
  
  public String parseAsString()
    throws IOException
  {
    InputStream localInputStream = getContent();
    if (localInputStream == null) {
      return "";
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    IOUtils.copy(localInputStream, localByteArrayOutputStream, true);
    return localByteArrayOutputStream.toString(getContentCharset().name());
  }
  
  public HttpResponse setContentLoggingLimit(int paramInt)
  {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "The content logging limit must be non-negative.");
    contentLoggingLimit = paramInt;
    return this;
  }
  
  public HttpResponse setLoggingEnabled(boolean paramBoolean)
  {
    loggingEnabled = paramBoolean;
    return this;
  }
}
