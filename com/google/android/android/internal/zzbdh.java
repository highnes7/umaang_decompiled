package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbdn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class zzbdh
  extends zzbck
  implements zzbdn<String, Integer>
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzbdh> CREATOR = new zzbdj();
  public int zzdxs;
  public final HashMap<String, Integer> zzfwl;
  public final SparseArray<String> zzfwm;
  public final ArrayList<com.google.android.gms.internal.zzbdi> zzfwn;
  
  public zzbdh()
  {
    zzdxs = 1;
    zzfwl = new HashMap();
    zzfwm = new SparseArray();
    zzfwn = null;
  }
  
  public zzbdh(int paramInt, ArrayList paramArrayList)
  {
    zzdxs = paramInt;
    zzfwl = new HashMap();
    zzfwm = new SparseArray();
    zzfwn = null;
    loadCatalog(paramArrayList);
  }
  
  private final void loadCatalog(ArrayList paramArrayList)
  {
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayList.get(i);
      i += 1;
      localObject = (zzbdi)localObject;
      setLevel(zzfwo, zzfwp);
    }
  }
  
  public final zzbdh setLevel(String paramString, int paramInt)
  {
    zzfwl.put(paramString, Integer.valueOf(paramInt));
    zzfwm.put(paramInt, paramString);
    return this;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, zzdxs);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = zzfwl.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new zzbdi(str, ((Integer)zzfwl.get(str)).intValue()));
    }
    zzbcn.save(paramParcel, 2, localArrayList, false);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
