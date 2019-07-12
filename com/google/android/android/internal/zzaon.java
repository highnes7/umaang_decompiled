package com.google.android.android.internal;

import com.google.android.android.common.internal.zzbp;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzaon
  extends zzams
{
  public static zzaon zzdti;
  
  public zzaon(zzamu paramZzamu)
  {
    super(paramZzamu);
  }
  
  public static String format(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    Object localObject1 = paramObject;
    if ((paramObject instanceof Integer)) {
      localObject1 = Long.valueOf(((Integer)paramObject).intValue());
    }
    boolean bool = localObject1 instanceof Long;
    paramObject = "-";
    if (bool)
    {
      Object localObject2 = (Long)localObject1;
      if (Math.abs(((Long)localObject2).longValue()) < 100L) {
        return String.valueOf(localObject1);
      }
      if (String.valueOf(localObject1).charAt(0) != '-') {
        paramObject = "";
      }
      localObject1 = String.valueOf(Math.abs(((Long)localObject2).longValue()));
      localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramObject);
      ((StringBuilder)localObject2).append(Math.round(Math.pow(10.0D, ((String)localObject1).length() - 1)));
      ((StringBuilder)localObject2).append("...");
      ((StringBuilder)localObject2).append(paramObject);
      ((StringBuilder)localObject2).append(Math.round(Math.pow(10.0D, ((String)localObject1).length()) - 1.0D));
      return ((StringBuilder)localObject2).toString();
    }
    if ((localObject1 instanceof Boolean)) {
      return String.valueOf(localObject1);
    }
    if ((localObject1 instanceof Throwable)) {
      return localObject1.getClass().getCanonicalName();
    }
    return "-";
  }
  
  public static zzaon zzyt()
  {
    return zzdti;
  }
  
  public final void append(zzaoi paramZzaoi, String paramString)
  {
    if (paramZzaoi != null) {
      paramZzaoi = paramZzaoi.toString();
    } else {
      paramZzaoi = "no hit data";
    }
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramString = "Discarding hit. ".concat(paramString);
    } else {
      paramString = new String("Discarding hit. ");
    }
    append(paramString, paramZzaoi);
  }
  
  public final void init(int paramInt, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    int i;
    char c1;
    try
    {
      zzbp.append(paramString);
      i = paramInt;
      if (paramInt >= 0) {
        break label196;
      }
      i = 0;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
    if (zzvz().zzxu()) {
      c1 = 'C';
    }
    for (;;)
    {
      char c2 = "01VDIWEA?".charAt(paramInt);
      String str = zzamt.VERSION;
      paramString = zzamr.replace(paramString, format(paramObject1), format(paramObject2), format(paramObject3));
      paramObject1 = new StringBuilder("3".length() + 3 + String.valueOf(str).length() + String.valueOf(paramString).length());
      paramObject1.append("3");
      paramObject1.append(c2);
      paramObject1.append(c1);
      paramObject1.append(str);
      paramObject1.append(":");
      paramObject1.append(paramString);
      paramObject1 = paramObject1.toString();
      paramString = paramObject1;
      if (paramObject1.length() > 1024) {
        paramString = paramObject1.substring(0, 1024);
      }
      paramObject1 = zzvw().zzwo();
      if (paramObject1 != null) {
        paramObject1.zzzg().zzdy(paramString);
      }
      return;
      label196:
      paramInt = i;
      if (i < 9) {
        break;
      }
      paramInt = 8;
      break;
      c1 = 'c';
    }
  }
  
  public final void write(Map paramMap, String paramString)
  {
    if (paramMap != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append(',');
        }
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append('=');
        localStringBuilder.append((String)localEntry.getValue());
      }
      paramMap = localStringBuilder.toString();
    }
    else
    {
      paramMap = "no hit data";
    }
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramString = "Discarding hit. ".concat(paramString);
    } else {
      paramString = new String("Discarding hit. ");
    }
    append(paramString, paramMap);
  }
  
  public final void zzuk()
  {
    try
    {
      zzdti = this;
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
