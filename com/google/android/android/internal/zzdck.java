package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.android.vision.Frame;
import com.google.android.android.vision.Frame.Metadata;

public final class zzdck
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzdck> CREATOR = new zzdcl();
  public int height;
  public int id;
  public int rotation;
  public int width;
  public long zzhyv;
  
  public zzdck() {}
  
  public zzdck(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    width = paramInt1;
    height = paramInt2;
    id = paramInt3;
    zzhyv = paramLong;
    rotation = paramInt4;
  }
  
  public static zzdck get(Frame paramFrame)
  {
    zzdck localZzdck = new zzdck();
    width = paramFrame.getMetadata().getWidth();
    height = paramFrame.getMetadata().getHeight();
    rotation = paramFrame.getMetadata().getRotation();
    id = paramFrame.getMetadata().getId();
    zzhyv = paramFrame.getMetadata().getTimestampMillis();
    return localZzdck;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 2, width);
    zzbcn.setCustomVar(paramParcel, 3, height);
    zzbcn.setCustomVar(paramParcel, 4, id);
    zzbcn.writeHeader(paramParcel, 5, zzhyv);
    zzbcn.setCustomVar(paramParcel, 6, rotation);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
