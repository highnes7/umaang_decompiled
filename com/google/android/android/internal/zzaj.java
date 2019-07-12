package com.google.android.android.internal;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class zzaj
  extends FilterInputStream
{
  public int zzca = 0;
  
  public zzaj(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public final int read()
    throws IOException
  {
    int i = super.read();
    if (i != -1) {
      zzca += 1;
    }
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != -1) {
      zzca += paramInt1;
    }
    return paramInt1;
  }
}
