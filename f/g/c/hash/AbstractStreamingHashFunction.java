package f.g.c.hash;

import f.g.c.package_10.Preconditions;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public abstract class AbstractStreamingHashFunction
  implements HashFunction
{
  public AbstractStreamingHashFunction() {}
  
  public HashCode hashBytes(byte[] paramArrayOfByte)
  {
    return newHasher().putBytes(paramArrayOfByte).hash();
  }
  
  public HashCode hashBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return newHasher().putBytes(paramArrayOfByte, paramInt1, paramInt2).hash();
  }
  
  public HashCode hashInt(int paramInt)
  {
    return newHasher().putInt(paramInt).hash();
  }
  
  public HashCode hashLong(long paramLong)
  {
    return newHasher().putLong(paramLong).hash();
  }
  
  public HashCode hashString(CharSequence paramCharSequence)
  {
    return newHasher().putString(paramCharSequence).hash();
  }
  
  public HashCode hashString(CharSequence paramCharSequence, Charset paramCharset)
  {
    return newHasher().putString(paramCharSequence, paramCharset).hash();
  }
  
  public Hasher newHasher(int paramInt)
  {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    return newHasher();
  }
  
  public abstract class AbstractStreamingHasher
    extends AbstractHasher
  {
    public final ByteBuffer buffer;
    public final int bufferSize;
    public final int chunkSize;
    
    public AbstractStreamingHasher()
    {
      this(this$1);
    }
    
    public AbstractStreamingHasher(int paramInt)
    {
      boolean bool;
      if (paramInt % this$1 == 0) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool);
      buffer = ByteBuffer.allocate(paramInt + 7).order(ByteOrder.LITTLE_ENDIAN);
      bufferSize = paramInt;
      chunkSize = this$1;
    }
    
    private void munch()
    {
      buffer.flip();
      while (buffer.remaining() >= chunkSize) {
        process(buffer);
      }
      buffer.compact();
    }
    
    private void munchIfFull()
    {
      if (buffer.remaining() < 8) {
        munch();
      }
    }
    
    private final Hasher putBytes(ByteBuffer paramByteBuffer)
    {
      if (paramByteBuffer.remaining() <= buffer.remaining())
      {
        buffer.put(paramByteBuffer);
        munchIfFull();
        return this;
      }
      int j = bufferSize;
      int k = buffer.position();
      int i = 0;
      while (i < j - k)
      {
        buffer.put(paramByteBuffer.get());
        i += 1;
      }
      munch();
      while (paramByteBuffer.remaining() >= chunkSize) {
        process(paramByteBuffer);
      }
      buffer.put(paramByteBuffer);
      return this;
    }
    
    public final HashCode hash()
    {
      munch();
      buffer.flip();
      if (buffer.remaining() > 0) {
        processRemaining(buffer);
      }
      return makeHash();
    }
    
    public abstract HashCode makeHash();
    
    public abstract void process(ByteBuffer paramByteBuffer);
    
    public void processRemaining(ByteBuffer paramByteBuffer)
    {
      paramByteBuffer.position(paramByteBuffer.limit());
      paramByteBuffer.limit(chunkSize + 7);
      int j;
      for (;;)
      {
        int i = paramByteBuffer.position();
        j = chunkSize;
        if (i >= j) {
          break;
        }
        paramByteBuffer.putLong(0L);
      }
      paramByteBuffer.limit(j);
      paramByteBuffer.flip();
      process(paramByteBuffer);
    }
    
    public final Hasher putByte(byte paramByte)
    {
      buffer.put(paramByte);
      munchIfFull();
      return this;
    }
    
    public final Hasher putBytes(byte[] paramArrayOfByte)
    {
      return putBytes(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    public final Hasher putBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      putBytes(ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2).order(ByteOrder.LITTLE_ENDIAN));
      return this;
    }
    
    public final Hasher putChar(char paramChar)
    {
      buffer.putChar(paramChar);
      munchIfFull();
      return this;
    }
    
    public final Hasher putInt(int paramInt)
    {
      buffer.putInt(paramInt);
      munchIfFull();
      return this;
    }
    
    public final Hasher putLong(long paramLong)
    {
      buffer.putLong(paramLong);
      munchIfFull();
      return this;
    }
    
    public final Hasher putObject(Object paramObject, Funnel paramFunnel)
    {
      paramFunnel.funnel(paramObject, this);
      return this;
    }
    
    public final Hasher putShort(short paramShort)
    {
      buffer.putShort(paramShort);
      munchIfFull();
      return this;
    }
    
    public final Hasher putString(CharSequence paramCharSequence)
    {
      int i = 0;
      while (i < paramCharSequence.length())
      {
        putChar(paramCharSequence.charAt(i));
        i += 1;
      }
      return this;
    }
  }
}
