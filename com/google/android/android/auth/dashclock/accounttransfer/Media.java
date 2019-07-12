package com.google.android.android.auth.dashclock.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.internal.zzatt;
import com.google.android.android.internal.zzbcn;
import com.google.android.gms.auth.api.accounttransfer.zzs;
import com.google.android.gms.auth.api.accounttransfer.zzu;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Media
  extends zzatt
{
  public static final Parcelable.Creator<zzs> CREATOR = new DiscreteSeekBar.CustomState.1();
  public static final HashMap<String, com.google.android.gms.internal.zzbdm<?, ?>> zzdzf;
  public String mPackageName;
  public String zzaxp;
  public int zzdxs;
  public Set<Integer> zzdzg;
  public MapPack zzdzq;
  
  static
  {
    HashMap localHashMap = new HashMap();
    zzdzf = localHashMap;
    localHashMap.put("authenticatorInfo", com.google.android.android.internal.zzbdm.get("authenticatorInfo", 2, zzu.class));
    zzdzf.put("signature", com.google.android.android.internal.zzbdm.getValue("signature", 3));
    zzdzf.put("package", com.google.android.android.internal.zzbdm.getValue("package", 4));
  }
  
  public Media()
  {
    zzdzg = new HashSet(3);
    zzdxs = 1;
  }
  
  public Media(Set paramSet, int paramInt, MapPack paramMapPack, String paramString1, String paramString2)
  {
    zzdzg = paramSet;
    zzdxs = paramInt;
    zzdzq = paramMapPack;
    zzaxp = paramString1;
    mPackageName = paramString2;
  }
  
  public final Object get(com.google.android.android.internal.zzbdm paramZzbdm)
  {
    int i = paramZzbdm.zzakq();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            return mPackageName;
          }
          throw new IllegalStateException(StringBuilder.add(37, "Unknown SafeParcelable id=", paramZzbdm.zzakq()));
        }
        return zzaxp;
      }
      return zzdzq;
    }
    return Integer.valueOf(zzdxs);
  }
  
  public final boolean getSize(com.google.android.android.internal.zzbdm paramZzbdm)
  {
    return zzdzg.contains(Integer.valueOf(paramZzbdm.zzakq()));
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    Set localSet = zzdzg;
    if (localSet.contains(Integer.valueOf(1))) {
      zzbcn.setCustomVar(paramParcel, 1, zzdxs);
    }
    if (localSet.contains(Integer.valueOf(2))) {
      zzbcn.addMenuItem(paramParcel, 2, zzdzq, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      zzbcn.append(paramParcel, 3, zzaxp, true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      zzbcn.append(paramParcel, 4, mPackageName, true);
    }
    zzbcn.zzah(paramParcel, i);
  }
}
