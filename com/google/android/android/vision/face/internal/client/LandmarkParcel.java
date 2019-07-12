package com.google.android.android.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import com.google.android.apps.common.proguard.UsedByNative;

@UsedByNative("wrapper.cc")
public final class LandmarkParcel
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.vision.face.internal.client.LandmarkParcel> CREATOR = new DownloadProgressInfo.1();
  public final float height;
  public final int type;
  public int versionCode;
  public final float width;
  
  public LandmarkParcel(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2)
  {
    versionCode = paramInt1;
    width = paramFloat1;
    height = paramFloat2;
    type = paramInt2;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, versionCode);
    zzbcn.set(paramParcel, 2, width);
    zzbcn.set(paramParcel, 3, height);
    zzbcn.setCustomVar(paramParcel, 4, type);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
