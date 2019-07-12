package f.g.c.hash;

import f.g.c.package_10.Preconditions;
import f.g.c.package_10.Throwables;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public abstract class AbstractNonStreamingHashFunction
  implements HashFunction
{
  public AbstractNonStreamingHashFunction() {}
  
  public HashCode hashBytes(byte[] paramArrayOfByte)
  {
    return hashBytes(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public HashCode hashInt(int paramInt)
  {
    return newHasher(4).putInt(paramInt).hash();
  }
  
  public HashCode hashLong(long paramLong)
  {
    return newHasher(8).putLong(paramLong).hash();
  }
  
  public HashCode hashString(CharSequence paramCharSequence)
  {
    int j = paramCharSequence.length();
    Hasher localHasher = newHasher(j * 2);
    int i = 0;
    while (i < j)
    {
      localHasher.putChar(paramCharSequence.charAt(i));
      i += 1;
    }
    return localHasher.hash();
  }
  
  public HashCode hashString(CharSequence paramCharSequence, Charset paramCharset)
  {
    paramCharSequence = paramCharset.encode(CharBuffer.wrap(paramCharSequence));
    if (paramCharSequence.hasArray())
    {
      paramCharset = paramCharSequence.array();
      int i = paramCharSequence.arrayOffset();
      int j = paramCharSequence.position();
      int k = paramCharSequence.limit();
      return hashBytes(paramCharset, j + i, paramCharSequence.arrayOffset() + k);
    }
    paramCharset = new byte[paramCharSequence.remaining()];
    paramCharSequence.get(paramCharset);
    return hashBytes(paramCharset);
  }
  
  public Hasher newHasher()
  {
    return new BufferingHasher(32);
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
    return new BufferingHasher(paramInt);
  }
  
  public final class BufferingHasher
    extends AbstractHasher
  {
    public static final int BOTTOM_BYTE = 255;
    public final AbstractNonStreamingHashFunction.ExposedByteArrayOutputStream stream;
    
    public BufferingHasher(int paramInt)
    {
      stream = new AbstractNonStreamingHashFunction.ExposedByteArrayOutputStream(paramInt);
    }
    
    public HashCode hash()
    {
      return hashBytes(stream.byteArray(), 0, stream.length());
    }
    
    public Hasher putByte(byte paramByte)
    {
      stream.write(paramByte);
      return this;
    }
    
    public Hasher putBytes(byte[] paramArrayOfByte)
    {
      AbstractNonStreamingHashFunction.ExposedByteArrayOutputStream localExposedByteArrayOutputStream = stream;
      try
      {
        localExposedByteArrayOutputStream.write(paramArrayOfByte);
        return this;
      }
      catch (IOException paramArrayOfByte)
      {
        Throwables.propagate(paramArrayOfByte);
        throw new NullPointerException("Null throw statement replaced by Soot");
      }
    }
    
    public Hasher putBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      stream.write(paramArrayOfByte, paramInt1, paramInt2);
      return this;
    }
    
    public Hasher putChar(char paramChar)
    {
      stream.write(paramChar & 0xFF);
      stream.write(paramChar >>> '\b' & 0xFF);
      return this;
    }
    
    public Hasher putInt(int paramInt)
    {
      stream.write(paramInt & 0xFF);
      stream.write(paramInt >>> 8 & 0xFF);
      stream.write(paramInt >>> 16 & 0xFF);
      stream.write(paramInt >>> 24 & 0xFF);
      return this;
    }
    
    public Hasher putLong(long paramLong)
    {
      int i = 0;
      while (i < 64)
      {
        stream.write((byte)(int)(paramLong >>> i & 0xFF));
        i += 8;
      }
      return this;
    }
    
    public Hasher putObject(Object paramObject, Funnel paramFunnel)
    {
      paramFunnel.funnel(paramObject, this);
      return this;
    }
    
    public Hasher putShort(short paramShort)
    {
      stream.write(paramShort & 0xFF);
      stream.write(paramShort >>> 8 & 0xFF);
      return this;
    }
  }
  
  public final class ExposedByteArrayOutputStream
    extends ByteArrayOutputStream
  {
    public ExposedByteArrayOutputStream()
    {
      super();
    }
    
    public byte[] byteArray()
    {
      return buf;
    }
    
    public int length()
    {
      return count;
    }
  }
}
