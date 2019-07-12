package f.g.c.hash;

import f.g.c.a.a;
import f.g.c.j.g;
import f.g.c.package_10.Preconditions;
import java.security.MessageDigest;

@a
public abstract class HashCode
{
  public static final char[] hexDigits = "0123456789abcdef".toCharArray();
  
  public HashCode() {}
  
  public abstract byte[] asBytes();
  
  public abstract int asInt();
  
  public abstract long asLong();
  
  public abstract int bits();
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof HashCode))
    {
      paramObject = (HashCode)paramObject;
      return MessageDigest.isEqual(asBytes(), paramObject.asBytes());
    }
    return false;
  }
  
  public int hashCode()
  {
    return asInt();
  }
  
  public String toString()
  {
    byte[] arrayOfByte = asBytes();
    StringBuilder localStringBuilder = new StringBuilder(arrayOfByte.length * 2);
    int j = arrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfByte[i];
      localStringBuilder.append(hexDigits[(k >> 4 & 0xF)]);
      localStringBuilder.append(hexDigits[(k & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public int writeBytesTo(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = asBytes();
    paramInt2 = g.c(new int[] { paramInt2, arrayOfByte.length });
    Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, paramInt1, paramInt2);
    return paramInt2;
  }
}
