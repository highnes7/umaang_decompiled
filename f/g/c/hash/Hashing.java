package f.g.c.hash;

import f.g.c.a.a;
import f.g.c.a.d;
import f.g.c.j.p;
import f.g.c.package_10.Preconditions;
import java.nio.ByteBuffer;
import java.util.Iterator;

@a
public final class Hashing
{
  public static final HashFunction GOOD_FAST_HASH_FUNCTION_128;
  public static final HashFunction GOOD_FAST_HASH_FUNCTION_32;
  public static final int GOOD_FAST_HASH_SEED = (int)System.currentTimeMillis();
  public static final HashFunction MD5 = new MessageDigestHashFunction("MD5");
  public static final Murmur3_128HashFunction MURMUR3_128;
  public static final Murmur3_32HashFunction MURMUR3_32;
  public static final HashFunction SHA_1 = new MessageDigestHashFunction("SHA-1");
  public static final HashFunction SHA_256 = new MessageDigestHashFunction("SHA-256");
  public static final HashFunction SHA_512 = new MessageDigestHashFunction("SHA-512");
  
  static
  {
    GOOD_FAST_HASH_FUNCTION_32 = new Murmur3_32HashFunction(GOOD_FAST_HASH_SEED);
    GOOD_FAST_HASH_FUNCTION_128 = new Murmur3_128HashFunction(GOOD_FAST_HASH_SEED);
    MURMUR3_32 = new Murmur3_32HashFunction(0);
    MURMUR3_128 = new Murmur3_128HashFunction(0);
  }
  
  public Hashing() {}
  
  public static int checkPositiveAndMakeMultipleOf32(int paramInt)
  {
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Number of bits must be positive");
    return paramInt + 31 & 0xFFFFFFE0;
  }
  
  public static HashCode combineOrdered(Iterable paramIterable)
  {
    Object localObject = paramIterable.iterator();
    Preconditions.checkArgument(((Iterator)localObject).hasNext(), "Must be at least 1 hash code to combine.");
    localObject = new byte[((HashCode)((Iterator)localObject).next()).bits() / 8];
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      byte[] arrayOfByte = ((HashCode)paramIterable.next()).asBytes();
      int j = arrayOfByte.length;
      int k = localObject.length;
      int i = 0;
      boolean bool;
      if (j == k) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "All hashcodes must have the same bit length.");
      while (i < arrayOfByte.length)
      {
        localObject[i] = ((byte)(localObject[i] * 37 ^ arrayOfByte[i]));
        i += 1;
      }
    }
    return new HashCodes.BytesHashCode((byte[])localObject);
  }
  
  public static HashCode combineUnordered(Iterable paramIterable)
  {
    Object localObject = paramIterable.iterator();
    Preconditions.checkArgument(((Iterator)localObject).hasNext(), "Must be at least 1 hash code to combine.");
    localObject = new byte[((HashCode)((Iterator)localObject).next()).bits() / 8];
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      byte[] arrayOfByte = ((HashCode)paramIterable.next()).asBytes();
      int j = arrayOfByte.length;
      int k = localObject.length;
      int i = 0;
      boolean bool;
      if (j == k) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "All hashcodes must have the same bit length.");
      while (i < arrayOfByte.length)
      {
        localObject[i] = ((byte)(localObject[i] + arrayOfByte[i]));
        i += 1;
      }
    }
    return new HashCodes.BytesHashCode((byte[])localObject);
  }
  
  public static int consistentHash(long paramLong, int paramInt)
  {
    int i = 0;
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "buckets must be positive: %s", new Object[] { Integer.valueOf(paramInt) });
    for (;;)
    {
      double d1 = i + 1;
      paramLong = paramLong * 2862933555777941757L + 1L;
      double d2 = (int)(paramLong >>> 33) + 1;
      Double.isNaN(d2);
      Double.isNaN(d2);
      d2 /= 2.147483648E9D;
      Double.isNaN(d1);
      int j = (int)(d1 / d2);
      if ((j < 0) || (j >= paramInt)) {
        break;
      }
      i = j;
    }
    return i;
  }
  
  public static int consistentHash(HashCode paramHashCode, int paramInt)
  {
    return consistentHash(padToLong(paramHashCode), paramInt);
  }
  
  public static HashFunction goodFastHash(int paramInt)
  {
    paramInt = checkPositiveAndMakeMultipleOf32(paramInt);
    if (paramInt == 32) {
      return GOOD_FAST_HASH_FUNCTION_32;
    }
    if (paramInt <= 128) {
      return GOOD_FAST_HASH_FUNCTION_128;
    }
    int j = (paramInt + 127) / 128;
    HashFunction[] arrayOfHashFunction = new HashFunction[j];
    arrayOfHashFunction[0] = GOOD_FAST_HASH_FUNCTION_128;
    int i = GOOD_FAST_HASH_SEED;
    paramInt = 1;
    while (paramInt < j)
    {
      i += 1500450271;
      arrayOfHashFunction[paramInt] = new Murmur3_128HashFunction(i);
      paramInt += 1;
    }
    return new ConcatenatedHashFunction(arrayOfHashFunction);
  }
  
  public static HashFunction md5()
  {
    return MD5;
  }
  
  public static HashFunction murmur3_128()
  {
    return MURMUR3_128;
  }
  
  public static HashFunction murmur3_128(int paramInt)
  {
    return new Murmur3_128HashFunction(paramInt);
  }
  
  public static HashFunction murmur3_32()
  {
    return MURMUR3_32;
  }
  
  public static HashFunction murmur3_32(int paramInt)
  {
    return new Murmur3_32HashFunction(paramInt);
  }
  
  public static long padToLong(HashCode paramHashCode)
  {
    if (paramHashCode.bits() < 64) {
      return p.b(paramHashCode.asInt());
    }
    return paramHashCode.asLong();
  }
  
  public static HashFunction sha1()
  {
    return SHA_1;
  }
  
  public static HashFunction sha256()
  {
    return SHA_256;
  }
  
  public static HashFunction sha512()
  {
    return SHA_512;
  }
  
  @d
  public final class ConcatenatedHashFunction
    extends AbstractCompositeHashFunction
  {
    public final int bits;
    
    public ConcatenatedHashFunction()
    {
      super();
      int k = this$1.length;
      int i = 0;
      int j = 0;
      while (i < k)
      {
        j += this$1[i].bits();
        i += 1;
      }
      bits = j;
    }
    
    public int bits()
    {
      return bits;
    }
    
    public HashCode makeHash(Hasher[] paramArrayOfHasher)
    {
      byte[] arrayOfByte = new byte[bits / 8];
      ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte);
      int j = paramArrayOfHasher.length;
      int i = 0;
      while (i < j)
      {
        localByteBuffer.put(paramArrayOfHasher[i].hash().asBytes());
        i += 1;
      }
      return new HashCodes.BytesHashCode(arrayOfByte);
    }
  }
  
  public final class LinearCongruentialGenerator
  {
    public long state;
    
    public LinearCongruentialGenerator()
    {
      state = this$1;
    }
    
    public double nextDouble()
    {
      state = (state * 2862933555777941757L + 1L);
      double d = (int)(state >>> 33) + 1;
      Double.isNaN(d);
      return d / 2.147483648E9D;
    }
  }
}
