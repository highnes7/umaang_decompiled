package com.google.android.android.internal;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzdet
{
  public static Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
  public static Uri zzkxu = Uri.parse("content://com.google.android.gsf.gservices/prefix");
  public static Pattern zzkxv = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
  public static Pattern zzkxw = Pattern.compile("^(0|false|f|off|no|n)$", 2);
  public static final AtomicBoolean zzkxx = new AtomicBoolean();
  public static HashMap<String, String> zzkxy;
  public static HashMap<String, Boolean> zzkxz = new HashMap();
  public static HashMap<String, Integer> zzkya = new HashMap();
  public static HashMap<String, Long> zzkyb = new HashMap();
  public static HashMap<String, Float> zzkyc = new HashMap();
  public static Object zzkyd;
  public static boolean zzkye;
  public static String[] zzkyf = new String[0];
  
  public zzdet() {}
  
  public static Object get(ContentResolver paramContentResolver)
  {
    try
    {
      runQuery(paramContentResolver);
      paramContentResolver = zzkyd;
      return paramContentResolver;
    }
    catch (Throwable paramContentResolver)
    {
      throw paramContentResolver;
    }
  }
  
  public static Object get(HashMap paramHashMap, String paramString, Object paramObject)
  {
    for (;;)
    {
      try
      {
        if (paramHashMap.containsKey(paramString))
        {
          paramString = paramHashMap.get(paramString);
          paramHashMap = paramString;
          if (paramString != null) {
            return paramHashMap;
          }
        }
        else
        {
          return null;
        }
      }
      catch (Throwable paramHashMap)
      {
        throw paramHashMap;
      }
      paramHashMap = paramObject;
    }
  }
  
  public static String get(ContentResolver paramContentResolver, String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        runQuery(paramContentResolver);
        Object localObject = zzkyd;
        if (zzkxy.containsKey(paramString1))
        {
          paramContentResolver = (String)zzkxy.get(paramString1);
          if (paramContentResolver != null) {
            return paramContentResolver;
          }
        }
        else
        {
          paramString2 = zzkyf;
          int j = paramString2.length;
          int i = 0;
          if (i < j)
          {
            if (paramString1.startsWith(paramString2[i]))
            {
              if ((!zzkye) || (zzkxy.isEmpty()))
              {
                match(paramContentResolver, zzkyf);
                if (zzkxy.containsKey(paramString1))
                {
                  paramContentResolver = (String)zzkxy.get(paramString1);
                  if (paramContentResolver == null) {
                    break label297;
                  }
                  return paramContentResolver;
                }
              }
              return null;
            }
            i += 1;
            continue;
          }
          Cursor localCursor = paramContentResolver.query(CONTENT_URI, null, null, new String[] { paramString1 }, null);
          if (localCursor != null) {}
          try
          {
            boolean bool = localCursor.moveToFirst();
            if (bool)
            {
              String str = localCursor.getString(1);
              paramString2 = str;
              paramContentResolver = paramString2;
              if (str != null)
              {
                bool = str.equals(null);
                paramContentResolver = paramString2;
                if (bool) {
                  paramContentResolver = null;
                }
              }
              split(localObject, paramString1, paramContentResolver);
              if (paramContentResolver == null) {
                paramContentResolver = null;
              }
              localCursor.close();
              return paramContentResolver;
            }
            split(localObject, paramString1, null);
            if (localCursor != null)
            {
              localCursor.close();
              return null;
            }
          }
          catch (Throwable paramContentResolver)
          {
            if (localCursor != null) {
              localCursor.close();
            }
            throw paramContentResolver;
          }
          return null;
        }
      }
      catch (Throwable paramContentResolver)
      {
        throw paramContentResolver;
      }
      paramContentResolver = null;
      continue;
      label297:
      paramContentResolver = null;
    }
  }
  
  public static long getLong(ContentResolver paramContentResolver, String paramString, long paramLong)
  {
    Object localObject2 = get(paramContentResolver);
    localObject1 = zzkyb;
    paramLong = 0L;
    localObject1 = (Long)get((HashMap)localObject1, paramString, Long.valueOf(0L));
    if (localObject1 != null) {
      return ((Long)localObject1).longValue();
    }
    paramContentResolver = get(paramContentResolver, paramString, null);
    if (paramContentResolver == null) {
      paramContentResolver = (ContentResolver)localObject1;
    }
    try
    {
      long l = Long.parseLong(paramContentResolver);
      paramContentResolver = Long.valueOf(l);
      paramLong = l;
    }
    catch (NumberFormatException paramContentResolver)
    {
      for (;;)
      {
        paramContentResolver = (ContentResolver)localObject1;
      }
    }
    localObject1 = zzkyb;
    try
    {
      if (localObject2 == zzkyd)
      {
        ((HashMap)localObject1).put(paramString, paramContentResolver);
        zzkxy.remove(paramString);
      }
      return paramLong;
    }
    catch (Throwable paramContentResolver)
    {
      throw paramContentResolver;
    }
  }
  
  public static Map getTags(ContentResolver paramContentResolver, String... paramVarArgs)
  {
    paramContentResolver = paramContentResolver.query(zzkxu, null, null, paramVarArgs, null);
    paramVarArgs = new TreeMap();
    if (paramContentResolver == null) {
      return paramVarArgs;
    }
    try
    {
      for (;;)
      {
        boolean bool = paramContentResolver.moveToNext();
        if (!bool) {
          break;
        }
        paramVarArgs.put(paramContentResolver.getString(0), paramContentResolver.getString(1));
      }
      paramContentResolver.close();
      return paramVarArgs;
    }
    catch (Throwable paramVarArgs)
    {
      paramContentResolver.close();
      throw paramVarArgs;
    }
  }
  
  public static void match(ContentResolver paramContentResolver, String[] paramArrayOfString)
  {
    zzkxy.putAll(getTags(paramContentResolver, paramArrayOfString));
    zzkye = true;
  }
  
  public static void query(ContentResolver paramContentResolver, String... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        runQuery(paramContentResolver);
        HashSet localHashSet = new HashSet((zzkyf.length + paramVarArgs.length << 2) / 3 + 1);
        localHashSet.addAll(Arrays.asList(zzkyf));
        ArrayList localArrayList = new ArrayList();
        int j = paramVarArgs.length;
        i = 0;
        if (i < j)
        {
          String str = paramVarArgs[i];
          if (localHashSet.add(str)) {
            localArrayList.add(str);
          }
        }
        else
        {
          if (localArrayList.isEmpty())
          {
            paramVarArgs = new String[0];
          }
          else
          {
            zzkyf = (String[])localHashSet.toArray(new String[localHashSet.size()]);
            paramVarArgs = (String[])localArrayList.toArray(new String[localArrayList.size()]);
          }
          if ((zzkye) && (!zzkxy.isEmpty()))
          {
            if (paramVarArgs.length != 0) {
              match(paramContentResolver, paramVarArgs);
            }
          }
          else {
            match(paramContentResolver, zzkyf);
          }
          return;
        }
      }
      catch (Throwable paramContentResolver)
      {
        throw paramContentResolver;
      }
      i += 1;
    }
  }
  
  public static void runQuery(ContentResolver paramContentResolver)
  {
    if (zzkxy == null)
    {
      zzkxx.set(false);
      zzkxy = new HashMap();
      zzkyd = new Object();
      zzkye = false;
      paramContentResolver.registerContentObserver(CONTENT_URI, true, new zzdeu(null));
      return;
    }
    if (zzkxx.getAndSet(false))
    {
      zzkxy.clear();
      zzkxz.clear();
      zzkya.clear();
      zzkyb.clear();
      zzkyc.clear();
      zzkyd = new Object();
      zzkye = false;
    }
  }
  
  public static void split(Object paramObject, String paramString1, String paramString2)
  {
    try
    {
      if (paramObject == zzkyd) {
        zzkxy.put(paramString1, paramString2);
      }
      return;
    }
    catch (Throwable paramObject)
    {
      throw paramObject;
    }
  }
}
