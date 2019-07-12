package f.g.org.org.http;

import java.io.InputStream;

public final class InputStreamContent
  extends AbstractInputStreamContent
{
  public final InputStream inputStream;
  public long length = -1L;
  public boolean retrySupported;
  
  public InputStreamContent(String paramString, InputStream paramInputStream)
  {
    super(paramString);
    if (paramInputStream != null)
    {
      inputStream = paramInputStream;
      return;
    }
    throw new NullPointerException();
  }
  
  public InputStream getInputStream()
  {
    return inputStream;
  }
  
  public long getLength()
  {
    return length;
  }
  
  public boolean retrySupported()
  {
    return retrySupported;
  }
  
  public InputStreamContent setCloseInputStream(boolean paramBoolean)
  {
    closeInputStream = paramBoolean;
    return this;
  }
  
  public InputStreamContent setLength(long paramLong)
  {
    length = paramLong;
    return this;
  }
  
  public InputStreamContent setRetrySupported(boolean paramBoolean)
  {
    retrySupported = paramBoolean;
    return this;
  }
  
  public InputStreamContent setType(String paramString)
  {
    type = paramString;
    return this;
  }
}
