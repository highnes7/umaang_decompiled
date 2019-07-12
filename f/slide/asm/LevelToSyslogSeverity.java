package f.slide.asm;

import java.io.UnsupportedEncodingException;

public final class LevelToSyslogSeverity
{
  public LevelToSyslogSeverity() {}
  
  public static String convert(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "us-ascii");
        return paramArrayOfByte;
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        throw new Error(paramArrayOfByte);
      }
    }
    return null;
  }
  
  public static byte[] convert(String paramString)
  {
    if (paramString != null) {
      try
      {
        paramString = paramString.getBytes("us-ascii");
        return paramString;
      }
      catch (UnsupportedEncodingException paramString)
      {
        throw new Error(paramString);
      }
    }
    return null;
  }
}
