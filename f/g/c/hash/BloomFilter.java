package f.g.c.hash;

import f.g.c.a.a;
import f.g.c.f.j;
import f.g.c.package_10.Preconditions;
import java.io.Serializable;

@a
public final class BloomFilter<T>
  implements Serializable
{
  public static final double LN2 = Math.log(2.0D);
  public static final double LN2_SQUARED;
  public final BloomFilterStrategies.BitArray bits;
  public final j<T> funnel;
  public final int numHashFunctions;
  public final Strategy strategy;
  
  static
  {
    double d = LN2;
    LN2_SQUARED = d * d;
  }
  
  public BloomFilter(BloomFilterStrategies.BitArray paramBitArray, int paramInt, Funnel paramFunnel, Strategy paramStrategy)
  {
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "numHashFunctions zero or negative");
    if (paramBitArray != null)
    {
      bits = paramBitArray;
      numHashFunctions = paramInt;
      if (paramFunnel != null)
      {
        funnel = paramFunnel;
        strategy = paramStrategy;
        if (paramInt <= 255) {
          return;
        }
        throw new AssertionError("Currently we don't allow BloomFilters that would use more than255 hash functions, please contact the guava team");
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static BloomFilter create(Funnel paramFunnel, int paramInt)
  {
    return create(paramFunnel, paramInt, 0.03D);
  }
  
  public static BloomFilter create(Funnel paramFunnel, int paramInt, double paramDouble)
  {
    if (paramFunnel != null)
    {
      int j = 0;
      boolean bool;
      if (paramInt >= 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Expected insertions cannot be negative");
      if (paramDouble > 0.0D) {
        i = 1;
      } else {
        i = 0;
      }
      if (paramDouble < 1.0D) {
        j = 1;
      }
      Preconditions.checkArgument(j & i, "False positive probability in (0.0, 1.0)");
      int i = paramInt;
      if (paramInt == 0) {
        i = 1;
      }
      paramInt = optimalNumOfBits(i, paramDouble);
      i = optimalNumOfHashFunctions(i, paramInt);
      return new BloomFilter(new BloomFilterStrategies.BitArray(paramInt), i, paramFunnel, BloomFilterStrategies.MURMUR128_MITZ_32);
    }
    throw new NullPointerException();
  }
  
  private Object create()
  {
    return new BigReal(this);
  }
  
  public static int optimalNumOfBits(int paramInt, double paramDouble)
  {
    double d = -paramInt;
    paramDouble = Math.log(paramDouble);
    Double.isNaN(d);
    return (int)(paramDouble * d / LN2_SQUARED);
  }
  
  public static int optimalNumOfHashFunctions(int paramInt1, int paramInt2)
  {
    double d1 = paramInt2 / paramInt1;
    double d2 = LN2;
    Double.isNaN(d1);
    return Math.max(1, (int)Math.round(d1 * d2));
  }
  
  public BloomFilter copy()
  {
    return new BloomFilter(bits.copy(), numHashFunctions, funnel, strategy);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof BloomFilter))
    {
      paramObject = (BloomFilter)paramObject;
      if ((numHashFunctions == numHashFunctions) && (bits.equals(bits)) && (funnel == funnel) && (strategy == strategy)) {
        return true;
      }
    }
    return false;
  }
  
  public double expectedFpp()
  {
    double d1 = bits.bitCount();
    double d2 = bits.bitSize();
    Double.isNaN(d1);
    Double.isNaN(d2);
    return Math.pow(d1 / d2, numHashFunctions);
  }
  
  public int getHashCount()
  {
    return numHashFunctions;
  }
  
  public int hashCode()
  {
    return bits.hashCode();
  }
  
  public boolean mightContain(Object paramObject)
  {
    return strategy.mightContain(paramObject, funnel, numHashFunctions, bits);
  }
  
  public boolean put(Object paramObject)
  {
    return strategy.put(paramObject, funnel, numHashFunctions, bits);
  }
  
  public abstract interface Strategy
    extends Serializable
  {
    public abstract boolean mightContain(Object paramObject, Funnel paramFunnel, int paramInt, BloomFilterStrategies.BitArray paramBitArray);
    
    public abstract int ordinal();
    
    public abstract boolean put(Object paramObject, Funnel paramFunnel, int paramInt, BloomFilterStrategies.BitArray paramBitArray);
  }
}
