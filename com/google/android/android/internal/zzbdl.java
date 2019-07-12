package com.google.android.android.internal;

import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.util.MD5;
import com.google.android.android.common.util.MultidimensionalCounter;
import com.google.android.android.common.util.Resources;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class zzbdl
{
  public zzbdl() {}
  
  public static void format(StringBuilder paramStringBuilder, zzbdm paramZzbdm, Object paramObject)
  {
    int i = zzfwq;
    if (i == 11) {
      paramZzbdm = ((zzbdl)zzfww.cast(paramObject)).toString();
    }
    for (;;)
    {
      paramStringBuilder.append(paramZzbdm);
      return;
      if (i != 7) {
        break;
      }
      paramZzbdm = "\"";
      paramStringBuilder.append("\"");
      paramStringBuilder.append(Resources.zzgl((String)paramObject));
    }
    paramStringBuilder.append(paramObject);
  }
  
  public static Object get(zzbdm paramZzbdm, Object paramObject)
  {
    Object localObject = paramObject;
    if (zzbdm.get0(paramZzbdm) != null) {
      localObject = paramZzbdm.convertBack(paramObject);
    }
    return localObject;
  }
  
  public static void processOptions(StringBuilder paramStringBuilder, zzbdm paramZzbdm, ArrayList paramArrayList)
  {
    paramStringBuilder.append("[");
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (i > 0) {
        paramStringBuilder.append(",");
      }
      Object localObject = paramArrayList.get(i);
      if (localObject != null) {
        format(paramStringBuilder, paramZzbdm, localObject);
      }
      i += 1;
    }
    paramStringBuilder.append("]");
  }
  
  public Object get(zzbdm paramZzbdm)
  {
    Object localObject = zzfwu;
    if (zzfww != null)
    {
      zzgi((String)localObject);
      zzbp.checkState(true, "Concrete field shouldn't be value object: %s", new Object[] { zzfwu });
      boolean bool = zzfwt;
      try
      {
        char c = Character.toUpperCase(((String)localObject).charAt(0));
        paramZzbdm = ((String)localObject).substring(1);
        int i = String.valueOf(paramZzbdm).length();
        localObject = new StringBuilder(i + 4);
        ((StringBuilder)localObject).append("get");
        ((StringBuilder)localObject).append(c);
        ((StringBuilder)localObject).append(paramZzbdm);
        paramZzbdm = ((StringBuilder)localObject).toString();
        localObject = getClass();
        paramZzbdm = ((Class)localObject).getMethod(paramZzbdm, new Class[0]);
        paramZzbdm = paramZzbdm.invoke(this, new Object[0]);
        return paramZzbdm;
      }
      catch (Exception paramZzbdm)
      {
        throw new RuntimeException(paramZzbdm);
      }
    }
    return zzgi((String)localObject);
  }
  
  public boolean getSize(zzbdm paramZzbdm)
  {
    if (zzfws == 11)
    {
      if (zzfwt)
      {
        paramZzbdm = zzfwu;
        throw new UnsupportedOperationException("Concrete type arrays not supported");
      }
      paramZzbdm = zzfwu;
      throw new UnsupportedOperationException("Concrete types not supported");
    }
    return zzgj(zzfwu);
  }
  
  public String toString()
  {
    Map localMap = zzzz();
    StringBuilder localStringBuilder = new StringBuilder(100);
    Iterator localIterator = localMap.keySet().iterator();
    String str1;
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      zzbdm localZzbdm = (zzbdm)localMap.get(str2);
      if (getSize(localZzbdm))
      {
        Object localObject = get(localZzbdm, get(localZzbdm));
        if (localStringBuilder.length() == 0) {
          str1 = "{";
        } else {
          str1 = ",";
        }
        f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, str1, "\"", str2, "\":");
        if (localObject == null) {
          localStringBuilder.append("null");
        } else {
          switch (zzfws)
          {
          default: 
            if (zzfwr) {
              processOptions(localStringBuilder, localZzbdm, (ArrayList)localObject);
            }
            break;
          case 10: 
            MultidimensionalCounter.toString(localStringBuilder, (HashMap)localObject);
            break;
          case 9: 
            localStringBuilder.append("\"");
            str1 = MD5.encode((byte[])localObject);
            break;
          case 8: 
            localStringBuilder.append("\"");
            str1 = MD5.decode((byte[])localObject);
            localStringBuilder.append(str1);
            localStringBuilder.append("\"");
            continue;
            format(localStringBuilder, localZzbdm, localObject);
          }
        }
      }
    }
    if (localStringBuilder.length() > 0) {
      str1 = "}";
    } else {
      str1 = "{}";
    }
    localStringBuilder.append(str1);
    return localStringBuilder.toString();
  }
  
  public abstract Object zzgi(String paramString);
  
  public abstract boolean zzgj(String paramString);
  
  public abstract Map zzzz();
}
