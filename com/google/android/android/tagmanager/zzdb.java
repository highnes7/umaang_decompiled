package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbe;
import com.google.android.android.internal.zzbp;
import com.google.android.android.internal.zzdbr;
import com.google.android.android.internal.zzdbs;
import com.google.android.android.internal.zzdbt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdb
{
  public static Object zzaf(Object paramObject)
    throws JSONException
  {
    if (!(paramObject instanceof JSONArray))
    {
      if (!JSONObject.NULL.equals(paramObject))
      {
        if ((paramObject instanceof JSONObject))
        {
          paramObject = (JSONObject)paramObject;
          HashMap localHashMap = new HashMap();
          Iterator localIterator = paramObject.keys();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localHashMap.put(str, zzaf(paramObject.get(str)));
          }
          return localHashMap;
        }
        return paramObject;
      }
      throw new RuntimeException("JSON nulls are not supported");
    }
    paramObject = new RuntimeException("JSONArrays are not supported");
    throw paramObject;
  }
  
  public static zzdbs zzlv(String paramString)
    throws JSONException
  {
    paramString = zzgk.zzah(zzaf(new JSONObject(paramString)));
    zzdbt localZzdbt = new zzdbt();
    int i = 0;
    while (i < zzyb.length)
    {
      localZzdbt.downloadBook(new zzdbr().lookup(zzbe.zzqo.toString(), zzyb[i]).lookup(zzbe.zzqc.toString(), zzgk.zzmf(Way.NAME)).lookup(Way.VALUE, zzyc[i]).zzbhw());
      i += 1;
    }
    return localZzdbt.zzbhz();
  }
}
