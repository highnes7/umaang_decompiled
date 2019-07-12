package com.google.android.android.tagmanager;

import android.content.Context;
import com.google.android.android.internal.zzbd;
import com.google.android.android.internal.zzbp;
import java.util.Map;

public final class SimpleNode
  extends zzbr
{
  public static final String id = zzbd.zzhj.toString();
  public final ScreenshotTaker zzjoq;
  
  public SimpleNode(Context paramContext)
  {
    this(ScreenshotTaker.zzdp(paramContext));
  }
  
  public SimpleNode(ScreenshotTaker paramScreenshotTaker)
  {
    super(id, new String[0]);
    zzjoq = paramScreenshotTaker;
  }
  
  public final zzbp evaluate(Map paramMap)
  {
    return zzgk.zzah(Boolean.valueOf(zzjoq.isLimitAdTrackingEnabled() ^ true));
  }
  
  public final boolean zzbcj()
  {
    return false;
  }
}
