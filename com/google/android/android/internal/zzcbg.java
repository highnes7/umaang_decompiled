package com.google.android.android.internal;

import com.google.android.android.common.internal.zzbp;

public final class zzcbg
{
  public final String mAppId;
  public final String mName;
  public final long zzinl;
  public final long zzinm;
  public final long zzinn;
  
  public zzcbg(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3)
  {
    zzbp.zzgg(paramString1);
    zzbp.zzgg(paramString2);
    boolean bool2 = true;
    boolean bool1;
    if (paramLong1 >= 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    zzbp.zzbh(bool1);
    if (paramLong2 >= 0L) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    zzbp.zzbh(bool1);
    mAppId = paramString1;
    mName = paramString2;
    zzinl = paramLong1;
    zzinm = paramLong2;
    zzinn = paramLong3;
  }
  
  public final zzcbg zzaxy()
  {
    return new zzcbg(mAppId, mName, zzinl + 1L, 1L + zzinm, zzinn);
  }
  
  public final zzcbg zzbb(long paramLong)
  {
    return new zzcbg(mAppId, mName, zzinl, zzinm, paramLong);
  }
}
