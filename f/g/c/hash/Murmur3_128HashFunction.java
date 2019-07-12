package f.g.c.hash;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class Murmur3_128HashFunction
  extends AbstractStreamingHashFunction
  implements Serializable
{
  public static final long serialVersionUID = 0L;
  public final int seed;
  
  public Murmur3_128HashFunction(int paramInt)
  {
    seed = paramInt;
  }
  
  public int bits()
  {
    return 128;
  }
  
  public Hasher newHasher()
  {
    return new Murmur3_128Hasher(seed);
  }
  
  public final class Murmur3_128Hasher
    extends AbstractStreamingHashFunction.AbstractStreamingHasher
  {
    public static final long C1 = -8663945395140668459L;
    public static final long C2 = 5545529020109919103L;
    public static final int CHUNK_SIZE = 16;
    public long h1;
    public long h2;
    public int length;
    
    public Murmur3_128Hasher()
    {
      super(16);
      long l = this$1;
      h1 = l;
      h2 = l;
      length = 0;
    }
    
    private void bmix64(long paramLong1, long paramLong2)
    {
      long l = h1;
      h1 = (mixK1(paramLong1) ^ l);
      h1 = Long.rotateLeft(h1, 27);
      paramLong1 = h1;
      l = h2;
      h1 = (paramLong1 + l);
      h1 = (h1 * 5L + 1390208809L);
      h2 = (mixK2(paramLong2) ^ l);
      h2 = Long.rotateLeft(h2, 31);
      h2 += h1;
      h2 = (h2 * 5L + 944331445L);
    }
    
    public static long fmix64(long paramLong)
    {
      paramLong = (paramLong ^ paramLong >>> 33) * -49064778989728563L;
      paramLong = (paramLong ^ paramLong >>> 33) * -4265267296055464877L;
      return paramLong ^ paramLong >>> 33;
    }
    
    public static long mixK1(long paramLong)
    {
      return Long.rotateLeft(paramLong * -8663945395140668459L, 31) * 5545529020109919103L;
    }
    
    public static long mixK2(long paramLong)
    {
      return Long.rotateLeft(paramLong * 5545529020109919103L, 33) * -8663945395140668459L;
    }
    
    public HashCode makeHash()
    {
      long l1 = h1;
      int i = length;
      h1 = (l1 ^ i);
      h2 ^= i;
      long l2 = h1;
      l1 = h2;
      h1 = (l2 + l1);
      l2 = h1;
      h2 = (l1 + l2);
      h1 = fmix64(l2);
      h2 = fmix64(h2);
      l1 = h1;
      l2 = h2;
      h1 = (l1 + l2);
      h2 = (l2 + h1);
      return new HashCodes.BytesHashCode(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(h1).putLong(h2).array());
    }
    
    public void process(ByteBuffer paramByteBuffer)
    {
      bmix64(paramByteBuffer.getLong(), paramByteBuffer.getLong());
      length += 16;
    }
    
    public void processRemaining(ByteBuffer paramByteBuffer)
    {
      int i = length;
      length = (paramByteBuffer.remaining() + i);
      switch (paramByteBuffer.remaining())
      {
      default: 
        throw new AssertionError("Should never get here.");
      case 15: 
        l1 = (paramByteBuffer.get(14) & 0xFF) << 48 ^ 0L;
        break;
      case 14: 
        l1 = 0L;
        l1 ^= (paramByteBuffer.get(13) & 0xFF) << 40;
        break;
      case 13: 
        l1 = 0L;
        l1 ^= (paramByteBuffer.get(12) & 0xFF) << 32;
        break;
      case 12: 
        l1 = 0L;
        l1 ^= (paramByteBuffer.get(11) & 0xFF) << 24;
        break;
      case 11: 
        l1 = 0L;
        l1 ^= (paramByteBuffer.get(10) & 0xFF) << 16;
        break;
      case 10: 
        l1 = 0L;
        l1 ^= (paramByteBuffer.get(9) & 0xFF) << 8;
        break;
      case 9: 
        l1 = 0L;
        l1 ^= paramByteBuffer.get(8) & 0xFF;
        break;
      case 8: 
        l1 = 0L;
        l2 = paramByteBuffer.getLong() ^ 0L;
        break;
      case 7: 
        l1 = (paramByteBuffer.get(6) & 0xFF) << 48 ^ 0L;
        break;
      case 6: 
        l1 = 0L;
        l1 ^= (paramByteBuffer.get(5) & 0xFF) << 40;
        break;
      case 5: 
        l1 = 0L;
        l1 ^= (paramByteBuffer.get(4) & 0xFF) << 32;
        break;
      case 4: 
        l1 = 0L;
        l1 ^= (paramByteBuffer.get(3) & 0xFF) << 24;
        break;
      case 3: 
        l1 = 0L;
        l1 ^= (paramByteBuffer.get(2) & 0xFF) << 16;
        break;
      case 2: 
        l1 = 0L;
        l1 ^= (paramByteBuffer.get(1) & 0xFF) << 8;
        break;
      }
      long l1 = 0L;
      long l2 = paramByteBuffer.get(0) & 0xFF ^ l1;
      l1 = 0L;
      long l3 = h1;
      h1 = (mixK1(l2) ^ l3);
      l2 = h2;
      h2 = (mixK2(l1) ^ l2);
    }
  }
}
