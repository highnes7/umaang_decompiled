package com.google.android.android.internal;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.android.common.internal.zzbp;
import com.google.android.gms.measurement.AppMeasurement;

public final class zzcbw
  extends zzcdu
{
  public final String zzfvk = zzcax.zzavl();
  public final long zzilg;
  public final char zzipr;
  public final zzcby zzips;
  public final zzcby zzipt;
  public final zzcby zzipu;
  public final zzcby zzipv;
  public final zzcby zzipw;
  public final zzcby zzipx;
  public final zzcby zzipy;
  public final zzcby zzipz;
  public final zzcby zziqa;
  
  public zzcbw(zzccw paramZzccw)
  {
    super(paramZzccw);
    zzcax.zzauv();
    zzilg = 11400L;
    char c;
    if (zzaun().zzxu())
    {
      zzcax.zzawk();
      c = 'C';
    }
    else
    {
      zzcax.zzawk();
      c = 'c';
    }
    zzipr = c;
    zzips = new zzcby(this, 6, false, false);
    zzipt = new zzcby(this, 6, true, false);
    zzipu = new zzcby(this, 6, false, true);
    zzipv = new zzcby(this, 5, false, false);
    zzipw = new zzcby(this, 5, true, false);
    zzipx = new zzcby(this, 5, false, true);
    zzipy = new zzcby(this, 4, false, false);
    zzipz = new zzcby(this, 3, false, false);
    zziqa = new zzcby(this, 2, false, false);
  }
  
  public static String format(boolean paramBoolean, Object paramObject)
  {
    String str1 = "";
    if (paramObject == null) {
      return "";
    }
    Object localObject1 = paramObject;
    if ((paramObject instanceof Integer)) {
      localObject1 = Long.valueOf(((Integer)paramObject).intValue());
    }
    boolean bool = localObject1 instanceof Long;
    int i = 0;
    Object localObject2;
    if (bool)
    {
      if (!paramBoolean) {
        return String.valueOf(localObject1);
      }
      localObject2 = (Long)localObject1;
      if (Math.abs(((Long)localObject2).longValue()) < 100L) {
        return String.valueOf(localObject1);
      }
      paramObject = str1;
      if (String.valueOf(localObject1).charAt(0) == '-') {
        paramObject = "-";
      }
      localObject1 = String.valueOf(Math.abs(((Long)localObject2).longValue()));
      long l1 = Math.round(Math.pow(10.0D, ((String)localObject1).length() - 1));
      long l2 = Math.round(Math.pow(10.0D, ((String)localObject1).length()) - 1.0D);
      i = paramObject.length();
      localObject1 = new StringBuilder(paramObject.length() + (i + 43));
      ((StringBuilder)localObject1).append(paramObject);
      ((StringBuilder)localObject1).append(l1);
      ((StringBuilder)localObject1).append("...");
      ((StringBuilder)localObject1).append(paramObject);
      ((StringBuilder)localObject1).append(l2);
      return ((StringBuilder)localObject1).toString();
    }
    if ((localObject1 instanceof Boolean)) {
      return String.valueOf(localObject1);
    }
    if ((localObject1 instanceof Throwable))
    {
      localObject2 = (Throwable)localObject1;
      if (paramBoolean) {
        paramObject = localObject2.getClass().getName();
      } else {
        paramObject = ((Throwable)localObject2).toString();
      }
      paramObject = new StringBuilder(paramObject);
      localObject1 = zzjg(AppMeasurement.class.getCanonicalName());
      str1 = zzjg(com.google.android.gms.internal.zzccw.class.getCanonicalName());
      localObject2 = ((Throwable)localObject2).getStackTrace();
      int j = localObject2.length;
      while (i < j)
      {
        Object localObject3 = localObject2[i];
        if (!localObject3.isNativeMethod())
        {
          String str2 = localObject3.getClassName();
          if (str2 != null)
          {
            str2 = zzjg(str2);
            if ((str2.equals(localObject1)) || (str2.equals(str1)))
            {
              paramObject.append(": ");
              paramObject.append(localObject3);
              break;
            }
          }
        }
        i += 1;
      }
      return paramObject.toString();
    }
    if ((localObject1 instanceof zzcbz)) {
      return zzgql;
    }
    if (paramBoolean) {
      return "-";
    }
    return String.valueOf(localObject1);
  }
  
  public static String toString(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    String str2 = "";
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    String str3 = format(paramBoolean, paramObject1);
    paramObject2 = format(paramBoolean, paramObject2);
    paramObject3 = format(paramBoolean, paramObject3);
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
  
  public static Object zzjf(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return new zzcbz(paramString);
  }
  
  public static String zzjg(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = paramString.lastIndexOf('.');
    if (i == -1) {
      return paramString;
    }
    return paramString.substring(0, i);
  }
  
  public final void add(int paramInt, String paramString)
  {
    Log.println(paramInt, zzfvk, paramString);
  }
  
  public final void add(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((!paramBoolean1) && (zzad(paramInt))) {
      add(paramInt, toString(false, paramString, paramObject1, paramObject2, paramObject3));
    }
    if ((!paramBoolean2) && (paramInt >= 5))
    {
      zzbp.append(paramString);
      zzccr localZzccr = zziki.zzayx();
      if (localZzccr == null)
      {
        paramString = "Scheduler not set. Not logging error/warn";
      }
      else
      {
        if (localZzccr.isInitialized()) {
          break label88;
        }
        paramString = "Scheduler not initialized. Not logging error/warn";
      }
      add(6, paramString);
      return;
      label88:
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      paramInt = i;
      if (i >= 9) {
        paramInt = 8;
      }
      char c1 = "01VDIWEA?".charAt(paramInt);
      char c2 = zzipr;
      long l = zzilg;
      paramObject1 = toString(true, paramString, paramObject1, paramObject2, paramObject3);
      paramObject2 = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramObject1, "2".length() + 23));
      paramObject2.append("2");
      paramObject2.append(c1);
      paramObject2.append(c2);
      paramObject2.append(l);
      paramObject2.append(":");
      paramObject2.append(paramObject1);
      paramObject2 = paramObject2.toString();
      paramObject1 = paramObject2;
      if (paramObject2.length() > 1024) {
        paramObject1 = paramString.substring(0, 1024);
      }
      localZzccr.e(new zzcbx(this, paramObject1));
    }
  }
  
  public final boolean zzad(int paramInt)
  {
    return Log.isLoggable(zzfvk, paramInt);
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
  
  public final zzcby zzayd()
  {
    return zzips;
  }
  
  public final zzcby zzaye()
  {
    return zzipt;
  }
  
  public final zzcby zzayf()
  {
    return zzipv;
  }
  
  public final zzcby zzayg()
  {
    return zzipx;
  }
  
  public final zzcby zzayh()
  {
    return zzipy;
  }
  
  public final zzcby zzayi()
  {
    return zzipz;
  }
  
  public final zzcby zzayj()
  {
    return zziqa;
  }
  
  public final String zzayk()
  {
    Object localObject = zzaumzziqo.zzzi();
    if ((localObject != null) && (localObject != zzcch.zziqn))
    {
      String str = String.valueOf(second);
      localObject = (String)first;
      return f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append(localObject, str.length() + 1), str, ":", (String)localObject);
    }
    return null;
  }
  
  public final void zzuk() {}
}
