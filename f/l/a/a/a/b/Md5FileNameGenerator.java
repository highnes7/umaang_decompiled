package f.l.a.a.a.b;

import f.l.a.c.L;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5FileNameGenerator
  implements FileNameGenerator
{
  public static final String HASH_ALGORITHM = "MD5";
  public static final int RADIX = 36;
  
  public Md5FileNameGenerator() {}
  
  private byte[] getMD5(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      L.e(paramArrayOfByte);
    }
    return null;
  }
  
  public String generate(String paramString)
  {
    return new BigInteger(getMD5(paramString.getBytes())).abs().toString(36);
  }
}
