package com.google.android.android.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class zzeyk
  implements Cloneable
{
  public Object value;
  public com.google.android.gms.internal.zzeyi<?, ?> zzotr;
  public List<com.google.android.gms.internal.zzeyp> zzots = new ArrayList();
  
  public zzeyk() {}
  
  private final byte[] toByteArray()
    throws IOException
  {
    byte[] arrayOfByte = new byte[indexOf()];
    get(zzeyf.toString(arrayOfByte, 0, arrayOfByte.length));
    return arrayOfByte;
  }
  
  private zzeyk zzcwb()
  {
    zzeyk localZzeyk = new zzeyk();
    zzotr = zzotr;
    Object localObject1;
    Object localObject2;
    if (zzots == null)
    {
      zzots = null;
    }
    else
    {
      localObject1 = zzots;
      localObject2 = zzots;
    }
    try
    {
      ((List)localObject1).addAll((Collection)localObject2);
      if (value != null)
      {
        if ((value instanceof zzeyn))
        {
          localObject1 = (zzeyn)value;
          localObject1 = ((zzeyn)localObject1).clone();
          localObject1 = (zzeyn)localObject1;
        }
        int j;
        int i;
        Object localObject3;
        for (;;)
        {
          value = localObject1;
          return localZzeyk;
          if ((value instanceof byte[]))
          {
            localObject1 = (byte[])value;
            localObject1 = localObject1.clone();
          }
          else
          {
            boolean bool = value instanceof byte[][];
            j = 0;
            i = 0;
            if (bool)
            {
              localObject1 = (byte[][])value;
              localObject2 = new byte[localObject1.length][];
              value = localObject2;
              while (i < localObject1.length)
              {
                localObject3 = localObject1[i];
                localObject3 = localObject3.clone();
                localObject2[i] = ((byte[])localObject3);
                i += 1;
              }
            }
            if ((value instanceof boolean[]))
            {
              localObject1 = (boolean[])value;
              localObject1 = localObject1.clone();
            }
            else if ((value instanceof int[]))
            {
              localObject1 = (int[])value;
              localObject1 = localObject1.clone();
            }
            else if ((value instanceof long[]))
            {
              localObject1 = (long[])value;
              localObject1 = localObject1.clone();
            }
            else if ((value instanceof float[]))
            {
              localObject1 = (float[])value;
              localObject1 = localObject1.clone();
            }
            else
            {
              if (!(value instanceof double[])) {
                break;
              }
              localObject1 = (double[])value;
              localObject1 = localObject1.clone();
            }
          }
        }
        if ((value instanceof zzeyn[]))
        {
          localObject1 = (zzeyn[])value;
          localObject2 = new zzeyn[localObject1.length];
          value = localObject2;
          i = j;
          while (i < localObject1.length)
          {
            localObject3 = localObject1[i];
            localObject3 = localObject3.clone();
            localObject2[i] = ((zzeyn)localObject3);
            i += 1;
          }
        }
      }
      else
      {
        return localZzeyk;
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      AssertionError localAssertionError = new AssertionError(localCloneNotSupportedException);
      throw localAssertionError;
    }
    return localZzeyk;
  }
  
  public final Object addElement(zzeyi paramZzeyi)
  {
    if (value != null)
    {
      if (!zzotr.equals(paramZzeyi)) {
        throw new IllegalStateException("Tried to getExtension with a different Extension.");
      }
    }
    else
    {
      zzotr = paramZzeyi;
      value = paramZzeyi.zzbn(zzots);
      zzots = null;
    }
    return value;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzeyk)) {
      return false;
    }
    paramObject = (zzeyk)paramObject;
    if ((value != null) && (value != null))
    {
      localObject = zzotr;
      if (localObject != zzotr) {
        return false;
      }
      if (!zzmlw.isArray()) {
        return value.equals(value);
      }
      localObject = value;
      if ((localObject instanceof byte[])) {
        return Arrays.equals((byte[])localObject, (byte[])value);
      }
      if ((localObject instanceof int[])) {
        return Arrays.equals((int[])localObject, (int[])value);
      }
      if ((localObject instanceof long[])) {
        return Arrays.equals((long[])localObject, (long[])value);
      }
      if ((localObject instanceof float[])) {
        return Arrays.equals((float[])localObject, (float[])value);
      }
      if ((localObject instanceof double[])) {
        return Arrays.equals((double[])localObject, (double[])value);
      }
      if ((localObject instanceof boolean[])) {
        return Arrays.equals((boolean[])localObject, (boolean[])value);
      }
      return Arrays.deepEquals((Object[])localObject, (Object[])value);
    }
    Object localObject = zzots;
    if (localObject != null)
    {
      List localList = zzots;
      if (localList != null) {
        return ((List)localObject).equals(localList);
      }
    }
    try
    {
      boolean bool = Arrays.equals(toByteArray(), paramObject.toByteArray());
      return bool;
    }
    catch (IOException paramObject)
    {
      throw new IllegalStateException(paramObject);
    }
  }
  
  public final void flush(zzeyp paramZzeyp)
  {
    zzots.add(paramZzeyp);
  }
  
  public final void get(zzeyf paramZzeyf)
    throws IOException
  {
    Object localObject1 = value;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = zzotr;
      if (zzotm)
      {
        int j = Array.getLength(localObject1);
        int i = 0;
        while (i < j)
        {
          Object localObject3 = Array.get(localObject1, i);
          if (localObject3 != null) {
            ((zzeyi)localObject2).init(localObject3, paramZzeyf);
          }
          i += 1;
        }
        return;
      }
      ((zzeyi)localObject2).init(localObject1, paramZzeyf);
      return;
    }
    localObject1 = zzots.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (zzeyp)((Iterator)localObject1).next();
      paramZzeyf.zzlc(offset);
      paramZzeyf.zzbh(bytes);
    }
  }
  
  public final int hashCode()
  {
    try
    {
      int i = Arrays.hashCode(toByteArray());
      return i + 527;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
  }
  
  public final int indexOf()
  {
    Object localObject1 = value;
    int i = 0;
    Object localObject2;
    int j;
    if (localObject1 != null)
    {
      localObject2 = zzotr;
      if (zzotm)
      {
        int m = Array.getLength(localObject1);
        int k;
        for (j = 0; i < m; j = k)
        {
          k = j;
          if (Array.get(localObject1, i) != null) {
            k = ((zzeyi)localObject2).zzcg(Array.get(localObject1, i)) + j;
          }
          i += 1;
        }
      }
      return ((zzeyi)localObject2).zzcg(localObject1);
    }
    localObject1 = zzots.iterator();
    i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (zzeyp)((Iterator)localObject1).next();
      i += zzeyf.zzld(offset) + 0 + bytes.length;
    }
    return j;
    return i;
  }
}
