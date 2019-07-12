package com.google.android.android.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.measurement.AppMeasurement.Event;
import com.google.android.android.measurement.AppMeasurement.Param;
import com.google.android.android.measurement.AppMeasurement.UserProperty;
import java.io.IOException;
import java.util.Map;
import support.android.v4.util.ArrayMap;

public final class zzccq
  extends zzcdu
{
  public final Map<String, Map<String, String>> zzirv = new ArrayMap();
  public final Map<String, Map<String, Boolean>> zzirw = new ArrayMap();
  public final Map<String, Map<String, Boolean>> zzirx = new ArrayMap();
  public final Map<String, com.google.android.gms.internal.zzcge> zziry = new ArrayMap();
  public final Map<String, String> zzirz = new ArrayMap();
  
  public zzccq(zzccw paramZzccw)
  {
    super(paramZzccw);
  }
  
  public static Map clone(zzcge paramZzcge)
  {
    ArrayMap localArrayMap = new ArrayMap();
    if (paramZzcge != null)
    {
      paramZzcge = zziyo;
      if (paramZzcge != null)
      {
        int j = paramZzcge.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramZzcge[i];
          if (localObject != null) {
            localArrayMap.put(name, value);
          }
          i += 1;
        }
      }
    }
    return localArrayMap;
  }
  
  private final zzcge loadIcon(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return new zzcge();
    }
    Object localObject = zzeye.getBlob(paramArrayOfByte, 0, paramArrayOfByte.length);
    paramArrayOfByte = new zzcge();
    try
    {
      paramArrayOfByte.digest((zzeye)localObject);
      localObject = zzaul().zzayj();
      Long localLong = zziym;
      String str = zzilu;
      ((zzcby)localObject).append("Parsed config. version, gmp_app_id", localLong, str);
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      zzaul().zzayf().append("Unable to merge remote config. appId", zzcbw.zzjf(paramString), paramArrayOfByte);
    }
    return new zzcge();
  }
  
  private final void loadProperties(String paramString, zzcge paramZzcge)
  {
    ArrayMap localArrayMap1 = new ArrayMap();
    ArrayMap localArrayMap2 = new ArrayMap();
    if (paramZzcge != null)
    {
      paramZzcge = zziyp;
      if (paramZzcge != null)
      {
        int j = paramZzcge.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramZzcge[i];
          if (localObject != null)
          {
            String str = AppMeasurement.Event.zzil(name);
            if (str != null) {
              name = str;
            }
            localArrayMap1.put(name, zziyk);
            localArrayMap2.put(name, zziyl);
          }
          i += 1;
        }
      }
    }
    zzirw.put(paramString, localArrayMap1);
    zzirx.put(paramString, localArrayMap2);
  }
  
  private final void zzjm(String paramString)
  {
    zzwk();
    zzuj();
    zzbp.zzgg(paramString);
    if (zziry.get(paramString) == null)
    {
      Object localObject = zzauf().zziy(paramString);
      if (localObject == null)
      {
        zzirv.put(paramString, null);
        zzirw.put(paramString, null);
        zzirx.put(paramString, null);
        zziry.put(paramString, null);
        zzirz.put(paramString, null);
        return;
      }
      localObject = loadIcon(paramString, (byte[])localObject);
      zzirv.put(paramString, clone((zzcge)localObject));
      loadProperties(paramString, (zzcge)localObject);
      zziry.put(paramString, localObject);
      zzirz.put(paramString, null);
    }
  }
  
  public final boolean putAll(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    zzwk();
    zzuj();
    zzbp.zzgg(paramString1);
    zzcge localZzcge = loadIcon(paramString1, paramArrayOfByte);
    loadProperties(paramString1, localZzcge);
    zziry.put(paramString1, localZzcge);
    zzirz.put(paramString1, paramString2);
    zzirv.put(paramString1, clone(localZzcge));
    paramString2 = zzaty();
    Object localObject1 = zziyq;
    zzbp.append(localObject1);
    int m = localObject1.length;
    int i = 0;
    while (i < m)
    {
      zzcgb[] arrayOfZzcgb = localObject1[i];
      Object localObject2 = zzixl;
      int n = localObject2.length;
      int j = 0;
      Object localObject3;
      while (j < n)
      {
        localObject3 = localObject2[j];
        String str1 = AppMeasurement.Event.zzil(zzixo);
        if (str1 != null) {
          zzixo = str1;
        }
        localObject3 = zzixp;
        int i1 = localObject3.length;
        k = 0;
        while (k < i1)
        {
          str1 = localObject3[k];
          String str2 = AppMeasurement.Param.zzil(zzixw);
          if (str2 != null) {
            zzixw = str2;
          }
          k += 1;
        }
        j += 1;
      }
      arrayOfZzcgb = zzixk;
      int k = arrayOfZzcgb.length;
      j = 0;
      while (j < k)
      {
        localObject2 = arrayOfZzcgb[j];
        localObject3 = AppMeasurement.UserProperty.zzil(zziyd);
        if (localObject3 != null) {
          zziyd = ((String)localObject3);
        }
        j += 1;
      }
      i += 1;
    }
    paramString2.zzauf().trim(paramString1, (zzcfx[])localObject1);
    zziyq = null;
    try
    {
      i = localZzcge.zzhi();
      localObject1 = new byte[i];
      paramString2 = (String)localObject1;
      i = localObject1.length;
      localZzcge.multiply(zzeyf.toString(paramString2, 0, i));
    }
    catch (IOException paramString2)
    {
      zzaul().zzayf().append("Unable to serialize reduced-size config. Storing full config instead. appId", zzcbw.zzjf(paramString1), paramString2);
      paramString2 = paramArrayOfByte;
    }
    paramArrayOfByte = zzauf();
    zzbp.zzgg(paramString1);
    paramArrayOfByte.zzuj();
    paramArrayOfByte.zzwk();
    localObject1 = new ContentValues();
    ((ContentValues)localObject1).put("remote_config", paramString2);
    try
    {
      paramString2 = paramArrayOfByte.getWritableDatabase();
      i = paramString2.update("apps", (ContentValues)localObject1, "app_id = ?", new String[] { paramString1 });
      if (i == 0L)
      {
        paramArrayOfByte.zzaul().zzayd().append("Failed to update remote config (got 0). appId", zzcbw.zzjf(paramString1));
        return true;
      }
    }
    catch (SQLiteException paramString2)
    {
      paramArrayOfByte.zzaul().zzayd().append("Error storing remote config. appId", zzcbw.zzjf(paramString1), paramString2);
    }
    return true;
  }
  
  public final String zzan(String paramString1, String paramString2)
  {
    zzuj();
    zzjm(paramString1);
    paramString1 = (Map)zzirv.get(paramString1);
    if (paramString1 != null) {
      return (String)paramString1.get(paramString2);
    }
    return null;
  }
  
  public final boolean zzao(String paramString1, String paramString2)
  {
    zzuj();
    zzjm(paramString1);
    if ((zzauh().zzkg(paramString1)) && (zzcfw.zzkd(paramString2))) {
      return true;
    }
    if ((zzauh().zzkh(paramString1)) && (zzcfw.zzju(paramString2))) {
      return true;
    }
    paramString1 = (Map)zzirw.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = (Boolean)paramString1.get(paramString2);
      if (paramString1 == null) {
        return false;
      }
      return paramString1.booleanValue();
    }
    return false;
  }
  
  public final boolean zzap(String paramString1, String paramString2)
  {
    zzuj();
    zzjm(paramString1);
    if ("ecommerce_purchase".equals(paramString2)) {
      return true;
    }
    paramString1 = (Map)zzirx.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = (Boolean)paramString1.get(paramString2);
      if (paramString1 == null) {
        return false;
      }
      return paramString1.booleanValue();
    }
    return false;
  }
  
  public final void zzatu()
  {
    zzccw.zzatu();
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void zzatv()
  {
    zzcax.zzawk();
  }
  
  public final zzcge zzjn(String paramString)
  {
    zzwk();
    zzuj();
    zzbp.zzgg(paramString);
    zzjm(paramString);
    return (zzcge)zziry.get(paramString);
  }
  
  public final String zzjo(String paramString)
  {
    zzuj();
    return (String)zzirz.get(paramString);
  }
  
  public final void zzjp(String paramString)
  {
    zzuj();
    zzirz.put(paramString, null);
  }
  
  public final void zzjq(String paramString)
  {
    zzuj();
    zziry.remove(paramString);
  }
  
  public final void zzuk() {}
}
