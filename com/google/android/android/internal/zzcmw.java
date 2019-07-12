package com.google.android.android.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class zzcmw
  extends zzbck
{
  public static final Parcelable.Creator<com.google.android.gms.internal.zzcmw> CREATOR = new zzcnc();
  public static byte[][] zzfdr = new byte[0][];
  public static zzcmw zzjij;
  public static final zzcnb zzjis = (zzcnb)new zzcmx();
  public static final zzcnb zzjit = (zzcnb)new zzcmy();
  public static final zzcnb zzjiu = (zzcnb)new zzcmz();
  public static final zzcnb zzjiv = (zzcnb)new zzcna();
  public String zzjik;
  public byte[] zzjil;
  public byte[][] zzjim;
  public byte[][] zzjin;
  public byte[][] zzjio;
  public byte[][] zzjip;
  public int[] zzjiq;
  public byte[][] zzjir;
  
  static
  {
    byte[][] arrayOfByte = zzfdr;
    zzjij = new zzcmw("", null, arrayOfByte, arrayOfByte, arrayOfByte, arrayOfByte, null, null);
  }
  
  public zzcmw(String paramString, byte[] paramArrayOfByte, byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2, byte[][] paramArrayOfByte3, byte[][] paramArrayOfByte4, int[] paramArrayOfInt, byte[][] paramArrayOfByte5)
  {
    zzjik = paramString;
    zzjil = paramArrayOfByte;
    zzjim = paramArrayOfByte1;
    zzjin = paramArrayOfByte2;
    zzjio = paramArrayOfByte3;
    zzjip = paramArrayOfByte4;
    zzjiq = paramArrayOfInt;
    zzjir = paramArrayOfByte5;
  }
  
  public static List doInBackground(byte[][] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfByte.length);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Base64.encodeToString(paramArrayOfByte[i], 3));
      i += 1;
    }
    Collections.sort(localArrayList);
    return localArrayList;
  }
  
  public static void onPostExecute(StringBuilder paramStringBuilder, String paramString, byte[][] paramArrayOfByte)
  {
    paramStringBuilder.append(paramString);
    paramStringBuilder.append("=");
    if (paramArrayOfByte == null) {}
    for (paramString = "null";; paramString = ")")
    {
      paramStringBuilder.append(paramString);
      return;
      paramStringBuilder.append("(");
      int k = paramArrayOfByte.length;
      int i = 0;
      for (int j = 1; i < k; j = 0)
      {
        paramString = paramArrayOfByte[i];
        if (j == 0) {
          paramStringBuilder.append(", ");
        }
        paramStringBuilder.append("'");
        paramStringBuilder.append(Base64.encodeToString(paramString, 3));
        paramStringBuilder.append("'");
        i += 1;
      }
    }
  }
  
  public static List revert(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList(paramArrayOfInt.length);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Integer.valueOf(paramArrayOfInt[i]));
      i += 1;
    }
    Collections.sort(localArrayList);
    return localArrayList;
  }
  
  public static void toHtml(StringBuilder paramStringBuilder, String paramString, int[] paramArrayOfInt)
  {
    paramStringBuilder.append(paramString);
    paramStringBuilder.append("=");
    if (paramArrayOfInt == null) {}
    for (paramString = "null";; paramString = ")")
    {
      paramStringBuilder.append(paramString);
      return;
      paramStringBuilder.append("(");
      int k = paramArrayOfInt.length;
      int i = 0;
      for (int j = 1; i < k; j = 0)
      {
        int m = paramArrayOfInt[i];
        if (j == 0) {
          paramStringBuilder.append(", ");
        }
        paramStringBuilder.append(m);
        i += 1;
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof zzcmw))
    {
      paramObject = (zzcmw)paramObject;
      if ((zzcnd.equals(zzjik, zzjik)) && (Arrays.equals(zzjil, zzjil)) && (zzcnd.equals(doInBackground(zzjim), doInBackground(zzjim))) && (zzcnd.equals(doInBackground(zzjin), doInBackground(zzjin))) && (zzcnd.equals(doInBackground(zzjio), doInBackground(zzjio))) && (zzcnd.equals(doInBackground(zzjip), doInBackground(zzjip))) && (zzcnd.equals(revert(zzjiq), revert(zzjiq))) && (zzcnd.equals(doInBackground(zzjir), doInBackground(zzjir)))) {
        return true;
      }
    }
    return false;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ExperimentTokens");
    localStringBuilder.append("(");
    Object localObject = zzjik;
    if (localObject == null)
    {
      localObject = "null";
    }
    else
    {
      int i = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localObject, "'".length());
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("'".length() + i, "'", (String)localObject, "'");
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", ");
    localObject = zzjil;
    localStringBuilder.append("direct");
    localStringBuilder.append("=");
    if (localObject == null)
    {
      localStringBuilder.append("null");
    }
    else
    {
      localStringBuilder.append("'");
      localStringBuilder.append(Base64.encodeToString((byte[])localObject, 3));
      localStringBuilder.append("'");
    }
    localStringBuilder.append(", ");
    onPostExecute(localStringBuilder, "GAIA", zzjim);
    localStringBuilder.append(", ");
    onPostExecute(localStringBuilder, "PSEUDO", zzjin);
    localStringBuilder.append(", ");
    onPostExecute(localStringBuilder, "ALWAYS", zzjio);
    localStringBuilder.append(", ");
    onPostExecute(localStringBuilder, "OTHER", zzjip);
    localStringBuilder.append(", ");
    toHtml(localStringBuilder, "weak", zzjiq);
    localStringBuilder.append(", ");
    onPostExecute(localStringBuilder, "directs", zzjir);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.append(paramParcel, 2, zzjik, false);
    zzbcn.writeString(paramParcel, 3, zzjil, false);
    zzbcn.writeString(paramParcel, 4, zzjim, false);
    zzbcn.writeString(paramParcel, 5, zzjin, false);
    zzbcn.writeString(paramParcel, 6, zzjio, false);
    zzbcn.writeString(paramParcel, 7, zzjip, false);
    zzbcn.writeValue(paramParcel, 8, zzjiq, false);
    zzbcn.writeString(paramParcel, 9, zzjir, false);
    zzbcn.zzah(paramParcel, paramInt);
  }
}
