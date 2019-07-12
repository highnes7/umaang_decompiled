package com.google.android.android.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.android.common.internal.zzas;
import com.google.android.android.common.internal.zzat;
import com.google.android.android.dynamic.Integer;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import com.google.android.android.internal.zzec;
import com.google.android.gms.common.zzm;

public final class Element
  extends zzbck
{
  public static final Parcelable.Creator<zzm> CREATOR = new DownloadProgressInfo.1();
  public final String zzfft;
  public final Vector2D zzffu;
  public final boolean zzffv;
  
  public Element(String paramString, IBinder paramIBinder, boolean paramBoolean)
  {
    zzfft = paramString;
    zzffu = zzai(paramIBinder);
    zzffv = paramBoolean;
  }
  
  public Element(String paramString, Vector2D paramVector2D, boolean paramBoolean)
  {
    zzfft = paramString;
    zzffu = paramVector2D;
    zzffv = paramBoolean;
  }
  
  public static Vector2D zzai(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    try
    {
      paramIBinder = zzat.zzak(paramIBinder).zzaez();
      if (paramIBinder == null) {
        paramIBinder = null;
      } else {
        paramIBinder = (byte[])Integer.get(paramIBinder);
      }
      if (paramIBinder != null) {
        return new ZipOutputStream(paramIBinder);
      }
    }
    catch (RemoteException paramIBinder) {}
    return null;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.append(paramParcel, 1, zzfft, false);
    Object localObject = zzffu;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((zzec)localObject).asBinder();
    }
    zzbcn.writeString(paramParcel, 2, (IBinder)localObject, false);
    zzbcn.onAction(paramParcel, 3, zzffv);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
