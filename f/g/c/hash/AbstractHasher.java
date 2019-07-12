package f.g.c.hash;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public abstract class AbstractHasher
  implements Hasher
{
  public AbstractHasher() {}
  
  public final Hasher putBoolean(boolean paramBoolean)
  {
    return putByte((byte)paramBoolean);
  }
  
  public final Hasher putDouble(double paramDouble)
  {
    return putLong(Double.doubleToRawLongBits(paramDouble));
  }
  
  public final Hasher putFloat(float paramFloat)
  {
    return putInt(Float.floatToRawIntBits(paramFloat));
  }
  
  public Hasher putString(CharSequence paramCharSequence)
  {
    int j = paramCharSequence.length();
    int i = 0;
    while (i < j)
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
