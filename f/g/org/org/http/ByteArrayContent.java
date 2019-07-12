package f.g.org.org.http;

import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.util.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public final class ByteArrayContent
  extends AbstractInputStreamContent
{
  public final byte[] byteArray;
  public final int length;
  public final int offset;
  
  public ByteArrayContent(String paramString, byte[] paramArrayOfByte)
  {
    this(paramString, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public ByteArrayContent(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramString);
    if (paramArrayOfByte != null)
    {
      byteArray = paramArrayOfByte;
      boolean bool;
      if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 + paramInt2 <= paramArrayOfByte.length)) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "offset %s, length %s, array length %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramArrayOfByte.length) });
      offset = paramInt1;
      length = paramInt2;
      return;
    }
    throw new NullPointerException();
  }
  
  public static ByteArrayContent fromString(String paramString1, String paramString2)
  {
    return new ByteArrayContent(paramString1, StringUtils.getBytesUtf8(paramString2));
  }
  
  public InputStream getInputStream()
  {
    return new ByteArrayInputStream(byteArray, offset, length);
  }
  
  public long getLength()
  {
    return length;
  }
  
  public boolean retrySupported()
  {
    return true;
  }
  
  public ByteArrayContent setCloseInputStream(boolean paramBoolean)
  {
    closeInputStream = paramBoolean;
    return this;
  }
  
  public ByteArrayContent setType(String paramString)
  {
    type = paramString;
    return this;
  }
}
