package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbd;
import com.google.android.android.internal.zzbe;
import com.google.android.android.internal.zzbp;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public final class zzbw
  extends zzbr
{
  public static final String cachePath = zzbd.zzit.toString();
  public static final String zzjrk = zzbe.zzmn.toString();
  public static final String zzjrm = zzbe.zzqn.toString();
  public static final String zzjrq = zzbe.zzmd.toString();
  
  public zzbw()
  {
    super(cachePath, new String[] { zzjrk });
  }
  
  public final zzbp evaluate(Map paramMap)
  {
    Object localObject1 = (zzbp)paramMap.get(zzjrk);
    Object localObject2;
    if ((localObject1 != null) && (localObject1 != zzgk.zzjwp))
    {
      localObject2 = zzgk.toString((zzbp)localObject1);
      localObject1 = (zzbp)paramMap.get(zzjrq);
      if (localObject1 == null) {
        localObject1 = "MD5";
      } else {
        localObject1 = zzgk.toString((zzbp)localObject1);
      }
      paramMap = (zzbp)paramMap.get(zzjrm);
      if (paramMap == null) {
        paramMap = "text";
      } else {
        paramMap = zzgk.toString(paramMap);
      }
      if ("text".equals(paramMap))
      {
        paramMap = ((String)localObject2).getBytes();
      }
      else
      {
        if (!"base16".equals(paramMap)) {
          break label187;
        }
        paramMap = Base16.zzld((String)localObject2);
      }
    }
    try
    {
      localObject2 = MessageDigest.getInstance((String)localObject1);
      ((MessageDigest)localObject2).update(paramMap);
      paramMap = zzgk.zzah(Base16.encode(((MessageDigest)localObject2).digest()));
      return paramMap;
    }
    catch (NoSuchAlgorithmException paramMap)
    {
      for (;;) {}
    }
    paramMap = String.valueOf(localObject1);
    if (paramMap.length() != 0) {
      paramMap = "Hash: unknown algorithm: ".concat(paramMap);
    } else {
      paramMap = new String("Hash: unknown algorithm: ");
    }
    zzdj.zzjss.get(paramMap);
    return zzgk.zzjwp;
    label187:
    paramMap = String.valueOf(paramMap);
    if (paramMap.length() != 0) {
      paramMap = "Hash: unknown input format: ".concat(paramMap);
    } else {
      paramMap = new String("Hash: unknown input format: ");
    }
    zzdj.zzjss.get(paramMap);
    return zzgk.zzjwp;
    return zzgk.zzjwp;
  }
  
  public final boolean zzbcj()
  {
    return true;
  }
}
