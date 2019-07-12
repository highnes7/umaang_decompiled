package f.g.org.org.util;

import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import java.io.IOException;
import java.io.OutputStream;

public class ByteArrayStreamingContent
  implements StreamingContent
{
  public final byte[] byteArray;
  public final int length;
  public final int offset;
  
  public ByteArrayStreamingContent(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public ByteArrayStreamingContent(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      byteArray = paramArrayOfByte;
      boolean bool;
      if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 + paramInt2 <= paramArrayOfByte.length)) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.append(bool);
      offset = paramInt1;
      length = paramInt2;
      return;
    }
    throw new NullPointerException();
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(byteArray, offset, length);
    paramOutputStream.flush();
  }
}
