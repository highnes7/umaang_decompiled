package com.google.android.android.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.android.common.internal.zzbp;
import java.util.ArrayList;

public final class zzbcp
{
  public static zzbco get(byte[] paramArrayOfByte, Parcelable.Creator paramCreator)
  {
    zzbp.append(paramCreator);
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    paramArrayOfByte = (zzbco)paramCreator.createFromParcel(localParcel);
    localParcel.recycle();
    return paramArrayOfByte;
  }
  
  public static ArrayList get(Intent paramIntent, String paramString, Parcelable.Creator paramCreator)
  {
    paramIntent = (ArrayList)paramIntent.getSerializableExtra(paramString);
    if (paramIntent == null) {
      return null;
    }
    paramString = new ArrayList(paramIntent.size());
    int j = paramIntent.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramIntent.get(i);
      i += 1;
      paramString.add(get((byte[])localObject, paramCreator));
    }
    return paramString;
  }
  
  public static zzbco load(Intent paramIntent, String paramString, Parcelable.Creator paramCreator)
  {
    paramIntent = paramIntent.getByteArrayExtra(paramString);
    if (paramIntent == null) {
      return null;
    }
    return get(paramIntent, paramCreator);
  }
  
  public static byte[] marshall(zzbco paramZzbco)
  {
    Parcel localParcel = Parcel.obtain();
    paramZzbco.writeToParcel(localParcel, 0);
    paramZzbco = localParcel.marshall();
    localParcel.recycle();
    return paramZzbco;
  }
  
  public static void sendBroadcast(zzbco paramZzbco, Intent paramIntent, String paramString)
  {
    paramIntent.putExtra(paramString, marshall(paramZzbco));
  }
}
