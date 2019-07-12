package f.g.c.hash;

import java.io.Serializable;

public final class Murmur3_32HashFunction
  extends AbstractStreamingHashFunction
  implements Serializable
{
  public static final int C1 = -862048943;
  public static final int C2 = 461845907;
  public static final long serialVersionUID = 0L;
  public final int seed;
  
  public Murmur3_32HashFunction(int paramInt)
  {
    seed = paramInt;
  }
  
  public static HashCode fmix(int paramInt1, int paramInt2)
  {
    paramInt1 ^= paramInt2;
    paramInt1 = (paramInt1 ^ paramInt1 >>> 16) * -2048144789;
    paramInt1 = (paramInt1 ^ paramInt1 >>> 13) * -1028477387;
    return new HashCode.BytesHashCode(paramInt1 ^ paramInt1 >>> 16);
  }
  
  public static int mixH1(int paramInt1, int paramInt2)
  {
    return Integer.rotateLeft(paramInt1 ^ paramInt2, 13) * 5 - 430675100;
  }
  
  public static int mixK1(int paramInt)
  {
    return Integer.rotateLeft(paramInt * -862048943, 15) * 461845907;
  }
  
  public int bits()
  {
    return 32;
  }
  
  public HashCode hashInt(int paramInt)
  {
    paramInt = mixK1(paramInt);
    return fmix(mixH1(seed, paramInt), 4);
  }
  
  public HashCode hashLong(long paramLong)
  {
    int j = (int)paramLong;
    int i = (int)(paramLong >>> 32);
    j = mixK1(j);
    return fmix(mixH1(mixH1(seed, j), mixK1(i)), 8);
  }
  
  public HashCode hashString(CharSequence paramCharSequence)
  {
    int i = seed;
    int j = 1;
    while (j < paramCharSequence.length())
    {
      i = mixH1(i, mixK1(paramCharSequence.charAt(j - 1) | paramCharSequence.charAt(j) << '\020'));
      j += 2;
    }
    j = i;
    if ((paramCharSequence.length() & 0x1) == 1) {
      j = i ^ mixK1(paramCharSequence.charAt(paramCharSequence.length() - 1));
    }
    return fmix(j, paramCharSequence.length() * 2);
  }
  
  public Hasher newHasher()
  {
    return new SipHashFunction.SipHasher(seed);
  }
}
