package com.google.android.android.auth.dashclock.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.internal.zzatt;
import com.google.android.android.internal.zzbcn;
import com.google.android.gms.auth.api.accounttransfer.zzu;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.HashMap;
import java.util.Set;
import support.android.v4.util.NodeList;

public class MapPack
  extends zzatt
{
  public static final Parcelable.Creator<zzu> CREATOR = new DownloadProgressInfo.1();
  public static final HashMap<String, com.google.android.gms.internal.zzbdm<?, ?>> zzdzf;
  public PendingIntent mPendingIntent;
  public int zzbyz;
  public int zzdxs;
  public Set<Integer> zzdzg;
  public String zzdzr;
  public byte[] zzdzs;
  public DeviceMetaData zzdzt;
  
  static
  {
    HashMap localHashMap = new HashMap();
    zzdzf = localHashMap;
    localHashMap.put("accountType", com.google.android.android.internal.zzbdm.getValue("accountType", 2));
    zzdzf.put("status", com.google.android.android.internal.zzbdm.add("status", 3));
    zzdzf.put("transferBytes", com.google.android.android.internal.zzbdm.initFunction("transferBytes", 4));
  }
  
  public MapPack()
  {
    zzdzg = new NodeList(3);
    zzdxs = 1;
  }
  
  public MapPack(Set paramSet, int paramInt1, String paramString, int paramInt2, byte[] paramArrayOfByte, PendingIntent paramPendingIntent, DeviceMetaData paramDeviceMetaData)
  {
    zzdzg = paramSet;
    zzdxs = paramInt1;
    zzdzr = paramString;
    zzbyz = paramInt2;
    zzdzs = paramArrayOfByte;
    mPendingIntent = paramPendingIntent;
    zzdzt = paramDeviceMetaData;
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
            return zzdzs;
          }
          throw new IllegalStateException(StringBuilder.add(37, "Unknown SafeParcelable id=", paramZzbdm.zzakq()));
        }
        i = zzbyz;
      }
      else
      {
        return zzdzr;
      }
    }
    else {
      i = zzdxs;
    }
    return Integer.valueOf(i);
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
      zzbcn.append(paramParcel, 2, zzdzr, true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      zzbcn.setCustomVar(paramParcel, 3, zzbyz);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      zzbcn.writeString(paramParcel, 4, zzdzs, true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      zzbcn.addMenuItem(paramParcel, 5, mPendingIntent, paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      zzbcn.addMenuItem(paramParcel, 6, zzdzt, paramInt, true);
    }
    zzbcn.zzah(paramParcel, i);
  }
}
