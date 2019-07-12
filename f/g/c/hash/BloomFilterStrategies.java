package f.g.c.hash;

import f.g.c.f.g.b;
import f.g.c.f.i;
import f.g.c.navigation.IntMath;
import f.g.c.package_10.Preconditions;
import java.math.RoundingMode;
import java.util.Arrays;

public enum BloomFilterStrategies
  implements g.b
{
  MURMUR128_MITZ_32;
  
  public class BitArray
  {
    public int bitCount;
    
    public BitArray()
    {
      this();
    }
    
    public BitArray()
    {
      int j = BloomFilterStrategies.this.length;
      int i = 0;
      boolean bool;
      if (j > 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "data length is zero!");
      int k = BloomFilterStrategies.this.length;
      j = 0;
      while (i < k)
      {
        j += Long.bitCount(BloomFilterStrategies.this[i]);
        i += 1;
      }
      bitCount = j;
    }
    
    public int bitCount()
    {
      return bitCount;
    }
    
    public int bitSize()
    {
      return BloomFilterStrategies.this.length * 64;
    }
    
    public BitArray copy()
    {
      return new BitArray((long[])clone());
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof BitArray))
      {
        paramObject = (BitArray)paramObject;
        return Arrays.equals(BloomFilterStrategies.this, data);
      }
      return false;
    }
    
    public boolean get(int paramInt)
    {
      return (BloomFilterStrategies.this[(paramInt >> 6)] & 1L << paramInt) != 0L;
    }
    
    public int hashCode()
    {
      return Arrays.hashCode(BloomFilterStrategies.this);
    }
    
    public boolean set(int paramInt)
    {
      if (!get(paramInt))
      {
        long[] arrayOfLong = BloomFilterStrategies.this;
        int i = paramInt >> 6;
        arrayOfLong[i] |= 1L << paramInt;
        bitCount += 1;
        return true;
      }
      return false;
    }
  }
}
