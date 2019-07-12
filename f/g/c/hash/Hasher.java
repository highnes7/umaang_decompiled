package f.g.c.hash;

import f.g.c.a.a;
import java.nio.charset.Charset;

@a
public abstract interface Hasher
  extends PrimitiveSink
{
  public abstract HashCode hash();
  
  public abstract Hasher putBoolean(boolean paramBoolean);
  
  public abstract Hasher putByte(byte paramByte);
  
  public abstract Hasher putBytes(byte[] paramArrayOfByte);
  
  public abstract Hasher putBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract Hasher putChar(char paramChar);
  
  public abstract Hasher putDouble(double paramDouble);
  
  public abstract Hasher putFloat(float paramFloat);
  
  public abstract Hasher putInt(int paramInt);
  
  public abstract Hasher putLong(long paramLong);
  
  public abstract Hasher putObject(Object paramObject, Funnel paramFunnel);
  
  public abstract Hasher putShort(short paramShort);
  
  public abstract Hasher putString(CharSequence paramCharSequence);
  
  public abstract Hasher putString(CharSequence paramCharSequence, Charset paramCharset);
}
