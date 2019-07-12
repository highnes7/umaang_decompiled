package com.google.android.android.auth.dashclock.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.internal.zzatt;
import com.google.android.android.internal.zzbcn;
import com.google.android.gms.auth.api.accounttransfer.zzm;
import com.google.android.gms.auth.api.accounttransfer.zzp;
import com.google.android.gms.auth.api.accounttransfer.zzs;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class Profile
  extends zzatt
{
  public static final Parcelable.Creator<zzm> CREATOR = new Server.1();
  public static final HashMap<String, com.google.android.gms.internal.zzbdm<?, ?>> zzdzf;
  public int zzdxs;
  public Set<Integer> zzdzg;
  public ArrayList<zzs> zzdzh;
  public int zzdzi;
  public MapFile zzdzj;
  
  static
  {
    HashMap localHashMap = new HashMap();
    zzdzf = localHashMap;
    localHashMap.put("authenticatorData", com.google.android.android.internal.zzbdm.selectStatement("authenticatorData", 2, zzs.class));
    zzdzf.put("progress", com.google.android.android.internal.zzbdm.get("progress", 4, zzp.class));
  }
  
  public Profile()
  {
    zzdzg = new HashSet(1);
    zzdxs = 1;
  }
  
  public Profile(Set paramSet, int paramInt1, ArrayList paramArrayList, int paramInt2, MapFile paramMapFile)
  {
    zzdzg = paramSet;
    zzdxs = paramInt1;
    zzdzh = paramArrayList;
    zzdzi = paramInt2;
    zzdzj = paramMapFile;
  }
  
  public final Object get(com.google.android.android.internal.zzbdm paramZzbdm)
  {
    int i = paramZzbdm.zzakq();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 4) {
          return zzdzj;
        }
        throw new IllegalStateException(StringBuilder.add(37, "Unknown SafeParcelable id=", paramZzbdm.zzakq()));
      }
      return zzdzh;
    }
    return Integer.valueOf(zzdxs);
  }
  
  public final boolean getSize(com.google.android.android.internal.zzbdm paramZzbdm)
  {
    return zzdzg.contains(Integer.valueOf(paramZzbdm.zzakq()));
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    Set localSet = zzdzg;
    if (localSet.contains(Integer.valueOf(1))) {
      zzbcn.setCustomVar(paramParcel, 1, zzdxs);
    }
    if (localSet.contains(Integer.valueOf(2))) {
      zzbcn.save(paramParcel, 2, zzdzh, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      zzbcn.setCustomVar(paramParcel, 3, zzdzi);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      zzbcn.addMenuItem(paramParcel, 4, zzdzj, paramInt, true);
    }
    zzbcn.zzah(paramParcel, i);
  }
}
