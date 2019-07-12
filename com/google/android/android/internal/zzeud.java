package com.google.android.android.internal;

import com.google.android.gms.internal.zzewm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class zzeud<MessageType extends com.google.android.gms.internal.zzeuc<MessageType, BuilderType>, BuilderType extends com.google.android.gms.internal.zzeud<MessageType, BuilderType>>
  implements zzewm
{
  public zzeud() {}
  
  public static void parse(Iterable paramIterable, List paramList)
  {
    Object localObject;
    int i;
    if (((paramList instanceof ArrayList)) && ((paramIterable instanceof Collection)))
    {
      localObject = (ArrayList)paramList;
      i = paramList.size();
      ((ArrayList)localObject).ensureCapacity(((Collection)paramIterable).size() + i);
    }
    int j = paramList.size();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      localObject = paramIterable.next();
      if (localObject == null)
      {
        i = paramList.size();
        paramIterable = new StringBuilder(37);
        paramIterable.append("Element at index ");
        paramIterable.append(i - j);
        paramIterable.append(" is null.");
        paramIterable = paramIterable.toString();
        i = paramList.size() - 1;
        while (i >= j)
        {
          paramList.remove(i);
          i -= 1;
        }
        throw new NullPointerException(paramIterable);
      }
      paramList.add(localObject);
    }
  }
  
  public static void transform(Iterable paramIterable, List paramList)
  {
    zzevu.add(paramIterable);
    if ((paramIterable instanceof zzewg))
    {
      Object localObject = ((zzewg)paramIterable).zzcuw();
      paramIterable = (zzewg)paramList;
      int j = paramList.size();
      paramList = ((List)localObject).iterator();
      while (paramList.hasNext())
      {
        localObject = paramList.next();
        if (localObject == null)
        {
          int i = paramIterable.size();
          paramList = new StringBuilder(37);
          paramList.append("Element at index ");
          paramList.append(i - j);
          paramList.append(" is null.");
          paramList = paramList.toString();
          i = paramIterable.size() - 1;
          while (i >= j)
          {
            paramIterable.remove(i);
            i -= 1;
          }
          throw new NullPointerException(paramList);
        }
        if (!(localObject instanceof zzeuk)) {
          paramIterable.add((String)localObject);
        }
      }
      return;
    }
    if ((paramIterable instanceof zzewq))
    {
      paramList.addAll((Collection)paramIterable);
      return;
    }
    parse(paramIterable, paramList);
  }
  
  public abstract zzeud cast(zzeuc paramZzeuc);
  
  public abstract zzeud setVariable(zzeut paramZzeut, zzevd paramZzevd)
    throws IOException;
  
  public abstract zzeud zzcsb();
}
