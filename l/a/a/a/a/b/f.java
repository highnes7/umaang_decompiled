package l.a.a.a.a.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l.a.a.a.Item;
import l.a.a.a.Log;
import l.a.a.a.n;

public class f
{
  public static final String A = "com.crashlytics.CollectUserIdentifiers";
  public static final String ACTION_VIEW_STATES_KEY = "0.0";
  public static final String EXPANDED_ACTION_VIEW_ID = "9774d56d682e549c";
  public static final String g = "crashlytics.advertising.id";
  public static final String i = Pattern.quote("/");
  public static final Pattern pattern = Pattern.compile("[^\\p{Alnum}]");
  public static final String t = "com.crashlytics.CollectDeviceIdentifiers";
  public static final String w = "crashlytics.installation.id";
  public final Context a;
  public h b;
  public final Collection<n> c;
  public final String d;
  public final String e;
  public final A j;
  public d l;
  public b m;
  public final ReentrantLock mLock = new ReentrantLock();
  public final boolean p;
  public final boolean r;
  public boolean s;
  
  public f(Context paramContext, String paramString1, String paramString2, Collection paramCollection)
  {
    if (paramContext != null)
    {
      if (paramString1 != null)
      {
        if (paramCollection != null)
        {
          a = paramContext;
          e = paramString1;
          d = paramString2;
          c = paramCollection;
          j = new A();
          l = new d(paramContext);
          b = new h();
          p = ClassWriter.getBoolean(paramContext, "com.crashlytics.CollectDeviceIdentifiers", true);
          if (!p)
          {
            paramString1 = l.a.a.a.f.get();
            paramString2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Device ID collection disabled for ");
            paramString2.append(paramContext.getPackageName());
            paramString1.d("Fabric", paramString2.toString());
          }
          r = ClassWriter.getBoolean(paramContext, "com.crashlytics.CollectUserIdentifiers", true);
          if (!r)
          {
            paramString1 = l.a.a.a.f.get();
            paramString2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("User information collection disabled for ");
            paramString2.append(paramContext.getPackageName());
            paramString1.d("Fabric", paramString2.toString());
          }
        }
        else
        {
          throw new IllegalArgumentException("kits must not be null");
        }
      }
      else {
        throw new IllegalArgumentException("appIdentifier must not be null");
      }
    }
    else {
      throw new IllegalArgumentException("appContext must not be null");
    }
  }
  
  private void add(SharedPreferences paramSharedPreferences, String paramString)
  {
    mLock.lock();
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool)
      {
        mLock.unlock();
        return;
      }
      String str = paramSharedPreferences.getString("crashlytics.advertising.id", null);
      bool = TextUtils.isEmpty(str);
      if (bool)
      {
        paramSharedPreferences.edit().putString("crashlytics.advertising.id", paramString).commit();
      }
      else
      {
        bool = str.equals(paramString);
        if (!bool) {
          paramSharedPreferences.edit().remove("crashlytics.installation.id").putString("crashlytics.advertising.id", paramString).commit();
        }
      }
      mLock.unlock();
      return;
    }
    catch (Throwable paramSharedPreferences)
    {
      mLock.unlock();
      throw paramSharedPreferences;
    }
  }
  
  private String append(String paramString)
  {
    return paramString.replaceAll(i, "");
  }
  
  private Boolean clear()
  {
    b localB = d();
    if (localB != null) {
      return Boolean.valueOf(b);
    }
    return null;
  }
  
  private String clear(SharedPreferences paramSharedPreferences)
  {
    mLock.lock();
    try
    {
      String str2 = paramSharedPreferences.getString("crashlytics.installation.id", null);
      String str1 = str2;
      if (str2 == null)
      {
        str2 = getName(UUID.randomUUID().toString());
        str1 = str2;
        paramSharedPreferences.edit().putString("crashlytics.installation.id", str2).commit();
      }
      mLock.unlock();
      return str1;
    }
    catch (Throwable paramSharedPreferences)
    {
      mLock.unlock();
      throw paramSharedPreferences;
    }
  }
  
  private void close(SharedPreferences paramSharedPreferences)
  {
    b localB = d();
    if (localB != null) {
      add(paramSharedPreferences, a);
    }
  }
  
  private String getName(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return pattern.matcher(paramString).replaceAll("").toLowerCase(Locale.US);
  }
  
  private void loadMetadata(Map paramMap, y.a paramA, String paramString)
  {
    if (paramString != null) {
      paramMap.put(paramA, paramString);
    }
  }
  
  public String a()
  {
    String str2 = d;
    String str1 = str2;
    if (str2 == null)
    {
      SharedPreferences localSharedPreferences = ClassWriter.getDefaultSharedPreferences(a);
      close(localSharedPreferences);
      str2 = localSharedPreferences.getString("crashlytics.installation.id", null);
      str1 = str2;
      if (str2 == null) {
        str1 = clear(localSharedPreferences);
      }
    }
    return str1;
  }
  
  public boolean add()
  {
    return (p) && (!b.a(a));
  }
  
  public Map apply()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Item)localIterator.next();
      if ((localObject1 instanceof Entry4))
      {
        localObject1 = ((Entry4)localObject1).getNested().entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          y.a localA = (y.a)((Map.Entry)localObject2).getKey();
          localObject2 = (String)((Map.Entry)localObject2).getValue();
          if (localObject2 != null) {
            localHashMap.put(localA, localObject2);
          }
        }
      }
    }
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public String b()
  {
    return j.a(a);
  }
  
  public String c()
  {
    return append(Build.VERSION.INCREMENTAL);
  }
  
  public b d()
  {
    try
    {
      if (!s)
      {
        m = l.a();
        s = true;
      }
      b localB = m;
      return localB;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public String e()
  {
    return e;
  }
  
  public String e(String paramString1, String paramString2)
  {
    return "";
  }
  
  public String f()
  {
    return null;
  }
  
  public String format()
  {
    return append(Build.VERSION.RELEASE);
  }
  
  public String getHeaderView()
  {
    return null;
  }
  
  public String getMirror()
  {
    return null;
  }
  
  public String getResources()
  {
    return null;
  }
  
  public String getString()
  {
    return String.format(Locale.US, "%s/%s", new Object[] { append(Build.MANUFACTURER), append(Build.MODEL) });
  }
  
  public String i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(format());
    localStringBuilder.append("/");
    localStringBuilder.append(c());
    return localStringBuilder.toString();
  }
  
  public Boolean k()
  {
    if (add()) {
      return clear();
    }
    return null;
  }
  
  public boolean m()
  {
    return r;
  }
  
  public String s()
  {
    return null;
  }
  
  public String startSupportActionMode()
  {
    return null;
  }
}
