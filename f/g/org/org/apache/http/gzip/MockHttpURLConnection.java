package f.g.org.org.apache.http.gzip;

import f.g.b.a.g.h;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@h
public class MockHttpURLConnection
  extends HttpURLConnection
{
  @Deprecated
  public static final byte[] ERROR_BUF = new byte[5];
  @Deprecated
  public static final byte[] INPUT_BUF = new byte[1];
  public boolean doOutputCalled;
  public InputStream errorStream = null;
  public Map<String, List<String>> headers = new LinkedHashMap();
  public InputStream inputStream = null;
  public OutputStream outputStream = new ByteArrayOutputStream(0);
  
  public MockHttpURLConnection(URL paramURL)
  {
    super(paramURL);
  }
  
  public MockHttpURLConnection addHeader(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 != null)
      {
        if (headers.containsKey(paramString1))
        {
          ((List)headers.get(paramString1)).add(paramString2);
          return this;
        }
        paramString2 = StringBuilder.newArrayList(paramString2);
        headers.put(paramString1, paramString2);
        return this;
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public void connect()
    throws IOException
  {}
  
  public void disconnect() {}
  
  public final boolean doOutputCalled()
  {
    return doOutputCalled;
  }
  
  public InputStream getErrorStream()
  {
    return errorStream;
  }
  
  public String getHeaderField(String paramString)
  {
    paramString = (List)headers.get(paramString);
    if (paramString == null) {
      return null;
    }
    return (String)paramString.get(0);
  }
  
  public Map getHeaderFields()
  {
    return headers;
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    if (responseCode < 400) {
      return inputStream;
    }
    throw new IOException();
  }
  
  public OutputStream getOutputStream()
    throws IOException
  {
    OutputStream localOutputStream = outputStream;
    if (localOutputStream != null) {
      return localOutputStream;
    }
    return super.getOutputStream();
  }
  
  public int getResponseCode()
    throws IOException
  {
    return responseCode;
  }
  
  public void setDoOutput(boolean paramBoolean)
  {
    doOutputCalled = true;
  }
  
  public MockHttpURLConnection setErrorStream(InputStream paramInputStream)
  {
    if (paramInputStream != null)
    {
      if (errorStream == null)
      {
        errorStream = paramInputStream;
        return this;
      }
    }
    else {
      throw new NullPointerException();
    }
    return this;
  }
  
  public MockHttpURLConnection setInputStream(InputStream paramInputStream)
  {
    if (paramInputStream != null)
    {
      if (inputStream == null)
      {
        inputStream = paramInputStream;
        return this;
      }
    }
    else {
      throw new NullPointerException();
    }
    return this;
  }
  
  public MockHttpURLConnection setOutputStream(OutputStream paramOutputStream)
  {
    outputStream = paramOutputStream;
    return this;
  }
  
  public MockHttpURLConnection setResponseCode(int paramInt)
  {
    boolean bool;
    if (paramInt >= -1) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.append(bool);
    responseCode = paramInt;
    return this;
  }
  
  public boolean usingProxy()
  {
    return false;
  }
}
