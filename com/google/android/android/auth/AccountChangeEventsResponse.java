package com.google.android.android.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import com.google.android.gms.auth.AccountChangeEvent;
import java.util.List;

public class AccountChangeEventsResponse
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.auth.AccountChangeEventsResponse> CREATOR = new DiscreteSeekBar.CustomState.1();
  public int mVersion;
  public List<AccountChangeEvent> zzaoc;
  
  public AccountChangeEventsResponse(int paramInt, List paramList)
  {
    mVersion = paramInt;
    zzbp.append(paramList);
    zzaoc = ((List)paramList);
  }
  
  public AccountChangeEventsResponse(List paramList)
  {
    mVersion = 1;
    zzbp.append(paramList);
    zzaoc = ((List)paramList);
  }
  
  public List getEvents()
  {
    return zzaoc;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, mVersion);
    zzbcn.save(paramParcel, 2, zzaoc, false);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
