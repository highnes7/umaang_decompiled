package com.google.android.android.internal;

import java.io.IOException;

public final class zzeye
{
  public final byte[] buffer;
  public int zzond;
  public int zzone = 64;
  public int zzonf = 67108864;
  public int zzonj;
  public int zzonl;
  public int zzonm = Integer.MAX_VALUE;
  public int zzono;
  public int zzoti;
  public int zzotj;
  
  public zzeye(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    buffer = paramArrayOfByte;
    zzoti = paramInt1;
    zzono = (paramInt2 + paramInt1);
    zzotj = paramInt1;
  }
  
  public static zzeye getBlob(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new zzeye(paramArrayOfByte, 0, paramInt2);
  }
  
  public static zzeye zzbe(byte[] paramArrayOfByte)
  {
    return getBlob(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  private final void zzctk()
  {
    zzono += zzonj;
    int i = zzono;
    int j = zzonm;
    if (i > j)
    {
      zzonj = (i - j);
      zzono = (i - zzonj);
      return;
    }
    zzonj = 0;
  }
  
  private final byte zzctl()
    throws IOException
  {
    int i = zzotj;
    if (i != zzono)
    {
      byte[] arrayOfByte = buffer;
      zzotj = (i + 1);
      return arrayOfByte[i];
    }
    throw zzeym.zzcwc();
  }
  
  private final void zzjp(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      int i = zzotj;
      int j = zzonm;
      if (i + paramInt <= j)
      {
        if (paramInt <= zzono - i)
        {
          zzotj = (i + paramInt);
          return;
        }
        throw zzeym.zzcwc();
      }
      zzjp(j - i);
      throw zzeym.zzcwc();
    }
    throw zzeym.zzcwd();
  }
  
  public final void digest(zzeyn paramZzeyn)
    throws IOException
  {
    int i = zzctc();
    if (zzond < zzone)
    {
      i = zzjn(i);
      zzond += 1;
      paramZzeyn.digest(this);
      zzjk(0);
      zzond -= 1;
      zzjo(i);
      return;
    }
    throw zzeym.zzcwf();
  }
  
  public final int getPosition()
  {
    return zzotj - zzoti;
  }
  
  public final byte[] readBytes()
    throws IOException
  {
    int i = zzctc();
    if (i >= 0)
    {
      if (i == 0) {
        return zzeyq.zzoue;
      }
      int j = zzono;
      int k = zzotj;
      if (i <= j - k)
      {
        byte[] arrayOfByte = new byte[i];
        System.arraycopy(buffer, k, arrayOfByte, 0, i);
        zzotj += i;
        return arrayOfByte;
      }
      throw zzeym.zzcwc();
    }
    throw zzeym.zzcwd();
  }
  
  public final void readFrom(zzeyn paramZzeyn, int paramInt)
    throws IOException
  {
    int i = zzond;
    if (i < zzone)
    {
      zzond = (i + 1);
      paramZzeyn.digest(this);
      zzjk(paramInt << 3 | 0x4);
      zzond -= 1;
      return;
    }
    throw zzeym.zzcwf();
  }
  
  public final String readString()
    throws IOException
  {
    int i = zzctc();
    if (i >= 0)
    {
      int j = zzono;
      int k = zzotj;
      if (i <= j - k)
      {
        String str = new String(buffer, k, i, zzeyl.UTF_8);
        zzotj += i;
        return str;
      }
      throw zzeym.zzcwc();
    }
    throw zzeym.zzcwd();
  }
  
  public final byte[] zzai(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return zzeyq.zzoue;
    }
    byte[] arrayOfByte = new byte[paramInt2];
    int i = zzoti;
    System.arraycopy(buffer, i + paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public final void zzaj(int paramInt1, int paramInt2)
  {
    int i = zzotj;
    int j = zzoti;
    if (paramInt1 <= i - j)
    {
      if (paramInt1 >= 0)
      {
        zzotj = (j + paramInt1);
        zzonl = paramInt2;
        return;
      }
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.add(24, "Bad position ", paramInt1));
    }
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append("Position ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" is beyond current ");
    localStringBuilder.append(i - j);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public final int zzcsn()
    throws IOException
  {
    if (zzotj == zzono)
    {
      zzonl = 0;
      return 0;
    }
    zzonl = zzctc();
    int i = zzonl;
    if (i != 0) {
      return i;
    }
    throw new zzeym("Protocol message contained an invalid tag (zero).");
  }
  
  public final long zzcsp()
    throws IOException
  {
    return zzcth();
  }
  
  public final int zzcsq()
    throws IOException
  {
    return zzctc();
  }
  
  public final boolean zzcst()
    throws IOException
  {
    return zzctc() != 0;
  }
  
  public final long zzctb()
    throws IOException
  {
    long l = zzcth();
    return -(l & 1L) ^ l >>> 1;
  }
  
  public final int zzctc()
    throws IOException
  {
    int i = zzctl();
    if (i >= 0) {
      return i;
    }
    i &= 0x7F;
    int j = zzctl();
    if (j >= 0) {
      j <<= 7;
    }
    for (;;)
    {
      return i | j;
      i |= (j & 0x7F) << 7;
      j = zzctl();
      if (j >= 0)
      {
        j <<= 14;
      }
      else
      {
        i |= (j & 0x7F) << 14;
        j = zzctl();
        if (j < 0) {
          break;
        }
        j <<= 21;
      }
    }
    int k = zzctl();
    j = i | (j & 0x7F) << 21 | k << 28;
    if (k < 0)
    {
      i = 0;
      while (i < 5)
      {
        if (zzctl() >= 0) {
          return j;
        }
        i += 1;
      }
      throw zzeym.zzcwe();
    }
    return j;
  }
  
  public final int zzcte()
  {
    int i = zzonm;
    if (i == Integer.MAX_VALUE) {
      return -1;
    }
    return i - zzotj;
  }
  
  public final long zzcth()
    throws IOException
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = zzctl();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    zzeym localZzeym = zzeym.zzcwe();
    throw localZzeym;
  }
  
  public final int zzcti()
    throws IOException
  {
    return zzctl() & 0xFF | (zzctl() & 0xFF) << 8 | (zzctl() & 0xFF) << 16 | (zzctl() & 0xFF) << 24;
  }
  
  public final long zzctj()
    throws IOException
  {
    int i = zzctl();
    int j = zzctl();
    int k = zzctl();
    int m = zzctl();
    int n = zzctl();
    int i1 = zzctl();
    int i2 = zzctl();
    int i3 = zzctl();
    long l = i;
    return (j & 0xFF) << 8 | l & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24 | (n & 0xFF) << 32 | (i1 & 0xFF) << 40 | (i2 & 0xFF) << 48 | (i3 & 0xFF) << 56;
  }
  
  public final void zzjk(int paramInt)
    throws zzeym
  {
    if (zzonl == paramInt) {
      return;
    }
    throw new zzeym("Protocol message end-group tag did not match expected tag.");
  }
  
  public final boolean zzjl(int paramInt)
    throws IOException
  {
    int i = paramInt & 0x7;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i == 5)
              {
                zzcti();
                return true;
              }
              throw new zzeym("Protocol message tag had invalid wire type.");
            }
            return false;
          }
          do
          {
            i = zzcsn();
          } while ((i != 0) && (zzjl(i)));
          zzjk(paramInt >>> 3 << 3 | 0x4);
          return true;
        }
        zzjp(zzctc());
        return true;
      }
      zzctj();
      return true;
    }
    zzctc();
    return true;
  }
  
  public final int zzjn(int paramInt)
    throws zzeym
  {
    if (paramInt >= 0)
    {
      paramInt += zzotj;
      int i = zzonm;
      if (paramInt <= i)
      {
        zzonm = paramInt;
        zzctk();
        return i;
      }
      throw zzeym.zzcwc();
    }
    throw zzeym.zzcwd();
  }
  
  public final void zzjo(int paramInt)
  {
    zzonm = paramInt;
    zzctk();
  }
  
  public final void zzla(int paramInt)
  {
    zzaj(paramInt, zzonl);
  }
}
