package f.libs.asm.menu;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

public final class Label
{
  public static final Label c = new Label(new byte[0]);
  public final byte[] b;
  public volatile int i = 0;
  
  public Label(byte[] paramArrayOfByte)
  {
    b = paramArrayOfByte;
  }
  
  public static Label a(String paramString)
  {
    try
    {
      paramString = new Label(paramString.getBytes("UTF-8"));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported.", paramString);
    }
  }
  
  public static Label a(String paramString1, String paramString2)
    throws UnsupportedEncodingException
  {
    return new Label(paramString1.getBytes(paramString2));
  }
  
  public static Label a(List paramList)
  {
    if (paramList.size() == 0) {
      return c;
    }
    if (paramList.size() == 1) {
      return (Label)paramList.get(0);
    }
    Object localObject = paramList.iterator();
    int j = 0;
    while (((Iterator)localObject).hasNext()) {
      j += ((Label)((Iterator)localObject).next()).a();
    }
    localObject = new byte[j];
    paramList = paramList.iterator();
    j = 0;
    while (paramList.hasNext())
    {
      Label localLabel = (Label)paramList.next();
      System.arraycopy(b, 0, localObject, j, localLabel.a());
      j += localLabel.a();
    }
    return new Label((byte[])localObject);
  }
  
  public static Label a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static Label a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return new Label(arrayOfByte);
  }
  
  public static e.a a(int paramInt)
  {
    return new e.a(paramInt);
  }
  
  public static Label copy(ByteBuffer paramByteBuffer)
  {
    return copy(paramByteBuffer, paramByteBuffer.remaining());
  }
  
  public static Label copy(ByteBuffer paramByteBuffer, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramByteBuffer.get(arrayOfByte);
    return new Label(arrayOfByte);
  }
  
  public static PdfStream getOverride()
  {
    return toString(32);
  }
  
  public static PdfStream toString(int paramInt)
  {
    return new PdfStream(new ByteArrayOutputStream(paramInt), null);
  }
  
  public int a()
  {
    return b.length;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(b, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  public ByteBuffer asReadOnlyByteBuffer()
  {
    return ByteBuffer.wrap(b).asReadOnlyBuffer();
  }
  
  public byte b(int paramInt)
  {
    return b[paramInt];
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = b;
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, paramInt, arrayOfByte.length);
  }
  
  public boolean b()
  {
    return b.length == 0;
  }
  
  public void copyTo(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = b;
    paramByteBuffer.put(arrayOfByte, 0, arrayOfByte.length);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Label)) {
      return false;
    }
    Object localObject = (Label)paramObject;
    paramObject = b;
    int k = paramObject.length;
    localObject = b;
    if (k != localObject.length) {
      return false;
    }
    int j = 0;
    while (j < k)
    {
      if (paramObject[j] != localObject[j]) {
        return false;
      }
      j += 1;
    }
    return true;
  }
  
  public String getColor(String paramString)
    throws UnsupportedEncodingException
  {
    return new String(b, paramString);
  }
  
  public InputStream getInputStream()
  {
    return new ByteArrayInputStream(b);
  }
  
  public byte[] getName()
  {
    byte[] arrayOfByte1 = b;
    int j = arrayOfByte1.length;
    byte[] arrayOfByte2 = new byte[j];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, j);
    return arrayOfByte2;
  }
  
  public int hashCode()
  {
    int k = i;
    int j = k;
    if (k == 0)
    {
      byte[] arrayOfByte = b;
      int m = arrayOfByte.length;
      k = 0;
      j = m;
      while (k < m)
      {
        j = j * 31 + arrayOfByte[k];
        k += 1;
      }
      if (j == 0) {
        j = 1;
      }
      i = j;
    }
    return j;
  }
  
  public String onActivityCreated()
  {
    Object localObject = b;
    try
    {
      localObject = new String((byte[])localObject, "UTF-8");
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("UTF-8 not supported?", localUnsupportedEncodingException);
    }
  }
}
