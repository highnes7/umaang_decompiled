package com.google.android.android.internal;

import android.content.Context;
import com.google.android.android.common.util.Clock;
import com.google.android.android.common.util.Log;
import java.util.HashMap;
import java.util.Map;

public final class zzdbn
{
  public final Context mContext;
  public final Log zzasc;
  public String zzjqd = null;
  public Map<String, Object> zzkcz = new HashMap();
  public final Map<String, Object> zzkda;
  public final zzdbx zzkfl;
  
  public zzdbn(Context paramContext)
  {
    this(paramContext, new HashMap(), new zzdbx(paramContext), Clock.zzfyr);
  }
  
  public zzdbn(Context paramContext, Map paramMap, zzdbx paramZzdbx, Log paramLog)
  {
    mContext = paramContext;
    zzasc = paramLog;
    zzkfl = paramZzdbx;
    zzkda = paramMap;
  }
  
  public final void zznj(String paramString)
  {
    zzjqd = paramString;
  }
}
