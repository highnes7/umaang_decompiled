package com.google.android.android.internal;

import java.io.IOException;
import java.util.Arrays;

public final class zzexl
{
  public static final zzexl zzoqy = new zzexl(0, new int[0], new Object[0], false);
  public int count;
  public boolean zzomt;
  public int zzoof = -1;
  public int[] zzoqz;
  public Object[] zzora;
  
  public zzexl()
  {
    this(0, new int[8], new Object[8], true);
  }
  
  public zzexl(int paramInt, int[] paramArrayOfInt, Object[] paramArrayOfObject, boolean paramBoolean)
  {
    count = paramInt;
    zzoqz = paramArrayOfInt;
    zzora = paramArrayOfObject;
    zzomt = paramBoolean;
  }
  
  public static zzexl copyOf(zzexl paramZzexl1, zzexl paramZzexl2)
  {
    int i = count + count;
    int[] arrayOfInt = Arrays.copyOf(zzoqz, i);
    System.arraycopy(zzoqz, 0, arrayOfInt, count, count);
    Object[] arrayOfObject = Arrays.copyOf(zzora, i);
    System.arraycopy(zzora, 0, arrayOfObject, count, count);
    return new zzexl(i, arrayOfInt, arrayOfObject, true);
  }
  
  private void scan(int paramInt, Object paramObject)
  {
    int i = count;
    if (i == zzoqz.length)
    {
      if (i < 4) {
        i = 8;
      } else {
        i >>= 1;
      }
      i = count + i;
      zzoqz = Arrays.copyOf(zzoqz, i);
      zzora = Arrays.copyOf(zzora, i);
    }
    int[] arrayOfInt = zzoqz;
    i = count;
    arrayOfInt[i] = paramInt;
    zzora[i] = paramObject;
    count = (i + 1);
  }
  
  private final zzexl sweep(zzeut paramZzeut)
    throws IOException
  {
    int i;
    do
    {
      i = paramZzeut.zzcsn();
    } while ((i != 0) && (next(i, paramZzeut)));
    return this;
  }
  
  public static zzexl zzcvp()
  {
    return zzoqy;
  }
  
  public static zzexl zzcvq()
  {
    return new zzexl();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof zzexl)) {
      return false;
    }
    paramObject = (zzexl)paramObject;
    int j = count;
    if (j == count)
    {
      Object localObject = zzoqz;
      int[] arrayOfInt = zzoqz;
      int i = 0;
      while (i < j)
      {
        if (localObject[i] != arrayOfInt[i])
        {
          i = 0;
          break label84;
        }
        i += 1;
      }
      i = 1;
      label84:
      if (i != 0)
      {
        localObject = zzora;
        paramObject = zzora;
        j = count;
        i = 0;
        while (i < j)
        {
          if (!localObject[i].equals(paramObject[i]))
          {
            i = 0;
            break label138;
          }
          i += 1;
        }
        i = 1;
        label138:
        return i != 0;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    int i = count;
    int j = Arrays.hashCode(zzoqz);
    return Arrays.deepHashCode(zzora) + (j + (i + 527) * 31) * 31;
  }
  
  public final void index(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = 0;
    while (i < count)
    {
      zzewo.write(paramStringBuilder, paramInt, String.valueOf(zzoqz[i] >>> 3), zzora[i]);
      i += 1;
    }
  }
  
  public final boolean next(int paramInt, zzeut paramZzeut)
    throws IOException
  {
    if (zzomt)
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
                  scan(paramInt, Integer.valueOf(paramZzeut.zzcss()));
                  return true;
                }
                throw zzevz.zzcur();
              }
              return false;
            }
            zzexl localZzexl = new zzexl();
            localZzexl.sweep(paramZzeut);
            paramZzeut.zzjk(paramInt >>> 3 << 3 | 0x4);
            scan(paramInt, localZzexl);
            return true;
          }
          scan(paramInt, paramZzeut.zzcsv());
          return true;
        }
        scan(paramInt, Long.valueOf(paramZzeut.zzcsr()));
        return true;
      }
      scan(paramInt, Long.valueOf(paramZzeut.zzcsp()));
      return true;
    }
    throw new UnsupportedOperationException();
  }
  
  public final void writeTo(zzeuy paramZzeuy)
    throws IOException
  {
    int i = 0;
    while (i < count)
    {
      int k = zzoqz[i];
      int j = k >>> 3;
      k &= 0x7;
      if (k != 0)
      {
        if (k != 1)
        {
          if (k != 2)
          {
            if (k != 3)
            {
              if (k == 5) {
                paramZzeuy.writeInt32(j, ((Integer)zzora[i]).intValue());
              } else {
                throw zzevz.zzcur();
              }
            }
            else
            {
              paramZzeuy.write(j, 3);
              ((zzexl)zzora[i]).writeTo(paramZzeuy);
              paramZzeuy.write(j, 4);
            }
          }
          else {
            paramZzeuy.writeInt32(j, (zzeuk)zzora[i]);
          }
        }
        else {
          paramZzeuy.writeInt64(j, ((Long)zzora[i]).longValue());
        }
      }
      else {
        paramZzeuy.writeLong(j, ((Long)zzora[i]).longValue());
      }
      i += 1;
    }
  }
  
  public final void zzbhs()
  {
    zzomt = false;
  }
  
  public final int zzhi()
  {
    int i = zzoof;
    if (i != -1) {
      return i;
    }
    int j = 0;
    for (int k = 0; j < count; k = i)
    {
      int m = zzoqz[j];
      i = m >>> 3;
      m &= 0x7;
      if (m != 0)
      {
        if (m != 1)
        {
          if (m != 2)
          {
            if (m != 3)
            {
              if (m == 5) {
                i = zzeuy.zzac(i, ((Integer)zzora[j]).intValue());
              } else {
                throw new IllegalStateException(zzevz.zzcur());
              }
            }
            else
            {
              i = zzeuy.zzkb(i);
              i = ((zzexl)zzora[j]).zzhi() + (i << 1) + k;
              break label189;
            }
          }
          else {
            i = zzeuy.getShares(i, (zzeuk)zzora[j]);
          }
        }
        else {
          i = zzeuy.goToRow(i, ((Long)zzora[j]).longValue());
        }
      }
      else {
        i = zzeuy.byteToString(i, ((Long)zzora[j]).longValue());
      }
      i += k;
      label189:
      j += 1;
    }
    zzoof = k;
    return k;
  }
}
