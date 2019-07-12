package com.google.android.android.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import java.util.Collections;
import java.util.List;

public final class zzaa
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.location.zzaa> CREATOR = new zzab();
  public final PendingIntent mPendingIntent;
  public final String mTag;
  public final List<String> zzhyx;
  
  public zzaa(List paramList, PendingIntent paramPendingIntent, String paramString)
  {
    if (paramList == null) {
      paramList = Collections.emptyList();
    } else {
      paramList = Collections.unmodifiableList(paramList);
    }
    zzhyx = paramList;
    mPendingIntent = paramPendingIntent;
    mTag = paramString;
  }
  
  public static zzaa a(List paramList)
  {
    zzbp.get(paramList, "geofence can't be null.");
    zzbp.get(paramList.isEmpty() ^ true, "Geofences must contains at least one id.");
    return new zzaa(paramList, null, "");
  }
  
  public static zzaa getElementValue(PendingIntent paramPendingIntent)
  {
    zzbp.get(paramPendingIntent, "PendingIntent can not be null.");
    return new zzaa(null, paramPendingIntent, "");
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.readString(paramParcel, 1, zzhyx, false);
    zzbcn.addMenuItem(paramParcel, 2, mPendingIntent, paramInt, false);
    zzbcn.append(paramParcel, 3, mTag, false);
    zzbcn.zzah(paramParcel, i);
  }
}
