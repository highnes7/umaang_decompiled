package com.google.android.android.internal;

import java.io.IOException;

public final class zzewh<K, V>
{
  public final V value;
  public final K zzlss;
  public final com.google.android.gms.internal.zzewj<K, V> zzopl;
  
  public zzewh(zzexu paramZzexu1, Object paramObject1, zzexu paramZzexu2, Object paramObject2)
  {
    zzopl = new zzewj(paramZzexu1, paramObject1, paramZzexu2, paramObject2);
    zzlss = paramObject1;
    value = paramObject2;
  }
  
  public static Object getIndex(zzeut paramZzeut, zzevd paramZzevd, zzexu paramZzexu, Object paramObject)
    throws IOException
  {
    int i = zzewi.zzood[paramZzexu.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return zzeve.readValue(paramZzeut, paramZzexu, true);
        }
        throw new RuntimeException("Groups are not allowed in maps.");
      }
      return Integer.valueOf(paramZzeut.zzcsx());
    }
    paramZzexu = ((zzewl)paramObject).zzcub();
    paramZzeut.blur(paramZzexu, paramZzevd);
    return paramZzexu.zzcug();
  }
  
  public static zzewh linearCombination(zzexu paramZzexu1, Object paramObject1, zzexu paramZzexu2, Object paramObject2)
  {
    return new zzewh(paramZzexu1, paramObject1, paramZzexu2, paramObject2);
  }
  
  public static int write(zzewj paramZzewj, Object paramObject1, Object paramObject2)
  {
    int i = zzeve.writeField(zzopm, 1, paramObject1);
    return zzeve.writeField(zzopo, 2, paramObject2) + i;
  }
  
  public final int propertyChanged(int paramInt, Object paramObject1, Object paramObject2)
  {
    paramInt = zzeuy.zzkb(paramInt);
    return zzeuy.zzki(write(zzopl, paramObject1, paramObject2)) + paramInt;
  }
  
  public final void subtract(zzewk paramZzewk, zzeut paramZzeut, zzevd paramZzevd)
    throws IOException
  {
    int i = paramZzeut.zzjn(paramZzeut.zzctc());
    Object localObject1 = zzopl;
    Object localObject2 = zzopn;
    localObject1 = zzopp;
    int j;
    do
    {
      for (;;)
      {
        j = paramZzeut.zzcsn();
        if (j == 0) {
          break label124;
        }
        if (j == (zzopl.zzopm.zzcvy() | 0x8))
        {
          localObject2 = getIndex(paramZzeut, paramZzevd, zzopl.zzopm, localObject2);
        }
        else
        {
          if (j != (zzopl.zzopo.zzcvy() | 0x10)) {
            break;
          }
          localObject1 = getIndex(paramZzeut, paramZzevd, zzopl.zzopo, localObject1);
        }
      }
    } while (paramZzeut.zzjl(j));
    label124:
    paramZzeut.zzjk(0);
    paramZzeut.zzjo(i);
    paramZzewk.put(localObject2, localObject1);
  }
  
  public final void writeField(zzeuy paramZzeuy, int paramInt, Object paramObject1, Object paramObject2)
    throws IOException
  {
    paramZzeuy.write(paramInt, 2);
    paramZzeuy.zzjy(write(zzopl, paramObject1, paramObject2));
    zzewj localZzewj = zzopl;
    zzeve.writeField(paramZzeuy, zzopm, 1, paramObject1);
    zzeve.writeField(paramZzeuy, zzopo, 2, paramObject2);
  }
}
