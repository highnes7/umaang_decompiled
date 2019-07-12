package com.google.android.android.tagmanager;

import android.content.Context;
import com.google.android.android.internal.zzbd;
import com.google.android.android.internal.zzbp;
import java.util.Map;

public final class Tokenizer
  extends zzbr
{
  public static final String pattern = zzbd.zzhi.toString();
  public final ScreenshotTaker zzjoq;
  
  public Tokenizer(Context paramContext)
  {
    this(ScreenshotTaker.zzdp(paramContext));
  }
  
  public Tokenizer(ScreenshotTaker paramScreenshotTaker)
  {
    super(pattern, new String[0]);
    zzjoq = paramScreenshotTaker;
    zzjoq.zzbcd();
  }
  
  public final zzbp evaluate(Map paramMap)
  {
    paramMap = zzjoq.zzbcd();
    if (paramMap == null) {
      return zzgk.zzjwp;
    }
    return zzgk.zzah(paramMap);
  }
  
  public final boolean zzbcj()
  {
    return false;
  }
}
