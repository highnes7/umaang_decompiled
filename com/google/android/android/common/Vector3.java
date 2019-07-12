package com.google.android.android.common;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.android.common.internal.zzaz;
import com.google.android.android.common.internal.zzba;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.dynamic.Integer;
import com.google.android.android.dynamite.DynamiteModule;
import com.google.android.android.dynamite.DynamiteModule.zzc;
import com.google.android.android.dynamite.DynamiteModule.zzd;

public final class Vector3
{
  public static zzaz zzffl;
  public static final Object zzffm = new Object();
  public static Context zzffn;
  
  public static boolean add(String paramString, Vector2D paramVector2D)
  {
    return set(paramString, paramVector2D, false);
  }
  
  public static boolean set(String paramString, Vector2D paramVector2D)
  {
    return set(paramString, paramVector2D, true);
  }
  
  public static boolean set(String paramString, Vector2D paramVector2D, boolean paramBoolean)
  {
    if (!zzaey()) {
      return false;
    }
    zzbp.append(zzffn);
    try
    {
      paramString = new Element(paramString, paramVector2D, paramBoolean);
      paramVector2D = zzffl;
      Object localObject = zzffn;
      localObject = ((Context)localObject).getPackageManager();
      paramBoolean = paramVector2D.getValue(paramString, new Integer(localObject));
      return paramBoolean;
    }
    catch (RemoteException paramString) {}
    return false;
  }
  
  public static boolean zzaey()
  {
    if (zzffl != null) {
      return true;
    }
    zzbp.append(zzffn);
    localObject1 = zzffm;
    for (;;)
    {
      try
      {
        localObject2 = zzffl;
        if (localObject2 == null)
        {
          localObject2 = zzffn;
          localZzd = DynamiteModule.zzgpr;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject2;
        DynamiteModule.zzd localZzd;
        throw localThrowable;
      }
      try
      {
        localObject2 = zzba.zzal(DynamiteModule.get((Context)localObject2, localZzd, "com.google.android.gms.googlecertificates").zzgv("com.google.android.gms.common.GoogleCertificatesImpl"));
        zzffl = (zzaz)localObject2;
      }
      catch (DynamiteModule.zzc localZzc) {}
    }
    return false;
    return true;
  }
  
  public static void zzbx(Context paramContext)
  {
    try
    {
      if ((zzffn == null) && (paramContext != null))
      {
        zzffn = paramContext.getApplicationContext();
        return;
      }
      return;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
}
