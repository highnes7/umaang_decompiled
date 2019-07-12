package com.google.android.android.internal;

import java.util.AbstractMap.SimpleEntry;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Stack;

public final class zzdow<K, V>
  implements Iterator<Map.Entry<K, V>>
{
  public final Stack<com.google.android.gms.internal.zzdpf<K, V>> zzlsk = new Stack();
  public final boolean zzlsl;
  
  public zzdow(zzdpb paramZzdpb, Object paramObject, Comparator paramComparator, boolean paramBoolean)
  {
    zzlsl = paramBoolean;
    while (!paramZzdpb.isEmpty())
    {
      int i;
      if (paramObject != null)
      {
        if (paramBoolean) {
          i = paramComparator.compare(paramObject, paramZzdpb.getKey());
        } else {
          i = paramComparator.compare(paramZzdpb.getKey(), paramObject);
        }
      }
      else {
        i = 1;
      }
      if (i < 0)
      {
        if (paramBoolean) {}
      }
      else {
        do
        {
          paramZzdpb = paramZzdpb.zzbqn();
          break;
          if (i == 0)
          {
            zzlsk.push((zzdpf)paramZzdpb);
            return;
          }
          zzlsk.push((zzdpf)paramZzdpb);
        } while (paramBoolean);
      }
      paramZzdpb = paramZzdpb.zzbqm();
    }
  }
  
  private final Map.Entry next()
  {
    Object localObject = zzlsk;
    AbstractMap.SimpleEntry localSimpleEntry;
    try
    {
      localObject = ((Stack)localObject).pop();
      localObject = (zzdpf)localObject;
      localSimpleEntry = new AbstractMap.SimpleEntry(((zzdpf)localObject).getKey(), ((zzdpf)localObject).getValue());
      boolean bool;
      Stack localStack;
      zzdpf localZzdpf;
      if (zzlsl) {
        for (localObject = ((zzdpf)localObject).zzbqm();; localObject = ((zzdpb)localObject).zzbqn())
        {
          bool = ((zzdpb)localObject).isEmpty();
          if (bool) {
            break;
          }
          localStack = zzlsk;
          localZzdpf = (zzdpf)localObject;
          localStack.push(localZzdpf);
        }
      }
      for (localObject = ((zzdpf)localObject).zzbqn();; localObject = ((zzdpb)localObject).zzbqm())
      {
        bool = ((zzdpb)localObject).isEmpty();
        if (bool) {
          break;
        }
        localStack = zzlsk;
        localZzdpf = (zzdpf)localObject;
        localStack.push(localZzdpf);
      }
      return localSimpleEntry;
    }
    catch (EmptyStackException localEmptyStackException)
    {
      for (;;) {}
    }
    localObject = new NoSuchElementException();
    throw ((Throwable)localObject);
    return localSimpleEntry;
  }
  
  public final boolean hasNext()
  {
    return zzlsk.size() > 0;
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException("remove called on immutable collection");
  }
}
