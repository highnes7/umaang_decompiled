package com.google.android.android.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzh;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public abstract class Log<T extends zzh>
{
  public Log() {}
  
  public static String getID(Object paramObject)
  {
    return toString(paramObject, 0);
  }
  
  public static String getID(Map paramMap)
  {
    return toString(paramMap, 1);
  }
  
  public static String toString(Object paramObject, int paramInt)
  {
    if (paramInt > 10) {
      return "ERROR: Recursive toString calls";
    }
    if (paramObject == null) {
      return "";
    }
    if ((paramObject instanceof String))
    {
      if (TextUtils.isEmpty((String)paramObject)) {
        return "";
      }
      return paramObject.toString();
    }
    if ((paramObject instanceof Integer))
    {
      if (((Integer)paramObject).intValue() == 0) {
        return "";
      }
      return paramObject.toString();
    }
    if ((paramObject instanceof Long))
    {
      if (((Long)paramObject).longValue() == 0L) {
        return "";
      }
      return paramObject.toString();
    }
    if ((paramObject instanceof Double))
    {
      if (((Double)paramObject).doubleValue() == 0.0D) {
        return "";
      }
      return paramObject.toString();
    }
    if ((paramObject instanceof Boolean))
    {
      if (!((Boolean)paramObject).booleanValue()) {
        return "";
      }
      return paramObject.toString();
    }
    StringBuffer localStringBuffer;
    int i;
    Object localObject;
    if ((paramObject instanceof List))
    {
      localStringBuffer = new StringBuffer();
      if (paramInt > 0) {
        localStringBuffer.append("[");
      }
      paramObject = (List)paramObject;
      i = localStringBuffer.length();
      paramObject = paramObject.iterator();
      while (paramObject.hasNext())
      {
        localObject = paramObject.next();
        if (localStringBuffer.length() > i) {
          localStringBuffer.append(", ");
        }
        localStringBuffer.append(toString(localObject, paramInt + 1));
      }
      if (paramInt > 0) {
        localStringBuffer.append("]");
      }
      return localStringBuffer.toString();
    }
    if ((paramObject instanceof Map))
    {
      localStringBuffer = new StringBuffer();
      paramObject = new TreeMap((Map)paramObject).entrySet().iterator();
      int k = 0;
      i = 0;
      while (paramObject.hasNext())
      {
        localObject = (Map.Entry)paramObject.next();
        String str = toString(((Map.Entry)localObject).getValue(), paramInt + 1);
        if (!TextUtils.isEmpty(str))
        {
          int m = k;
          int j = i;
          if (paramInt > 0)
          {
            m = k;
            j = i;
            if (k == 0)
            {
              localStringBuffer.append("{");
              j = localStringBuffer.length();
              m = 1;
            }
          }
          if (localStringBuffer.length() > j) {
            localStringBuffer.append(", ");
          }
          localStringBuffer.append((String)((Map.Entry)localObject).getKey());
          localStringBuffer.append('=');
          localStringBuffer.append(str);
          k = m;
          i = j;
        }
      }
      if (k != 0) {
        localStringBuffer.append("}");
      }
      return localStringBuffer.toString();
    }
    return paramObject.toString();
  }
  
  public abstract void deepCopy(Log paramLog);
}
