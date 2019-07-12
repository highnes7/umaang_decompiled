package com.google.android.android.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.android.internal.zzbd;
import com.google.android.android.internal.zzbp;
import java.util.Map;

public final class zzen
  extends zzbr
{
  public static final String cachePath = zzbd.zzij.toString();
  public final Context mContext;
  
  public zzen(Context paramContext)
  {
    super(cachePath, new String[0]);
    mContext = paramContext;
  }
  
  public final zzbp evaluate(Map paramMap)
  {
    paramMap = new DisplayMetrics();
    ((WindowManager)mContext.getSystemService("window")).getDefaultDisplay().getMetrics(paramMap);
    int i = widthPixels;
    int j = heightPixels;
    paramMap = new StringBuilder(23);
    paramMap.append(i);
    paramMap.append("x");
    paramMap.append(j);
    return zzgk.zzah(paramMap.toString());
  }
  
  public final boolean zzbcj()
  {
    return true;
  }
}
