package l.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import l.a.a.a.a.c.Function;
import l.a.a.a.a.c.Label;
import l.a.a.a.a.c.UnsupportedDataException;

public class f
{
  public static final String A = ".Fabric";
  public static final boolean D = false;
  public static final String TAG = "Fabric";
  public static volatile f c;
  public static final String e = "com.crashlytics.sdk.android:answers";
  public static final Log t = new Logger();
  public static final String w = "com.crashlytics.sdk.android:crashlytics";
  public final k<?> a;
  public final l.a.a.a.a.b.f b;
  public final k<g> d;
  public final ExecutorService g;
  public b i;
  public final Handler j;
  public final Log k;
  public WeakReference<Activity> l;
  public final Map<Class<? extends n>, n> m;
  public AtomicBoolean n;
  public final Context r;
  public final boolean s;
  
  public f(Context paramContext, Map paramMap, l.a.a.a.a.c.Item paramItem, Handler paramHandler, Log paramLog, boolean paramBoolean, g paramG, l.a.a.a.a.b.f paramF, Activity paramActivity)
  {
    r = paramContext;
    m = paramMap;
    g = paramItem;
    j = paramHandler;
    k = paramLog;
    s = paramBoolean;
    d = paramG;
    n = new AtomicBoolean(false);
    a = getItem(paramMap.size());
    b = paramF;
    a(paramActivity);
  }
  
  public static Map a(Collection paramCollection)
  {
    HashMap localHashMap = new HashMap(paramCollection.size());
    a(localHashMap, paramCollection);
    return localHashMap;
  }
  
  public static f a(Context paramContext, Item... paramVarArgs)
  {
    if (c == null) {
      try
      {
        if (c == null)
        {
          paramContext = new e(paramContext).a(paramVarArgs).a();
          c = paramContext;
          paramContext.a();
        }
      }
      catch (Throwable paramContext)
      {
        throw paramContext;
      }
    }
    return c;
  }
  
  public static f a(f paramF)
  {
    if (c == null) {
      try
      {
        if (c == null)
        {
          c = paramF;
          paramF.a();
        }
      }
      catch (Throwable paramF)
      {
        throw paramF;
      }
    }
    return c;
  }
  
  private void a()
  {
    i = new b(r);
    i.a(new i(this));
    a(r);
  }
  
  public static void a(Map paramMap, Collection paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Item localItem = (Item)paramCollection.next();
      paramMap.put(localItem.getClass(), localItem);
      if ((localItem instanceof l)) {
        a(paramMap, ((l)localItem).b());
      }
    }
  }
  
  public static Item add(Class paramClass)
  {
    return (Item)clearm.get(paramClass);
  }
  
  public static f clear()
  {
    if (c != null) {
      return c;
    }
    throw new IllegalStateException("Must Initialize Fabric before using singleton()");
  }
  
  public static boolean close()
  {
    return (c != null) && (cn.get());
  }
  
  public static void d(f paramF)
  {
    c = paramF;
    paramF.a();
  }
  
  public static boolean d()
  {
    if (c == null) {
      return false;
    }
    return cs;
  }
  
  public static Activity f(Context paramContext)
  {
    if ((paramContext instanceof Activity)) {
      return (Activity)paramContext;
    }
    return null;
  }
  
  public static Log get()
  {
    if (c == null) {
      return t;
    }
    return ck;
  }
  
  public f a(Activity paramActivity)
  {
    l = new WeakReference(paramActivity);
    return this;
  }
  
  public void a(Context paramContext)
  {
    Object localObject1 = invoke(paramContext);
    Object localObject2 = getItem();
    localObject1 = new d((Future)localObject1, (Collection)localObject2);
    localObject2 = new ArrayList((Collection)localObject2);
    Collections.sort((List)localObject2);
    ((Item)localObject1).a(paramContext, this, g.d, b);
    Object localObject3 = ((List)localObject2).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Item)((Iterator)localObject3).next()).a(paramContext, this, a, b);
    }
    ((Item)localObject1).setTitle();
    if (get().write("Fabric", 3))
    {
      paramContext = new StringBuilder("Initializing ");
      paramContext.append(f());
      paramContext.append(" [Version: ");
      paramContext.append(s());
      paramContext.append("], with the following kits:\n");
    }
    else
    {
      paramContext = null;
    }
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Item)((Iterator)localObject2).next();
      b.a(b);
      write(m, (Item)localObject3);
      ((Item)localObject3).setTitle();
      if (paramContext != null)
      {
        paramContext.append(((Item)localObject3).getId());
        paramContext.append(" [Version: ");
        paramContext.append(((Item)localObject3).c());
        paramContext.append("]\n");
      }
    }
    if (paramContext != null) {
      get().d("Fabric", paramContext.toString());
    }
  }
  
  public Activity add()
  {
    WeakReference localWeakReference = l;
    if (localWeakReference != null) {
      return (Activity)localWeakReference.get();
    }
    return null;
  }
  
  public ExecutorService b()
  {
    return g;
  }
  
  public String c()
  {
    return b.a();
  }
  
  public String e()
  {
    return b.e();
  }
  
  public String f()
  {
    return "io.fabric.sdk.android:fabric";
  }
  
  public b g()
  {
    return i;
  }
  
  public Collection getItem()
  {
    return m.values();
  }
  
  public g getItem(int paramInt)
  {
    return new c(this, paramInt);
  }
  
  public Handler h()
  {
    return j;
  }
  
  public Future invoke(Context paramContext)
  {
    paramContext = new a(paramContext.getPackageCodePath());
    return b().submit(paramContext);
  }
  
  public String s()
  {
    return "1.4.8.32";
  }
  
  public void write(Map paramMap, Item paramItem)
  {
    Object localObject1 = g;
    if (localObject1 != null)
    {
      localObject1 = ((Function)localObject1).value();
      int i2 = localObject1.length;
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject2 = localObject1[i1];
        if (localObject2.isInterface())
        {
          Iterator localIterator = paramMap.values().iterator();
          while (localIterator.hasNext())
          {
            Item localItem = (Item)localIterator.next();
            if (localObject2.isAssignableFrom(localItem.getClass())) {
              b.a(b);
            }
          }
        }
        if ((Item)paramMap.get(localObject2) != null)
        {
          b.a(getb);
          i1 += 1;
        }
        else
        {
          throw new UnsupportedDataException("Referenced Kit was null, does the kit exist?");
        }
      }
    }
  }
}
