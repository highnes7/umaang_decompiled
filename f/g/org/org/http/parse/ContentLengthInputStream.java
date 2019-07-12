package f.g.org.org.http.parse;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ContentLengthInputStream
  extends FilterInputStream
{
  public long pos = 0L;
  
  public ContentLengthInputStream(NetHttpResponse paramNetHttpResponse, InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  private void execute()
    throws IOException
  {
    long l1 = this$0.getContentLength();
    if (l1 == -1L) {
      return;
    }
    long l2 = pos;
    if (l2 != 0L)
    {
      if (l2 >= l1) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder(102);
      localStringBuilder.append("Connection closed prematurely: bytesRead = ");
      localStringBuilder.append(l2);
      localStringBuilder.append(", Content-Length = ");
      localStringBuilder.append(l1);
      throw new IOException(localStringBuilder.toString());
    }
  }
  
  public int read()
    throws IOException
  {
    int i = in.read();
    if (i == -1)
    {
      execute();
      return i;
    }
    pos += 1L;
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt1 = in.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 == -1)
    {
      execute();
      return paramInt1;
    }
    pos += paramInt1;
    return paramInt1;
  }
}
