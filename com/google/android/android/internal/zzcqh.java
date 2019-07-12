package com.google.android.android.internal;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.stats.Transport;
import com.google.android.android.common.stats.Vector3;
import com.google.android.android.common.util.ObjectCache;
import com.google.android.android.common.util.Pattern;

public final class zzcqh
{
  public static boolean DEBUG;
  public static String TAG;
  public static String zzjnz;
  public final Context mContext;
  public final String zzfxz;
  public final String zzfyb;
  public final PowerManager.WakeLock zzjoa;
  public WorkSource zzjob;
  public final int zzjoc;
  public final String zzjod;
  public boolean zzjoe = true;
  public int zzjof;
  public int zzjog;
  
  public zzcqh(Context paramContext, int paramInt, String paramString)
  {
    this(paramContext, 1, paramString, null, str);
  }
  
  public zzcqh(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this(paramContext, 1, paramString1, null, paramString3, null);
  }
  
  public zzcqh(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    zzbp.format(paramString1, "Wake lock name can NOT be empty");
    zzjoc = paramInt;
    zzjod = null;
    zzfyb = null;
    mContext = paramContext.getApplicationContext();
    if (!"com.google.android.gms".equals(paramContext.getPackageName()))
    {
      paramString2 = String.valueOf(zzjnz);
      paramString4 = String.valueOf(paramString1);
      if (paramString4.length() != 0) {
        paramString2 = paramString2.concat(paramString4);
      } else {
        paramString2 = new String(paramString2);
      }
      zzfxz = paramString2;
    }
    else
    {
      zzfxz = paramString1;
    }
    zzjoa = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(paramInt, paramString1);
    if (ObjectCache.zzco(mContext))
    {
      paramString1 = paramString3;
      if (Pattern.zzgm(paramString3)) {
        paramString1 = paramContext.getPackageName();
      }
      zzjob = ObjectCache.zzac(paramContext, paramString1);
      paramContext = zzjob;
      if ((paramContext != null) && (ObjectCache.zzco(mContext)))
      {
        paramString1 = zzjob;
        if (paramString1 != null) {
          paramString1.add(paramContext);
        } else {
          zzjob = paramContext;
        }
        paramContext = zzjob;
        paramString1 = zzjoa;
        try
        {
          paramString1.setWorkSource(paramContext);
          return;
        }
        catch (IllegalArgumentException paramContext)
        {
          Log.wtf(TAG, paramContext.toString());
        }
      }
    }
  }
  
  private final String get(String paramString, boolean paramBoolean)
  {
    if (zzjoe)
    {
      if (paramBoolean) {
        return null;
      }
      return zzjod;
    }
    return zzjod;
  }
  
  private final boolean zzlb(String paramString)
  {
    if (TextUtils.isEmpty(null)) {
      return false;
    }
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void acquire(long paramLong)
  {
    zzlb(null);
    String str = get(null, false);
    try
    {
      if (((zzjof > 0) || (zzjog > 0)) && (!zzjoa.isHeld()))
      {
        zzjof = 0;
        zzjog = 0;
      }
      if (zzjoe)
      {
        int i = zzjof;
        zzjof = (i + 1);
        if (i == 0) {}
      }
      else
      {
        if ((zzjoe) || (zzjog != 0)) {
          break label141;
        }
      }
      Vector3 localVector3 = Vector3.zzfyk;
      Vector3.add(mContext, Transport.get(zzjoa, str), 7, zzfxz, str, null, zzjoc, ObjectCache.searchText(zzjob), 1000L);
      zzjog += 1;
      label141:
      zzjoa.acquire(1000L);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final boolean isHeld()
  {
    return zzjoa.isHeld();
  }
  
  public final void release()
  {
    zzlb(null);
    String str = get(null, false);
    try
    {
      if (zzjoe)
      {
        int i = zzjof - 1;
        zzjof = i;
        if (i == 0) {}
      }
      else
      {
        if ((zzjoe) || (zzjog != 1)) {
          break label101;
        }
      }
      Vector3 localVector3 = Vector3.zzfyk;
      Vector3.add(mContext, Transport.get(zzjoa, str), 8, zzfxz, str, null, zzjoc, ObjectCache.searchText(zzjob));
      zzjog -= 1;
      label101:
      zzjoa.release();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void setReferenceCounted(boolean paramBoolean)
  {
    zzjoa.setReferenceCounted(false);
    zzjoe = false;
  }
}
