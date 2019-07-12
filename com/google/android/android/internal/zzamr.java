package com.google.android.android.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.android.analytics.GoogleAnalytics;
import com.google.android.android.analytics.TerminalManager;
import com.google.android.android.common.internal.zzbp;

public class zzamr
{
  public final zzamu zzdod;
  
  public zzamr(zzamu paramZzamu)
  {
    zzbp.append(paramZzamu);
    zzdod = paramZzamu;
  }
  
  private final void get(int paramInt, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Object localObject = zzdod;
    if (localObject != null) {
      localObject = ((zzamu)localObject).zzwm();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      String str = (String)zzaod.zzdrb.setDoOutput();
      if (android.util.Log.isLoggable(str, paramInt)) {
        android.util.Log.println(paramInt, str, replace(paramString, paramObject1, paramObject2, paramObject3));
      }
      if (paramInt >= 5) {
        ((zzaon)localObject).init(paramInt, paramString, paramObject1, paramObject2, paramObject3);
      }
    }
    else
    {
      localObject = (String)zzaod.zzdrb.setDoOutput();
      if (android.util.Log.isLoggable((String)localObject, paramInt)) {
        android.util.Log.println(paramInt, (String)localObject, replace(paramString, paramObject1, paramObject2, paramObject3));
      }
    }
  }
  
  public static String getValue(Object paramObject)
  {
    if (paramObject == null) {
      return "";
    }
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if ((paramObject instanceof Boolean))
    {
      if (paramObject == Boolean.TRUE) {
        return "true";
      }
      return "false";
    }
    if ((paramObject instanceof Throwable)) {
      return ((Throwable)paramObject).toString();
    }
    return paramObject.toString();
  }
  
  public static String replace(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    String str2 = "";
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    String str3 = getValue(paramObject1);
    paramObject2 = getValue(paramObject2);
    paramObject3 = getValue(paramObject3);
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = str2;
    if (!TextUtils.isEmpty(str1))
    {
      localStringBuilder.append(str1);
      paramString = ": ";
    }
    paramObject1 = paramString;
    if (!TextUtils.isEmpty(str3))
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(str3);
      paramObject1 = ", ";
    }
    paramString = paramObject1;
    if (!TextUtils.isEmpty(paramObject2))
    {
      localStringBuilder.append(paramObject1);
      localStringBuilder.append(paramObject2);
      paramString = ", ";
    }
    if (!TextUtils.isEmpty(paramObject3))
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(paramObject3);
    }
    return localStringBuilder.toString();
  }
  
  public static boolean zzqu()
  {
    return android.util.Log.isLoggable((String)zzaod.zzdrb.setDoOutput(), 2);
  }
  
  public final void a(String paramString, Object paramObject1, Object paramObject2)
  {
    get(6, paramString, paramObject1, paramObject2, null);
  }
  
  public final void add(String paramString, Object paramObject)
  {
    get(3, paramString, paramObject, null, null);
  }
  
  public final void add(String paramString, Object paramObject1, Object paramObject2)
  {
    get(2, paramString, paramObject1, paramObject2, null);
  }
  
  public final void append(String paramString, Object paramObject)
  {
    get(5, paramString, paramObject, null, null);
  }
  
  public final void append(String paramString, Object paramObject1, Object paramObject2)
  {
    get(5, paramString, paramObject1, paramObject2, null);
  }
  
  public final void d(String paramString, Object paramObject)
  {
    get(2, paramString, paramObject, null, null);
  }
  
  public final Context getContext()
  {
    return zzdod.getContext();
  }
  
  public final void info(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    get(3, paramString, paramObject1, paramObject2, paramObject3);
  }
  
  public final void toString(String paramString, Object paramObject)
  {
    get(6, paramString, paramObject, null, null);
  }
  
  public final void usage(String paramString, Object paramObject)
  {
    get(4, paramString, paramObject, null, null);
  }
  
  public final void warn(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    get(5, paramString, paramObject1, paramObject2, paramObject3);
  }
  
  public final void write(String paramString, Object paramObject1, Object paramObject2)
  {
    get(3, paramString, paramObject1, paramObject2, null);
  }
  
  public final void zzdm(String paramString)
  {
    get(2, paramString, null, null, null);
  }
  
  public final void zzdn(String paramString)
  {
    get(3, paramString, null, null, null);
  }
  
  public final void zzdo(String paramString)
  {
    get(4, paramString, null, null, null);
  }
  
  public final void zzdp(String paramString)
  {
    get(5, paramString, null, null, null);
  }
  
  public final void zzdq(String paramString)
  {
    get(6, paramString, null, null, null);
  }
  
  public final zzamu zzvw()
  {
    return zzdod;
  }
  
  public final com.google.android.android.common.util.Log zzvx()
  {
    return zzdod.zzvx();
  }
  
  public final zzaon zzvy()
  {
    return zzdod.zzvy();
  }
  
  public final zzanv zzvz()
  {
    return zzdod.zzvz();
  }
  
  public final TerminalManager zzwa()
  {
    return zzdod.zzwa();
  }
  
  public final GoogleAnalytics zzwb()
  {
    return zzdod.zzwn();
  }
  
  public final zzamj zzwc()
  {
    return zzdod.zzwc();
  }
  
  public final zzaoa zzwd()
  {
    return zzdod.zzwd();
  }
  
  public final zzape zzwe()
  {
    return zzdod.zzwe();
  }
  
  public final zzaor zzwf()
  {
    return zzdod.zzwf();
  }
  
  public final zzanm zzwg()
  {
    return zzdod.zzwq();
  }
  
  public final zzami zzwh()
  {
    return zzdod.zzwp();
  }
  
  public final zzanf zzwi()
  {
    return zzdod.zzwi();
  }
  
  public final zzanz zzwj()
  {
    return zzdod.zzwj();
  }
}
