package com.google.android.android.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzeuw
  extends zzeut
{
  public final byte[] buffer;
  public int buflen;
  public int zzonj;
  public int zzonl;
  public int zzonm = Integer.MAX_VALUE;
  public final InputStream zzonn;
  public int zzono;
  public int zzonp;
  public zzeux zzonq = null;
  
  public zzeuw(InputStream paramInputStream, int paramInt)
  {
    zzevu.add(paramInputStream, "input");
    zzonn = paramInputStream;
    buffer = new byte[paramInt];
    zzono = 0;
    buflen = 0;
    zzonp = 0;
  }
  
  private final long zzcth()
    throws IOException
  {
    int k = buflen;
    int i = zzono;
    if (i != k)
    {
      byte[] arrayOfByte = buffer;
      int j = k + 1;
      k = arrayOfByte[k];
      if (k >= 0)
      {
        buflen = j;
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
        buflen = i;
        return l1;
      }
    }
    label347:
    return zzctd();
  }
  
  private final int zzcti()
    throws IOException
  {
    int j = buflen;
    int i = j;
    if (zzono - j < 4)
    {
      zzjr(4);
      i = buflen;
    }
    byte[] arrayOfByte = buffer;
    buflen = (i + 4);
    j = arrayOfByte[i];
    int k = arrayOfByte[(i + 1)];
    int m = arrayOfByte[(i + 2)];
    return (arrayOfByte[(i + 3)] & 0xFF) << 24 | j & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16;
  }
  
  private final long zzctj()
    throws IOException
  {
    int j = buflen;
    int i = j;
    if (zzono - j < 8)
    {
      zzjr(8);
      i = buflen;
    }
    byte[] arrayOfByte = buffer;
    buflen = (i + 8);
    long l1 = arrayOfByte[i];
    long l2 = arrayOfByte[(i + 1)];
    long l3 = arrayOfByte[(i + 2)];
    long l4 = arrayOfByte[(i + 3)];
    long l5 = arrayOfByte[(i + 4)];
    long l6 = arrayOfByte[(i + 5)];
    long l7 = arrayOfByte[(i + 6)];
    return (arrayOfByte[(i + 7)] & 0xFF) << 56 | l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48;
  }
  
  private final void zzctk()
  {
    zzono += zzonj;
    int j = zzonp;
    int i = zzono;
    j += i;
    int k = zzonm;
    if (j > k)
    {
      zzonj = (j - k);
      zzono = (i - zzonj);
      return;
    }
    zzonj = 0;
  }
  
  private final byte zzctl()
    throws IOException
  {
    if (buflen == zzono) {
      zzjr(1);
    }
    byte[] arrayOfByte = buffer;
    int i = buflen;
    buflen = (i + 1);
    return arrayOfByte[i];
  }
  
  private final void zzjr(int paramInt)
    throws IOException
  {
    if (!zzjs(paramInt))
    {
      if (paramInt > zzonf - zzonp - buflen) {
        throw zzevz.zzcut();
      }
      throw zzevz.zzcum();
    }
  }
  
  private final boolean zzjs(int paramInt)
    throws IOException
  {
    int i;
    do
    {
      i = buflen;
      int j = zzono;
      if (i + paramInt <= j) {
        break label249;
      }
      int k = zzonf;
      int m = zzonp;
      if (paramInt > k - m - i) {
        return false;
      }
      if (m + i + paramInt > zzonm) {
        return false;
      }
      if (i > 0)
      {
        if (j > i)
        {
          localObject = buffer;
          System.arraycopy(localObject, i, localObject, 0, j - i);
        }
        zzonp += i;
        zzono -= i;
        buflen = 0;
      }
      localObject = zzonn;
      byte[] arrayOfByte = buffer;
      i = zzono;
      i = ((InputStream)localObject).read(arrayOfByte, i, Math.min(arrayOfByte.length - i, zzonf - zzonp - i));
      if ((i == 0) || (i < -1) || (i > buffer.length)) {
        break label202;
      }
      if (i <= 0) {
        break;
      }
      zzono += i;
      zzctk();
    } while (zzono < paramInt);
    return true;
    return false;
    label202:
    Object localObject = new StringBuilder(102);
    ((StringBuilder)localObject).append("InputStream#read(byte[]) returned invalid result: ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("\nThe InputStream implementation is buggy.");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
    label249:
    localObject = new StringBuilder(77);
    ((StringBuilder)localObject).append("refillBuffer() called when ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" bytes were already available in buffer");
    localObject = new IllegalStateException(((StringBuilder)localObject).toString());
    throw ((Throwable)localObject);
  }
  
  private final byte[] zzjt(int paramInt)
    throws IOException
  {
    byte[] arrayOfByte1 = zzju(paramInt);
    if (arrayOfByte1 != null) {
      return arrayOfByte1;
    }
    int j = buflen;
    int k = zzono;
    int i = k - j;
    zzonp += k;
    buflen = 0;
    zzono = 0;
    Object localObject = zzjv(paramInt - i);
    arrayOfByte1 = new byte[paramInt];
    System.arraycopy(buffer, j, arrayOfByte1, 0, i);
    localObject = ((List)localObject).iterator();
    paramInt = i;
    while (((Iterator)localObject).hasNext())
    {
      byte[] arrayOfByte2 = (byte[])((Iterator)localObject).next();
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, paramInt, arrayOfByte2.length);
      paramInt += arrayOfByte2.length;
    }
    return arrayOfByte1;
  }
  
  private final byte[] zzju(int paramInt)
    throws IOException
  {
    if (paramInt == 0) {
      return zzevu.EMPTY_BYTE_ARRAY;
    }
    if (paramInt >= 0)
    {
      int i = zzonp;
      int j = buflen;
      int k = i + j + paramInt;
      if (k - zzonf <= 0)
      {
        int m = zzonm;
        if (k <= m)
        {
          i = zzono - j;
          j = paramInt - i;
          if ((j >= 4096) && (j > zzonn.available())) {
            return null;
          }
          localObject = new byte[paramInt];
          System.arraycopy(buffer, buflen, localObject, 0, i);
          zzonp += zzono;
          buflen = 0;
          zzono = 0;
          for (;;)
          {
            if (i >= localObject.length) {
              break label205;
            }
            j = zzonn.read((byte[])localObject, i, paramInt - i);
            if (j == -1) {
              break;
            }
            zzonp += j;
            i += j;
          }
          throw zzevz.zzcum();
        }
        zzjp(m - i - j);
        throw zzevz.zzcum();
      }
      throw zzevz.zzcut();
    }
    Object localObject = zzevz.zzcun();
    throw ((Throwable)localObject);
    label205:
    return localObject;
  }
  
  private final List zzjv(int paramInt)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    while (paramInt > 0)
    {
      byte[] arrayOfByte = new byte[Math.min(paramInt, 4096)];
      int i = 0;
      while (i < arrayOfByte.length)
      {
        int j = zzonn.read(arrayOfByte, i, arrayOfByte.length - i);
        if (j != -1)
        {
          zzonp += j;
          i += j;
        }
        else
        {
          throw zzevz.zzcum();
        }
      }
      paramInt -= arrayOfByte.length;
      localArrayList.add(arrayOfByte);
    }
    return localArrayList;
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
    String str;
    if (i > 0)
    {
      int j = zzono;
      int k = buflen;
      if (i <= j - k)
      {
        str = new String(buffer, k, i, zzevu.UTF_8);
        buflen += i;
        return str;
      }
    }
    if (i == 0) {
      return "";
    }
    if (i <= zzono)
    {
      zzjr(i);
      str = new String(buffer, buflen, i, zzevu.UTF_8);
      buflen += i;
      return str;
    }
    return new String(zzjt(i), zzevu.UTF_8);
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
    int k = zzctc();
    int i = buflen;
    int m = zzono;
    int j = 0;
    byte[] arrayOfByte;
    if ((k <= m - i) && (k > 0))
    {
      arrayOfByte = buffer;
      buflen = (i + k);
    }
    else
    {
      if (k == 0) {
        return "";
      }
      if (k <= zzono)
      {
        zzjr(k);
        arrayOfByte = buffer;
        buflen = k;
        i = j;
      }
      else
      {
        arrayOfByte = zzjt(k);
        i = j;
      }
    }
    if (zzexo.putInt(arrayOfByte, i, i + k)) {
      return new String(arrayOfByte, i, k, zzevu.UTF_8);
    }
    throw zzevz.zzcuu();
  }
  
  public final zzeuk zzcsv()
    throws IOException
  {
    int i = zzctc();
    int j = zzono;
    int k = buflen;
    if ((i <= j - k) && (i > 0))
    {
      localObject1 = zzeuk.putShort(buffer, k, i);
      buflen += i;
      return localObject1;
    }
    if (i == 0) {
      return zzeuk.zzomx;
    }
    Object localObject1 = zzju(i);
    if (localObject1 != null) {
      return zzeuk.zzba((byte[])localObject1);
    }
    j = buflen;
    k = zzono;
    int m = k - j;
    zzonp += k;
    buflen = 0;
    zzono = 0;
    Object localObject2 = zzjv(i - m);
    localObject1 = new ArrayList(((List)localObject2).size() + 1);
    ((List)localObject1).add(zzeuk.putShort(buffer, j, m));
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(zzeuk.zzba((byte[])((Iterator)localObject2).next()));
    }
    return zzeuk.collate((Iterable)localObject1);
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
    int k = buflen;
    int i = zzono;
    if (i != k)
    {
      byte[] arrayOfByte = buffer;
      int j = k + 1;
      k = arrayOfByte[k];
      if (k >= 0)
      {
        buflen = j;
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
                          break label263;
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
        buflen = i;
        return j;
      }
    }
    label263:
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
    return i - (zzonp + buflen);
  }
  
  public final boolean zzctf()
    throws IOException
  {
    return (buflen == zzono) && (!zzjs(1));
  }
  
  public final int zzctg()
  {
    return zzonp + buflen;
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
      if (zzono - buflen >= 10)
      {
        paramInt = i;
        while (paramInt < 10)
        {
          localObject = buffer;
          i = buflen;
          buflen = (i + 1);
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
      paramInt = zzonp + buflen + paramInt;
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
    int i = zzono;
    int j = buflen;
    if ((paramInt <= i - j) && (paramInt >= 0))
    {
      buflen = (j + paramInt);
      return;
    }
    if (paramInt >= 0)
    {
      j = zzonp;
      i = buflen;
      int k = zzonm;
      if (j + i + paramInt <= k)
      {
        j = zzono;
        i = j - i;
        for (buflen = j;; buflen = j)
        {
          zzjr(1);
          k = paramInt - i;
          j = zzono;
          if (k <= j) {
            break;
          }
          i += j;
        }
        buflen = k;
        return;
      }
      zzjp(k - j - i);
      throw zzevz.zzcum();
    }
    zzevz localZzevz = zzevz.zzcun();
    throw localZzevz;
  }
}
