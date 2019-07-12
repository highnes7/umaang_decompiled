package com.google.android.android.internal;

import java.io.IOException;
import java.util.Arrays;

public final class zzeuv
  extends zzeut
{
  public final byte[] buffer;
  public int limit;
  public int pointer;
  public final boolean zzoni;
  public int zzonj;
  public int zzonk;
  public int zzonl;
  public int zzonm = Integer.MAX_VALUE;
  
  public zzeuv(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    buffer = paramArrayOfByte;
    limit = (paramInt2 + paramInt1);
    pointer = paramInt1;
    zzonk = pointer;
    zzoni = paramBoolean;
  }
  
  private final long zzcth()
    throws IOException
  {
    int k = pointer;
    int i = limit;
    if (i != k)
    {
      byte[] arrayOfByte = buffer;
      int j = k + 1;
      k = arrayOfByte[k];
      if (k >= 0)
      {
        pointer = j;
        return k;
      }
      if (i - j >= 9)
      {
        i = j + 1;
        k ^= arrayOfByte[j] << 7;
        if (k < 0) {
          j = k ^ 0xFFFFFF80;
        }
        for (;;)
        {
          l1 = j;
          break label339;
          j = i + 1;
          k ^= arrayOfByte[i] << 14;
          if (k >= 0)
          {
            l1 = k ^ 0x3F80;
            i = j;
            break label339;
          }
          i = j + 1;
          j = k ^ arrayOfByte[j] << 21;
          if (j >= 0) {
            break;
          }
          j ^= 0xFFE03F80;
        }
        long l1 = j;
        j = i + 1;
        l1 ^= arrayOfByte[i] << 28;
        long l2;
        if (l1 >= 0L)
        {
          l2 = 266354560L;
          i = j;
          l1 = l2 ^ l1;
        }
        for (;;)
        {
          break label339;
          i = j + 1;
          l1 ^= arrayOfByte[j] << 35;
          if (l1 < 0L) {}
          for (l2 = -34093383808L;; l2 = -558586000294016L)
          {
            l1 ^= l2;
            break label339;
            j = i + 1;
            l1 ^= arrayOfByte[i] << 42;
            if (l1 >= 0L)
            {
              l2 = 4363953127296L;
              i = j;
              break;
            }
            i = j + 1;
            l1 ^= arrayOfByte[j] << 49;
            if (l1 >= 0L) {
              break label287;
            }
          }
          label287:
          j = i + 1;
          l2 = l1 ^ arrayOfByte[i] << 56 ^ 0xFE03F80FE03F80;
          i = j;
          l1 = l2;
          if (l2 < 0L)
          {
            i = j + 1;
            if (arrayOfByte[j] < 0L) {
              break label347;
            }
            l1 = l2;
          }
        }
        label339:
        pointer = i;
        return l1;
      }
    }
    label347:
    return zzctd();
  }
  
  private final int zzcti()
    throws IOException
  {
    int i = pointer;
    if (limit - i >= 4)
    {
      byte[] arrayOfByte = buffer;
      pointer = (i + 4);
      int j = arrayOfByte[i];
      int k = arrayOfByte[(i + 1)];
      int m = arrayOfByte[(i + 2)];
      return (arrayOfByte[(i + 3)] & 0xFF) << 24 | j & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16;
    }
    throw zzevz.zzcum();
  }
  
  private final long zzctj()
    throws IOException
  {
    int i = pointer;
    if (limit - i >= 8)
    {
      byte[] arrayOfByte = buffer;
      pointer = (i + 8);
      long l1 = arrayOfByte[i];
      long l2 = arrayOfByte[(i + 1)];
      long l3 = arrayOfByte[(i + 2)];
      long l4 = arrayOfByte[(i + 3)];
      long l5 = arrayOfByte[(i + 4)];
      long l6 = arrayOfByte[(i + 5)];
      long l7 = arrayOfByte[(i + 6)];
      return (arrayOfByte[(i + 7)] & 0xFF) << 56 | l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48;
    }
    throw zzevz.zzcum();
  }
  
  private final void zzctk()
  {
    limit += zzonj;
    int i = limit;
    int j = i - zzonk;
    int k = zzonm;
    if (j > k)
    {
      zzonj = (j - k);
      limit = (i - zzonj);
      return;
    }
    zzonj = 0;
  }
  
  private final byte zzctl()
    throws IOException
  {
    int i = pointer;
    if (i != limit)
    {
      byte[] arrayOfByte = buffer;
      pointer = (i + 1);
      return arrayOfByte[i];
    }
    throw zzevz.zzcum();
  }
  
  public final void blur(zzewm paramZzewm, zzevd paramZzevd)
    throws IOException
  {
    int i = zzctc();
    if (zzond < zzone)
    {
      i = zzjn(i);
      zzond += 1;
      paramZzewm.with(this, paramZzevd);
      zzjk(0);
      zzond -= 1;
      zzjo(i);
      return;
    }
    throw zzevz.zzcus();
  }
  
  public final zzevh items(zzevh paramZzevh, zzevd paramZzevd)
    throws IOException
  {
    int i = zzctc();
    if (zzond < zzone)
    {
      i = zzjn(i);
      zzond += 1;
      paramZzevh = zzevh.clearNotification(paramZzevh, this, paramZzevd);
      zzjk(0);
      zzond -= 1;
      zzjo(i);
      return paramZzevh;
    }
    throw zzevz.zzcus();
  }
  
  public final double readDouble()
    throws IOException
  {
    return Double.longBitsToDouble(zzctj());
  }
  
  public final float readFloat()
    throws IOException
  {
    return Float.intBitsToFloat(zzcti());
  }
  
  public final String readString()
    throws IOException
  {
    int i = zzctc();
    if (i > 0)
    {
      int j = limit;
      int k = pointer;
      if (i <= j - k)
      {
        String str = new String(buffer, k, i, zzevu.UTF_8);
        pointer += i;
        return str;
      }
    }
    if (i == 0) {
      return "";
    }
    if (i < 0) {
      throw zzevz.zzcun();
    }
    throw zzevz.zzcum();
  }
  
  public final int zzcsn()
    throws IOException
  {
    if (zzctf())
    {
      zzonl = 0;
      return 0;
    }
    zzonl = zzctc();
    int i = zzonl;
    if (i >>> 3 != 0) {
      return i;
    }
    throw zzevz.zzcup();
  }
  
  public final long zzcso()
    throws IOException
  {
    return zzcth();
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
  
  public final long zzcsr()
    throws IOException
  {
    return zzctj();
  }
  
  public final int zzcss()
    throws IOException
  {
    return zzcti();
  }
  
  public final boolean zzcst()
    throws IOException
  {
    return zzcth() != 0L;
  }
  
  public final String zzcsu()
    throws IOException
  {
    int i = zzctc();
    if (i > 0)
    {
      int j = limit;
      int k = pointer;
      if (i <= j - k)
      {
        if (zzexo.putInt(buffer, k, k + i))
        {
          j = pointer;
          pointer = (j + i);
          return new String(buffer, j, i, zzevu.UTF_8);
        }
        throw zzevz.zzcuu();
      }
    }
    if (i == 0) {
      return "";
    }
    if (i <= 0) {
      throw zzevz.zzcun();
    }
    throw zzevz.zzcum();
  }
  
  public final zzeuk zzcsv()
    throws IOException
  {
    int i = zzctc();
    int j;
    int k;
    Object localObject;
    if (i > 0)
    {
      j = limit;
      k = pointer;
      if (i <= j - k)
      {
        localObject = zzeuk.putShort(buffer, k, i);
        pointer += i;
        return localObject;
      }
    }
    if (i == 0) {
      return zzeuk.zzomx;
    }
    if (i > 0)
    {
      j = limit;
      k = pointer;
      if (i <= j - k)
      {
        pointer = (i + k);
        localObject = Arrays.copyOfRange(buffer, k, pointer);
        break label116;
      }
    }
    if (i <= 0)
    {
      if (i == 0)
      {
        localObject = zzevu.EMPTY_BYTE_ARRAY;
        label116:
        return zzeuk.zzba((byte[])localObject);
      }
      throw zzevz.zzcun();
    }
    throw zzevz.zzcum();
  }
  
  public final int zzcsw()
    throws IOException
  {
    return zzctc();
  }
  
  public final int zzcsx()
    throws IOException
  {
    return zzctc();
  }
  
  public final int zzcsy()
    throws IOException
  {
    return zzcti();
  }
  
  public final long zzcsz()
    throws IOException
  {
    return zzctj();
  }
  
  public final int zzcta()
    throws IOException
  {
    return zzeut.zzjq(zzctc());
  }
  
  public final long zzctb()
    throws IOException
  {
    return zzeut.zzcq(zzcth());
  }
  
  public final int zzctc()
    throws IOException
  {
    int k = pointer;
    int i = limit;
    if (i != k)
    {
      byte[] arrayOfByte = buffer;
      int j = k + 1;
      k = arrayOfByte[k];
      if (k >= 0)
      {
        pointer = j;
        return k;
      }
      if (i - j >= 9)
      {
        i = j + 1;
        k ^= arrayOfByte[j] << 7;
        if (k < 0)
        {
          j = k ^ 0xFFFFFF80;
        }
        else
        {
          j = i + 1;
          k ^= arrayOfByte[i] << 14;
          if (k >= 0)
          {
            k ^= 0x3F80;
            i = j;
            j = k;
          }
          for (;;)
          {
            break;
            i = j + 1;
            j = k ^ arrayOfByte[j] << 21;
            if (j < 0)
            {
              j ^= 0xFFE03F80;
            }
            else
            {
              int m = i + 1;
              int n = arrayOfByte[i];
              k = j ^ n << 28 ^ 0xFE03F80;
              j = k;
              i = m;
              if (n < 0)
              {
                n = m + 1;
                i = n;
                j = k;
                if (arrayOfByte[m] < 0)
                {
                  m = n + 1;
                  j = k;
                  i = m;
                  if (arrayOfByte[n] < 0)
                  {
                    n = m + 1;
                    i = n;
                    j = k;
                    if (arrayOfByte[m] < 0)
                    {
                      m = n + 1;
                      j = k;
                      i = m;
                      if (arrayOfByte[n] < 0)
                      {
                        i = m + 1;
                        if (arrayOfByte[m] < 0) {
                          break label262;
                        }
                        j = k;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        pointer = i;
        return j;
      }
    }
    label262:
    return (int)zzctd();
  }
  
  public final long zzctd()
    throws IOException
  {
    long l = 0L;
    int i = 0;
    while (i < 64)
    {
      int j = zzctl();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    zzevz localZzevz = zzevz.zzcuo();
    throw localZzevz;
  }
  
  public final int zzcte()
  {
    int i = zzonm;
    if (i == Integer.MAX_VALUE) {
      return -1;
    }
    return i - zzctg();
  }
  
  public final boolean zzctf()
    throws IOException
  {
    return pointer == limit;
  }
  
  public final int zzctg()
  {
    return pointer - zzonk;
  }
  
  public final void zzjk(int paramInt)
    throws zzevz
  {
    if (zzonl == paramInt) {
      return;
    }
    throw zzevz.zzcuq();
  }
  
  public final boolean zzjl(int paramInt)
    throws IOException
  {
    int k = paramInt & 0x7;
    int j = 0;
    int i = 0;
    if (k != 0)
    {
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 3)
          {
            if (k != 4)
            {
              if (k == 5)
              {
                zzjp(4);
                return true;
              }
              throw zzevz.zzcur();
            }
          }
          else
          {
            do
            {
              i = zzcsn();
            } while ((i != 0) && (zzjl(i)));
            zzjk(paramInt >>> 3 << 3 | 0x4);
            return true;
          }
        }
        else
        {
          zzjp(zzctc());
          return true;
        }
      }
      else
      {
        zzjp(8);
        return true;
      }
    }
    else
    {
      paramInt = j;
      if (limit - pointer >= 10)
      {
        paramInt = i;
        while (paramInt < 10)
        {
          localObject = buffer;
          i = pointer;
          pointer = (i + 1);
          if (localObject[i] >= 0) {
            break label184;
          }
          paramInt += 1;
        }
        throw zzevz.zzcuo();
      }
      while (paramInt < 10)
      {
        if (zzctl() >= 0) {
          break label199;
        }
        paramInt += 1;
      }
      label184:
      return true;
      Object localObject = zzevz.zzcuo();
      throw ((Throwable)localObject);
    }
    return false;
    label199:
    return true;
  }
  
  public final int zzjn(int paramInt)
    throws zzevz
  {
    if (paramInt >= 0)
    {
      paramInt = zzctg() + paramInt;
      int i = zzonm;
      if (paramInt <= i)
      {
        zzonm = paramInt;
        zzctk();
        return i;
      }
      throw zzevz.zzcum();
    }
    throw zzevz.zzcun();
  }
  
  public final void zzjo(int paramInt)
  {
    zzonm = paramInt;
    zzctk();
  }
  
  public final void zzjp(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      int i = limit;
      int j = pointer;
      if (paramInt <= i - j)
      {
        pointer = (j + paramInt);
        return;
      }
    }
    if (paramInt < 0) {
      throw zzevz.zzcun();
    }
    throw zzevz.zzcum();
  }
}
