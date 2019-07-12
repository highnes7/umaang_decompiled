package com.google.android.android.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import com.google.android.gms.location.zzt;

public final class StatusBarPanelCustomTile
  extends zzbck
{
  public static final Parcelable.Creator<zzt> CREATOR = new AccountMirakel.2();
  public final String zzepl;
  public final String zzhye;
  public final String zzhyf;
  public final int zzhyg;
  public final boolean zzhyh;
  
  public StatusBarPanelCustomTile(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    zzepl = paramString1;
    zzhye = paramString2;
    zzhyf = paramString3;
    zzhyg = paramInt;
    zzhyh = paramBoolean;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.append(paramParcel, 1, zzhye, false);
    zzbcn.append(paramParcel, 2, zzhyf, false);
    zzbcn.setCustomVar(paramParcel, 3, zzhyg);
    zzbcn.onAction(paramParcel, 4, zzhyh);
    zzbcn.append(paramParcel, 5, zzepl, false);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
