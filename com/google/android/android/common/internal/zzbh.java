package com.google.android.android.common.internal;

import java.util.ArrayList;
import java.util.List;

public final class zzbh
{
  public final Object zzdef;
  public final List<String> zzfvq;
  
  public zzbh(Object paramObject)
  {
    zzbp.append(paramObject);
    zzdef = paramObject;
    zzfvq = new ArrayList();
  }
  
  public final zzbh add(String paramString, Object paramObject)
  {
    List localList = zzfvq;
    zzbp.append(paramString);
    paramString = (String)paramString;
    paramObject = String.valueOf(paramObject);
    int i = f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramString, 1);
    StringBuilder localStringBuilder = new StringBuilder(paramObject.length() + i);
    localStringBuilder.append(paramString);
    localStringBuilder.append("=");
    localStringBuilder.append(paramObject);
    localList.add(localStringBuilder.toString());
    return this;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(zzdef.getClass().getSimpleName());
    localStringBuilder.append('{');
    int j = zzfvq.size();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append((String)zzfvq.get(i));
      if (i < j - 1) {
        localStringBuilder.append(", ");
      }
      i += 1;
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
