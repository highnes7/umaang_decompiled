package com.google.android.android.common.data;

import java.util.ArrayList;

public abstract class Bookshelf<T>
  extends com.google.android.gms.common.data.AbstractDataBuffer<T>
{
  public boolean zzfqy = false;
  public ArrayList<Integer> zzfqz;
  
  public Bookshelf(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  private final void zzaix()
  {
    for (;;)
    {
      int i;
      Object localObject3;
      try
      {
        if (!zzfqy)
        {
          int j = zzflf.zzfqq;
          zzfqz = new ArrayList();
          if (j > 0)
          {
            zzfqz.add(Integer.valueOf(0));
            String str2 = zzaiw();
            i = zzflf.zzbx(0);
            Object localObject1 = zzflf.getData(str2, 0, i);
            i = 1;
            if (i < j)
            {
              int k = zzflf.zzbx(i);
              String str1 = zzflf.getData(str2, i, k);
              if (str1 != null)
              {
                localObject3 = localObject1;
                if (str1.equals(localObject1)) {
                  break label236;
                }
                zzfqz.add(Integer.valueOf(i));
                localObject3 = str1;
                break label236;
              }
              localObject1 = new StringBuilder(String.valueOf(str2).length() + 78);
              ((StringBuilder)localObject1).append("Missing value for markerColumn: ");
              ((StringBuilder)localObject1).append(str2);
              ((StringBuilder)localObject1).append(", at row: ");
              ((StringBuilder)localObject1).append(i);
              ((StringBuilder)localObject1).append(", for window: ");
              ((StringBuilder)localObject1).append(k);
              throw new NullPointerException(((StringBuilder)localObject1).toString());
            }
          }
          zzfqy = true;
        }
        else
        {
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      label236:
      i += 1;
      Object localObject2 = localObject3;
    }
  }
  
  private final int zzca(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < zzfqz.size())) {
      return ((Integer)zzfqz.get(paramInt)).intValue();
    }
    StringBuilder localStringBuilder = new StringBuilder(53);
    localStringBuilder.append("Position ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" is out of bounds for this buffer");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int getCount()
  {
    zzaix();
    return zzfqz.size();
  }
  
  public abstract Object getMessage(int paramInt1, int paramInt2);
  
  public final Object truncate(int paramInt)
  {
    zzaix();
    int k = zzca(paramInt);
    int i;
    if ((paramInt >= 0) && (paramInt != zzfqz.size()))
    {
      if (paramInt == zzfqz.size() - 1) {
        i = zzflf.zzfqq;
      } else {
        i = ((Integer)zzfqz.get(paramInt + 1)).intValue();
      }
      int j = i - ((Integer)zzfqz.get(paramInt)).intValue();
      i = j;
      if (j == 1)
      {
        paramInt = zzca(paramInt);
        zzflf.zzbx(paramInt);
        i = j;
      }
    }
    else
    {
      i = 0;
    }
    return getMessage(k, i);
  }
  
  public abstract String zzaiw();
}
