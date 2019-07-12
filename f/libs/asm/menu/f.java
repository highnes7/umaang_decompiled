package f.libs.asm.menu;

import f.c.a.c.fa;
import f.c.a.c.ja;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.HttpsURLConnection;
import l.a.a.a.a.b.Label;
import l.a.a.a.a.b.i;
import l.a.a.a.a.c.UnsupportedDataException;
import l.a.a.a.a.c.j;
import l.a.a.a.a.e.MathArrays.OrderDirection;
import l.a.a.a.a.e.TShortCollection;
import l.a.a.a.a.f.MethodWriter;
import l.a.a.a.a.f.Settings;
import l.a.a.a.a.f.a;
import l.a.a.a.a.g.Frame;
import l.a.a.a.n;

@j({ja.class})
public class f
  extends n<Void>
{
  public static final String A = "com.crashlytics.RequireBuildId";
  public static final int B = 64;
  public static final boolean D = true;
  public static final int INTER_TAB_SIZE2 = 1024;
  public static final String TAG = "com.crashlytics.android.core.CrashlyticsCore";
  public static final float WEIGHT_POPULATION = 1.0F;
  public static final String e = "crash_marker";
  public static final String g = "The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.";
  public static final int l = 4;
  public static final String t = "CrashlyticsCore";
  public static final String w = "initialization_marker";
  public final ConcurrentHashMap<String, String> a;
  public String b;
  public final TDoubleCollection c;
  public Context d;
  public String f;
  public final long h;
  public boolean i;
  public l.a.a.a.a.e.LayoutManager j;
  public Log k;
  public Log m;
  public NavigationMenuPresenter o;
  public Paint p;
  public ClassWriter r;
  public String v;
  public float x;
  
  public f()
  {
    this(1.0F, null, null, false);
  }
  
  public f(float paramFloat, Paint paramPaint, TDoubleCollection paramTDoubleCollection, boolean paramBoolean)
  {
    this(paramFloat, paramPaint, paramTDoubleCollection, paramBoolean, l.a.a.a.a.b.LayoutManager.init("Crashlytics Exception Handler"));
  }
  
  public f(float paramFloat, Paint paramPaint, TDoubleCollection paramTDoubleCollection, boolean paramBoolean, ExecutorService paramExecutorService) {}
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if (i) {
      return;
    }
    if (!close("prior to logging messages.")) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = h;
    r.a(l1 - l2, b(paramInt, paramString1, paramString2));
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      l.a.a.a.f.get().d("CrashlyticsCore", "Configured not to require a build ID.");
      return true;
    }
    return !l.a.a.a.a.b.ClassWriter.put(paramString);
  }
  
  private void add()
  {
    Object localObject = (Boolean)d.get(new fa.b(m));
    if (!Boolean.TRUE.equals(localObject)) {
      return;
    }
    localObject = p;
    try
    {
      ((Paint)localObject).setStrokeCap();
      return;
    }
    catch (Exception localException)
    {
      l.a.a.a.f.get().d("CrashlyticsCore", "Exception thrown by CrashlyticsListener while notifying of previous crash.", localException);
    }
  }
  
  public static String b(int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(l.a.a.a.a.b.ClassWriter.getCharacter(paramInt));
    localStringBuilder.append("/");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  private void close()
  {
    Object localObject1 = new NameRevCommand(this);
    Object localObject2 = getLabels().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((l.a.a.a.a.c.ClassWriter)localObject1).a((l.a.a.a.a.c.l)((Iterator)localObject2).next());
    }
    localObject1 = e().b().submit((Callable)localObject1);
    l.a.a.a.f.get().d("CrashlyticsCore", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
    localObject2 = TimeUnit.SECONDS;
    try
    {
      ((Future)localObject1).get(4L, (TimeUnit)localObject2);
      return;
    }
    catch (TimeoutException localTimeoutException)
    {
      l.a.a.a.f.get().d("CrashlyticsCore", "Crashlytics timed out during initialization.", localTimeoutException);
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      l.a.a.a.f.get().d("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", localExecutionException);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      l.a.a.a.f.get().d("CrashlyticsCore", "Crashlytics was interrupted during initialization.", localInterruptedException);
    }
  }
  
  public static boolean close(String paramString)
  {
    Object localObject = valueOf();
    if ((localObject != null) && (r != null)) {
      return true;
    }
    localObject = l.a.a.a.f.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Crashlytics must be initialized by calling Fabric.with(Context) ");
    localStringBuilder.append(paramString);
    ((l.a.a.a.Log)localObject).d("CrashlyticsCore", localStringBuilder.toString(), null);
    return false;
  }
  
  public static f valueOf()
  {
    return (f)l.a.a.a.f.add(fa.class);
  }
  
  public static String valueOf(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      paramString = paramString.trim();
      str = paramString;
      if (paramString.length() > 1024) {
        str = paramString.substring(0, 1024);
      }
    }
    return str;
  }
  
  public String a()
  {
    if (getName().m()) {
      return f;
    }
    return null;
  }
  
  public void a(Paint paramPaint)
  {
    try
    {
      l.a.a.a.f.get().remove("CrashlyticsCore", "Use of setListener is deprecated.");
      if (paramPaint != null)
      {
        p = paramPaint;
        return;
      }
      throw new IllegalArgumentException("listener must not be null.");
    }
    catch (Throwable paramPaint)
    {
      throw paramPaint;
    }
  }
  
  public void a(String paramString)
  {
    if (i) {
      return;
    }
    if (!close("prior to setting user data.")) {
      return;
    }
    b = valueOf(paramString);
    r.a(b, v, f);
  }
  
  public void a(String paramString, double paramDouble)
  {
    a(paramString, Double.toString(paramDouble));
  }
  
  public void a(String paramString, long paramLong)
  {
    a(paramString, Long.toString(paramLong));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (i) {
      return;
    }
    if (!close("prior to setting keys.")) {
      return;
    }
    if (paramString1 == null)
    {
      paramString1 = getContext();
      if ((paramString1 != null) && (l.a.a.a.a.b.ClassWriter.isDebugMode(paramString1))) {
        throw new IllegalArgumentException("Custom attribute key must not be null.");
      }
      l.a.a.a.f.get().d("CrashlyticsCore", "Attempting to set custom attribute with null key, ignoring.", null);
      return;
    }
    String str = valueOf(paramString1);
    if ((a.size() >= 64) && (!a.containsKey(str)))
    {
      l.a.a.a.f.get().d("CrashlyticsCore", "Exceeded maximum number of custom attributes (64)");
      return;
    }
    if (paramString2 == null) {
      paramString1 = "";
    } else {
      paramString1 = valueOf(paramString2);
    }
    a.put(str, paramString1);
    r.a(a);
  }
  
  public void a(Throwable paramThrowable)
  {
    if (i) {
      return;
    }
    if (!close("prior to logging exceptions.")) {
      return;
    }
    if (paramThrowable == null)
    {
      l.a.a.a.f.get().println(5, "CrashlyticsCore", "Crashlytics is ignoring a request to log a null exception.");
      return;
    }
    r.b(Thread.currentThread(), paramThrowable);
  }
  
  public boolean a(android.content.Context paramContext)
  {
    if (!Label.a(paramContext).a())
    {
      l.a.a.a.f.get().d("CrashlyticsCore", "Crashlytics is disabled, because data collection is disabled by Firebase.");
      i = true;
    }
    if (i) {
      return false;
    }
    Object localObject3 = new i().a(paramContext);
    if (localObject3 == null) {
      return false;
    }
    Object localObject4 = l.a.a.a.a.b.ClassWriter.c(paramContext);
    if (a((String)localObject4, l.a.a.a.a.b.ClassWriter.getBoolean(paramContext, "com.crashlytics.RequireBuildId", true))) {
      try
      {
        Object localObject1 = l.a.a.a.f.get();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Initializing Crashlytics Core ");
        ((StringBuilder)localObject2).append(c());
        ((l.a.a.a.Log)localObject1).i("CrashlyticsCore", ((StringBuilder)localObject2).toString());
        localObject2 = new MethodWriter(this);
        localObject1 = new Log("crash_marker", (a)localObject2);
        m = ((Log)localObject1);
        localObject1 = new Log("initialization_marker", (a)localObject2);
        k = ((Log)localObject1);
        ImageLoader.Task localTask = ImageLoader.Task.execute(new Settings(getContext(), "com.crashlytics.android.core.CrashlyticsCore"), this);
        if (c != null)
        {
          localObject1 = c;
          localObject1 = new TSynchronizedShortCollection((TDoubleCollection)localObject1);
        }
        else
        {
          localObject1 = null;
        }
        Object localObject5 = new l.a.a.a.a.e.ClassWriter(l.a.a.a.f.get());
        j = ((l.a.a.a.a.e.LayoutManager)localObject5);
        localObject5 = j;
        ((l.a.a.a.a.e.LayoutManager)localObject5).a((TShortCollection)localObject1);
        localObject1 = getName();
        localObject3 = e.a(paramContext, (l.a.a.a.a.b.f)localObject1, (String)localObject3, (String)localObject4);
        localObject4 = e;
        localObject4 = new AnnotationWriter(paramContext, new q(paramContext, (String)localObject4));
        localObject5 = new l(this);
        f.libs.asm.asm.k localK = f.libs.asm.asm.l.a(paramContext);
        Context localContext = d;
        l.a.a.a.a.e.LayoutManager localLayoutManager = j;
        localObject1 = new ClassWriter(this, localContext, localLayoutManager, (l.a.a.a.a.b.f)localObject1, localTask, (a)localObject2, (e)localObject3, (k)localObject4, (CopyOnWriteArrayList)localObject5, localK);
        r = ((ClassWriter)localObject1);
        boolean bool1 = i();
        add();
        boolean bool2 = new l.a.a.a.a.b.h().a(paramContext);
        localObject1 = r;
        ((ClassWriter)localObject1).a(Thread.getDefaultUncaughtExceptionHandler(), bool2);
        if (bool1)
        {
          bool1 = l.a.a.a.a.b.ClassWriter.isOnline(paramContext);
          if (bool1)
          {
            l.a.a.a.f.get().d("CrashlyticsCore", "Crashlytics did not finish previous background initialization. Initializing synchronously.");
            close();
            return false;
          }
        }
        l.a.a.a.f.get().d("CrashlyticsCore", "Exception handling initialization successful");
        return true;
      }
      catch (Exception paramContext)
      {
        l.a.a.a.f.get().d("CrashlyticsCore", "Crashlytics was not started due to an exception during initialization", paramContext);
        r = null;
        return false;
      }
    }
    throw new UnsupportedDataException("The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
  }
  
  public boolean a(URL paramURL)
  {
    if (b() != null)
    {
      paramURL = j.a(MathArrays.OrderDirection.d, paramURL.toString());
      ((HttpsURLConnection)paramURL.getConnection()).setInstanceFollowRedirects(false);
      paramURL.get();
      return true;
    }
    return false;
  }
  
  public TDoubleCollection b()
  {
    if (!i) {
      return c;
    }
    return null;
  }
  
  public void b(String paramString)
  {
    if (i) {
      return;
    }
    if (!close("prior to setting user data.")) {
      return;
    }
    v = valueOf(paramString);
    r.a(b, v, f);
  }
  
  public void b(String paramString, float paramFloat)
  {
    a(paramString, Float.toString(paramFloat));
  }
  
  public String c()
  {
    return "2.7.0.33";
  }
  
  public void c(int paramInt, String paramString1, String paramString2)
  {
    a(paramInt, paramString1, paramString2);
    l.a.a.a.f.get().d(paramInt, f.sufficientlysecure.rootcommands.util.StringBuilder.toString("", paramString1), f.sufficientlysecure.rootcommands.util.StringBuilder.toString("", paramString2), true);
  }
  
  public void c(String paramString)
  {
    a(3, "CrashlyticsCore", paramString);
  }
  
  public boolean c(URL paramURL)
  {
    try
    {
      boolean bool = a(paramURL);
      return bool;
    }
    catch (Exception paramURL)
    {
      l.a.a.a.f.get().d("CrashlyticsCore", "Could not verify SSL pinning", paramURL);
    }
    return false;
  }
  
  public void clear()
  {
    d.invoke(new Observable.26(this));
  }
  
  public Message d()
  {
    NavigationMenuPresenter localNavigationMenuPresenter = o;
    if (localNavigationMenuPresenter != null) {
      return localNavigationMenuPresenter.d();
    }
    return null;
  }
  
  public void e(NavigationMenuPresenter paramNavigationMenuPresenter)
  {
    o = paramNavigationMenuPresenter;
  }
  
  public String f()
  {
    if (getName().m()) {
      return v;
    }
    return null;
  }
  
  public void f(String paramString)
  {
    if (i) {
      return;
    }
    if (!close("prior to setting user data.")) {
      return;
    }
    f = valueOf(paramString);
    r.a(b, v, f);
  }
  
  public void f(String paramString, int paramInt)
  {
    a(paramString, Integer.toString(paramInt));
  }
  
  public void f(String paramString, boolean paramBoolean)
  {
    a(paramString, Boolean.toString(paramBoolean));
  }
  
  public Map getAttributes()
  {
    return Collections.unmodifiableMap(a);
  }
  
  public String getCount()
  {
    if (getName().m()) {
      return b;
    }
    return null;
  }
  
  public String getId()
  {
    return "com.crashlytics.sdk.android.crashlytics-core";
  }
  
  public void getItem()
  {
    m.a();
  }
  
  public boolean i()
  {
    return k.log();
  }
  
  public void l()
  {
    new Configurator().clear();
  }
  
  public ClassWriter m()
  {
    return r;
  }
  
  public boolean onCreate()
  {
    return a(i);
  }
  
  public Void run()
  {
    s();
    r.accept();
    Object localObject3 = r;
    f localF = this;
    Object localObject2 = localF;
    Object localObject1 = localF;
    try
    {
      ((ClassWriter)localObject3).put();
      localObject2 = localF;
      localObject1 = localF;
      l.a.a.a.a.g.e localE = l.a.a.a.a.g.h.c().b();
      if (localE == null)
      {
        localObject2 = localF;
        localObject1 = localF;
        l.a.a.a.f.get().remove("CrashlyticsCore", "Received null settings, skipping report submission!");
        localF.clear();
        return null;
      }
      localObject2 = localF;
      localObject3 = r;
      localObject2 = localF;
      localObject1 = localF;
      ((ClassWriter)localObject3).b(localE);
      localObject2 = localF;
      boolean bool = b.c;
      if (!bool)
      {
        localObject2 = localF;
        localObject1 = localF;
        l.a.a.a.f.get().d("CrashlyticsCore", "Collection of crash reports disabled in Crashlytics settings.");
        localF.clear();
        return null;
      }
      localObject2 = localF;
      localObject1 = localF;
      bool = Label.a(localF.getContext()).a();
      if (!bool)
      {
        localObject2 = localF;
        localObject1 = localF;
        l.a.a.a.f.get().d("CrashlyticsCore", "Automatic collection of crash reports disabled by Firebase settings.");
        localF.clear();
        return null;
      }
      localObject2 = localF;
      localObject1 = localF;
      localObject3 = localF.d();
      if (localObject3 != null)
      {
        localObject4 = r;
        localObject2 = localF;
        localObject1 = localF;
        bool = ((ClassWriter)localObject4).a((Message)localObject3);
        if (!bool)
        {
          localObject2 = localF;
          localObject1 = localF;
          l.a.a.a.f.get().d("CrashlyticsCore", "Could not finalize previous NDK sessions.");
        }
      }
      localF = this;
      localObject3 = r;
      Object localObject4 = i;
      localObject2 = localF;
      localObject1 = localF;
      bool = ((ClassWriter)localObject3).a((Frame)localObject4);
      if (!bool)
      {
        localObject2 = localF;
        localObject1 = localF;
        l.a.a.a.f.get().d("CrashlyticsCore", "Could not finalize previous sessions.");
      }
      localObject4 = r;
      localObject3 = localF;
      float f1 = x;
      localObject2 = localObject3;
      localObject1 = localObject3;
      ((ClassWriter)localObject4).a(f1, localE);
      localObject1 = localObject3;
    }
    catch (Throwable localThrowable)
    {
      break label387;
    }
    catch (Exception localException)
    {
      localObject2 = localThrowable;
      l.a.a.a.f.get().d("CrashlyticsCore", "Crashlytics encountered a problem during asynchronous initialization.", localException);
    }
    localThrowable.clear();
    return null;
    label387:
    ((f)localObject2).clear();
    throw localThrowable;
  }
  
  public void s()
  {
    d.get(new ConnectionCacheImpl.ConnectionTask(this));
  }
}
