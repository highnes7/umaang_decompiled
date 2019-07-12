package com.google.android.android.auth.dashclock.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import b.b.x.n.b;
import com.google.android.android.internal.zzatt;
import com.google.android.android.internal.zzbcn;
import com.google.android.gms.auth.api.accounttransfer.zzp;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.List;
import java.util.Map;
import support.android.v4.util.ArrayMap;
import support.android.v4.util.SimpleArrayMap;

public class MapFile
  extends zzatt
{
  public static final Parcelable.Creator<zzp> CREATOR = new VerticalProgressBar.SavedState.1();
  public static final b<String, com.google.android.gms.internal.zzbdm<?, ?>> zzdzk;
  public int zzdxs;
  public List<String> zzdzl;
  public List<String> zzdzm;
  public List<String> zzdzn;
  public List<String> zzdzo;
  public List<String> zzdzp;
  
  static
  {
    ArrayMap localArrayMap = new ArrayMap();
    zzdzk = localArrayMap;
    localArrayMap.put("registered", com.google.android.android.internal.zzbdm.get("registered", 2));
    zzdzk.put("in_progress", com.google.android.android.internal.zzbdm.get("in_progress", 3));
    zzdzk.put("success", com.google.android.android.internal.zzbdm.get("success", 4));
    zzdzk.put("failed", com.google.android.android.internal.zzbdm.get("failed", 5));
    zzdzk.put("escrowed", com.google.android.android.internal.zzbdm.get("escrowed", 6));
  }
  
  public MapFile()
  {
    zzdxs = 1;
  }
  
  public MapFile(int paramInt, List paramList1, List paramList2, List paramList3, List paramList4, List paramList5)
  {
    zzdxs = paramInt;
    zzdzl = paramList1;
    zzdzm = paramList2;
    zzdzn = paramList3;
    zzdzo = paramList4;
    zzdzp = paramList5;
  }
  
  public final Object get(com.google.android.android.internal.zzbdm paramZzbdm)
  {
    switch (paramZzbdm.zzakq())
    {
    default: 
      throw new IllegalStateException(StringBuilder.add(37, "Unknown SafeParcelable id=", paramZzbdm.zzakq()));
    case 6: 
      return zzdzp;
    case 5: 
      return zzdzo;
    case 4: 
      return zzdzn;
    case 3: 
      return zzdzm;
    case 2: 
      return zzdzl;
    }
    return Integer.valueOf(zzdxs);
  }
  
  public final boolean getSize(com.google.android.android.internal.zzbdm paramZzbdm)
  {
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, zzdxs);
    zzbcn.readString(paramParcel, 2, zzdzl, false);
    zzbcn.readString(paramParcel, 3, zzdzm, false);
    zzbcn.readString(paramParcel, 4, zzdzn, false);
    zzbcn.readString(paramParcel, 5, zzdzo, false);
    zzbcn.readString(paramParcel, 6, zzdzp, false);
    zzbcn.zzah(paramParcel, paramInt);
  }
  
  public final Map zzzz()
  {
    return zzdzk;
  }
}
