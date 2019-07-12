package com.google.android.android.tagmanager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataLayer
{
  public static final String EVENT_KEY = "event";
  public static final Object OBJECT_NOT_PRESENT = new Object();
  public static String[] zzjqg = "gtm.lifetime".split("\\.");
  public static final Pattern zzjqh = Pattern.compile("(\\d+)\\s*([smhd]?)");
  public final ConcurrentHashMap<com.google.android.gms.tagmanager.DataLayer.zzb, Integer> zzjqi;
  public final Map<String, Object> zzjqj;
  public final ReentrantLock zzjqk;
  public final LinkedList<Map<String, Object>> zzjql;
  public final zzc zzjqm;
  public final CountDownLatch zzjqn;
  
  public DataLayer()
  {
    this(new zzao());
  }
  
  public DataLayer(zzc paramZzc)
  {
    zzjqm = paramZzc;
    zzjqi = new ConcurrentHashMap();
    zzjqj = new HashMap();
    zzjqk = new ReentrantLock();
    zzjql = new LinkedList();
    zzjqn = new CountDownLatch(1);
    zzjqm.removeEntry(new zzap(this));
  }
  
  private final void add(Map paramMap1, Map paramMap2)
  {
    Iterator localIterator = paramMap1.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramMap1.get(str);
      if ((localObject instanceof List))
      {
        if (!(paramMap2.get(str) instanceof List)) {
          paramMap2.put(str, new ArrayList());
        }
        set((List)localObject, (List)paramMap2.get(str));
      }
      else if ((localObject instanceof Map))
      {
        if (!(paramMap2.get(str) instanceof Map)) {
          paramMap2.put(str, new HashMap());
        }
        add((Map)localObject, (Map)paramMap2.get(str));
      }
      else
      {
        paramMap2.put(str, localObject);
      }
    }
  }
  
  private final void execute(Map paramMap)
  {
    zzjqk.lock();
    try
    {
      zzjql.offer(paramMap);
      int i = zzjqk.getHoldCount();
      Object localObject2;
      if (i == 1)
      {
        i = 0;
        for (;;)
        {
          localObject1 = (Map)zzjql.poll();
          if (localObject1 != null)
          {
            localObject2 = zzjqj;
            try
            {
              Iterator localIterator = ((Map)localObject1).keySet().iterator();
              while (localIterator.hasNext())
              {
                String str = (String)localIterator.next();
                add(valueOf(str, ((Map)localObject1).get(str)), zzjqj);
              }
              localObject2 = zzjqi.keySet().iterator();
              for (;;)
              {
                boolean bool = ((Iterator)localObject2).hasNext();
                if (!bool) {
                  break;
                }
                ((zzb)((Iterator)localObject2).next()).changed((Map)localObject1);
              }
              i += 1;
              if (i > 500)
              {
                zzjql.clear();
                throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
              }
            }
            catch (Throwable paramMap)
            {
              throw paramMap;
            }
          }
        }
      }
      Object localObject1 = putIfAbsent(paramMap);
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = zzlk(localObject1.toString());
      }
      if (localObject1 != null)
      {
        localObject2 = new ArrayList();
        process(paramMap, "", (Collection)localObject2);
        zzjqm.Save((List)localObject2, ((Long)localObject1).longValue());
      }
      zzjqk.unlock();
      return;
    }
    catch (Throwable paramMap)
    {
      zzjqk.unlock();
      throw paramMap;
    }
  }
  
  public static List listOf(Object... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      localArrayList.add(paramVarArgs[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  public static Map mapOf(Object... paramVarArgs)
  {
    Object localObject;
    if (paramVarArgs.length % 2 == 0)
    {
      localObject = new HashMap();
      int i = 0;
      for (;;)
      {
        if (i >= paramVarArgs.length) {
          return localObject;
        }
        if (!(paramVarArgs[i] instanceof String)) {
          break;
        }
        ((Map)localObject).put((String)paramVarArgs[i], paramVarArgs[(i + 1)]);
        i += 2;
      }
      paramVarArgs = String.valueOf(paramVarArgs[i]);
      localObject = new StringBuilder(paramVarArgs.length() + 21);
      ((StringBuilder)localObject).append("key is not a string: ");
      ((StringBuilder)localObject).append(paramVarArgs);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    paramVarArgs = new IllegalArgumentException("expected even number of key-value pairs");
    throw paramVarArgs;
    return localObject;
  }
  
  private final void process(Map paramMap, String paramString, Collection paramCollection)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (paramString.length() == 0) {
        paramMap = "";
      } else {
        paramMap = ".";
      }
      String str = (String)localEntry.getKey();
      int i = paramString.length();
      paramMap = f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append(str, paramMap.length() + i), paramString, paramMap, str);
      if ((localEntry.getValue() instanceof Map)) {
        process((Map)localEntry.getValue(), paramMap, paramCollection);
      } else if (!paramMap.equals("gtm.lifetime")) {
        paramCollection.add(new zza(paramMap, localEntry.getValue()));
      }
    }
  }
  
  public static Object putIfAbsent(Map paramMap)
  {
    String[] arrayOfString = zzjqg;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (!(paramMap instanceof Map)) {
        return null;
      }
      paramMap = ((Map)paramMap).get(str);
      i += 1;
    }
    return paramMap;
  }
  
  private final void set(List paramList1, List paramList2)
  {
    while (paramList2.size() < paramList1.size()) {
      paramList2.add(null);
    }
    int i = 0;
    while (i < paramList1.size())
    {
      Object localObject = paramList1.get(i);
      if ((localObject instanceof List))
      {
        if (!(paramList2.get(i) instanceof List)) {
          paramList2.set(i, new ArrayList());
        }
        set((List)localObject, (List)paramList2.get(i));
      }
      else if ((localObject instanceof Map))
      {
        if (!(paramList2.get(i) instanceof Map)) {
          paramList2.set(i, new HashMap());
        }
        add((Map)localObject, (Map)paramList2.get(i));
      }
      else if (localObject != OBJECT_NOT_PRESENT)
      {
        paramList2.set(i, localObject);
      }
      i += 1;
    }
  }
  
  public static Map valueOf(String paramString, Object paramObject)
  {
    HashMap localHashMap1 = new HashMap();
    String[] arrayOfString = paramString.toString().split("\\.");
    int i = 0;
    HashMap localHashMap2;
    for (paramString = localHashMap1; i < arrayOfString.length - 1; paramString = localHashMap2)
    {
      localHashMap2 = new HashMap();
      paramString.put(arrayOfString[i], localHashMap2);
      i += 1;
    }
    paramString.put(arrayOfString[(arrayOfString.length - 1)], paramObject);
    return localHashMap1;
  }
  
  public static Long zzlk(String paramString)
  {
    Matcher localMatcher = zzjqh.matcher(paramString);
    if (!localMatcher.matches())
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "unknown _lifetime: ".concat(paramString);
      } else {
        paramString = new String("unknown _lifetime: ");
      }
      zzdj.zzjss.zzcq(paramString);
      return null;
    }
    try
    {
      l = Long.parseLong(localMatcher.group(1));
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l;
      String str;
      int i;
      for (;;) {}
    }
    str = String.valueOf(paramString);
    if (str.length() != 0) {
      str = "illegal number in _lifetime value: ".concat(str);
    } else {
      str = new String("illegal number in _lifetime value: ");
    }
    zzdj.zzjss.zzcr(str);
    l = 0L;
    if (l <= 0L)
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "non-positive _lifetime: ".concat(paramString);
      } else {
        paramString = new String("non-positive _lifetime: ");
      }
      zzdj.zzjss.zzcq(paramString);
      return null;
    }
    str = localMatcher.group(2);
    if (str.length() == 0) {
      return Long.valueOf(l);
    }
    i = str.charAt(0);
    if (i != 100) {
      if (i != 104) {
        if (i != 109)
        {
          if (i != 115)
          {
            paramString = String.valueOf(paramString);
            if (paramString.length() != 0) {
              paramString = "unknown units in _lifetime: ".concat(paramString);
            } else {
              paramString = new String("unknown units in _lifetime: ");
            }
            zzdj.zzjss.zzcr(paramString);
            return null;
          }
          l *= 1000L;
        }
      }
    }
    for (;;)
    {
      return Long.valueOf(l);
      for (l *= 1000L;; l = l * 1000L * 60L)
      {
        l *= 60L;
        break;
      }
      l = l * 1000L * 60L * 60L * 24L;
    }
  }
  
  public Object getValue(String paramString)
  {
    Map localMap = zzjqj;
    try
    {
      Object localObject = zzjqj;
      String[] arrayOfString = paramString.split("\\.");
      int j = arrayOfString.length;
      int i = 0;
      paramString = (String)localObject;
      while (i < j)
      {
        localObject = arrayOfString[i];
        if (!(paramString instanceof Map)) {
          return null;
        }
        localObject = ((Map)paramString).get(localObject);
        paramString = (String)localObject;
        if (localObject == null) {
          return null;
        }
        i += 1;
      }
      return paramString;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void push(String paramString, Object paramObject)
  {
    push(valueOf(paramString, paramObject));
  }
  
  public void push(Map paramMap)
  {
    CountDownLatch localCountDownLatch = zzjqn;
    try
    {
      localCountDownLatch.await();
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
    zzdj.zzjss.zzcr("DataLayer.push: unexpected InterruptedException");
    execute(paramMap);
  }
  
  public void pushEvent(String paramString, Map paramMap)
  {
    paramMap = new HashMap(paramMap);
    paramMap.put("event", paramString);
    push(paramMap);
  }
  
  public final void scan(zzb paramZzb)
  {
    zzjqi.put(paramZzb, Integer.valueOf(0));
  }
  
  public String toString()
  {
    Map localMap = zzjqj;
    try
    {
      Object localObject = new StringBuilder();
      Iterator localIterator = zzjqj.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ((StringBuilder)localObject).append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", new Object[] { localEntry.getKey(), localEntry.getValue() }));
      }
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void zzlj(String paramString)
  {
    push(paramString, null);
    zzjqm.zzll(paramString);
  }
  
  public final class zza
  {
    public final Object mValue;
    
    public zza(Object paramObject)
    {
      mValue = paramObject;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof zza)) {
        return false;
      }
      paramObject = (zza)paramObject;
      return (DataLayer.this.equals(zzbff)) && (mValue.equals(mValue));
    }
    
    public final int hashCode()
    {
      return Arrays.hashCode(new Integer[] { Integer.valueOf(DataLayer.this.hashCode()), Integer.valueOf(mValue.hashCode()) });
    }
    
    public final String toString()
    {
      String str1 = DataLayer.this;
      String str2 = mValue.toString();
      StringBuilder localStringBuilder = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(str2, f.sufficientlysecure.rootcommands.util.StringBuilder.append(str1, 13)));
      localStringBuilder.append("Key: ");
      localStringBuilder.append(str1);
      localStringBuilder.append(" value: ");
      localStringBuilder.append(str2);
      return localStringBuilder.toString();
    }
  }
  
  public abstract interface zzb
  {
    public abstract void changed(Map paramMap);
  }
  
  public abstract interface zzc
  {
    public abstract void Save(List paramList, long paramLong);
    
    public abstract void removeEntry(zzaq paramZzaq);
    
    public abstract void zzll(String paramString);
  }
}
