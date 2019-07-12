package com.google.android.android.common.util;

import android.content.Context;
import android.os.DropBoxManager;
import com.google.android.android.common.internal.zzbp;

public final class Communication
{
  public static final String[] zzfym = { "android.", "com.android.", "dalvik.", "java.", "javax." };
  public static DropBoxManager zzfyn = null;
  public static boolean zzfyo = false;
  public static int zzfyp = -1;
  public static int zzfyq = 0;
  
  public static boolean sendRequest(Context paramContext, Throwable paramThrowable)
  {
    sendRequest(paramContext, paramThrowable, 0);
    return false;
  }
  
  public static boolean sendRequest(Context paramContext, Throwable paramThrowable, int paramInt)
  {
    try
    {
      zzbp.append(paramContext);
      zzbp.append(paramThrowable);
      return false;
    }
    catch (Exception paramContext) {}
    return false;
  }
}
