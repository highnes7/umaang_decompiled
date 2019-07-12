package com.google.android.android.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import com.google.android.apps.common.proguard.UsedByNative;

@UsedByNative("wrapper.cc")
public class FaceParcel
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.vision.face.internal.client.FaceParcel> CREATOR = new VerticalProgressBar.SavedState.1();
  public final float centerX;
  public final float centerY;
  public final float height;
  public int versionCode;
  public final float width;
  public final int x;
  public final float zzkjd;
  public final float zzkje;
  public final LandmarkParcel[] zzkjf;
  public final float zzkjg;
  public final float zzkjh;
  public final float zzkji;
  
  public FaceParcel(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, LandmarkParcel[] paramArrayOfLandmarkParcel, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    versionCode = paramInt1;
    x = paramInt2;
    centerX = paramFloat1;
    centerY = paramFloat2;
    width = paramFloat3;
    height = paramFloat4;
    zzkjd = paramFloat5;
    zzkje = paramFloat6;
    zzkjf = paramArrayOfLandmarkParcel;
    zzkjg = paramFloat7;
    zzkjh = paramFloat8;
    zzkji = paramFloat9;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, versionCode);
    zzbcn.setCustomVar(paramParcel, 2, x);
    zzbcn.set(paramParcel, 3, centerX);
    zzbcn.set(paramParcel, 4, centerY);
    zzbcn.set(paramParcel, 5, width);
    zzbcn.set(paramParcel, 6, height);
    zzbcn.set(paramParcel, 7, zzkjd);
    zzbcn.set(paramParcel, 8, zzkje);
    zzbcn.writeHeader(paramParcel, 9, zzkjf, paramInt, false);
    zzbcn.set(paramParcel, 10, zzkjg);
    zzbcn.set(paramParcel, 11, zzkjh);
    zzbcn.set(paramParcel, 12, zzkji);
    zzbcn.zzah(paramParcel, i);
  }
}
