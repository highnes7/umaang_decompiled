package com.google.android.android.internal;

import android.text.TextUtils;
import com.google.android.android.common.internal.zzbp;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzaoi
{
  public final Map<String, String> zzbqm;
  public final List<com.google.android.gms.internal.zzanp> zzdsw;
  public final long zzdsx;
  public final long zzdsy;
  public final int zzdsz;
  public final boolean zzdta;
  public final String zzdtb;
  
  public zzaoi(zzamr paramZzamr, Map paramMap, long paramLong, boolean paramBoolean)
  {
    this(paramZzamr, paramMap, paramLong, paramBoolean, 0L, 0, null);
  }
  
  public zzaoi(zzamr paramZzamr, Map paramMap, long paramLong1, boolean paramBoolean, long paramLong2, int paramInt)
  {
    this(paramZzamr, paramMap, paramLong1, paramBoolean, paramLong2, paramInt, null);
  }
  
  public zzaoi(zzamr paramZzamr, Map paramMap, long paramLong1, boolean paramBoolean, long paramLong2, int paramInt, List paramList)
  {
    zzbp.append(paramZzamr);
    zzbp.append(paramMap);
    zzdsy = paramLong1;
    zzdta = paramBoolean;
    zzdsx = paramLong2;
    zzdsz = paramInt;
    if (paramList != null) {
      localObject1 = paramList;
    } else {
      localObject1 = Collections.emptyList();
    }
    zzdsw = ((List)localObject1);
    zzdtb = a(paramList);
    paramList = new HashMap();
    Object localObject1 = paramMap.entrySet().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (matches(((Map.Entry)localObject2).getKey()))
      {
        String str = convert(paramZzamr, ((Map.Entry)localObject2).getKey());
        if (str != null) {
          paramList.put(str, trimString(paramZzamr, ((Map.Entry)localObject2).getValue()));
        }
      }
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      localObject1 = (Map.Entry)paramMap.next();
      if (!matches(((Map.Entry)localObject1).getKey()))
      {
        localObject2 = convert(paramZzamr, ((Map.Entry)localObject1).getKey());
        if (localObject2 != null) {
          paramList.put(localObject2, trimString(paramZzamr, ((Map.Entry)localObject1).getValue()));
        }
      }
    }
    if (!TextUtils.isEmpty(zzdtb))
    {
      zzapd.put(paramList, "_v", zzdtb);
      if ((zzdtb.equals("ma4.0.0")) || (zzdtb.equals("ma4.0.1"))) {
        paramList.remove("adid");
      }
    }
    zzbqm = Collections.unmodifiableMap(paramList);
  }
  
  public static String a(List paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        zzanp localZzanp = (zzanp)paramList.next();
        if ("appendVersion".equals(localZzanp.getId()))
        {
          paramList = localZzanp.getValue();
          break label52;
        }
      }
    }
    paramList = null;
    label52:
    if (TextUtils.isEmpty(paramList)) {
      return null;
    }
    return paramList;
  }
  
  public static String convert(zzamr paramZzamr, Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    Object localObject = paramObject.toString();
    paramObject = localObject;
    if (((String)localObject).startsWith("&")) {
      paramObject = ((String)localObject).substring(1);
    }
    int i = paramObject.length();
    localObject = paramObject;
    if (i > 256)
    {
      localObject = paramObject.substring(0, 256);
      paramObject = localObject;
      paramZzamr.append("Hit param name is too long and will be trimmed", Integer.valueOf(i), localObject);
      localObject = paramObject;
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    return localObject;
  }
  
  private final String getStringValue(String paramString1, String paramString2)
  {
    zzbp.zzgg(paramString1);
    zzbp.get(paramString1.startsWith("&") ^ true, "Short param name required");
    paramString1 = (String)zzbqm.get(paramString1);
    if (paramString1 != null) {
      return paramString1;
    }
    return paramString2;
  }
  
  public static boolean matches(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    return paramObject.toString().startsWith("&");
  }
  
  public static String trimString(zzamr paramZzamr, Object paramObject)
  {
    if (paramObject == null) {
      paramObject = "";
    } else {
      paramObject = paramObject.toString();
    }
    int i = paramObject.length();
    Object localObject = paramObject;
    if (i > 8192)
    {
      localObject = paramObject.substring(0, 8192);
      paramZzamr.append("Hit param value is too long and will be trimmed", Integer.valueOf(i), localObject);
    }
    return localObject;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = StringBuilder.getText("ht=");
    localStringBuffer.append(zzdsy);
    if (zzdsx != 0L)
    {
      localStringBuffer.append(", dbId=");
      localStringBuffer.append(zzdsx);
    }
    if (zzdsz != 0)
    {
      localStringBuffer.append(", appUID=");
      localStringBuffer.append(zzdsz);
    }
    ArrayList localArrayList = new ArrayList(zzbqm.keySet());
    Collections.sort(localArrayList);
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = localArrayList.get(i);
      i += 1;
      localObject = (String)localObject;
      localStringBuffer.append(", ");
      localStringBuffer.append((String)localObject);
      localStringBuffer.append("=");
      localStringBuffer.append((String)zzbqm.get(localObject));
    }
    return localStringBuffer.toString();
  }
  
  public final Map zziy()
  {
    return zzbqm;
  }
  
  public final int zzyl()
  {
    return zzdsz;
  }
  
  public final long zzym()
  {
    return zzdsx;
  }
  
  public final long zzyn()
  {
    return zzdsy;
  }
  
  public final List zzyo()
  {
    return zzdsw;
  }
  
  public final boolean zzyp()
  {
    return zzdta;
  }
  
  public final long zzyq()
  {
    return zzapd.zzea(getStringValue("_s", "0"));
  }
  
  public final String zzyr()
  {
    return getStringValue("_m", "");
  }
}
