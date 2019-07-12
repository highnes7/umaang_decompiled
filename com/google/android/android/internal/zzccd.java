package com.google.android.android.internal;

import b.b.a.X;
import com.google.android.android.common.internal.zzbp;
import java.util.List;
import java.util.Map;

@X
public final class zzccd
  implements Runnable
{
  public final String mPackageName;
  public final int zzbyz;
  public final Throwable zzdfp;
  public final zzccc zziqf;
  public final byte[] zziqg;
  public final Map<String, List<String>> zziqh;
  
  public zzccd(String paramString, zzccc paramZzccc, int paramInt, Throwable paramThrowable, byte[] paramArrayOfByte, Map paramMap)
  {
    zzbp.append(paramZzccc);
    zziqf = paramZzccc;
    zzbyz = paramInt;
    zzdfp = paramThrowable;
    zziqg = paramArrayOfByte;
    mPackageName = paramString;
    zziqh = paramMap;
  }
  
  public final void run()
  {
    zziqf.deleteMessages(mPackageName, zzbyz, zzdfp, zziqg, zziqh);
  }
}
