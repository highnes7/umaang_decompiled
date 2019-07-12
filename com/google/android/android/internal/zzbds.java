package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzbds
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzbds> CREATOR = new zzbdv();
  public final String className;
  public int versionCode;
  public ArrayList<com.google.android.gms.internal.zzbdt> zzfxd;
  
  public zzbds(int paramInt, String paramString, ArrayList paramArrayList)
  {
    versionCode = paramInt;
    className = paramString;
    zzfxd = paramArrayList;
  }
  
  public zzbds(String paramString, Map paramMap)
  {
    versionCode = 1;
    className = paramString;
    if (paramMap == null)
    {
      paramString = null;
    }
    else
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramMap.keySet().iterator();
      for (;;)
      {
        paramString = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        paramString = (String)localIterator.next();
        localArrayList.add(new zzbdt(paramString, (zzbdm)paramMap.get(paramString)));
      }
    }
    zzfxd = paramString;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, versionCode);
    zzbcn.append(paramParcel, 2, className, false);
    zzbcn.save(paramParcel, 3, zzfxd, false);
    zzbcn.zzah(paramParcel, paramInt);
  }
  
  public final HashMap zzakw()
  {
    HashMap localHashMap = new HashMap();
    int j = zzfxd.size();
    int i = 0;
    while (i < j)
    {
      zzbdt localZzbdt = (zzbdt)zzfxd.get(i);
      localHashMap.put(userId, zzfxe);
      i += 1;
    }
    return localHashMap;
  }
}
