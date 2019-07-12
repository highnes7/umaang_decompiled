package com.google.android.android.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public abstract class zzbdo
  extends zzbdl
  implements zzbco
{
  public zzbdo() {}
  
  public final int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!getClass().isInstance(paramObject)) {
      return false;
    }
    paramObject = (zzbdl)paramObject;
    Iterator localIterator = zzzz().values().iterator();
    while (localIterator.hasNext())
    {
      zzbdm localZzbdm = (zzbdm)localIterator.next();
      if (getSize(localZzbdm))
      {
        if (!paramObject.getSize(localZzbdm)) {
          break label105;
        }
        if (!get(localZzbdm).equals(paramObject.get(localZzbdm))) {
          return false;
        }
      }
      else if (paramObject.getSize(localZzbdm))
      {
        return false;
      }
    }
    return true;
    label105:
    return false;
  }
  
  public int hashCode()
  {
    Iterator localIterator = zzzz().values().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      zzbdm localZzbdm = (zzbdm)localIterator.next();
      if (getSize(localZzbdm)) {
        i = get(localZzbdm).hashCode() + i * 31;
      }
    }
    return i;
  }
  
  public Object zzgi(String paramString)
  {
    return null;
  }
  
  public boolean zzgj(String paramString)
  {
    return false;
  }
}
