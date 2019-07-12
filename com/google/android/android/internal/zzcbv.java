package com.google.android.android.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.android.common.internal.Log;
import com.google.android.android.common.internal.Point;
import com.google.android.android.common.internal.TaskManager;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.internal.zzcbo;

public final class zzcbv
  extends zzd<zzcbo>
{
  public zzcbv(Context paramContext, Looper paramLooper, Point paramPoint, Log paramLog)
  {
    super(paramContext, paramLooper, 93, paramPoint, paramLog, null);
  }
  
  public final String zzhc()
  {
    return "com.google.android.gms.measurement.START";
  }
  
  public final String zzhd()
  {
    return "com.google.android.gms.measurement.internal.IMeasurementService";
  }
}
