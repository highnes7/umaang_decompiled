package com.google.android.android.tagmanager;

import com.google.android.android.internal.zzbp;
import com.google.android.android.internal.zzeyn;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzgk
{
  public static final Object zzjwh;
  public static Long zzjwi = new Long(0L);
  public static Double zzjwj = new Double(0.0D);
  public static zzgj zzjwk = new zzgj(0L);
  public static String zzjwl = new String("");
  public static Boolean zzjwm = new Boolean(false);
  public static List<Object> zzjwn = new ArrayList(0);
  public static Map<Object, Object> zzjwo = new HashMap();
  public static zzbp zzjwp = zzah(zzjwl);
  
  public static Object get(zzbp paramZzbp)
  {
    if (paramZzbp == null) {
      return null;
    }
    int m = type;
    int j = 0;
    int k = 0;
    int i = 0;
    Object localObject1;
    Object localObject2;
    switch (m)
    {
    default: 
      paramZzbp = StringBuilder.add(46, "Failed to convert a value of type: ", m);
      break;
    case 8: 
      return Boolean.valueOf(zzyg);
    case 7: 
      localObject1 = new StringBuffer();
      paramZzbp = zzyh;
      j = paramZzbp.length;
      while (i < j)
      {
        localObject2 = toString(paramZzbp[i]);
        if (localObject2 == zzjwl) {
          return null;
        }
        ((StringBuffer)localObject1).append((String)localObject2);
        i += 1;
      }
      return ((StringBuffer)localObject1).toString();
    case 6: 
      return Long.valueOf(zzyf);
    case 5: 
      zzdj.zzjss.get("Trying to convert a function id to object");
      return null;
    case 4: 
      zzdj.zzjss.get("Trying to convert a macro reference to object");
      return null;
    case 3: 
      i = zzyb.length;
      localObject1 = zzyc;
      if (i != localObject1.length)
      {
        paramZzbp = String.valueOf(paramZzbp.toString());
        if (paramZzbp.length() != 0) {
          paramZzbp = "Converting an invalid value to object: ".concat(paramZzbp);
        } else {
          paramZzbp = new String("Converting an invalid value to object: ");
        }
        zzdj.zzjss.get(paramZzbp);
        return null;
      }
      localObject1 = new HashMap(localObject1.length);
      i = j;
      for (;;)
      {
        localObject2 = zzyb;
        if (i >= localObject2.length) {
          break label358;
        }
        localObject2 = get(localObject2[i]);
        Object localObject3 = get(zzyc[i]);
        if (localObject2 == null) {
          break;
        }
        if (localObject3 == null) {
          return null;
        }
        ((Map)localObject1).put(localObject2, localObject3);
        i += 1;
      }
      return null;
      return localObject1;
    case 2: 
      localObject1 = new ArrayList(zzya.length);
      paramZzbp = zzya;
      j = paramZzbp.length;
      i = k;
      while (i < j)
      {
        localObject2 = get(paramZzbp[i]);
        if (localObject2 == null) {
          return null;
        }
        ((ArrayList)localObject1).add(localObject2);
        i += 1;
      }
      return localObject1;
    case 1: 
      label358:
      return string;
    }
    zzdj.zzjss.get(paramZzbp);
    return null;
  }
  
  public static double getDouble(Object paramObject)
  {
    if ((paramObject instanceof Number)) {
      return ((Number)paramObject).doubleValue();
    }
    zzdj.zzjss.get("getDouble received non-Number");
    return 0.0D;
  }
  
  public static Long getFileSize(zzbp paramZzbp)
  {
    paramZzbp = get(paramZzbp);
    if (zzaj(paramZzbp)) {}
    for (long l = zzak(paramZzbp);; l = paramZzbp.longValue())
    {
      return Long.valueOf(l);
      paramZzbp = zzmg(zzag(paramZzbp));
      if (paramZzbp == zzjwk) {
        return zzjwi;
      }
    }
  }
  
  public static Double parseDouble(zzbp paramZzbp)
  {
    paramZzbp = get(paramZzbp);
    if (zzai(paramZzbp)) {}
    for (double d = getDouble(paramZzbp);; d = paramZzbp.doubleValue())
    {
      return Double.valueOf(d);
      paramZzbp = zzmg(zzag(paramZzbp));
      if (paramZzbp == zzjwk) {
        return zzjwj;
      }
    }
  }
  
  public static zzgj parseNumber(zzbp paramZzbp)
  {
    paramZzbp = get(paramZzbp);
    if ((paramZzbp instanceof zzgj)) {
      return (zzgj)paramZzbp;
    }
    if (zzaj(paramZzbp)) {
      return new zzgj(zzak(paramZzbp));
    }
    if (zzai(paramZzbp)) {
      return zzgj.parseDouble(Double.valueOf(getDouble(paramZzbp)));
    }
    return zzmg(zzag(paramZzbp));
  }
  
  public static String toString(zzbp paramZzbp)
  {
    return zzag(get(paramZzbp));
  }
  
  public static Boolean valueOf(zzbp paramZzbp)
  {
    paramZzbp = get(paramZzbp);
    if ((paramZzbp instanceof Boolean)) {
      return (Boolean)paramZzbp;
    }
    paramZzbp = zzag(paramZzbp);
    if ("true".equalsIgnoreCase(paramZzbp)) {
      return Boolean.TRUE;
    }
    if ("false".equalsIgnoreCase(paramZzbp)) {
      return Boolean.FALSE;
    }
    return zzjwm;
  }
  
  public static String zzag(Object paramObject)
  {
    if (paramObject == null) {
      return zzjwl;
    }
    return paramObject.toString();
  }
  
  public static zzbp zzah(Object paramObject)
  {
    zzbp localZzbp1 = new zzbp();
    if ((paramObject instanceof zzbp)) {
      return (zzbp)paramObject;
    }
    boolean bool2 = paramObject instanceof String;
    boolean bool1 = false;
    if (bool2) {
      type = 1;
    }
    for (paramObject = (String)paramObject;; paramObject = paramObject.toString())
    {
      string = paramObject;
      break label479;
      Object localObject1;
      Object localObject2;
      zzbp localZzbp2;
      if ((paramObject instanceof List))
      {
        type = 2;
        localObject1 = (List)paramObject;
        paramObject = new ArrayList(((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        bool1 = false;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = zzah(((Iterator)localObject1).next());
          localZzbp2 = zzjwp;
          if (localObject2 == localZzbp2) {
            return localZzbp2;
          }
          if ((!bool1) && (!zzyj)) {
            bool1 = false;
          } else {
            bool1 = true;
          }
          paramObject.add(localObject2);
        }
        zzya = ((zzbp[])paramObject.toArray(new zzbp[0]));
        break label479;
      }
      if ((paramObject instanceof Map))
      {
        type = 3;
        localObject2 = ((Map)paramObject).entrySet();
        paramObject = new ArrayList(((Set)localObject2).size());
        localObject1 = new ArrayList(((Set)localObject2).size());
        localObject2 = ((Set)localObject2).iterator();
        bool1 = false;
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
          localZzbp2 = zzah(((Map.Entry)localObject3).getKey());
          localObject3 = zzah(((Map.Entry)localObject3).getValue());
          zzbp localZzbp3 = zzjwp;
          if ((localZzbp2 != localZzbp3) && (localObject3 != localZzbp3))
          {
            if ((!bool1) && (!zzyj) && (!zzyj)) {
              bool1 = false;
            } else {
              bool1 = true;
            }
            paramObject.add(localZzbp2);
            ((List)localObject1).add(localObject3);
          }
          else
          {
            return zzjwp;
          }
        }
        zzyb = ((zzbp[])paramObject.toArray(new zzbp[0]));
        zzyc = ((zzbp[])((List)localObject1).toArray(new zzbp[0]));
        break label479;
      }
      if (!zzai(paramObject)) {
        break;
      }
      type = 1;
    }
    if (zzaj(paramObject))
    {
      type = 6;
      zzyf = zzak(paramObject);
    }
    else
    {
      if (!(paramObject instanceof Boolean)) {
        break label486;
      }
      type = 8;
      zzyg = ((Boolean)paramObject).booleanValue();
    }
    label479:
    zzyj = bool1;
    return localZzbp1;
    label486:
    if (paramObject == null) {
      paramObject = "null";
    } else {
      paramObject = paramObject.getClass().toString();
    }
    paramObject = String.valueOf(paramObject);
    if (paramObject.length() != 0) {
      paramObject = "Converting to Value from unknown object type: ".concat(paramObject);
    } else {
      paramObject = new String("Converting to Value from unknown object type: ");
    }
    zzdj.zzjss.get(paramObject);
    return zzjwp;
  }
  
  public static boolean zzai(Object paramObject)
  {
    return ((paramObject instanceof Double)) || ((paramObject instanceof Float)) || (((paramObject instanceof zzgj)) && (((zzgj)paramObject).zzbfd()));
  }
  
  public static boolean zzaj(Object paramObject)
  {
    return ((paramObject instanceof Byte)) || ((paramObject instanceof Short)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Long)) || (((paramObject instanceof zzgj)) && (((zzgj)paramObject).zzbfe()));
  }
  
  public static long zzak(Object paramObject)
  {
    if ((paramObject instanceof Number)) {
      return ((Number)paramObject).longValue();
    }
    zzdj.zzjss.get("getInt64 received non-Number");
    return 0L;
  }
  
  public static Object zzbff()
  {
    return null;
  }
  
  public static Long zzbfg()
  {
    return zzjwi;
  }
  
  public static Double zzbfh()
  {
    return zzjwj;
  }
  
  public static Boolean zzbfi()
  {
    return zzjwm;
  }
  
  public static zzgj zzbfj()
  {
    return zzjwk;
  }
  
  public static String zzbfk()
  {
    return zzjwl;
  }
  
  public static zzbp zzbfl()
  {
    return zzjwp;
  }
  
  public static zzbp zzmf(String paramString)
  {
    zzbp localZzbp = new zzbp();
    type = 5;
    zzye = paramString;
    return localZzbp;
  }
  
  public static zzgj zzmg(String paramString)
  {
    try
    {
      zzgj localZzgj = zzgj.zzme(paramString);
      return localZzgj;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
    paramString = StringBuilder.append(StringBuilder.append(paramString, 33), "Failed to convert '", paramString, "' to a number.");
    zzdj.zzjss.get(paramString);
    return zzjwk;
  }
}
