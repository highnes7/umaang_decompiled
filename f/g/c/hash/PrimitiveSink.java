package f.g.c.hash;

import f.g.c.a.a;
import java.nio.charset.Charset;

@a
public abstract interface PrimitiveSink
{
  public abstract PrimitiveSink putBoolean(boolean paramBoolean);
  
  public abstract PrimitiveSink putByte(byte paramByte);
  
  public abstract PrimitiveSink putBytes(byte[] paramArrayOfByte);
  
  public abstract PrimitiveSink putBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract PrimitiveSink putChar(char paramChar);
  
  public abstract PrimitiveSink putDouble(double paramDouble);
  
  public abstract PrimitiveSink putFloat(float paramFloat);
  
  public abstract PrimitiveSink putInt(int paramInt);
  
  public abstract PrimitiveSink putLong(long paramLong);
  
  public abstract PrimitiveSink putShort(short paramShort);
  
  public abstract PrimitiveSink putString(CharSequence paramCharSequence);
  
  public abstract PrimitiveSink putString(CharSequence paramCharSequence, Charset paramCharset);
}
