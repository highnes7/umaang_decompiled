package com.google.android.android.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.android.internal.zzbec;
import com.google.android.android.internal.zzbed;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ObjectCache
{
  public static final Method zzfzi = ;
  public static final Method zzfzj = zzalm();
  public static final Method zzfzk = zzaln();
  public static final Method zzfzl = zzalo();
  public static final Method zzfzm = zzalp();
  
  public static int get(WorkSource paramWorkSource)
  {
    Method localMethod = zzfzk;
    if (localMethod != null) {
      try
      {
        paramWorkSource = localMethod.invoke(paramWorkSource, new Object[0]);
        paramWorkSource = (Integer)paramWorkSource;
        int i = paramWorkSource.intValue();
        return i;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
      }
    }
    return 0;
  }
  
  public static WorkSource get(int paramInt, String paramString)
  {
    WorkSource localWorkSource = new WorkSource();
    String str;
    if (zzfzj != null)
    {
      str = paramString;
      if (paramString == null) {
        str = "";
      }
      paramString = zzfzj;
    }
    try
    {
      paramString.invoke(localWorkSource, new Object[] { Integer.valueOf(paramInt), str });
      return localWorkSource;
    }
    catch (Exception paramString)
    {
      Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramString);
    }
    paramString = zzfzi;
    if (paramString != null)
    {
      paramString.invoke(localWorkSource, new Object[] { Integer.valueOf(paramInt) });
      return localWorkSource;
    }
    return localWorkSource;
  }
  
  public static String get(WorkSource paramWorkSource, int paramInt)
  {
    Method localMethod = zzfzm;
    if (localMethod != null) {
      try
      {
        paramWorkSource = localMethod.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt) });
        return (String)paramWorkSource;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
      }
    }
    return null;
  }
  
  public static List searchText(WorkSource paramWorkSource)
  {
    int j = 0;
    int i;
    if (paramWorkSource == null) {
      i = 0;
    } else {
      i = get(paramWorkSource);
    }
    if (i == 0) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList();
    while (j < i)
    {
      String str = get(paramWorkSource, j);
      if (!Pattern.zzgm(str)) {
        localArrayList.add(str);
      }
      j += 1;
    }
    return localArrayList;
  }
  
  public static WorkSource zzac(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramContext.getPackageManager() != null))
    {
      if (paramString == null) {
        return null;
      }
      try
      {
        paramContext = zzbed.zzcr(paramContext).getApplicationInfo(paramString, 0);
        if (paramContext == null)
        {
          if (paramString.length() != 0)
          {
            "Could not get applicationInfo from package: ".concat(paramString);
            return null;
          }
          new String("Could not get applicationInfo from package: ");
          return null;
        }
        return get(uid, paramString);
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;) {}
      }
      if (paramString.length() != 0)
      {
        "Could not find package: ".concat(paramString);
        return null;
      }
      new String("Could not find package: ");
      return null;
    }
    return null;
  }
  
  public static Method zzall()
  {
    Object localObject = Integer.TYPE;
    try
    {
      localObject = WorkSource.class.getMethod("add", new Class[] { localObject });
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static Method zzalm()
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject = Integer.TYPE;
    try
    {
      localObject = WorkSource.class.getMethod("add", new Class[] { localObject, String.class });
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static Method zzaln()
  {
    try
    {
      Method localMethod = WorkSource.class.getMethod("size", new Class[0]);
      return localMethod;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static Method zzalo()
  {
    Object localObject = Integer.TYPE;
    try
    {
      localObject = WorkSource.class.getMethod("get", new Class[] { localObject });
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static Method zzalp()
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject = Integer.TYPE;
    try
    {
      localObject = WorkSource.class.getMethod("getName", new Class[] { localObject });
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static boolean zzco(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    if (paramContext.getPackageManager() == null) {
      return false;
    }
    return zzbed.zzcr(paramContext).checkPermission("android.permission.UPDATE_DEVICE_STATS", paramContext.getPackageName()) == 0;
  }
}
