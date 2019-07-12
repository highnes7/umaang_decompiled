package com.google.android.android.internal;

import java.io.IOException;
import java.io.InputStream;

public final class zzeww
  extends InputStream
{
  public int mark;
  public zzewv zzoqc;
  public zzeuq zzoqd;
  public int zzoqe;
  public int zzoqf;
  public int zzoqg;
  
  public zzeww(zzews paramZzews)
  {
    initialize();
  }
  
  private final int append(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = paramInt2;
    int i = paramInt1;
    paramInt1 = j;
    while (paramInt1 > 0)
    {
      zzcvd();
      if (zzoqd == null)
      {
        if (paramInt1 != paramInt2) {
          break;
        }
        return -1;
      }
      int k = Math.min(zzoqe - zzoqf, paramInt1);
      j = i;
      if (paramArrayOfByte != null)
      {
        zzoqd.add(paramArrayOfByte, zzoqf, i, k);
        j = i + k;
      }
      zzoqf += k;
      paramInt1 -= k;
      i = j;
    }
    return paramInt2 - paramInt1;
  }
  
  private final void initialize()
  {
    zzoqc = new zzewv(zzoqh);
    zzoqd = ((zzeuq)zzoqc.next());
    zzoqe = zzoqd.size();
    zzoqf = 0;
    zzoqg = 0;
  }
  
  private final void zzcvd()
  {
    if (zzoqd != null)
    {
      int i = zzoqf;
      int j = zzoqe;
      if (i == j)
      {
        zzoqg += j;
        zzoqf = 0;
        if (zzoqc.hasNext())
        {
          zzoqd = ((zzeuq)zzoqc.next());
          zzoqe = zzoqd.size();
          return;
        }
        zzoqd = null;
        zzoqe = 0;
      }
    }
  }
  
  public final int available()
    throws IOException
  {
    int i = zzoqg;
    int j = zzoqf;
    return zzoqh.size() - (i + j);
  }
  
  public final void mark(int paramInt)
  {
    mark = (zzoqg + zzoqf);
  }
  
  public final boolean markSupported()
  {
    return true;
  }
  
  public final int read()
    throws IOException
  {
    zzcvd();
    zzeuq localZzeuq = zzoqd;
    if (localZzeuq == null) {
      return -1;
    }
    int i = zzoqf;
    zzoqf = (i + 1);
    return localZzeuq.zzji(i) & 0xFF;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt2 <= paramArrayOfByte.length - paramInt1)) {
        return append(paramArrayOfByte, paramInt1, paramInt2);
      }
      throw new IndexOutOfBoundsException();
    }
    throw new NullPointerException();
  }
  
  public final void reset()
  {
    try
    {
      initialize();
      append(null, 0, mark);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final long skip(long paramLong)
  {
    if (paramLong >= 0L)
    {
      long l = paramLong;
      if (paramLong > 2147483647L) {
        l = 2147483647L;
      }
      return append(null, 0, (int)l);
    }
    throw new IndexOutOfBoundsException();
  }
}
