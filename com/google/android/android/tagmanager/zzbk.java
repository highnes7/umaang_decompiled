package com.google.android.android.tagmanager;

import android.util.Base64;
import com.google.android.android.internal.zzbd;
import com.google.android.android.internal.zzbe;
import com.google.android.android.internal.zzbp;
import java.util.Map;

public final class zzbk
  extends zzbr
{
  public static final String cachePath = zzbd.zzir.toString();
  public static final String zzjrk = zzbe.zzmn.toString();
  public static final String zzjrl = zzbe.zzru.toString();
  public static final String zzjrm = zzbe.zzqn.toString();
  public static final String zzjrn = zzbe.zzse.toString();
  
  public zzbk()
  {
    super(cachePath, new String[] { zzjrk });
  }
  
  public final zzbp evaluate(Map paramMap)
  {
    Object localObject = (zzbp)paramMap.get(zzjrk);
    String str2;
    String str1;
    int i;
    if ((localObject != null) && (localObject != zzgk.zzjwp))
    {
      str2 = zzgk.toString((zzbp)localObject);
      localObject = (zzbp)paramMap.get(zzjrm);
      if (localObject == null) {
        str1 = "text";
      } else {
        str1 = zzgk.toString((zzbp)localObject);
      }
      localObject = (zzbp)paramMap.get(zzjrn);
      if (localObject == null) {
        localObject = "base16";
      } else {
        localObject = zzgk.toString((zzbp)localObject);
      }
      int j = 2;
      paramMap = (zzbp)paramMap.get(zzjrl);
      i = j;
      if (paramMap != null)
      {
        i = j;
        if (zzgk.valueOf(paramMap).booleanValue()) {
          i = 3;
        }
      }
    }
    for (;;)
    {
      try
      {
        bool = "text".equals(str1);
        if (!bool) {}
      }
      catch (IllegalArgumentException paramMap)
      {
        boolean bool;
        continue;
      }
      try
      {
        paramMap = str2.getBytes();
        continue;
        bool = "base16".equals(str1);
        if (bool)
        {
          paramMap = Base16.zzld(str2);
        }
        else
        {
          bool = "base64".equals(str1);
          if (bool)
          {
            paramMap = Base64.decode(str2, i);
          }
          else
          {
            bool = "base64url".equals(str1);
            if (!bool) {
              continue;
            }
            paramMap = Base64.decode(str2, i | 0x8);
          }
        }
        if ("base16".equals(localObject))
        {
          paramMap = Base16.encode(paramMap);
        }
        else if ("base64".equals(localObject))
        {
          paramMap = Base64.encodeToString(paramMap, i);
        }
        else
        {
          if (!"base64url".equals(localObject)) {
            continue;
          }
          paramMap = Base64.encodeToString(paramMap, i | 0x8);
        }
        return zzgk.zzah(paramMap);
        paramMap = String.valueOf(localObject);
        if (paramMap.length() != 0) {
          paramMap = "Encode: unknown output format: ".concat(paramMap);
        } else {
          paramMap = new String("Encode: unknown output format: ");
        }
        zzdj.zzjss.get(paramMap);
        return zzgk.zzjwp;
      }
      catch (IllegalArgumentException paramMap)
      {
        continue;
      }
      try
      {
        paramMap = String.valueOf(str1);
        i = paramMap.length();
        if (i != 0) {
          paramMap = "Encode: unknown input format: ".concat(paramMap);
        } else {
          paramMap = new String("Encode: unknown input format: ");
        }
        localObject = zzdj.zzjss;
        ((zzdk)localObject).get(paramMap);
        return zzgk.zzjwp;
      }
      catch (IllegalArgumentException paramMap) {}
    }
    zzdj.zzjss.get("Encode: invalid input:");
    return zzgk.zzjwp;
    return zzgk.zzjwp;
  }
  
  public final boolean zzbcj()
  {
    return true;
  }
}
