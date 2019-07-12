package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbd;
import com.google.android.android.internal.zzbe;
import com.google.android.android.internal.zzbp;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzcy
  extends zzbr
{
  public static final String cachePath = zzbd.zziv.toString();
  public static final String zzjrk = zzbe.zzmn.toString();
  public static final String zzjsc = zzbe.zzqs.toString();
  public static final String zzjsd = zzbe.zzqw.toString();
  public static final String zzjse = zzbe.zzpm.toString();
  
  public zzcy()
  {
    super(cachePath, new String[] { zzjrk });
  }
  
  public static void addTo(Set paramSet, String paramString)
  {
    int i = 0;
    while (i < paramString.length())
    {
      paramSet.add(Character.valueOf(paramString.charAt(i)));
      i += 1;
    }
  }
  
  public static void append(StringBuilder paramStringBuilder, String paramString, int paramInt, Set paramSet)
  {
    paramStringBuilder.append(escape(paramString, paramInt, paramSet));
  }
  
  public static String escape(String paramString, int paramInt, Set paramSet)
  {
    paramInt = zzcz.zzjsf[(paramInt - 1)];
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return paramString;
      }
      paramString = paramString.replace("\\", "\\\\");
      Iterator localIterator = paramSet.iterator();
      while (localIterator.hasNext())
      {
        String str = ((Character)localIterator.next()).toString();
        paramSet = String.valueOf(str);
        if (paramSet.length() != 0) {
          paramSet = "\\".concat(paramSet);
        } else {
          paramSet = new String("\\");
        }
        paramString = paramString.replace(str, paramSet);
      }
      return paramString;
    }
    try
    {
      paramSet = zzgo.zzmj(paramString);
      return paramSet;
    }
    catch (UnsupportedEncodingException paramSet)
    {
      zzdj.zzjss.e("Joiner: unsupported encoding", paramSet);
    }
    return paramString;
  }
  
  public final zzbp evaluate(Map paramMap)
  {
    zzbp localZzbp = (zzbp)paramMap.get(zzjrk);
    if (localZzbp == null) {
      return zzgk.zzjwp;
    }
    Object localObject1 = (zzbp)paramMap.get(zzjsc);
    if (localObject1 != null) {
      localObject1 = zzgk.toString((zzbp)localObject1);
    } else {
      localObject1 = "";
    }
    Object localObject2 = (zzbp)paramMap.get(zzjsd);
    if (localObject2 != null) {
      localObject2 = zzgk.toString((zzbp)localObject2);
    } else {
      localObject2 = "=";
    }
    int i = zzda.zzjsg;
    Object localObject3 = (zzbp)paramMap.get(zzjse);
    StringBuilder localStringBuilder = null;
    paramMap = localStringBuilder;
    if (localObject3 != null)
    {
      paramMap = zzgk.toString((zzbp)localObject3);
      if ("url".equals(paramMap))
      {
        i = zzda.zzjsh;
        paramMap = localStringBuilder;
      }
      else if ("backslash".equals(paramMap))
      {
        i = zzda.zzjsi;
        paramMap = new HashSet();
        addTo(paramMap, (String)localObject1);
        addTo(paramMap, (String)localObject2);
        paramMap.remove(Character.valueOf('\\'));
      }
      else
      {
        paramMap = String.valueOf(paramMap);
        if (paramMap.length() != 0) {
          paramMap = "Joiner: unsupported escape type: ".concat(paramMap);
        } else {
          paramMap = new String("Joiner: unsupported escape type: ");
        }
        zzdj.zzjss.get(paramMap);
        return zzgk.zzjwp;
      }
    }
    localStringBuilder = new StringBuilder();
    int k = type;
    int j = 0;
    if (k != 2)
    {
      if (k != 3) {
        append(localStringBuilder, zzgk.toString(localZzbp), i, paramMap);
      } else {
        while (j < zzyb.length)
        {
          if (j > 0) {
            localStringBuilder.append((String)localObject1);
          }
          localObject3 = zzgk.toString(zzyb[j]);
          String str = zzgk.toString(zzyc[j]);
          append(localStringBuilder, (String)localObject3, i, paramMap);
          localStringBuilder.append((String)localObject2);
          append(localStringBuilder, str, i, paramMap);
          j += 1;
        }
      }
    }
    else
    {
      localObject2 = zzya;
      int m = localObject2.length;
      k = 0;
      for (j = 1; k < m; j = 0)
      {
        localZzbp = localObject2[k];
        if (j == 0) {
          localStringBuilder.append((String)localObject1);
        }
        append(localStringBuilder, zzgk.toString(localZzbp), i, paramMap);
        k += 1;
      }
    }
    return zzgk.zzah(localStringBuilder.toString());
  }
  
  public final boolean zzbcj()
  {
    return true;
  }
}
