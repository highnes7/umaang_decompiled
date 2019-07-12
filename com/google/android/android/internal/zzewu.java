package com.google.android.android.internal;

import java.util.Arrays;
import java.util.Stack;

public final class zzewu
{
  public final Stack<com.google.android.gms.internal.zzeuk> zzopz = new Stack();
  
  public zzewu() {}
  
  private final zzeuk getPath(zzeuk paramZzeuk1, zzeuk paramZzeuk2)
  {
    zzao(paramZzeuk1);
    zzao(paramZzeuk2);
    for (paramZzeuk1 = (zzeuk)zzopz.pop(); !zzopz.isEmpty(); paramZzeuk1 = new zzews((zzeuk)zzopz.pop(), paramZzeuk1)) {}
    return paramZzeuk1;
  }
  
  private final void zzao(zzeuk paramZzeuk)
  {
    for (;;)
    {
      if (paramZzeuk.zzcsi())
      {
        int i = zzkt(paramZzeuk.size());
        int j = zzews.zzopt[(i + 1)];
        if ((!zzopz.isEmpty()) && (((zzeuk)zzopz.peek()).size() < j))
        {
          i = zzews.zzopt[i];
          for (localObject = (zzeuk)zzopz.pop(); (!zzopz.isEmpty()) && (((zzeuk)zzopz.peek()).size() < i); localObject = new zzews((zzeuk)zzopz.pop(), (zzeuk)localObject)) {}
          for (paramZzeuk = new zzews((zzeuk)localObject, paramZzeuk); !zzopz.isEmpty(); paramZzeuk = new zzews((zzeuk)zzopz.pop(), paramZzeuk))
          {
            i = zzkt(paramZzeuk.size());
            i = zzews.zzopt[(i + 1)];
            if (((zzeuk)zzopz.peek()).size() >= i) {
              break;
            }
          }
          zzopz.push(paramZzeuk);
          return;
        }
        zzopz.push(paramZzeuk);
        return;
      }
      if (!(paramZzeuk instanceof zzews)) {
        break;
      }
      paramZzeuk = (zzews)paramZzeuk;
      zzao(zzews.getSide(paramZzeuk));
      paramZzeuk = zzews.take(paramZzeuk);
    }
    paramZzeuk = String.valueOf(paramZzeuk.getClass());
    Object localObject = new StringBuilder(paramZzeuk.length() + 49);
    ((StringBuilder)localObject).append("Has a new type of ByteString been created? Found ");
    ((StringBuilder)localObject).append(paramZzeuk);
    paramZzeuk = new IllegalArgumentException(((StringBuilder)localObject).toString());
    throw paramZzeuk;
  }
  
  public static int zzkt(int paramInt)
  {
    int i = Arrays.binarySearch(zzews.zzopt, paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -(i + 1) - 1;
    }
    return paramInt;
  }
}
