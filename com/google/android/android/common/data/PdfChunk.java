package com.google.android.android.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PdfChunk<T extends com.google.android.gms.internal.zzbco>
  extends com.google.android.gms.common.data.AbstractDataBuffer<T>
{
  public static final String[] zzfqj = { "data" };
  public final Parcelable.Creator<T> zzfqk;
  
  public PdfChunk(DataHolder paramDataHolder, Parcelable.Creator paramCreator)
  {
    super(paramDataHolder);
    zzfqk = paramCreator;
  }
  
  public static void addMessage(DataHolder.zza paramZza, com.google.android.android.internal.zzbco paramZzbco)
  {
    Parcel localParcel = Parcel.obtain();
    paramZzbco.writeToParcel(localParcel, 0);
    paramZzbco = new ContentValues();
    paramZzbco.put("data", localParcel.marshall());
    paramZza.add(paramZzbco);
    localParcel.recycle();
  }
  
  public static DataHolder.zza zzaiu()
  {
    return DataHolder.serialize(zzfqj);
  }
  
  public com.google.android.android.internal.zzbco zzbw(int paramInt)
  {
    Object localObject1 = zzflf;
    Object localObject2 = ((DataHolder)localObject1).get("data", paramInt, ((DataHolder)localObject1).zzbx(paramInt));
    localObject1 = Parcel.obtain();
    ((Parcel)localObject1).unmarshall((byte[])localObject2, 0, localObject2.length);
    ((Parcel)localObject1).setDataPosition(0);
    localObject2 = (com.google.android.android.internal.zzbco)zzfqk.createFromParcel((Parcel)localObject1);
    ((Parcel)localObject1).recycle();
    return localObject2;
  }
}
