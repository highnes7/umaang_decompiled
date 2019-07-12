package f.g.org.org.apache.http;

import f.g.b.a.g.h;
import f.g.org.org.apache.commons.TestableByteArrayInputStream;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.http.LowLevelHttpResponse;
import f.g.org.org.util.StringUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@h
public class MockLowLevelHttpResponse
  extends LowLevelHttpResponse
{
  public InputStream content;
  public String contentEncoding;
  public long contentLength = -1L;
  public String contentType;
  public List<String> headerNames = new ArrayList();
  public List<String> headerValues = new ArrayList();
  public boolean isDisconnected;
  public String reasonPhrase;
  public int statusCode = 200;
  
  public MockLowLevelHttpResponse() {}
  
  public MockLowLevelHttpResponse addHeader(String paramString1, String paramString2)
  {
    List localList = headerNames;
    if (paramString1 != null)
    {
      localList.add(paramString1);
      paramString1 = headerValues;
      if (paramString2 != null)
      {
        paramString1.add(paramString2);
        return this;
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public void disconnect()
    throws IOException
  {
    isDisconnected = true;
  }
  
  public InputStream getContent()
    throws IOException
  {
    return content;
  }
  
  public String getContentEncoding()
  {
    return contentEncoding;
  }
  
  public long getContentLength()
  {
    return contentLength;
  }
  
  public final String getContentType()
  {
    return contentType;
  }
  
  public int getHeaderCount()
  {
    return headerNames.size();
  }
  
  public String getHeaderName(int paramInt)
  {
    return (String)headerNames.get(paramInt);
  }
  
  public final List getHeaderNames()
  {
    return headerNames;
  }
  
  public String getHeaderValue(int paramInt)
  {
    return (String)headerValues.get(paramInt);
  }
  
  public final List getHeaderValues()
  {
    return headerValues;
  }
  
  public String getReasonPhrase()
  {
    return reasonPhrase;
  }
  
  public int getStatusCode()
  {
    return statusCode;
  }
  
  public String getStatusLine()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(statusCode);
    String str = reasonPhrase;
    if (str != null) {
      localStringBuilder.append(str);
    }
    return localStringBuilder.toString();
  }
  
  public boolean isDisconnected()
  {
    return isDisconnected;
  }
  
  public MockLowLevelHttpResponse setContent(InputStream paramInputStream)
  {
    content = paramInputStream;
    return this;
  }
  
  public MockLowLevelHttpResponse setContent(String paramString)
  {
    if (paramString == null) {
      return setZeroContent();
    }
    return setContent(StringUtils.getBytesUtf8(paramString));
  }
  
  public MockLowLevelHttpResponse setContent(List paramList)
  {
    if (paramList != null)
    {
      headerNames = paramList;
      return this;
    }
    throw new NullPointerException();
  }
  
  public MockLowLevelHttpResponse setContent(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return setZeroContent();
    }
    content = new TestableByteArrayInputStream(paramArrayOfByte);
    setContentLength(paramArrayOfByte.length);
    return this;
  }
  
  public MockLowLevelHttpResponse setContentEncoding(String paramString)
  {
    contentEncoding = paramString;
    return this;
  }
  
  public MockLowLevelHttpResponse setContentEncoding(List paramList)
  {
    if (paramList != null)
    {
      headerValues = paramList;
      return this;
    }
    throw new NullPointerException();
  }
  
  public MockLowLevelHttpResponse setContentLength(long paramLong)
  {
    contentLength = paramLong;
    boolean bool;
    if (paramLong >= -1L) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.append(bool);
    return this;
  }
  
  public MockLowLevelHttpResponse setContentType(String paramString)
  {
    contentType = paramString;
    return this;
  }
  
  public MockLowLevelHttpResponse setReasonPhrase(String paramString)
  {
    reasonPhrase = paramString;
    return this;
  }
  
  public MockLowLevelHttpResponse setStatusCode(int paramInt)
  {
    statusCode = paramInt;
    return this;
  }
  
  public MockLowLevelHttpResponse setZeroContent()
  {
    content = null;
    setContentLength(0L);
    return this;
  }
}
