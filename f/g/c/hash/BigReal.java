package f.g.c.hash;

import f.g.c.f.j;
import java.io.Serializable;

public class BigReal<T>
  implements Serializable
{
  public static final long serialVersionUID = 1L;
  public final j<T> ONE;
  public final int ZERO;
  public final long[] data;
  public final BloomFilter.Strategy scale;
  
  public BigReal(BloomFilter paramBloomFilter)
  {
    data = access$getBitsdata;
    ZERO = BloomFilter.access$getNumHashFunctions(paramBloomFilter);
    ONE = BloomFilter.access$getFunnel(paramBloomFilter);
    scale = BloomFilter.access$getStrategy(paramBloomFilter);
  }
  
  public Object reciprocal()
  {
    return new BloomFilter(new BloomFilterStrategies.BitArray(data), ZERO, ONE, scale);
  }
}
