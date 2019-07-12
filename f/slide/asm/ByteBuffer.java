package f.slide.asm;

import java.io.UnsupportedEncodingException;

public final class ByteBuffer
{
  public ByteBuffer() {}
  
  public static byte[] append(String paramString)
  {
    if (paramString != null) {
      try
      {
        paramString = paramString.getBytes("UTF-8");
        return paramString;
      }
      catch (UnsupportedEncodingException paramString)
      {
        throw new Error(paramString);
      }
    }
    return null;
  }
  
  public static int convert(String paramString)
  {
    if (paramString != null) {}
    try
    {
      paramString = paramString.getBytes("UTF-8");
      return paramString.length;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;) {}
    }
    throw new RuntimeException();
    return 0;
  }
  
  public static String decode(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
        return paramArrayOfByte;
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        throw new Error(paramArrayOfByte);
      }
    }
    return null;
  }
}
