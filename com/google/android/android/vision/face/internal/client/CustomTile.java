package com.google.android.android.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.internal.zzbck;
import com.google.android.android.internal.zzbcn;
import com.google.android.gms.vision.face.internal.client.zzc;

public final class CustomTile
  extends zzbck
{
  public static final Parcelable.Creator<zzc> CREATOR = new DiscreteSeekBar.CustomState.1();
  public int mode;
  public int zzkjj;
  public int zzkjk;
  public boolean zzkjl;
  public boolean zzkjm;
  public float zzkjn;
  
  public CustomTile() {}
  
  public CustomTile(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat)
  {
    mode = paramInt1;
    zzkjj = paramInt2;
    zzkjk = paramInt3;
    zzkjl = paramBoolean1;
    zzkjm = paramBoolean2;
    zzkjn = paramFloat;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 2, mode);
    zzbcn.setCustomVar(paramParcel, 3, zzkjj);
    zzbcn.setCustomVar(paramParcel, 4, zzkjk);
    zzbcn.onAction(paramParcel, 5, zzkjl);
    zzbcn.onAction(paramParcel, 6, zzkjm);
    zzbcn.set(paramParcel, 7, zzkjn);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
