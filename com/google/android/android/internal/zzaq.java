package com.google.android.android.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class zzaq
  extends ByteArrayOutputStream
{
  public final zzae zzbp;
  
  public zzaq(zzae paramZzae, int paramInt)
  {
    zzbp = paramZzae;
    buf = zzbp.getBuf(Math.max(paramInt, 256));
  }
  
  private final void expand(int paramInt)
  {
    int i = count;
    if (i + paramInt <= buf.length) {
      return;
    }
    byte[] arrayOfByte = zzbp.getBuf(i + paramInt << 1);
    System.arraycopy(buf, 0, arrayOfByte, 0, count);
    zzbp.returnBuf(buf);
    buf = arrayOfByte;
  }
  
  public final void close()
    throws IOException
  {
    zzbp.returnBuf(buf);
    buf = null;
    super.close();
  }
  
  public final void finalize()
  {
    zzbp.returnBuf(buf);
  }
  
  public final void write(int paramInt)
  {
    try
    {
      expand(1);
      super.write(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      expand(paramInt2);
      super.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      throw paramArrayOfByte;
    }
  }
}
