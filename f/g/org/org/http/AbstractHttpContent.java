package f.g.org.org.http;

import f.g.org.org.util.Charsets;
import f.g.org.org.util.IOUtils;
import java.io.IOException;
import java.nio.charset.Charset;

public abstract class AbstractHttpContent
  implements HttpContent
{
  public long computedLength = -1L;
  public HttpMediaType mediaType;
  
  public AbstractHttpContent(HttpMediaType paramHttpMediaType)
  {
    mediaType = paramHttpMediaType;
  }
  
  public AbstractHttpContent(String paramString)
  {
    this(paramString);
  }
  
  public static long computeLength(HttpContent paramHttpContent)
    throws IOException
  {
    if (!paramHttpContent.retrySupported()) {
      return -1L;
    }
    return IOUtils.computeLength(paramHttpContent);
  }
  
  public long computeLength()
    throws IOException
  {
    return computeLength(this);
  }
  
  public final Charset getCharset()
  {
    HttpMediaType localHttpMediaType = mediaType;
    if ((localHttpMediaType != null) && (localHttpMediaType.getCharsetParameter() != null)) {
      return mediaType.getCharsetParameter();
    }
    return Charsets.UTF_8;
  }
  
  public long getLength()
    throws IOException
  {
    if (computedLength == -1L) {
      computedLength = computeLength();
    }
    return computedLength;
  }
  
  public final HttpMediaType getMediaType()
  {
    return mediaType;
  }
  
  public String getType()
  {
    HttpMediaType localHttpMediaType = mediaType;
    if (localHttpMediaType == null) {
      return null;
    }
    return localHttpMediaType.build();
  }
  
  public boolean retrySupported()
  {
    return true;
  }
  
  public AbstractHttpContent setMediaType(HttpMediaType paramHttpMediaType)
  {
    mediaType = paramHttpMediaType;
    return this;
  }
}
