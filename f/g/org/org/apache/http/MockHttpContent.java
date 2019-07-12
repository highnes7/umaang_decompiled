package f.g.org.org.apache.http;

import f.g.b.a.g.h;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.http.HttpContent;
import java.io.IOException;
import java.io.OutputStream;

@h
public class MockHttpContent
  implements HttpContent
{
  public byte[] content = new byte[0];
  public long length = -1L;
  public String type;
  
  public MockHttpContent() {}
  
  public final byte[] getContent()
  {
    return content;
  }
  
  public long getLength()
    throws IOException
  {
    return length;
  }
  
  public String getType()
  {
    return type;
  }
  
  public boolean retrySupported()
  {
    return true;
  }
  
  public MockHttpContent setContent(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      content = paramArrayOfByte;
      return this;
    }
    throw new NullPointerException();
  }
  
  public MockHttpContent setLength(long paramLong)
  {
    boolean bool;
    if (paramLong >= -1L) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.append(bool);
    length = paramLong;
    return this;
  }
  
  public MockHttpContent setType(String paramString)
  {
    type = paramString;
    return this;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(content);
    paramOutputStream.flush();
  }
}
