package com.google.android.android.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.android.internal.zzbcn;
import java.util.List;

public final class WakeLockEvent
  extends StatsEvent
{
  public static final Parcelable.Creator<com.google.android.gms.common.stats.WakeLockEvent> CREATOR = new VerticalProgressBar.SavedState.1();
  public final long mTimeout;
  public int zzdxs;
  public final long zzfxx;
  public int zzfxy;
  public final String zzfxz;
  public final String zzfya;
  public final String zzfyb;
  public final int zzfyc;
  public final List<String> zzfyd;
  public final String zzfye;
  public final long zzfyf;
  public int zzfyg;
  public final String zzfyh;
  public final float zzfyi;
  public long zzfyj;
  
  public WakeLockEvent(int paramInt1, long paramLong1, int paramInt2, String paramString1, int paramInt3, List paramList, String paramString2, long paramLong2, int paramInt4, String paramString3, String paramString4, float paramFloat, long paramLong3, String paramString5)
  {
    zzdxs = paramInt1;
    zzfxx = paramLong1;
    zzfxy = paramInt2;
    zzfxz = paramString1;
    zzfya = paramString3;
    zzfyb = paramString5;
    zzfyc = paramInt3;
    zzfyj = -1L;
    zzfyd = paramList;
    zzfye = paramString2;
    zzfyf = paramLong2;
    zzfyg = paramInt4;
    zzfyh = paramString4;
    zzfyi = paramFloat;
    mTimeout = paramLong3;
  }
  
  public WakeLockEvent(long paramLong1, int paramInt1, String paramString1, int paramInt2, List paramList, String paramString2, long paramLong2, int paramInt3, String paramString3, String paramString4, float paramFloat, long paramLong3, String paramString5)
  {
    this(2, paramLong1, paramInt1, paramString1, paramInt2, paramList, paramString2, paramLong2, paramInt3, paramString3, paramString4, paramFloat, paramLong3, paramString5);
  }
  
  public final int getEventType()
  {
    return zzfxy;
  }
  
  public final long getTimeMillis()
  {
    return zzfxx;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = zzbcn.writeValue(paramParcel);
    zzbcn.setCustomVar(paramParcel, 1, zzdxs);
    zzbcn.writeHeader(paramParcel, 2, getTimeMillis());
    zzbcn.append(paramParcel, 4, zzfxz, false);
    zzbcn.setCustomVar(paramParcel, 5, zzfyc);
    zzbcn.readString(paramParcel, 6, zzfyd, false);
    zzbcn.writeHeader(paramParcel, 8, zzfyf);
    zzbcn.append(paramParcel, 10, zzfya, false);
    zzbcn.setCustomVar(paramParcel, 11, getEventType());
    zzbcn.append(paramParcel, 12, zzfye, false);
    zzbcn.append(paramParcel, 13, zzfyh, false);
    zzbcn.setCustomVar(paramParcel, 14, zzfyg);
    zzbcn.set(paramParcel, 15, zzfyi);
    zzbcn.writeHeader(paramParcel, 16, mTimeout);
    zzbcn.append(paramParcel, 17, zzfyb, false);
    zzbcn.zzah(paramParcel, paramInt);
  }
  
  public final long zzakz()
  {
    return zzfyj;
  }
  
  public final String zzala()
  {
    String str = zzfxz;
    int i = zzfyc;
    Object localObject1 = zzfyd;
    Object localObject4 = "";
    if (localObject1 == null) {
      localObject1 = "";
    } else {
      localObject1 = TextUtils.join(",", (Iterable)localObject1);
    }
    int j = zzfyg;
    Object localObject3 = zzfya;
    Object localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    Object localObject5 = zzfyh;
    localObject3 = localObject5;
    if (localObject5 == null) {
      localObject3 = "";
    }
    float f = zzfyi;
    localObject5 = zzfyb;
    if (localObject5 != null) {
      localObject4 = localObject5;
    }
    int k = f.sufficientlysecure.rootcommands.util.StringBuilder.append(str, "\t".length() + 37);
    int m = "\t".length();
    k = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localObject1, "\t".length() + (m + k));
    m = "\t".length();
    k = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localObject2, "\t".length() + (m + k));
    k = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localObject3, "\t".length() + k);
    m = "\t".length();
    localObject5 = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(localObject4, "\t".length() + (m + k)));
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append(str);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append(i);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append((String)localObject1);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append(j);
    f.sufficientlysecure.rootcommands.util.StringBuilder.append((StringBuilder)localObject5, "\t", (String)localObject2, "\t", (String)localObject3);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append(f);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append((String)localObject4);
    return ((StringBuilder)localObject5).toString();
  }
}
