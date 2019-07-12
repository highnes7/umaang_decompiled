package f.g.c.hash;

import f.g.c.a.a;
import java.nio.charset.Charset;

@a
public abstract interface HashFunction
{
  public abstract int bits();
  
  public abstract HashCode hashBytes(byte[] paramArrayOfByte);
  
  public abstract HashCode hashBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract HashCode hashInt(int paramInt);
  
  public abstract HashCode hashLong(long paramLong);
  
  public abstract HashCode hashString(CharSequence paramCharSequence);
  
  public abstract HashCode hashString(CharSequence paramCharSequence, Charset paramCharset);
  
  public abstract Hasher newHasher();
  
  public abstract Hasher newHasher(int paramInt);
}
