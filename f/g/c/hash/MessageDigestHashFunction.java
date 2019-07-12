package f.g.c.hash;

import f.g.c.package_10.Preconditions;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class MessageDigestHashFunction
  extends AbstractStreamingHashFunction
{
  public final String algorithmName;
  public final int bits;
  
  public MessageDigestHashFunction(String paramString)
  {
    algorithmName = paramString;
    bits = (getMessageDigest(paramString).getDigestLength() * 8);
  }
  
  public static MessageDigest getMessageDigest(String paramString)
  {
    try
    {
      paramString = MessageDigest.getInstance(paramString);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  public int bits()
  {
    return bits;
  }
  
  public Hasher newHasher()
  {
    return new MessageDigestHasher(getMessageDigest(algorithmName));
  }
  
  public class MessageDigestHasher
    implements Hasher
  {
    public boolean done;
    public final ByteBuffer scratch = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
    
    public MessageDigestHasher() {}
    
    private void checkNotDone()
    {
      Preconditions.checkState(done ^ true, "Cannot use Hasher after calling #hash() on it");
    }
    
    public HashCode hash()
    {
      done = true;
      return new HashCodes.BytesHashCode(digest());
    }
    
    public Hasher putBoolean(boolean paramBoolean)
    {
      return putByte((byte)paramBoolean);
    }
    
    public Hasher putByte(byte paramByte)
    {
      checkNotDone();
      update(paramByte);
      return this;
    }
    
    public Hasher putBytes(byte[] paramArrayOfByte)
    {
      checkNotDone();
      update(paramArrayOfByte);
      return this;
    }
    
    public Hasher putBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      checkNotDone();
      Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
      update(paramArrayOfByte, paramInt1, paramInt2);
      return this;
    }
    
    public Hasher putChar(char paramChar)
    {
      checkNotDone();
      scratch.putChar(paramChar);
      update(scratch.array(), 0, 2);
      scratch.clear();
      return this;
    }
    
    public Hasher putDouble(double paramDouble)
    {
      checkNotDone();
      scratch.putDouble(paramDouble);
      update(scratch.array(), 0, 8);
      scratch.clear();
      return this;
    }
    
    public Hasher putFloat(float paramFloat)
    {
      checkNotDone();
      scratch.putFloat(paramFloat);
      update(scratch.array(), 0, 4);
      scratch.clear();
      return this;
    }
    
    public Hasher putInt(int paramInt)
    {
      checkNotDone();
      scratch.putInt(paramInt);
      update(scratch.array(), 0, 4);
      scratch.clear();
      return this;
    }
    
    public Hasher putLong(long paramLong)
    {
      checkNotDone();
      scratch.putLong(paramLong);
      update(scratch.array(), 0, 8);
      scratch.clear();
      return this;
    }
    
    public Hasher putObject(Object paramObject, Funnel paramFunnel)
    {
      checkNotDone();
      paramFunnel.funnel(paramObject, this);
      return this;
    }
    
    public Hasher putShort(short paramShort)
    {
      checkNotDone();
      scratch.putShort(paramShort);
      update(scratch.array(), 0, 2);
      scratch.clear();
      return this;
    }
    
    public Hasher putString(CharSequence paramCharSequence)
    {
      int i = 0;
      while (i < paramCharSequence.length())
      {
        putChar(paramCharSequence.charAt(i));
        i += 1;
      }
      return this;
    }
    
    public Hasher putString(CharSequence paramCharSequence, Charset paramCharset)
    {
      paramCharSequence = paramCharset.encode(CharBuffer.wrap(paramCharSequence));
      if (paramCharSequence.hasArray())
      {
        paramCharset = paramCharSequence.array();
        int i = paramCharSequence.arrayOffset();
        int j = paramCharSequence.position();
        int k = paramCharSequence.limit();
        return putBytes(paramCharset, j + i, paramCharSequence.arrayOffset() + k);
      }
      paramCharset = new byte[paramCharSequence.remaining()];
      paramCharSequence.get(paramCharset);
      return putBytes(paramCharset);
    }
  }
}
