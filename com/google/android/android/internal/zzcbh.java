package com.google.android.android.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbck;
import java.util.Iterator;

public final class zzcbh
  extends zzbck
  implements Iterable<String>
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzcbh> CREATOR = new zzcbj();
  public final Bundle zzino;
  
  public zzcbh(Bundle paramBundle)
  {
    zzino = paramBundle;
  }
  
  public final Object getValue(String paramString)
  {
    return zzino.get(paramString);
  }
  
  public final Iterator iterator()
  {
    return new zzcbi(this);
  }
  
  public final int size()
  {
    return zzino.size();
  }
  
  public final String toString()
  {
    return zzino.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.writeString(paramParcel, 2, zzaxz(), false);
    zzbcn.zzah(paramParcel, paramInt);
  }
  
  public final Bundle zzaxz()
  {
    return new Bundle(zzino);
  }
}
